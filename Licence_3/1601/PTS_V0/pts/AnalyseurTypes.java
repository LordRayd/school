/**
 * Compilateur PTS Version 0
 * F. Raimbault
 */
package pts;

import java.util.List;

import pts.ast.Noeud;
import pts.erreur.Erreur;
import pts.erreur.Messages;
import pts.symb.Symbole;
import pts.type.Type;
import pts.type.TypeArray;
import pts.type.TypeBasic;
import pts.type.TypeFunction;

/**
 * Analyseurs et vérificateurs de tous les types du programme
 */
public class AnalyseurTypes {

  /**
   * Attributs synthétisés
   */
  class Synthesized{ // une valeur parmi ces quatre
    Type type; // type 
    List<TypeBasic> type_list; // liste de type 
    Symbole symbol; // symbole
    int value; // valeur entière
  }
  
    // type de la fonction courante (en cours de définition)
    private static Type type_a_retourner; // TypeBasic ou TypeVoid uniquement
    /**
     * Parcours récursif gauche droite de l'AST avec synthèse d'attributs.
     * Mise à jour du type du noeud et le cas échéant de celui du symbole associé.
     * @param node noeud courant
     * @return les attributs synthétisés après parcours du noeud 
     */
    public  Synthesized parcours(Noeud node) {
        Synthesized att= new Synthesized();
        switch (node.etiquette) {
        case IDENTIFIER:
            att.type= node.type= node.symbole.type;
            break;
        case NEW_IDENTIFIER:
            att.symbol= node.symbole;
            break;
        case PROGRAM: 
            node.symbole = parcours(node.fils[0]).symbol;
            node.symbole.type = Type.PROGRAM;
            if (node.fils[1]!=null) parcours(node.fils[1]);
            if (node.fils[2]!=null) parcours(node.fils[2]);
            parcours(node.fils[3]);
            break;
        case INTEGER_TYPE:
            att.type= node.type= Type.INTEGER;
        	break;
        case BOOLEAN_TYPE:
            att.type= node.type= Type.BOOLEAN;
        	break;
        case VOID_TYPE:
            att.type= node.type= Type.VOID;
        	break;
        case ARRAY_TYPE: {
            int size= parcours(node.fils[0]).value;
            TypeBasic elt_type = (TypeBasic) parcours(node.fils[1]).type;
            Type array_type = new TypeArray(elt_type,size);
            att.type= node.type= array_type;
            break;
        }
        case VARIABLE_DECLARATION_LIST:
        case FUNCTION_DECLARATION_LIST:
        case STATEMENT_LIST:
        case COMPOUND_STATEMENT:
            for(Noeud fils: node.fils){   //pour chaque fils
                if(fils != null)           //qui existe
                        parcours(fils);     //on parcourt
            }
            break;
        case VARIABLE_DECLARATION: {
            Symbole symb = parcours(node.fils[0]).symbol;
            att.type= symb.type= parcours(node.fils[1]).type;
            break;
        }
        case FUNCTION_DECLARATION: {
            Symbole func_symb = parcours(node.fils[0]).symbol;
            Type param_type= null;
            if (node.fils[1] != null){
                param_type= parcours(node.fils[1]).type;
                if (! param_type.isBasic())
                  Erreur.compilation(Messages.TYPE_BASIC_AWAITED,node.ligne);
            }
            type_a_retourner= parcours(node.fils[2]).type;
            func_symb.type= new TypeFunction((TypeBasic) param_type,type_a_retourner);
            parcours(node.fils[3]);
            break;
        }
       case PARAMETER_DECLARATION:{
            Symbole symb = parcours(node.fils[0]).symbol;
       		att.type= symb.type= parcours(node.fils[1]).type;
            if (! att.type.isBasic())
              Erreur.compilation(Messages.TYPE_PARAM,symb.ident,node.ligne);
            break;
   		}
       case INTEGER_VALUE:
             att.type= node.type= Type.INTEGER;
             att.value= Integer.valueOf(node.identificateur);
             break;
        case BOOLEAN_VALUE:
            att.type= node.type= Type.BOOLEAN;
            break;
        case VARIABLE_ACCESS: 
            att.type= node.type = parcours(node.fils[0]).type;
            if (!node.type.isBasic())
                Erreur.compilation(Messages.TYPE_BASIC_AWAITED,node.ligne);
            break;
        case ARRAY_ACCESS: {
            Type array_type = parcours(node.fils[0]).type;
            if (! array_type.isArray())
                Erreur.compilation(Messages.TYPE_ARRAY_AWAITED,node.ligne);
            Type index_type = parcours(node.fils[1]).type;
            if (! index_type.isInteger())
                Erreur.compilation(Messages.TYPE_ARRAY_INDEX,node.ligne);
            att.type=node.type= ((TypeArray) array_type).getEltType();
            break;
        }
        case PROCEDURE_STATEMENT: 
        case FUNCTION_CALL: {
            Type proc_type = parcours(node.fils[0]).type;
            if (!proc_type.isFunction())
                Erreur.compilation(Messages.TYPE_FUNCTION_AWAITED,node.ligne);
            TypeBasic param_type= ((TypeFunction) proc_type).getParamType();
            if (node.fils[1] != null) {
                TypeBasic arg_type = (TypeBasic) parcours(node.fils[1]).type;
                if (param_type == null)
                    Erreur.compilation(Messages.TYPE_ARGS_NUMBER,node.ligne);
                else if (! arg_type.match(param_type))
                    Erreur.compilation(Messages.TYPE_ARG_MISMATCH,node.ligne);
            }else{
              if (param_type != null)
                Erreur.compilation(Messages.TYPE_ARGS_NUMBER,node.ligne);
            }
            att.type= node.type= ((TypeFunction) proc_type).getReturnType();
            break;
        }
        case WHILE_STATEMENT: 
            if (! parcours(node.fils[0]).type.isBoolean())
                Erreur.compilation(Messages.TYPE_CONDITION,node.ligne);
            parcours(node.fils[1]);
            break;
      case IF_STATEMENT: {
            if (! parcours(node.fils[0]).type.isBoolean())
                Erreur.compilation(Messages.TYPE_CONDITION,node.ligne);
            parcours(node.fils[1]);
            if (node.fils[2] != null)
                parcours(node.fils[2]);
            break;
        }
        case ASSIGN_STATEMENT: {
            Type var_type = parcours(node.fils[0]).type;
            Type expr_type = parcours(node.fils[1]).type;
            if (!expr_type.match(var_type))
                Erreur.compilation(Messages.TYPE_ASSIGN,node.ligne);
            break;
        }
        case READ_STATEMENT: 
            if (! parcours(node.fils[0]).type.isBasic())
                Erreur.compilation(Messages.TYPE_READ,node.ligne);
            break;
        case WRITE_STATEMENT:
            if (! parcours(node.fils[0]).type.isBasic())
                Erreur.compilation(Messages.TYPE_WRITE,node.ligne);
            break;
        case RETURN_STATEMENT:
            if (! parcours(node.fils[0]).type.match(type_a_retourner))
                Erreur.compilation(Messages.TYPE_RETURN,node.ligne);
            break;
        case EQUAL_EXPRESSION:
        case NOT_EQUAL_EXPRESSION: {
            Type left_type = parcours(node.fils[0]).type;
            if (! left_type.isBasic())
                Erreur.compilation(Messages.TYPE_BASIC_AWAITED,node.ligne);
            Type right_type = parcours(node.fils[1]).type;
            if (! right_type.isBasic())
                Erreur.compilation(Messages.TYPE_BASIC_AWAITED,node.ligne);
            if (! right_type.match(left_type))
                Erreur.compilation(Messages.TYPE_RELATIONAL_EXP,node.ligne);
            att.type= node.type= Type.BOOLEAN;
            break;
        }
        case LOWER_EXPRESSION:
        case GREATER_EXPRESSION:
        case LOWER_EQUAL_EXPRESSION:
        case GREATER_EQUAL_EXPRESSION: {
            Type left_type = parcours(node.fils[0]).type;
            if (! left_type.isInteger())
                Erreur.compilation(Messages.TYPE_INTEGER_AWAITED,node.ligne);
            Type right_type = parcours(node.fils[1]).type;
            if (! right_type.isInteger())
                Erreur.compilation(Messages.TYPE_INTEGER_AWAITED,node.ligne);
            att.type= node.type= Type.BOOLEAN;
            break;
        }
        case MINUS_EXPRESSION:
        case PLUS_EXPRESSION:
        case MUL_EXPRESSION:
        case DIV_EXPRESSION:
        case MOD_EXPRESSION: {
            Type left_type = parcours(node.fils[0]).type;
            if (! left_type.isInteger())
                Erreur.compilation(Messages.TYPE_INTEGER_AWAITED,node.ligne);
            Type right_type = parcours(node.fils[1]).type;
            if (! right_type.isInteger())
                Erreur.compilation(Messages.TYPE_INTEGER_AWAITED,node.ligne);
            att.type= node.type= Type.INTEGER;
            break;
        }
        case OR_EXPRESSION:
        case AND_EXPRESSION: {
            Type left_type = parcours(node.fils[0]).type;
            if (! left_type.isBoolean())
                Erreur.compilation(Messages.TYPE_BOOLEAN_AWAITED,node.ligne);
            Type right_type = parcours(node.fils[1]).type;
            if (! right_type.isBoolean())
                Erreur.compilation(Messages.TYPE_BOOLEAN_AWAITED,node.ligne);
            att.type= node.type= Type.BOOLEAN;
            break;
        }
        case NOT_EXPRESSION:{
            Type expr_type = parcours(node.fils[0]).type;
            if (! expr_type.isBoolean())
                Erreur.compilation(Messages.TYPE_BOOLEAN_AWAITED,node.ligne);
            att.type= node.type= Type.BOOLEAN;
            break;
        }
        case NEGATIVE_EXPRESSION:{ 
          Type expr_type = parcours(node.fils[0]).type;
          if (! expr_type.isInteger())
              Erreur.compilation(Messages.TYPE_INTEGER_AWAITED,node.ligne);
          att.type= node.type= Type.INTEGER;
          break;
        }
        }
         return att;
      }
}