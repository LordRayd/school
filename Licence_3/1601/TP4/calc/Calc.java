/* Generated By:JavaCC: Do not edit this line. Calc.java */
  package calc; /* <= precedemment oublie */

  import java.util.HashMap;

import calc.Token;

import java.io.StringReader;
  import java.io.InputStreamReader;
  import java.io.BufferedReader;
  import java.io.IOException;

  public class Calc implements CalcConstants {
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

  /* LA GRAMMAIRE */
  static final public void Program() throws ParseException {
    InsList();
  }

  static final public void InsList() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case READ:
    case WRITE:
    case IDENTIFIER:
      Ins();
      InsList();
      break;
    default:
      jj_la1[0] = jj_gen;

    }
  }

  static final public void Ins() throws ParseException {
    Token tok;
    double x;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case IDENTIFIER:
      tok = jj_consume_token(IDENTIFIER);
      jj_consume_token(AFF);
      x = Expr();
                                      definir(tok.image,x);
      break;
    case READ:
      jj_consume_token(READ);
      tok = jj_consume_token(IDENTIFIER);
                                      definir(tok.image,lire_double(tok.image));
      break;
    case WRITE:
      jj_consume_token(WRITE);
      x = Expr();
                                      ecrire_double(x);
      break;
    default:
      jj_la1[1] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public double Expr() throws ParseException {
    double x1,x2;
    x1 = Term();
    x2 = TermEnd(x1);
                               {if (true) return x2;}
    throw new Error("Missing return statement in function");
  }

  static final public double TermEnd(double v) throws ParseException {
    double x1,x2;
    char c;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ADD:
    case SUB:
      c = AddOp();
      x1 = Term();
      x2 = TermEnd(x1);
     {if (true) return calcul_operateur(v, x2, c);}
      break;
    default:
      jj_la1[2] = jj_gen;
       {if (true) return v;}
    }
    throw new Error("Missing return statement in function");
  }

  static final public double Term() throws ParseException {
    double t1,t2;
    t1 = Factor();
    t2 = FactorEnd(t1);
                                  {if (true) return t2;}
    throw new Error("Missing return statement in function");
  }

  static final public double FactorEnd(double v) throws ParseException {
    double x1,x2;
    char c;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MUL:
    case DIV:
      c = MulOp();
      x1 = Factor();
      x2 = FactorEnd(x1);
                                            {if (true) return calcul_operateur(v, x2, c);}
      break;
    default:
      jj_la1[3] = jj_gen;
       {if (true) return v;}
    }
    throw new Error("Missing return statement in function");
  }

  static final public double Factor() throws ParseException {
    double d;
    Token tok;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LPAREN:
      jj_consume_token(LPAREN);
      d = Expr();
      jj_consume_token(RPAREN);
        {if (true) return d;}
      break;
    case IDENTIFIER:
      tok = jj_consume_token(IDENTIFIER);
        {if (true) return referencer(tok.image);}
      break;
    case CONSTANT:
      tok = jj_consume_token(CONSTANT);
        d=Double.parseDouble(tok.image);
        {if (true) return d;}
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public char AddOp() throws ParseException {
    Token tok;
    char c;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ADD:
      tok = jj_consume_token(ADD);
        c=tok.image.charAt(0);
        {if (true) return c;}
      break;
    case SUB:
      tok = jj_consume_token(SUB);
        c=tok.image.charAt(0);
        {if (true) return c;}
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public char MulOp() throws ParseException {
    Token tok;
    char c;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case MUL:
      tok = jj_consume_token(MUL);
        c=tok.image.charAt(0);
        {if (true) return c;}
      break;
    case DIV:
      tok = jj_consume_token(DIV);
        c=tok.image.charAt(0);
        {if (true) return c;}
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public CalcTokenManager token_source;
  static JavaCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[7];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x4c0,0x4c0,0xc000,0x30000,0x1500,0xc000,0x30000,};
   }

  /** Constructor with InputStream. */
  public Calc(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Calc(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new JavaCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new CalcTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Calc(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new JavaCharStream(stream, 1, 1);
    token_source = new CalcTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Calc(CalcTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(CalcTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 7; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[19];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 7; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 19; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

  }
