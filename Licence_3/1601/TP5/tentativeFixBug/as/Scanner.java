/* The following code was generated by JFlex 1.4.3 on 22/03/19 12:09 */

//A COMPLETER
package as; 

import map.CodeOperation;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 22/03/19 12:09 from the specification file
 * <tt>./as/Scanner.lex</tt>
 */
class Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0, 0
  };

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = {
     0,  0,  0,  0,  0,  0,  0,  0,  1,  1,  5,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     1,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 26,  0,  0, 
     3,  3,  3,  3,  3,  3,  3,  3,  3,  3,  0,  4,  0,  0,  0,  0, 
     0,  9, 13, 19, 10, 22,  2, 23, 21, 16, 24,  2, 15, 14,  6,  7, 
     8,  2, 18, 11, 20, 12, 17,  2,  2,  2, 25,  0,  0,  0,  0,  2, 
     0,  9, 13, 19, 10, 22,  2, 23, 21, 16, 24,  2, 15, 14,  6,  7, 
     8,  2, 18, 11, 20, 12, 17,  2,  2,  2, 25,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0, 
     0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0,  0
  };

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\1\1\1\2\1\3\1\4\1\5\13\3\1\1"+
    "\25\3\1\6\1\7\1\10\1\11\1\12\1\13\1\14"+
    "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24"+
    "\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34"+
    "\1\35\1\36\1\37";

  private static int [] zzUnpackAction() {
    int [] result = new int[65];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\33\0\66\0\121\0\154\0\207\0\242\0\275"+
    "\0\330\0\363\0\u010e\0\u0129\0\u0144\0\u015f\0\u017a\0\u0195"+
    "\0\u01b0\0\154\0\u01cb\0\u01e6\0\u0201\0\u021c\0\u0237\0\u0252"+
    "\0\u026d\0\u0288\0\u02a3\0\u02be\0\u02d9\0\u02f4\0\u030f\0\u032a"+
    "\0\u0345\0\u0360\0\u037b\0\u0396\0\u03b1\0\u03cc\0\u03e7\0\121"+
    "\0\121\0\121\0\121\0\121\0\121\0\121\0\121\0\121"+
    "\0\121\0\121\0\121\0\121\0\121\0\121\0\121\0\121"+
    "\0\121\0\121\0\121\0\121\0\121\0\121\0\121\0\121"+
    "\0\121";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[65];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\2\1\3\1\4\1\5\1\6\1\3\1\7\2\4"+
    "\1\10\1\11\1\12\2\4\1\13\1\14\1\15\1\4"+
    "\1\16\2\4\1\17\1\4\1\20\1\21\1\4\1\22"+
    "\34\0\1\3\3\0\1\3\27\0\2\4\2\0\24\4"+
    "\4\0\1\5\27\0\5\6\1\0\25\6\2\0\2\4"+
    "\2\0\1\4\1\23\22\4\3\0\2\4\2\0\4\4"+
    "\1\24\17\4\3\0\2\4\2\0\12\4\1\25\5\4"+
    "\1\26\3\4\3\0\2\4\2\0\1\27\5\4\1\30"+
    "\7\4\1\31\5\4\3\0\2\4\2\0\1\4\1\32"+
    "\4\4\1\33\15\4\3\0\2\4\2\0\4\4\1\34"+
    "\4\4\1\35\7\4\1\36\2\4\3\0\2\4\2\0"+
    "\1\37\23\4\3\0\2\4\2\0\15\4\1\40\2\4"+
    "\1\41\3\4\3\0\2\4\2\0\11\4\1\42\12\4"+
    "\3\0\2\4\2\0\7\4\1\43\14\4\3\0\2\4"+
    "\2\0\1\44\4\4\1\45\2\4\1\46\10\4\1\47"+
    "\2\4\3\0\2\4\2\0\2\4\1\50\21\4\3\0"+
    "\2\4\2\0\4\4\1\51\17\4\3\0\2\4\2\0"+
    "\13\4\1\52\10\4\3\0\2\4\2\0\15\4\1\53"+
    "\6\4\3\0\2\4\2\0\4\4\1\54\17\4\3\0"+
    "\2\4\2\0\7\4\1\55\14\4\3\0\2\4\2\0"+
    "\11\4\1\56\1\57\6\4\1\60\2\4\3\0\2\4"+
    "\2\0\4\4\1\61\17\4\3\0\2\4\2\0\11\4"+
    "\1\62\12\4\3\0\2\4\2\0\11\4\1\63\1\64"+
    "\2\4\1\65\3\4\1\66\2\4\3\0\2\4\2\0"+
    "\3\4\1\67\20\4\3\0\2\4\2\0\3\4\1\70"+
    "\20\4\3\0\2\4\2\0\15\4\1\71\6\4\3\0"+
    "\2\4\2\0\13\4\1\72\10\4\3\0\2\4\2\0"+
    "\16\4\1\73\5\4\3\0\2\4\2\0\16\4\1\74"+
    "\5\4\3\0\2\4\2\0\11\4\1\75\12\4\3\0"+
    "\2\4\2\0\23\4\1\76\3\0\2\4\2\0\14\4"+
    "\1\77\7\4\3\0\2\4\2\0\2\4\1\100\21\4"+
    "\3\0\2\4\2\0\23\4\1\101\1\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[1026];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\77\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[65];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
  // methode pour recuperer le numero de ligne d'une instruction
   public int getLineNo(){
	return yyline;
    }



  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  Scanner(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  Scanner(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new Error(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public UniteLexicale yylex() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      yychar+= zzMarkedPosL-zzStartRead;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          zzR = false;
          break;
        case '\r':
          yyline++;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
          }
          break;
        default:
          zzR = false;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 14: 
          { return new UniteLexicale(CodeOperation.STG);
          }
        case 32: break;
        case 31: 
          { return new UniteLexicale(CodeOperation.JGZ);
          }
        case 33: break;
        case 28: 
          { return new UniteLexicale(CodeOperation.JNZ);
          }
        case 34: break;
        case 17: 
          { return new UniteLexicale(CodeOperation.LDL);
          }
        case 35: break;
        case 19: 
          { return new UniteLexicale(CodeOperation.LDC);
          }
        case 36: break;
        case 13: 
          { return new UniteLexicale(CodeOperation.STI);
          }
        case 37: break;
        case 24: 
          { return new UniteLexicale(CodeOperation.RCV);
          }
        case 38: break;
        case 6: 
          { return new UniteLexicale(CodeOperation.NOP);
          }
        case 39: break;
        case 21: 
          { return new UniteLexicale(CodeOperation.LLA);
          }
        case 40: break;
        case 26: 
          { return new UniteLexicale(CodeOperation.HLT);
          }
        case 41: break;
        case 16: 
          { return new UniteLexicale(CodeOperation.MUL);
          }
        case 42: break;
        case 20: 
          { return new UniteLexicale(CodeOperation.LDG);
          }
        case 43: break;
        case 9: 
          { return new UniteLexicale(CodeOperation.DEC);
          }
        case 44: break;
        case 25: 
          { return new UniteLexicale(CodeOperation.RET);
          }
        case 45: break;
        case 30: 
          { return new UniteLexicale(CodeOperation.JMP);
          }
        case 46: break;
        case 29: 
          { return new UniteLexicale(CodeOperation.JSR);
          }
        case 47: break;
        case 11: 
          { return new UniteLexicale(CodeOperation.SUB);
          }
        case 48: break;
        case 18: 
          { return new UniteLexicale(CodeOperation.LDI);
          }
        case 49: break;
        case 8: 
          { return new UniteLexicale(CodeOperation.DIV);
          }
        case 50: break;
        case 22: 
          { return new UniteLexicale(CodeOperation.LGA);
          }
        case 51: break;
        case 5: 
          { /* passe les commentaires */
          }
        case 52: break;
        case 10: 
          { return new UniteLexicale(CodeOperation.SND);
          }
        case 53: break;
        case 1: 
          { return new UniteLexicale(TypeUniteLexicale.ERROR,yytext());
          }
        case 54: break;
        case 27: 
          { return new UniteLexicale(CodeOperation.GBL);
          }
        case 55: break;
        case 23: 
          { return new UniteLexicale(CodeOperation.INC);
          }
        case 56: break;
        case 12: 
          { return new UniteLexicale(CodeOperation.STL);
          }
        case 57: break;
        case 7: 
          { return new UniteLexicale(CodeOperation.ADD);
          }
        case 58: break;
        case 3: 
          { return new UniteLexicale(TypeUniteLexicale.LABEL, yytext());
          }
        case 59: break;
        case 15: 
          { return new UniteLexicale(CodeOperation.MOD);
          }
        case 60: break;
        case 2: 
          { /* passe les blancs */
          }
        case 61: break;
        case 4: 
          { return new UniteLexicale(TypeUniteLexicale.VALUE, yytext());
          }
        case 62: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
              {     return new UniteLexicale(TypeUniteLexicale.EOF,null); 
 }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}