/**
 * Compilateur PTS Version 0
 * F. Raimbault
 */
package pts.type;

import java.util.List;

/**
 * Type d'une fonction ou procédure
 */
public class TypeFunction extends TypeConstructor {

  Type return_type; // TypeVoid ou TypeBasic seulement
  List<TypeBasic> param_type; // TypeBasic ou null seulement
  
  public TypeFunction(List<TypeBasic> p,Type r){
    super("()",0);
    return_type= r;
    name= "(";
    param_type= p;
    name= name+p;
    name= name+"):"+return_type;
  }
  
  /**
   * 
   * @see pts.type.Type#isArray()
   */
  public boolean isArray(){
    return false;
  }
  /**
   * 
   * @see pts.type.Type#isFunction()
   */
  public boolean isFunction(){
    return true;
  }
  /**
   * le paramètre de la fonction 
   * @return le paramètre de la fonction ou null si pas de paramètre
   */
  public  List<TypeBasic> getParamType() {
	    return param_type;
  }
  public  List<TypeBasic> getParamTypeList() {
		    return param_type;
	  }
/**
 * 
 * @see pts.type.Type#match(pts.type.Type)
 */
  public boolean match(Type param_type){
    return false;
  }
  /**
   * Type de retour de la fonction
   * @return le type de retour de la fonction
   */
  public Type getReturnType() {
    return return_type;
  }

}
