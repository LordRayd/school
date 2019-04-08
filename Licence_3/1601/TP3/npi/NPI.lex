package npi;

import java.util.HashMap;
import java.util.Stack;
import java.io.IOException;
import java.io.InputStreamReader;

%%

%class NPI
%int

%{
  static Stack<Double> pile;
  static HashMap<String,Double> table;
  static boolean errorBool;
  void error(String m){ // affiche un message et reviens à l'état initial
    errorBool=true;
    System.err.println(m);
    pile.clear();
    yybegin(YYINITIAL);
  }
  
  public static void main(String[] arg) {
    errorBool = false;
    pile= new Stack<>();
    table= new HashMap<>();
    NPI yy = new NPI(new InputStreamReader(System.in));
    System.out.print("Enter expression: ");
    try{
      while (yy.yylex() != YYEOF);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
%}

ESPACE=[\ \t\b]
// AJOUTEZ VOS DEFINITIONS REGULIERES ICI
PLUS="+"
MINUS="-"
MINUSENTER={MINUS}{ENTER}
MINUSSPACE="- "
MUL="*"
DIV="/"
ENTER="\n"
NUMBER= ( 0 | [1-9] [0-9]* ) ( \. [1-9] [0-9]* )?
NUMBEROP = ({PLUS}|{MINUS})? {NUMBER}
FIN="#"
ALPHA=[A-Z]+
SAVE= > {ALPHA}
WRONG=[a-z]+
%%
{WRONG}
{
  error("Caractere non pris en compte");
}
{ESPACE}+ 
{ /* passe les blancs */}

// AJOUTEZ VOS REGLES ICI
{PLUS}
{
  if(!errorBool){
    if(pile.size()>= 2){
      pile.push(pile.pop()+pile.pop());
    }else{
      error("Pas assez de nombre");
    }
  }
}
{MINUSSPACE}
{
  if(!errorBool){
    if(pile.size()>= 2){
      pile.push((-pile.pop())+pile.pop());
    }else{
      error("Pas assez de nombre");
    }
  }
}
{MUL}
{
  if(!errorBool){
    if(pile.size()>= 2){
      pile.push(pile.pop()*pile.pop());
    }else{
      error("Pas assez de nombre");
    }
  }
}
{DIV}
{
  if(!errorBool){
    if(pile.size()>= 2){
      double v1 = pile.pop();
      double v2 = pile.pop();
      pile.push(v2/v1);
    }else{
      error("Pas assez de nombre");
    }
  }
}
{NUMBEROP}
{
  if(!errorBool)pile.push(new Double(yytext()));
}
{ALPHA}
{
  if(!errorBool){
    String key = yytext();
    if(table.containsKey(key)){
      pile.push(table.get(key));
    }else{
      error("La variable n est pas presente en memoire");
    }
  }
}
{SAVE}
{
  if(!errorBool){
    String key = yytext().substring(1);
    if(table.containsKey(key)){
      table.replace(key,pile.peek());
    }else{
      table.put(key,pile.peek());
    }
  }
}
{ENTER}
{
  if(!errorBool){
    if(pile.empty()){
      error("Pile de calcul vide");
    }else if(pile.size()>= 2){
      error("Pas assez d operateur");
    }
  }
  if(!pile.empty()) System.out.println(pile.peek());
  pile.clear();
  errorBool=false;
}
{MINUSENTER}
{
  if(!errorBool){
    if(pile.size()>= 2){
      pile.push((-pile.pop())+pile.pop());
    }else{
      error("Pas assez de nombre");
    }
    if(pile.empty()){
      error("Pile de calcul vide");
    }else if(pile.size()>= 2){
      error("Pas assez d operateur");
    }
  }
  if(!pile.empty()) System.out.println(pile.peek());
  pile.clear();
  errorBool=false;
}
{FIN}
{
  System.out.println("Bye, Bye !");
  return YYEOF;
}
. 
{ /* on passe */}