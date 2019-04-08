/*
 * Calculateur d'expressions simples (sans repetitions)
 * version avec actions : A COMPLETER (ne compile pas!)
 */

options {
    JAVA_UNICODE_ESCAPE = true;
    STATIC = true;                                                                             
    OUTPUT_DIRECTORY = "calc";
  }
  
  PARSER_BEGIN(Calc)
  
  package calc; /* <= precedemment oublie */
  
  import java.util.HashMap;

import calc.Token;

import java.io.StringReader;
  import java.io.InputStreamReader;
  import java.io.BufferedReader;
  import java.io.IOException;
  
  public class Calc
  {
      static double calcul_operateur(double v1, double v2, char c){
          double ret = 0;
          if(c == '+'){
              ret =  v1 + v2;
          }else if(c == '-'){
            ret =  v1 - v2;
          }else if(c == '*'){
            ret =  v1 * v2;
          }else if(c == '/'){
              if(v2 == 0) erreur("Division par zero");
            ret =  v1 / v2;
          }
          return ret;
      }
      static BufferedReader clavier;
      
      static void ecrire_double(double x){
          /* ecrit la valeur x a l'ecran */
          System.out.println(x);
      }
      static double lire_double(String s){
          /* lit la valeur de la variable s au clavier */
          double ret = 0;
        try{
            System.out.println("Entrer la valeur de : "+s);
            String val = clavier.readLine();
            ret = Double.parseDouble(val);
        }catch (IOException ioe){
            System.out.println(ioe.getMessage());
        }
          return ret;
      }
      static void erreur(String m){
          /* affiche le message d'erreur m et stopppe */
          System.out.println(m);
          try{
              clavier.close();
          }catch (IOException ioe){
              System.out.println(ioe.getMessage());
          }
          System.exit(0);
      }
      static HashMap<String,Double> tab_symb;
  
      static void definir(String s, double x){
          /* associe la valeur x a la variable s */
          tab_symb.put(s,x);
      }
      static double referencer(String s){
          /* rend la valeur associee a la variable s */
          return tab_symb.get(s);
      }
      public static void main(String [] argv){
          tab_symb= new HashMap();
          clavier= new BufferedReader(new InputStreamReader(System.in));
          try {
              Calc calc= new Calc(new BufferedReader(new StringReader(argv[0])));
              calc.Program();
          } catch (ParseException e) {
              erreur(e.getMessage());
          }catch (Exception ex){
            System.out.println(ex.getMessage());
        }
      }
  }
  
  PARSER_END(Calc)
  
  /* espaces */
  SPECIAL_TOKEN :
  {
      " " | "\t" | "\n" | "\r" | "\f"
  }
  /* mots reserves */
  TOKEN :
  {
      < READ: "read" > | < WRITE: "write" > 
  }
  /* literaux */
  TOKEN :
  {
      < CONSTANT: <DIGIT> ( <DIGIT> )* ( "." ( <DIGIT> )* )? > |
      < #DIGIT: ["0"-"9"] >
  }
  /* IDENTIFICATEURS */
  TOKEN :
  {
      < IDENTIFIER: <LETTER> ( <LETTER> | <DIGIT> )* > |
      < #LETTER:["_","a"-"z","A"-"Z"] >
  }
  /* PARENTHESES */
  TOKEN :
  {
        < LPAREN: "(" > | < RPAREN: ")" >
  }
  /* OPERATORS */
  TOKEN :
  {
      <ADD: "+" >| <SUB: "-" > | <MUL: "*" > | <DIV: "/" > | <AFF: ":=">
  }
  /* LA GRAMMAIRE */
  void Program() : 
{}
{
    InsList()
}
void InsList() : 
{}
{
    Ins() InsList() | {}
}
void Ins() :
{ 
    Token tok;
    double x;
}
{
    tok=<IDENTIFIER> <AFF> x=Expr() { definir(tok.image,x);}
    | <READ> tok=<IDENTIFIER>       { definir(tok.image,lire_double(tok.image));}
    | <WRITE> x=Expr()              { ecrire_double(x);}
}
double Expr() :
{
    double x1,x2;
}
{
    x1=Term() x2=TermEnd(x1) { return x2;}
}
double TermEnd(double v) :
{     
    double x1,x2;
    char c;
}
{
    c=AddOp()
    x1=Term() 
    x2=TermEnd(x1)
    {return calcul_operateur(v, x2, c);}
    | {return v;} 
}
double Term() :
{
    double t1,t2;}
{
    t1=Factor() t2=FactorEnd(t1) {return t2;}
}
double FactorEnd(double v) :
{
    double x1,x2;
    char c;
}
{
    c=MulOp() x1=Factor() x2=FactorEnd(x1) {return calcul_operateur(v, x2, c);} 
    | {return v;} 
}
double Factor() :
{
    double d;
    Token tok;
}
{
    <LPAREN> d=Expr() <RPAREN> {
        return d;
    }
    | tok=<IDENTIFIER> {
        return referencer(tok.image);
    }
    | tok=<CONSTANT>  {
        d=Double.parseDouble(tok.image); 
        return d;
    }   
}
char AddOp() :
{
    Token tok;
    char c;
}
{
    tok=<ADD> {
        c=tok.image.charAt(0);
        return c;
    } 
    | tok=<SUB> {
        c=tok.image.charAt(0);
        return c;
    } 
}
char MulOp() :
{
    Token tok;
    char c;
}
{
    tok=<MUL> {
        c=tok.image.charAt(0);
        return c;
    } 
    | tok=<DIV> {
        c=tok.image.charAt(0);
        return c;
    } 
}
  