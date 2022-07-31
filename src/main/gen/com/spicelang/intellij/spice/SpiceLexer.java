/* The following code was generated by JFlex 1.7.0 tweaked for IntelliJ platform */

package com.spicelang.intellij.spice;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.spicelang.intellij.spice.psi.SpiceTokenType;
import com.spicelang.intellij.spice.psi.SpiceTypes;
import com.intellij.psi.TokenType;


/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.7.0
 * from the specification file <tt>Spice.flex</tt>
 */
class SpiceLexer implements FlexLexer {

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
   * Chosen bits are [9, 6, 6]
   * Total runtime size is 1568 bytes
   */
  public static int ZZ_CMAP(int ch) {
    return ZZ_CMAP_A[(ZZ_CMAP_Y[ZZ_CMAP_Z[ch>>12]|((ch>>6)&0x3f)]<<6)|(ch&0x3f)];
  }

  /* The ZZ_CMAP_Z table has 272 entries */
  static final char ZZ_CMAP_Z[] = zzUnpackCMap(
    "\1\0\1\100\1\200\u010d\100");

  /* The ZZ_CMAP_Y table has 192 entries */
  static final char ZZ_CMAP_Y[] = zzUnpackCMap(
    "\1\0\1\1\1\2\175\3\1\4\77\3");

  /* The ZZ_CMAP_A table has 320 entries */
  static final char ZZ_CMAP_A[] = zzUnpackCMap(
    "\11\0\1\15\1\3\2\4\1\3\22\0\1\15\1\63\1\5\2\0\1\60\1\53\1\1\1\46\1\47\1\14"+
    "\1\55\1\70\1\56\1\71\1\13\1\7\11\6\1\67\1\66\1\61\1\57\1\62\1\65\1\0\32\12"+
    "\1\50\1\2\1\51\1\54\1\12\1\0\1\33\1\21\1\32\1\16\1\22\1\35\1\30\1\26\1\23"+
    "\1\42\1\40\1\11\1\37\1\24\1\17\1\34\1\12\1\27\1\10\1\25\1\20\1\12\1\36\1\43"+
    "\1\31\1\41\1\44\1\52\1\45\1\64\6\0\1\4\242\0\2\4\26\0");

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\1\0\2\1\1\2\1\1\2\3\3\4\1\5\1\6"+
    "\12\4\1\7\1\10\3\4\1\11\1\12\1\13\1\14"+
    "\1\15\1\16\1\17\1\20\1\21\1\22\1\23\1\24"+
    "\1\25\1\26\1\27\1\30\1\31\1\32\1\33\1\34"+
    "\1\35\1\36\1\0\1\37\3\0\1\40\1\0\1\41"+
    "\1\42\1\0\5\4\1\43\1\0\1\44\1\45\12\4"+
    "\1\46\11\4\1\47\7\4\1\50\1\51\1\52\1\53"+
    "\1\54\1\55\1\56\1\57\1\60\1\61\1\62\1\63"+
    "\1\0\1\64\1\0\1\65\1\0\2\66\5\4\1\67"+
    "\1\0\1\70\1\4\1\71\5\4\1\72\1\4\1\73"+
    "\1\4\1\74\1\75\11\4\1\76\4\4\1\77\1\100"+
    "\1\101\5\4\1\102\1\103\3\4\1\104\1\4\1\105"+
    "\1\106\3\4\1\107\1\110\3\4\1\111\6\4\1\112"+
    "\1\113\4\4\1\114\3\4\1\115\4\4\1\116\5\4"+
    "\1\117\1\120\1\121\1\122\1\123\1\124\1\125\1\4"+
    "\1\126\1\127\1\130\1\131\1\132\1\4\1\133\1\134"+
    "\1\135\3\4\1\136\1\137\1\140";

