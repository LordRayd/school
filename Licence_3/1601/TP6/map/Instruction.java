/**
 * Machine à pile MAP : instruction de la MAP
 * @author F. Raimbault
 * A COMPLETER
 */
package map;

import static map.Registres.*;

/**
 * Instructions de la machine MAP
 */
public class Instruction { // TODO : A COMPLETER (méthode executer() seulement)

    /**
     * adresse de l'instruction 
     */
    private short adresse;

    /**
     * taille de l'instruction 
     */
    private int size;
    
    /**
     * code de l'opération 
     */
    private CodeOperation code_op;

    /**
     * argument de l'opération si présent
     */
    private short argument;

    /**
     * Nouvelle instruction sans argument. 
     * @param ad adresse de l'instruction
     * @param code_op code opération de l'instruction
     */
    public Instruction(short ad, CodeOperation code_op) {
        this.code_op = code_op;
        this.adresse= ad;
        this.size= 1; // pour le code op
    }

    /**
     * Nouvelle instruction avec argument. 
     * @param ad adresse de l'instruction
     * @param code_op code opération de l'instruction
     * @param arg argument de l'opération
     */
    public Instruction(short ad, CodeOperation code_op, short arg) {
        this(ad,code_op);
        this.size += 1; // pour l'argument
        this.argument= arg;
    }

    /**
     * Effet de l'exécution de l'instruction sur la MAP 
     * @return l'adresse de l'instruction suivante à exécuter
     */
    public short executer() { // TODO : A COMPLETER
        int adresse_instruction_suivante= adresse+size; // sauf pour les branchements
        switch (code_op) {
        case INC: // NE PAS MODIFIER
        	Memoire.reserverVariableLocale(argument);
          	break;
        case LDC: // TODO : a completer
        	Memoir.empiler(argument);
        	break;
        case DEC: // TODO : a completer
        	Memoire.libererVariableLocale(argument);
        	break;
        case GBL: // TODO : a completer
        	Memoire.reserverVariableGlobale(argument);
          	break;
        case LDL: // TODO : a completer
        	short varLocal = Memoire.lireVariableLocal(argument);
        	Memoire.empiler(varLocal);
        	break;
        case STL: // TODO : a completer
        	short var = Memoire.depiler();
        	Memoire.ecrireVariableLocale(argument,var);
        	break;
        case LDG: // TODO : a completer
        	short varGlobal = Memoire.lireVariableGlobal(argument);
        	Memoire.empiler(varGlobal);
        	break;
        case STG: // TODO : a completer
        	short var = Memoire.depiler();
        	Memoire.ecrireVariableGlobal(argument,var);
        	break;
        case LDI:{ // TODO : a completer
        	short varAdresse = Memoire.lireEmplacement(argument);
        	Memoire.empiler(varAdresse);
        	break;
        }
        case STI:{ // TODO : a completer
        	short var = Memoire.depiler();
        	Memoire.ecrireEmplacement(argument,var);
        	break;
        }
        case LLA:{ // TODO : a completer
        	Memoire.empiler(FP.lire() + n);
          break;	
        }
        case LGA:{ // TODO : a completer
        	Memoire.empiler(GP.lire() + n);
          break;
        }
        case ADD: { // TODO : a completer
        	short v1 = Memoire.depiler();
        	short v2 = Memoire.depiler();
        	Memoire.empiler(v1+v2);
            break;
        }
        case SUB: { // TODO : a completer
        	short v1 = Memoire.depiler();
        	short v2 = Memoire.depiler();
        	Memoire.empiler(v2-v1);
        }
        case MUL: { // TODO : a completer
        	short v1 = Memoire.depiler();
        	short v2 = Memoire.depiler();
        	Memoire.empiler(v1*v2);
            break;
        }
        case DIV: { // TODO : a completer
        	short v1 = Memoire.depiler();
        	short v2 = Memoire.depiler();
        	Memoire.empiler(v2/v1);
            break;
        }
        case MOD: { // TODO : a completer
        	short v1 = Memoire.depiler();
        	short v2 = Memoire.depiler();
        	Memoire.empiler(v2%v1);
            break;
        }
         case RET: { // TODO : a completer
        	 Memoire.restaureFP();
            break;
        }
        case JMP: // TODO : a completer
        	adresse_instruction_suivante = argument;
        	break;
        case JNZ: { // TODO : a completer
        	if(Memoire.depiler != 0 ) {
            	adresse_instruction_suivante = argument;
        	}
            break;
        }
        case JGZ: { // TODO : a completer
        	if(Memoire.depiler >= 0 ) {
        		adresse_instruction_suivante = argument;
        	}
            break;
        }
        case JSR: { // TODO : a completer
        	Memoire.sauveFP();
        	adresse_instruction_suivante = argument;
            break;
        }
        case NOP: // NE PAS MODIFIER
            break;
        case SND: { // TODO : a completer
        	short var = Memoire.depiler();
        	EntreesSorties.ecrireEntier(var);
            break;
        }
        case RCV: { // TODO : a completer
        	short var = EntreesSorties.lireEntier();
        	Memoir.empiler(var);
            break;
        }
        case HLT: // NE PAS MODIFIER
            Sequenceur.stop();
            break;
        }
        return (short) adresse_instruction_suivante;
    }

    /**
     * Représentation d'une instruction avec son argument (si présent)
     * @return une chaine qui représente le contenu de l'instruction
     */
    public String toString() {
        StringBuffer s = new StringBuffer(code_op.toString());
        if (code_op.argumentSuit())
           s.append(' ').append(argument);
        return s.toString();
    }
}