  private static int [] zzUnpackAction() {
    int [] result = new int[226];
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
    "\0\0\0\72\0\164\0\256\0\350\0\u0122\0\u015c\0\u0196"+
    "\0\u01d0\0\u020a\0\u0244\0\u027e\0\u02b8\0\u02f2\0\u032c\0\u0366"+
    "\0\u03a0\0\u03da\0\u0414\0\u044e\0\u0488\0\u04c2\0\u04fc\0\u0536"+
    "\0\u0570\0\u05aa\0\u05e4\0\72\0\72\0\72\0\72\0\72"+
    "\0\72\0\u061e\0\u0658\0\u0692\0\u06cc\0\u0706\0\u0740\0\u077a"+
    "\0\u07b4\0\u07ee\0\u0828\0\72\0\72\0\72\0\72\0\72"+
    "\0\u0862\0\164\0\72\0\u089c\0\350\0\u08d6\0\72\0\u0910"+
    "\0\u0910\0\u0910\0\u094a\0\u0984\0\u09be\0\u09f8\0\u0a32\0\u0a6c"+
    "\0\u0aa6\0\u0ae0\0\72\0\72\0\u0b1a\0\u0b54\0\u0b8e\0\u0bc8"+
    "\0\u0c02\0\u0c3c\0\u0c76\0\u0cb0\0\u0cea\0\u0d24\0\u020a\0\u0d5e"+
    "\0\u0d98\0\u0dd2\0\u0e0c\0\u0e46\0\u0e80\0\u0eba\0\u0ef4\0\u0f2e"+
    "\0\u0f68\0\u0fa2\0\u0fdc\0\u1016\0\u1050\0\u108a\0\u10c4\0\u10fe"+
    "\0\72\0\72\0\72\0\72\0\72\0\72\0\72\0\72"+
    "\0\72\0\72\0\72\0\72\0\u1138\0\72\0\u1172\0\72"+
    "\0\u11ac\0\u0910\0\u094a\0\u11e6\0\u1220\0\u125a\0\u1294\0\u12ce"+
    "\0\u020a\0\u1308\0\u020a\0\u1342\0\u020a\0\u137c\0\u13b6\0\u13f0"+
    "\0\u142a\0\u1464\0\u020a\0\u149e\0\u020a\0\u14d8\0\u020a\0\u020a"+
    "\0\u1512\0\u154c\0\u1586\0\u15c0\0\u15fa\0\u1634\0\u166e\0\u16a8"+
    "\0\u16e2\0\u171c\0\u1756\0\u1790\0\u17ca\0\u1804\0\72\0\72"+
    "\0\72\0\u183e\0\u1878\0\u18b2\0\u18ec\0\u1926\0\u020a\0\72"+
    "\0\u1960\0\u199a\0\u19d4\0\u020a\0\u1a0e\0\u020a\0\u020a\0\u1a48"+
    "\0\u1a82\0\u1abc\0\u020a\0\u020a\0\u1af6\0\u1b30\0\u1b6a\0\u020a"+
    "\0\u1ba4\0\u1bde\0\u1c18\0\u1c52\0\u1c8c\0\u1cc6\0\u020a\0\u020a"+
    "\0\u1d00\0\u1d3a\0\u1d74\0\u1dae\0\u020a\0\u1de8\0\u1e22\0\u1e5c"+
    "\0\u020a\0\u1e96\0\u1ed0\0\u1f0a\0\u1f44\0\u020a\0\u1f7e\0\u1fb8"+
    "\0\u1ff2\0\u202c\0\u2066\0\u020a\0\u020a\0\u020a\0\u020a\0\u020a"+
    "\0\u020a\0\u020a\0\u20a0\0\u020a\0\u020a\0\u020a\0\u020a\0\u020a"+
    "\0\u20da\0\u020a\0\u020a\0\u020a\0\u2114\0\u214e\0\u2188\0\u020a"+
    "\0\u020a\0\u020a";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[226];
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
    "\1\2\1\3\1\2\1\4\1\2\1\5\1\6\1\7"+
    "\1\10\1\11\1\12\1\13\1\14\1\4\1\15\1\12"+
    "\1\16\1\17\1\20\1\21\1\22\1\23\1\12\1\24"+
    "\2\12\1\25\1\26\1\27\1\30\1\31\1\32\2\12"+
    "\1\33\1\12\1\34\1\35\1\36\1\37\1\40\1\41"+
    "\1\42\1\43\1\44\1\45\1\46\1\47\1\50\1\51"+
    "\1\52\1\53\1\54\1\55\1\56\1\57\1\60\1\61"+
    "\72\0\1\62\1\63\1\64\67\62\3\0\1\4\11\0"+
    "\1\4\54\0\2\65\1\66\2\65\1\67\64\65\3\70"+
    "\2\0\1\70\2\6\1\71\1\72\63\70\2\0\1\70"+
    "\2\73\1\71\1\72\60\70\6\0\5\12\3\0\5\12"+
    "\1\74\1\12\1\75\1\76\15\12\34\0\5\12\3\0"+
    "\1\12\1\77\2\12\1\100\21\12\34\0\5\12\3\0"+
    "\26\12\41\0\1\101\1\102\42\0\1\103\71\0\1\104"+
    "\20\0\3\12\1\105\1\12\3\0\1\12\1\106\11\12"+
    "\1\107\12\12\34\0\5\12\3\0\6\12\1\110\17\12"+
    "\34\0\5\12\3\0\1\12\1\111\7\12\1\112\1\12"+
    "\1\113\12\12\34\0\3\12\1\114\1\12\3\0\25\12"+
    "\1\115\34\0\5\12\3\0\6\12\1\116\10\12\1\117"+
    "\1\12\1\120\4\12\34\0\5\12\3\0\5\12\1\121"+
    "\20\12\34\0\5\12\3\0\5\12\1\122\2\12\1\123"+
    "\1\124\1\12\1\125\12\12\34\0\5\12\3\0\4\12"+
    "\1\126\21\12\34\0\5\12\3\0\1\12\1\127\6\12"+
    "\1\130\15\12\34\0\2\12\1\131\2\12\3\0\26\12"+
    "\34\0\5\12\3\0\2\12\1\132\6\12\1\133\14\12"+
    "\34\0\5\12\3\0\1\12\1\134\13\12\1\135\10\12"+
    "\34\0\5\12\3\0\10\12\1\136\15\12\34\0\5\12"+
    "\3\0\15\12\1\137\10\12\34\0\5\12\3\0\1\12"+
    "\1\140\24\12\100\0\1\141\4\0\1\142\65\0\1\143"+
    "\3\0\1\144\71\0\1\145\67\0\1\146\1\0\1\147"+
    "\70\0\1\150\1\151\71\0\1\152\71\0\1\153\71\0"+
    "\1\154\1\0\1\155\67\0\1\156\2\0\1\157\66\0"+
    "\1\160\103\0\1\161\3\62\2\0\65\62\3\65\2\0"+
    "\65\65\6\0\2\162\62\0\3\70\2\0\1\70\2\163"+
    "\62\70\6\0\5\12\3\0\12\12\1\164\10\12\1\165"+
    "\2\12\34\0\5\12\3\0\11\12\1\166\14\12\34\0"+
    "\5\12\3\0\1\12\1\167\24\12\34\0\5\12\3\0"+
    "\6\12\1\170\17\12\34\0\5\12\3\0\6\12\1\171"+
    "\17\12\26\0\3\101\2\0\65\101\14\102\1\172\55\102"+
    "\6\0\3\12\1\173\1\12\3\0\26\12\34\0\5\12"+
    "\3\0\2\12\1\174\23\12\34\0\5\12\3\0\6\12"+
    "\1\175\17\12\34\0\2\12\1\176\2\12\3\0\26\12"+
    "\34\0\5\12\3\0\1\12\1\177\24\12\34\0\5\12"+
    "\3\0\4\12\1\200\21\12\34\0\5\12\3\0\7\12"+
    "\1\201\16\12\34\0\2\12\1\202\2\12\3\0\26\12"+
    "\34\0\5\12\3\0\7\12\1\203\16\12\34\0\3\12"+
    "\1\204\1\12\3\0\7\12\1\205\16\12\34\0\5\12"+
    "\3\0\16\12\1\206\7\12\34\0\3\12\1\207\1\12"+
    "\3\0\26\12\34\0\5\12\3\0\1\210\25\12\34\0"+
    "\5\12\3\0\11\12\1\211\14\12\34\0\5\12\3\0"+
    "\2\12\1\212\23\12\34\0\5\12\3\0\16\12\1\213"+
    "\7\12\34\0\5\12\3\0\7\12\1\214\16\12\34\0"+
    "\5\12\3\0\6\12\1\215\17\12\34\0\5\12\3\0"+
    "\15\12\1\216\10\12\34\0\2\12\1\217\2\12\3\0"+
    "\26\12\34\0\5\12\3\0\3\12\1\220\22\12\34\0"+
    "\5\12\3\0\5\12\1\221\20\12\34\0\5\12\3\0"+
    "\11\12\1\222\14\12\34\0\3\12\1\223\1\12\3\0"+
    "\26\12\34\0\5\12\3\0\5\12\1\224\20\12\34\0"+
    "\5\12\3\0\5\12\1\225\20\12\34\0\5\12\3\0"+
    "\5\12\1\226\20\12\105\0\1\227\71\0\1\230\103\0"+
    "\1\231\6\0\5\12\3\0\6\12\1\232\17\12\34\0"+
    "\5\12\3\0\4\12\1\233\21\12\34\0\5\12\3\0"+
    "\2\12\1\234\2\12\1\235\20\12\34\0\5\12\3\0"+
    "\11\12\1\236\14\12\34\0\5\12\3\0\12\12\1\237"+
    "\13\12\26\0\13\102\1\240\1\172\55\102\6\0\5\12"+
    "\3\0\3\12\1\241\22\12\34\0\5\12\3\0\5\12"+
    "\1\242\7\12\1\243\10\12\34\0\3\12\1\244\1\12"+
    "\3\0\26\12\34\0\5\12\3\0\15\12\1\245\10\12"+
    "\34\0\5\12\3\0\4\12\1\246\21\12\34\0\5\12"+
    "\3\0\4\12\1\247\21\12\34\0\5\12\3\0\5\12"+
    "\1\250\20\12\34\0\5\12\3\0\1\12\1\251\24\12"+
    "\34\0\5\12\3\0\4\12\1\252\21\12\34\0\5\12"+
    "\3\0\4\12\1\253\21\12\34\0\5\12\3\0\4\12"+
    "\1\254\21\12\34\0\5\12\3\0\2\12\1\255\23\12"+
    "\34\0\2\12\1\256\2\12\3\0\7\12\1\257\16\12"+
    "\34\0\5\12\3\0\11\12\1\260\14\12\34\0\5\12"+
    "\3\0\4\12\1\261\21\12\34\0\3\12\1\262\1\12"+
    "\3\0\26\12\34\0\5\12\3\0\6\12\1\263\17\12"+
    "\34\0\5\12\3\0\4\12\1\264\21\12\34\0\2\12"+
    "\1\265\2\12\3\0\26\12\34\0\3\12\1\266\1\12"+
    "\3\0\26\12\34\0\5\12\3\0\6\12\1\267\17\12"+
    "\34\0\5\12\3\0\6\12\1\270\17\12\34\0\5\12"+
    "\3\0\4\12\1\271\21\12\34\0\5\12\3\0\1\12"+
    "\1\272\24\12\34\0\5\12\3\0\14\12\1\273\11\12"+
    "\34\0\5\12\3\0\6\12\1\274\17\12\34\0\5\12"+
    "\3\0\7\12\1\275\16\12\34\0\3\12\1\276\1\12"+
    "\3\0\26\12\34\0\5\12\3\0\12\12\1\277\13\12"+
    "\34\0\5\12\3\0\17\12\1\300\6\12\34\0\5\12"+
    "\3\0\22\12\1\301\3\12\34\0\5\12\3\0\6\12"+
    "\1\302\17\12\34\0\5\12\3\0\11\12\1\303\14\12"+
    "\34\0\5\12\3\0\15\12\1\304\10\12\34\0\5\12"+
    "\3\0\11\12\1\305\14\12\34\0\5\12\3\0\7\12"+
    "\1\306\16\12\34\0\5\12\3\0\5\12\1\307\20\12"+
    "\34\0\5\12\3\0\11\12\1\310\14\12\34\0\5\12"+
    "\3\0\5\12\1\311\20\12\34\0\5\12\3\0\7\12"+
    "\1\312\16\12\34\0\5\12\3\0\15\12\1\313\10\12"+
    "\34\0\5\12\3\0\4\12\1\314\21\12\34\0\5\12"+
    "\3\0\4\12\1\315\21\12\34\0\5\12\3\0\1\316"+
    "\25\12\34\0\5\12\3\0\17\12\1\317\6\12\34\0"+
    "\5\12\3\0\7\12\1\320\16\12\34\0\5\12\3\0"+
    "\12\12\1\321\13\12\34\0\5\12\3\0\4\12\1\322"+
    "\21\12\34\0\5\12\3\0\6\12\1\323\17\12\34\0"+
    "\5\12\3\0\4\12\1\324\21\12\34\0\5\12\3\0"+
    "\4\12\1\325\21\12\34\0\5\12\3\0\7\12\1\326"+
    "\16\12\34\0\5\12\3\0\1\327\25\12\34\0\5\12"+
    "\3\0\6\12\1\330\17\12\34\0\5\12\3\0\6\12"+
    "\1\331\17\12\34\0\5\12\3\0\7\12\1\332\16\12"+
    "\34\0\5\12\3\0\14\12\1\333\11\12\34\0\5\12"+
    "\3\0\17\12\1\334\6\12\34\0\5\12\3\0\14\12"+
    "\1\335\11\12\34\0\5\12\3\0\4\12\1\336\21\12"+
    "\34\0\5\12\3\0\2\12\1\337\23\12\34\0\5\12"+
    "\3\0\10\12\1\340\15\12\34\0\5\12\3\0\1\341"+
    "\25\12\34\0\5\12\3\0\4\12\1\342\21\12\26\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[8642];
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
  private static final String[] ZZ_ERROR_MSG = {
    "Unknown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\1\0\1\11\31\1\6\11\12\1\5\11\1\1\1\0"+
    "\1\11\3\0\1\11\1\0\2\1\1\0\6\1\1\0"+
    "\2\11\34\1\14\11\1\0\1\11\1\0\1\11\1\0"+
    "\10\1\1\0\34\1\3\11\6\1\1\11\102\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[226];
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
  private CharSequence zzBuffer = "";

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /**
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;


  /**
   * Creates a new scanner
   *
   * @param   in  the java.io.Reader to read input from.
   */
  SpiceLexer(java.io.Reader in) {
    this.zzReader = in;
  }


  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    int size = 0;
    for (int i = 0, length = packed.length(); i < length; i += 2) {
      size += packed.charAt(i);
    }
    char[] map = new char[size];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < packed.length()) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }

  public final int getTokenStart() {
    return zzStartRead;
  }

  public final int getTokenEnd() {
    return getTokenStart() + yylength();
  }

  public void reset(CharSequence buffer, int start, int end, int initialState) {
    zzBuffer = buffer;
    zzCurrentPos = zzMarkedPos = zzStartRead = start;
    zzAtEOF  = false;
    zzAtBOL = true;
    zzEndRead = end;
    yybegin(initialState);
  }

  /**
   * Refills the input buffer.
   *
   * @return      {@code false}, iff there was new input.
   *
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {
    return true;
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
  public final CharSequence yytext() {
    return zzBuffer.subSequence(zzStartRead, zzMarkedPos);
  }


  /**
   * Returns the character at position {@code pos} from the
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
    return zzBuffer.charAt(zzStartRead+pos);
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occurred while scanning.
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
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() {
    if (!zzEOFDone) {
      zzEOFDone = true;
        return;

    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public IElementType advance() throws java.io.IOException {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    CharSequence zzBufferL = zzBuffer;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;

      zzState = ZZ_LEXSTATE[zzLexicalState];

      // set up zzAction for empty match case:
      int zzAttributes = zzAttrL[zzState];
      if ( (zzAttributes & 1) == 1 ) {
        zzAction = zzState;
      }


      zzForAction: {
        while (true) {

          if (zzCurrentPosL < zzEndReadL) {
            zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
            zzCurrentPosL += Character.charCount(zzInput);
          }
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
              zzInput = Character.codePointAt(zzBufferL, zzCurrentPosL/*, zzEndReadL*/);
              zzCurrentPosL += Character.charCount(zzInput);
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + ZZ_CMAP(zzInput) ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
        zzAtEOF = true;
        zzDoEOF();
        return null;
      }
      else {
        switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
          case 1: 
            { return TokenType.BAD_CHARACTER;
            } 
            // fall through
          case 97: break;
          case 2: 
            { return TokenType.WHITE_SPACE;
            } 
            // fall through
          case 98: break;
          case 3: 
            { return SpiceTypes.INT_LIT;
            } 
            // fall through
          case 99: break;
          case 4: 
            { return SpiceTypes.IDENTIFIER;
            } 
            // fall through
          case 100: break;
          case 5: 
            { return SpiceTypes.DIV;
            } 
            // fall through
          case 101: break;
          case 6: 
            { return SpiceTypes.MUL;
            } 
            // fall through
          case 102: break;
          case 7: 
            { return SpiceTypes.P;
            } 
            // fall through
          case 103: break;
          case 8: 
            { return SpiceTypes.F;
            } 
            // fall through
          case 104: break;
          case 9: 
            { return SpiceTypes.LBRACE;
            } 
            // fall through
          case 105: break;
          case 10: 
            { return SpiceTypes.RBRACE;
            } 
            // fall through
          case 106: break;
          case 11: 
            { return SpiceTypes.LPAREN;
            } 
            // fall through
          case 107: break;
          case 12: 
            { return SpiceTypes.RPAREN;
            } 
            // fall through
          case 108: break;
          case 13: 
            { return SpiceTypes.LBRACKET;
            } 
            // fall through
          case 109: break;
          case 14: 
            { return SpiceTypes.RBRACKET;
            } 
            // fall through
          case 110: break;
          case 15: 
            { return SpiceTypes.BITWISE_OR;
            } 
            // fall through
          case 111: break;
          case 16: 
            { return SpiceTypes.BITWISE_AND;
            } 
            // fall through
          case 112: break;
          case 17: 
            { return SpiceTypes.BITWISE_XOR;
            } 
            // fall through
          case 113: break;
          case 18: 
            { return SpiceTypes.PLUS;
            } 
            // fall through
          case 114: break;
          case 19: 
            { return SpiceTypes.MINUS;
            } 
            // fall through
          case 115: break;
          case 20: 
            { return SpiceTypes.ASSIGN;
            } 
            // fall through
          case 116: break;
          case 21: 
            { return SpiceTypes.REM;
            } 
            // fall through
          case 117: break;
          case 22: 
            { return SpiceTypes.LESS;
            } 
            // fall through
          case 118: break;
          case 23: 
            { return SpiceTypes.GREATER;
            } 
            // fall through
          case 119: break;
          case 24: 
            { return SpiceTypes.NOT;
            } 
            // fall through
          case 120: break;
          case 25: 
            { return SpiceTypes.BITWISE_NOT;
            } 
            // fall through
          case 121: break;
          case 26: 
            { return SpiceTypes.QUESTION_MARK;
            } 
            // fall through
          case 122: break;
          case 27: 
            { return SpiceTypes.SEMICOLON;
            } 
            // fall through
          case 123: break;
          case 28: 
            { return SpiceTypes.COLON;
            } 
            // fall through
          case 124: break;
          case 29: 
            { return SpiceTypes.COMMA;
            } 
            // fall through
          case 125: break;
          case 30: 
            { return SpiceTypes.DOT;
            } 
            // fall through
          case 126: break;
          case 31: 
            { return SpiceTypes.CHAR_LIT;
            } 
            // fall through
          case 127: break;
          case 32: 
            { return SpiceTypes.STRING_LIT;
            } 
            // fall through
          case 128: break;
          case 33: 
            { return SpiceTypes.SHORT_LIT;
            } 
            // fall through
          case 129: break;
          case 34: 
            { return SpiceTypes.LONG_LIT;
            } 
            // fall through
          case 130: break;
          case 35: 
            { return SpiceTypes.LINE_COMMENT;
            } 
            // fall through
          case 131: break;
          case 36: 
            { return SpiceTypes.DIV_EQUAL;
            } 
            // fall through
          case 132: break;
          case 37: 
            { return SpiceTypes.MUL_EQUAL;
            } 
            // fall through
          case 133: break;
          case 38: 
            { return SpiceTypes.IF;
            } 
            // fall through
          case 134: break;
          case 39: 
            { return SpiceTypes.AS;
            } 
            // fall through
          case 135: break;
          case 40: 
            { return SpiceTypes.LOGICAL_OR;
            } 
            // fall through
          case 136: break;
          case 41: 
            { return SpiceTypes.OR_EQUAL;
            } 
            // fall through
          case 137: break;
          case 42: 
            { return SpiceTypes.LOGICAL_AND;
            } 
            // fall through
          case 138: break;
          case 43: 
            { return SpiceTypes.AND_EQUAL;
            } 
            // fall through
          case 139: break;
          case 44: 
            { return SpiceTypes.XOR_EQUAL;
            } 
            // fall through
          case 140: break;
          case 45: 
            { return SpiceTypes.PLUS_PLUS;
            } 
            // fall through
          case 141: break;
          case 46: 
            { return SpiceTypes.PLUS_EQUAL;
            } 
            // fall through
          case 142: break;
          case 47: 
            { return SpiceTypes.MINUS_MINUS;
            } 
            // fall through
          case 143: break;
          case 48: 
            { return SpiceTypes.MINUS_EQUAL;
            } 
            // fall through
          case 144: break;
          case 49: 
            { return SpiceTypes.EQUAL;
            } 
            // fall through
          case 145: break;
          case 50: 
            { return SpiceTypes.REM_EQUAL;
            } 
            // fall through
          case 146: break;
          case 51: 
            { return SpiceTypes.LESS_EQUAL;
            } 
            // fall through
          case 147: break;
          case 52: 
            { return SpiceTypes.GREATER_EQUAL;
            } 
            // fall through
          case 148: break;
          case 53: 
            { return SpiceTypes.NOT_EQUAL;
            } 
            // fall through
          case 149: break;
          case 54: 
            { return SpiceTypes.DOUBLE_LIT;
            } 
            // fall through
          case 150: break;
          case 55: 
            { return SpiceTypes.LEN;
            } 
            // fall through
          case 151: break;
          case 56: 
            { return SpiceTypes.DLL;
            } 
            // fall through
          case 152: break;
          case 57: 
            { return SpiceTypes.TYPE_DYN;
            } 
            // fall through
          case 153: break;
          case 58: 
            { return SpiceTypes.EXT;
            } 
            // fall through
          case 154: break;
          case 59: 
            { return SpiceTypes.TYPE_INT;
            } 
            // fall through
          case 155: break;
          case 60: 
            { return SpiceTypes.NIL;
            } 
            // fall through
          case 156: break;
          case 61: 
            { return SpiceTypes.TID;
            } 
            // fall through
          case 157: break;
          case 62: 
            { return SpiceTypes.FOR;
            } 
            // fall through
          case 158: break;
          case 63: 
            { return SpiceTypes.SHL_EQUAL;
            } 
            // fall through
          case 159: break;
          case 64: 
            { return SpiceTypes.SHR_EQUAL;
            } 
            // fall through
          case 160: break;
          case 65: 
            { return SpiceTypes.ELLIPSIS;
            } 
            // fall through
          case 161: break;
          case 66: 
            { return SpiceTypes.TYPE_LONG;
            } 
            // fall through
          case 162: break;
          case 67: 
            { return SpiceTypes.BLOCK_COMMENT;
            } 
            // fall through
          case 163: break;
          case 68: 
            { return SpiceTypes.TYPE_BOOL;
            } 
            // fall through
          case 164: break;
          case 69: 
            { return SpiceTypes.TYPE_BYTE;
            } 
            // fall through
          case 165: break;
          case 70: 
            { return SpiceTypes.ELSE;
            } 
            // fall through
          case 166: break;
          case 71: 
            { return SpiceTypes.TRUE;
            } 
            // fall through
          case 167: break;
          case 72: 
            { return SpiceTypes.TYPE;
            } 
            // fall through
          case 168: break;
          case 73: 
            { return SpiceTypes.TYPE_CHAR;
            } 
            // fall through
          case 169: break;
          case 74: 
            { return SpiceTypes.MAIN;
            } 
            // fall through
          case 170: break;
          case 75: 
            { return SpiceTypes.JOIN;
            } 
            // fall through
          case 171: break;
          case 76: 
            { return SpiceTypes.TYPE_SHORT;
            } 
            // fall through
          case 172: break;
          case 77: 
            { return SpiceTypes.BREAK;
            } 
            // fall through
          case 173: break;
          case 78: 
            { return SpiceTypes.CONST;
            } 
            // fall through
          case 174: break;
          case 79: 
            { return SpiceTypes.FALSE;
            } 
            // fall through
          case 175: break;
          case 80: 
            { return SpiceTypes.WHILE;
            } 
            // fall through
          case 176: break;
          case 81: 
            { return SpiceTypes.SIGNED;
            } 
            // fall through
          case 177: break;
          case 82: 
            { return SpiceTypes.SIZEOF;
            } 
            // fall through
          case 178: break;
          case 83: 
            { return SpiceTypes.STRUCT;
            } 
            // fall through
          case 179: break;
          case 84: 
            { return SpiceTypes.TYPE_STRING;
            } 
            // fall through
          case 180: break;
          case 85: 
            { return SpiceTypes.TYPE_DOUBLE;
            } 
            // fall through
          case 181: break;
          case 86: 
            { return SpiceTypes.UNSAFE;
            } 
            // fall through
          case 182: break;
          case 87: 
            { return SpiceTypes.INLINE;
            } 
            // fall through
          case 183: break;
          case 88: 
            { return SpiceTypes.IMPORT;
            } 
            // fall through
          case 184: break;
          case 89: 
            { return SpiceTypes.THREAD;
            } 
            // fall through
          case 185: break;
          case 90: 
            { return SpiceTypes.RETURN;
            } 
            // fall through
          case 186: break;
          case 91: 
            { return SpiceTypes.ASSERT;
            } 
            // fall through
          case 187: break;
          case 92: 
            { return SpiceTypes.PUBLIC;
            } 
            // fall through
          case 188: break;
          case 93: 
            { return SpiceTypes.PRINTF;
            } 
            // fall through
          case 189: break;
          case 94: 
            { return SpiceTypes.FOREACH;
            } 
            // fall through
          case 190: break;
          case 95: 
            { return SpiceTypes.UNSIGNED;
            } 
            // fall through
          case 191: break;
          case 96: 
            { return SpiceTypes.CONTINUE;
            } 
            // fall through
          case 192: break;
          default:
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
