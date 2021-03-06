// This is a generated file. Not intended for manual editing.
package com.spicelang.intellij.spice;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.spicelang.intellij.spice.psi.SpiceTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class SpiceParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return spiceFile(b, l + 1);
  }

  /* ********************************************************** */
  // multiplicativeExpr ((PLUS | MINUS) multiplicativeExpr)*
  public static boolean additiveExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additiveExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ADDITIVE_EXPR, "<additive expr>");
    r = multiplicativeExpr(b, l + 1);
    r = r && additiveExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ((PLUS | MINUS) multiplicativeExpr)*
  private static boolean additiveExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additiveExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!additiveExpr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "additiveExpr_1", c)) break;
    }
    return true;
  }

  // (PLUS | MINUS) multiplicativeExpr
  private static boolean additiveExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additiveExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = additiveExpr_1_0_0(b, l + 1);
    r = r && multiplicativeExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // PLUS | MINUS
  private static boolean additiveExpr_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "additiveExpr_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    return r;
  }

  /* ********************************************************** */
  // assignExpr (COMMA assignExpr)*
  public static boolean argLst(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argLst")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARG_LST, "<arg lst>");
    r = assignExpr(b, l + 1);
    r = r && argLst_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA assignExpr)*
  private static boolean argLst_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argLst_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!argLst_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "argLst_1", c)) break;
    }
    return true;
  }

  // COMMA assignExpr
  private static boolean argLst_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argLst_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && assignExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // declStmt (COMMA declStmt)*
  public static boolean argLstDef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argLstDef")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARG_LST_DEF, "<arg lst def>");
    r = declStmt(b, l + 1);
    r = r && argLstDef_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA declStmt)*
  private static boolean argLstDef_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argLstDef_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!argLstDef_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "argLstDef_1", c)) break;
    }
    return true;
  }

  // COMMA declStmt
  private static boolean argLstDef_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "argLstDef_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && declStmt(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LBRACE argLst? RBRACE
  public static boolean arrayInitialization(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayInitialization")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && arrayInitialization_1(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, ARRAY_INITIALIZATION, r);
    return r;
  }

  // argLst?
  private static boolean arrayInitialization_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayInitialization_1")) return false;
    argLst(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ASSERT assignExpr SEMICOLON
  public static boolean assertStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assertStmt")) return false;
    if (!nextTokenIs(b, ASSERT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSERT);
    r = r && assignExpr(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, ASSERT_STMT, r);
    return r;
  }

  /* ********************************************************** */
  // prefixUnaryExpr assignOp assignExpr | ternaryExpr | threadDef
  public static boolean assignExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSIGN_EXPR, "<assign expr>");
    r = assignExpr_0(b, l + 1);
    if (!r) r = ternaryExpr(b, l + 1);
    if (!r) r = threadDef(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // prefixUnaryExpr assignOp assignExpr
  private static boolean assignExpr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignExpr_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = prefixUnaryExpr(b, l + 1);
    r = r && assignOp(b, l + 1);
    r = r && assignExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ASSIGN | PLUS_EQUAL | MINUS_EQUAL | MUL_EQUAL | DIV_EQUAL | REM_EQUAL | SHL_EQUAL | SHR_EQUAL | AND_EQUAL | OR_EQUAL | XOR_EQUAL
  public static boolean assignOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignOp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSIGN_OP, "<assign op>");
    r = consumeToken(b, ASSIGN);
    if (!r) r = consumeToken(b, PLUS_EQUAL);
    if (!r) r = consumeToken(b, MINUS_EQUAL);
    if (!r) r = consumeToken(b, MUL_EQUAL);
    if (!r) r = consumeToken(b, DIV_EQUAL);
    if (!r) r = consumeToken(b, REM_EQUAL);
    if (!r) r = consumeToken(b, SHL_EQUAL);
    if (!r) r = consumeToken(b, SHR_EQUAL);
    if (!r) r = consumeToken(b, AND_EQUAL);
    if (!r) r = consumeToken(b, OR_EQUAL);
    if (!r) r = consumeToken(b, XOR_EQUAL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // value | identifierExpr | builtinCall | LPAREN assignExpr RPAREN
  public static boolean atomicExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atomicExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATOMIC_EXPR, "<atomic expr>");
    r = value(b, l + 1);
    if (!r) r = identifierExpr(b, l + 1);
    if (!r) r = builtinCall(b, l + 1);
    if (!r) r = atomicExpr_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LPAREN assignExpr RPAREN
  private static boolean atomicExpr_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atomicExpr_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && assignExpr(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // TYPE_DOUBLE | TYPE_INT | TYPE_SHORT | TYPE_LONG | TYPE_BYTE | TYPE_CHAR | TYPE_STRING | TYPE_BOOL | TYPE_DYN | customDataType
  public static boolean baseDataType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "baseDataType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BASE_DATA_TYPE, "<base data type>");
    r = consumeToken(b, TYPE_DOUBLE);
    if (!r) r = consumeToken(b, TYPE_INT);
    if (!r) r = consumeToken(b, TYPE_SHORT);
    if (!r) r = consumeToken(b, TYPE_LONG);
    if (!r) r = consumeToken(b, TYPE_BYTE);
    if (!r) r = consumeToken(b, TYPE_CHAR);
    if (!r) r = consumeToken(b, TYPE_STRING);
    if (!r) r = consumeToken(b, TYPE_BOOL);
    if (!r) r = consumeToken(b, TYPE_DYN);
    if (!r) r = customDataType(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // equalityExpr (BITWISE_AND equalityExpr)*
  public static boolean bitwiseAndExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitwiseAndExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BITWISE_AND_EXPR, "<bitwise and expr>");
    r = equalityExpr(b, l + 1);
    r = r && bitwiseAndExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (BITWISE_AND equalityExpr)*
  private static boolean bitwiseAndExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitwiseAndExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!bitwiseAndExpr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "bitwiseAndExpr_1", c)) break;
    }
    return true;
  }

  // BITWISE_AND equalityExpr
  private static boolean bitwiseAndExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitwiseAndExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BITWISE_AND);
    r = r && equalityExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // bitwiseXorExpr (BITWISE_OR bitwiseXorExpr)*
  public static boolean bitwiseOrExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitwiseOrExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BITWISE_OR_EXPR, "<bitwise or expr>");
    r = bitwiseXorExpr(b, l + 1);
    r = r && bitwiseOrExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (BITWISE_OR bitwiseXorExpr)*
  private static boolean bitwiseOrExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitwiseOrExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!bitwiseOrExpr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "bitwiseOrExpr_1", c)) break;
    }
    return true;
  }

  // BITWISE_OR bitwiseXorExpr
  private static boolean bitwiseOrExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitwiseOrExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BITWISE_OR);
    r = r && bitwiseXorExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // bitwiseAndExpr (BITWISE_XOR bitwiseAndExpr)*
  public static boolean bitwiseXorExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitwiseXorExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BITWISE_XOR_EXPR, "<bitwise xor expr>");
    r = bitwiseAndExpr(b, l + 1);
    r = r && bitwiseXorExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (BITWISE_XOR bitwiseAndExpr)*
  private static boolean bitwiseXorExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitwiseXorExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!bitwiseXorExpr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "bitwiseXorExpr_1", c)) break;
    }
    return true;
  }

  // BITWISE_XOR bitwiseAndExpr
  private static boolean bitwiseXorExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bitwiseXorExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BITWISE_XOR);
    r = r && bitwiseAndExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // BLOCK_COMMENT
  public static boolean blockCom(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "blockCom")) return false;
    if (!nextTokenIs(b, BLOCK_COMMENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BLOCK_COMMENT);
    exit_section_(b, m, BLOCK_COM, r);
    return r;
  }

  /* ********************************************************** */
  // BREAK INTEGER?
  public static boolean breakStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "breakStmt")) return false;
    if (!nextTokenIs(b, BREAK)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BREAK);
    r = r && breakStmt_1(b, l + 1);
    exit_section_(b, m, BREAK_STMT, r);
    return r;
  }

  // INTEGER?
  private static boolean breakStmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "breakStmt_1")) return false;
    consumeToken(b, INTEGER);
    return true;
  }

  /* ********************************************************** */
  // printfCall | sizeOfCall | lenCall | tidCall | joinCall
  public static boolean builtinCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "builtinCall")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BUILTIN_CALL, "<builtin call>");
    r = printfCall(b, l + 1);
    if (!r) r = sizeOfCall(b, l + 1);
    if (!r) r = lenCall(b, l + 1);
    if (!r) r = tidCall(b, l + 1);
    if (!r) r = joinCall(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // prefixUnaryExpr | LPAREN dataType RPAREN prefixUnaryExpr
  public static boolean castExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "castExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CAST_EXPR, "<cast expr>");
    r = prefixUnaryExpr(b, l + 1);
    if (!r) r = castExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // LPAREN dataType RPAREN prefixUnaryExpr
  private static boolean castExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "castExpr_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && dataType(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && prefixUnaryExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // CONTINUE INTEGER?
  public static boolean continueStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "continueStmt")) return false;
    if (!nextTokenIs(b, CONTINUE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CONTINUE);
    r = r && continueStmt_1(b, l + 1);
    exit_section_(b, m, CONTINUE_STMT, r);
    return r;
  }

  // INTEGER?
  private static boolean continueStmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "continueStmt_1")) return false;
    consumeToken(b, INTEGER);
    return true;
  }

  /* ********************************************************** */
  // identifierExpr (DOT identifierExpr)* (LESS typeLst GREATER)?
  public static boolean customDataType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "customDataType")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifierExpr(b, l + 1);
    r = r && customDataType_1(b, l + 1);
    r = r && customDataType_2(b, l + 1);
    exit_section_(b, m, CUSTOM_DATA_TYPE, r);
    return r;
  }

  // (DOT identifierExpr)*
  private static boolean customDataType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "customDataType_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!customDataType_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "customDataType_1", c)) break;
    }
    return true;
  }

  // DOT identifierExpr
  private static boolean customDataType_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "customDataType_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && identifierExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (LESS typeLst GREATER)?
  private static boolean customDataType_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "customDataType_2")) return false;
    customDataType_2_0(b, l + 1);
    return true;
  }

  // LESS typeLst GREATER
  private static boolean customDataType_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "customDataType_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LESS);
    r = r && typeLst(b, l + 1);
    r = r && consumeToken(b, GREATER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // baseDataType (MUL | LBRACKET (INTEGER | assignExpr)? RBRACKET)*
  public static boolean dataType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DATA_TYPE, "<data type>");
    r = baseDataType(b, l + 1);
    r = r && dataType_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (MUL | LBRACKET (INTEGER | assignExpr)? RBRACKET)*
  private static boolean dataType_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataType_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!dataType_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "dataType_1", c)) break;
    }
    return true;
  }

  // MUL | LBRACKET (INTEGER | assignExpr)? RBRACKET
  private static boolean dataType_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataType_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MUL);
    if (!r) r = dataType_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LBRACKET (INTEGER | assignExpr)? RBRACKET
  private static boolean dataType_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataType_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACKET);
    r = r && dataType_1_0_1_1(b, l + 1);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // (INTEGER | assignExpr)?
  private static boolean dataType_1_0_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataType_1_0_1_1")) return false;
    dataType_1_0_1_1_0(b, l + 1);
    return true;
  }

  // INTEGER | assignExpr
  private static boolean dataType_1_0_1_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataType_1_0_1_1_0")) return false;
    boolean r;
    r = consumeToken(b, INTEGER);
    if (!r) r = assignExpr(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // specifierLst? dataType identifierExpr (ASSIGN assignExpr)?
  public static boolean declStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declStmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DECL_STMT, "<decl stmt>");
    r = declStmt_0(b, l + 1);
    r = r && dataType(b, l + 1);
    r = r && identifierExpr(b, l + 1);
    r = r && declStmt_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // specifierLst?
  private static boolean declStmt_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declStmt_0")) return false;
    specifierLst(b, l + 1);
    return true;
  }

  // (ASSIGN assignExpr)?
  private static boolean declStmt_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declStmt_3")) return false;
    declStmt_3_0(b, l + 1);
    return true;
  }

  // ASSIGN assignExpr
  private static boolean declStmt_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declStmt_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGN);
    r = r && assignExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // ELSE ifStmt | ELSE LBRACE stmtLst RBRACE
  public static boolean elseStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseStmt")) return false;
    if (!nextTokenIs(b, ELSE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = elseStmt_0(b, l + 1);
    if (!r) r = elseStmt_1(b, l + 1);
    exit_section_(b, m, ELSE_STMT, r);
    return r;
  }

  // ELSE ifStmt
  private static boolean elseStmt_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseStmt_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && ifStmt(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ELSE LBRACE stmtLst RBRACE
  private static boolean elseStmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseStmt_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ELSE, LBRACE);
    r = r && stmtLst(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // relationalExpr ((EQUAL | NOT_EQUAL) relationalExpr)?
  public static boolean equalityExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equalityExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EQUALITY_EXPR, "<equality expr>");
    r = relationalExpr(b, l + 1);
    r = r && equalityExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ((EQUAL | NOT_EQUAL) relationalExpr)?
  private static boolean equalityExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equalityExpr_1")) return false;
    equalityExpr_1_0(b, l + 1);
    return true;
  }

  // (EQUAL | NOT_EQUAL) relationalExpr
  private static boolean equalityExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equalityExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = equalityExpr_1_0_0(b, l + 1);
    r = r && relationalExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // EQUAL | NOT_EQUAL
  private static boolean equalityExpr_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equalityExpr_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, EQUAL);
    if (!r) r = consumeToken(b, NOT_EQUAL);
    return r;
  }

  /* ********************************************************** */
  // EXT (LESS dataType GREATER)? identifierExpr LPAREN typeLstEllipsis? RPAREN DLL? SEMICOLON
  public static boolean extDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extDecl")) return false;
    if (!nextTokenIs(b, EXT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, EXT);
    r = r && extDecl_1(b, l + 1);
    r = r && identifierExpr(b, l + 1);
    r = r && consumeToken(b, LPAREN);
    r = r && extDecl_4(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && extDecl_6(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, EXT_DECL, r);
    return r;
  }

  // (LESS dataType GREATER)?
  private static boolean extDecl_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extDecl_1")) return false;
    extDecl_1_0(b, l + 1);
    return true;
  }

  // LESS dataType GREATER
  private static boolean extDecl_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extDecl_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LESS);
    r = r && dataType(b, l + 1);
    r = r && consumeToken(b, GREATER);
    exit_section_(b, m, null, r);
    return r;
  }

  // typeLstEllipsis?
  private static boolean extDecl_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extDecl_4")) return false;
    typeLstEllipsis(b, l + 1);
    return true;
  }

  // DLL?
  private static boolean extDecl_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extDecl_6")) return false;
    consumeToken(b, DLL);
    return true;
  }

  /* ********************************************************** */
  // specifierLst? dataType IDENTIFIER
  public static boolean field(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD, "<field>");
    r = field_0(b, l + 1);
    r = r && dataType(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // specifierLst?
  private static boolean field_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_0")) return false;
    specifierLst(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // declStmt SEMICOLON assignExpr SEMICOLON assignExpr
  public static boolean forHead(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forHead")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FOR_HEAD, "<for head>");
    r = declStmt(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    r = r && assignExpr(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    r = r && assignExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // FOR (forHead | LPAREN forHead RPAREN) LBRACE stmtLst RBRACE
  public static boolean forLoop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forLoop")) return false;
    if (!nextTokenIs(b, FOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FOR);
    r = r && forLoop_1(b, l + 1);
    r = r && consumeToken(b, LBRACE);
    r = r && stmtLst(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, FOR_LOOP, r);
    return r;
  }

  // forHead | LPAREN forHead RPAREN
  private static boolean forLoop_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forLoop_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = forHead(b, l + 1);
    if (!r) r = forLoop_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LPAREN forHead RPAREN
  private static boolean forLoop_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forLoop_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && forHead(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (declStmt COMMA)? declStmt COLON assignExpr
  public static boolean foreachHead(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "foreachHead")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FOREACH_HEAD, "<foreach head>");
    r = foreachHead_0(b, l + 1);
    r = r && declStmt(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && assignExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (declStmt COMMA)?
  private static boolean foreachHead_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "foreachHead_0")) return false;
    foreachHead_0_0(b, l + 1);
    return true;
  }

  // declStmt COMMA
  private static boolean foreachHead_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "foreachHead_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = declStmt(b, l + 1);
    r = r && consumeToken(b, COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // FOREACH (foreachHead | LPAREN foreachHead RPAREN) LBRACE stmtLst RBRACE
  public static boolean foreachLoop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "foreachLoop")) return false;
    if (!nextTokenIs(b, FOREACH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FOREACH);
    r = r && foreachLoop_1(b, l + 1);
    r = r && consumeToken(b, LBRACE);
    r = r && stmtLst(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, FOREACH_LOOP, r);
    return r;
  }

  // foreachHead | LPAREN foreachHead RPAREN
  private static boolean foreachLoop_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "foreachLoop_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = foreachHead(b, l + 1);
    if (!r) r = foreachLoop_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LPAREN foreachHead RPAREN
  private static boolean foreachLoop_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "foreachLoop_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && foreachHead(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // identifierExpr (DOT identifierExpr)* (LESS typeLst GREATER)? LPAREN argLst? RPAREN
  public static boolean functionCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifierExpr(b, l + 1);
    r = r && functionCall_1(b, l + 1);
    r = r && functionCall_2(b, l + 1);
    r = r && consumeToken(b, LPAREN);
    r = r && functionCall_4(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, FUNCTION_CALL, r);
    return r;
  }

  // (DOT identifierExpr)*
  private static boolean functionCall_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!functionCall_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "functionCall_1", c)) break;
    }
    return true;
  }

  // DOT identifierExpr
  private static boolean functionCall_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && identifierExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (LESS typeLst GREATER)?
  private static boolean functionCall_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall_2")) return false;
    functionCall_2_0(b, l + 1);
    return true;
  }

  // LESS typeLst GREATER
  private static boolean functionCall_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LESS);
    r = r && typeLst(b, l + 1);
    r = r && consumeToken(b, GREATER);
    exit_section_(b, m, null, r);
    return r;
  }

  // argLst?
  private static boolean functionCall_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall_4")) return false;
    argLst(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // specifierLst? F LESS dataType GREATER (identifierExpr DOT)? identifierExpr templateDef? LPAREN argLstDef? RPAREN LBRACE stmtLst RBRACE
  public static boolean functionDef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDef")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_DEF, "<function def>");
    r = functionDef_0(b, l + 1);
    r = r && consumeTokens(b, 0, F, LESS);
    r = r && dataType(b, l + 1);
    r = r && consumeToken(b, GREATER);
    r = r && functionDef_5(b, l + 1);
    r = r && identifierExpr(b, l + 1);
    r = r && functionDef_7(b, l + 1);
    r = r && consumeToken(b, LPAREN);
    r = r && functionDef_9(b, l + 1);
    r = r && consumeTokens(b, 0, RPAREN, LBRACE);
    r = r && stmtLst(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // specifierLst?
  private static boolean functionDef_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDef_0")) return false;
    specifierLst(b, l + 1);
    return true;
  }

  // (identifierExpr DOT)?
  private static boolean functionDef_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDef_5")) return false;
    functionDef_5_0(b, l + 1);
    return true;
  }

  // identifierExpr DOT
  private static boolean functionDef_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDef_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifierExpr(b, l + 1);
    r = r && consumeToken(b, DOT);
    exit_section_(b, m, null, r);
    return r;
  }

  // templateDef?
  private static boolean functionDef_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDef_7")) return false;
    templateDef(b, l + 1);
    return true;
  }

  // argLstDef?
  private static boolean functionDef_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDef_9")) return false;
    argLstDef(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // specifierLst? TYPE IDENTIFIER typeAlts SEMICOLON
  public static boolean genericTypeDef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "genericTypeDef")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GENERIC_TYPE_DEF, "<generic type def>");
    r = genericTypeDef_0(b, l + 1);
    r = r && consumeTokens(b, 0, TYPE, IDENTIFIER);
    r = r && typeAlts(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // specifierLst?
  private static boolean genericTypeDef_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "genericTypeDef_0")) return false;
    specifierLst(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // specifierLst? dataType identifierExpr (ASSIGN MINUS? value)? SEMICOLON
  public static boolean globalVarDef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "globalVarDef")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GLOBAL_VAR_DEF, "<global var def>");
    r = globalVarDef_0(b, l + 1);
    r = r && dataType(b, l + 1);
    r = r && identifierExpr(b, l + 1);
    r = r && globalVarDef_3(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // specifierLst?
  private static boolean globalVarDef_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "globalVarDef_0")) return false;
    specifierLst(b, l + 1);
    return true;
  }

  // (ASSIGN MINUS? value)?
  private static boolean globalVarDef_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "globalVarDef_3")) return false;
    globalVarDef_3_0(b, l + 1);
    return true;
  }

  // ASSIGN MINUS? value
  private static boolean globalVarDef_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "globalVarDef_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGN);
    r = r && globalVarDef_3_0_1(b, l + 1);
    r = r && value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // MINUS?
  private static boolean globalVarDef_3_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "globalVarDef_3_0_1")) return false;
    consumeToken(b, MINUS);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER
  public static boolean identifierExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifierExpr")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    exit_section_(b, m, IDENTIFIER_EXPR, r);
    return r;
  }

  /* ********************************************************** */
  // IF assignExpr LBRACE stmtLst RBRACE elseStmt?
  public static boolean ifStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifStmt")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && assignExpr(b, l + 1);
    r = r && consumeToken(b, LBRACE);
    r = r && stmtLst(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    r = r && ifStmt_5(b, l + 1);
    exit_section_(b, m, IF_STMT, r);
    return r;
  }

  // elseStmt?
  private static boolean ifStmt_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifStmt_5")) return false;
    elseStmt(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IMPORT STRING_LITERAL AS identifierExpr SEMICOLON
  public static boolean importStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "importStmt")) return false;
    if (!nextTokenIs(b, IMPORT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IMPORT, STRING_LITERAL, AS);
    r = r && identifierExpr(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, IMPORT_STMT, r);
    return r;
  }

  /* ********************************************************** */
  // JOIN LPAREN assignExpr (COMMA assignExpr)* RPAREN
  public static boolean joinCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "joinCall")) return false;
    if (!nextTokenIs(b, JOIN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, JOIN, LPAREN);
    r = r && assignExpr(b, l + 1);
    r = r && joinCall_3(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, JOIN_CALL, r);
    return r;
  }

  // (COMMA assignExpr)*
  private static boolean joinCall_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "joinCall_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!joinCall_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "joinCall_3", c)) break;
    }
    return true;
  }

  // COMMA assignExpr
  private static boolean joinCall_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "joinCall_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && assignExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // LEN LPAREN assignExpr RPAREN
  public static boolean lenCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lenCall")) return false;
    if (!nextTokenIs(b, LEN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LEN, LPAREN);
    r = r && assignExpr(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, LEN_CALL, r);
    return r;
  }

  /* ********************************************************** */
  // LINE_COMMENT
  public static boolean lineCom(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lineCom")) return false;
    if (!nextTokenIs(b, LINE_COMMENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LINE_COMMENT);
    exit_section_(b, m, LINE_COM, r);
    return r;
  }

  /* ********************************************************** */
  // bitwiseOrExpr (LOGICAL_AND bitwiseOrExpr)*
  public static boolean logicalAndExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logicalAndExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LOGICAL_AND_EXPR, "<logical and expr>");
    r = bitwiseOrExpr(b, l + 1);
    r = r && logicalAndExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (LOGICAL_AND bitwiseOrExpr)*
  private static boolean logicalAndExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logicalAndExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!logicalAndExpr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "logicalAndExpr_1", c)) break;
    }
    return true;
  }

  // LOGICAL_AND bitwiseOrExpr
  private static boolean logicalAndExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logicalAndExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LOGICAL_AND);
    r = r && bitwiseOrExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // logicalAndExpr (LOGICAL_OR logicalAndExpr)*
  public static boolean logicalOrExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logicalOrExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LOGICAL_OR_EXPR, "<logical or expr>");
    r = logicalAndExpr(b, l + 1);
    r = r && logicalOrExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (LOGICAL_OR logicalAndExpr)*
  private static boolean logicalOrExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logicalOrExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!logicalOrExpr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "logicalOrExpr_1", c)) break;
    }
    return true;
  }

  // LOGICAL_OR logicalAndExpr
  private static boolean logicalOrExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "logicalOrExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LOGICAL_OR);
    r = r && logicalAndExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // F LESS TYPE_INT GREATER MAIN LPAREN argLstDef? RPAREN LBRACE stmtLst RBRACE
  public static boolean mainFunctionDef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mainFunctionDef")) return false;
    if (!nextTokenIs(b, F)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, F, LESS, TYPE_INT, GREATER, MAIN, LPAREN);
    r = r && mainFunctionDef_6(b, l + 1);
    r = r && consumeTokens(b, 0, RPAREN, LBRACE);
    r = r && stmtLst(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, MAIN_FUNCTION_DEF, r);
    return r;
  }

  // argLstDef?
  private static boolean mainFunctionDef_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mainFunctionDef_6")) return false;
    argLstDef(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // castExpr ((MUL | DIV | REM) castExpr)*
  public static boolean multiplicativeExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicativeExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MULTIPLICATIVE_EXPR, "<multiplicative expr>");
    r = castExpr(b, l + 1);
    r = r && multiplicativeExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ((MUL | DIV | REM) castExpr)*
  private static boolean multiplicativeExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicativeExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!multiplicativeExpr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "multiplicativeExpr_1", c)) break;
    }
    return true;
  }

  // (MUL | DIV | REM) castExpr
  private static boolean multiplicativeExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicativeExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = multiplicativeExpr_1_0_0(b, l + 1);
    r = r && castExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // MUL | DIV | REM
  private static boolean multiplicativeExpr_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiplicativeExpr_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, MUL);
    if (!r) r = consumeToken(b, DIV);
    if (!r) r = consumeToken(b, REM);
    return r;
  }

  /* ********************************************************** */
  // atomicExpr (LBRACKET assignExpr RBRACKET | DOT postfixUnaryExpr | PLUS_PLUS | MINUS_MINUS)*
  public static boolean postfixUnaryExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "postfixUnaryExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, POSTFIX_UNARY_EXPR, "<postfix unary expr>");
    r = atomicExpr(b, l + 1);
    r = r && postfixUnaryExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (LBRACKET assignExpr RBRACKET | DOT postfixUnaryExpr | PLUS_PLUS | MINUS_MINUS)*
  private static boolean postfixUnaryExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "postfixUnaryExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!postfixUnaryExpr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "postfixUnaryExpr_1", c)) break;
    }
    return true;
  }

  // LBRACKET assignExpr RBRACKET | DOT postfixUnaryExpr | PLUS_PLUS | MINUS_MINUS
  private static boolean postfixUnaryExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "postfixUnaryExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = postfixUnaryExpr_1_0_0(b, l + 1);
    if (!r) r = postfixUnaryExpr_1_0_1(b, l + 1);
    if (!r) r = consumeToken(b, PLUS_PLUS);
    if (!r) r = consumeToken(b, MINUS_MINUS);
    exit_section_(b, m, null, r);
    return r;
  }

  // LBRACKET assignExpr RBRACKET
  private static boolean postfixUnaryExpr_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "postfixUnaryExpr_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACKET);
    r = r && assignExpr(b, l + 1);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // DOT postfixUnaryExpr
  private static boolean postfixUnaryExpr_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "postfixUnaryExpr_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && postfixUnaryExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // prefixUnaryOp* postfixUnaryExpr
  public static boolean prefixUnaryExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefixUnaryExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PREFIX_UNARY_EXPR, "<prefix unary expr>");
    r = prefixUnaryExpr_0(b, l + 1);
    r = r && postfixUnaryExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // prefixUnaryOp*
  private static boolean prefixUnaryExpr_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefixUnaryExpr_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!prefixUnaryOp(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "prefixUnaryExpr_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // MINUS | PLUS_PLUS | MINUS_MINUS | NOT | BITWISE_NOT | MUL | BITWISE_AND | LOGICAL_AND
  public static boolean prefixUnaryOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefixUnaryOp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PREFIX_UNARY_OP, "<prefix unary op>");
    r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, PLUS_PLUS);
    if (!r) r = consumeToken(b, MINUS_MINUS);
    if (!r) r = consumeToken(b, NOT);
    if (!r) r = consumeToken(b, BITWISE_NOT);
    if (!r) r = consumeToken(b, MUL);
    if (!r) r = consumeToken(b, BITWISE_AND);
    if (!r) r = consumeToken(b, LOGICAL_AND);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE | INTEGER | SHORT | LONG | CHAR_LITERAL | STRING_LITERAL | TRUE | FALSE
  public static boolean primitiveValue(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "primitiveValue")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PRIMITIVE_VALUE, "<primitive value>");
    r = consumeToken(b, DOUBLE);
    if (!r) r = consumeToken(b, INTEGER);
    if (!r) r = consumeToken(b, SHORT);
    if (!r) r = consumeToken(b, LONG);
    if (!r) r = consumeToken(b, CHAR_LITERAL);
    if (!r) r = consumeToken(b, STRING_LITERAL);
    if (!r) r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PRINTF LPAREN STRING_LITERAL (COMMA assignExpr)* RPAREN
  public static boolean printfCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "printfCall")) return false;
    if (!nextTokenIs(b, PRINTF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PRINTF, LPAREN, STRING_LITERAL);
    r = r && printfCall_3(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, PRINTF_CALL, r);
    return r;
  }

  // (COMMA assignExpr)*
  private static boolean printfCall_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "printfCall_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!printfCall_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "printfCall_3", c)) break;
    }
    return true;
  }

  // COMMA assignExpr
  private static boolean printfCall_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "printfCall_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && assignExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // specifierLst? P (identifierExpr DOT)? identifierExpr templateDef? LPAREN argLstDef? RPAREN LBRACE stmtLst RBRACE
  public static boolean procedureDef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "procedureDef")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROCEDURE_DEF, "<procedure def>");
    r = procedureDef_0(b, l + 1);
    r = r && consumeToken(b, P);
    r = r && procedureDef_2(b, l + 1);
    r = r && identifierExpr(b, l + 1);
    r = r && procedureDef_4(b, l + 1);
    r = r && consumeToken(b, LPAREN);
    r = r && procedureDef_6(b, l + 1);
    r = r && consumeTokens(b, 0, RPAREN, LBRACE);
    r = r && stmtLst(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // specifierLst?
  private static boolean procedureDef_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "procedureDef_0")) return false;
    specifierLst(b, l + 1);
    return true;
  }

  // (identifierExpr DOT)?
  private static boolean procedureDef_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "procedureDef_2")) return false;
    procedureDef_2_0(b, l + 1);
    return true;
  }

  // identifierExpr DOT
  private static boolean procedureDef_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "procedureDef_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifierExpr(b, l + 1);
    r = r && consumeToken(b, DOT);
    exit_section_(b, m, null, r);
    return r;
  }

  // templateDef?
  private static boolean procedureDef_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "procedureDef_4")) return false;
    templateDef(b, l + 1);
    return true;
  }

  // argLstDef?
  private static boolean procedureDef_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "procedureDef_6")) return false;
    argLstDef(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // shiftExpr ((LESS | GREATER | LESS_EQUAL | GREATER_EQUAL) shiftExpr)?
  public static boolean relationalExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationalExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RELATIONAL_EXPR, "<relational expr>");
    r = shiftExpr(b, l + 1);
    r = r && relationalExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ((LESS | GREATER | LESS_EQUAL | GREATER_EQUAL) shiftExpr)?
  private static boolean relationalExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationalExpr_1")) return false;
    relationalExpr_1_0(b, l + 1);
    return true;
  }

  // (LESS | GREATER | LESS_EQUAL | GREATER_EQUAL) shiftExpr
  private static boolean relationalExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationalExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = relationalExpr_1_0_0(b, l + 1);
    r = r && shiftExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LESS | GREATER | LESS_EQUAL | GREATER_EQUAL
  private static boolean relationalExpr_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "relationalExpr_1_0_0")) return false;
    boolean r;
    r = consumeToken(b, LESS);
    if (!r) r = consumeToken(b, GREATER);
    if (!r) r = consumeToken(b, LESS_EQUAL);
    if (!r) r = consumeToken(b, GREATER_EQUAL);
    return r;
  }

  /* ********************************************************** */
  // RETURN assignExpr?
  public static boolean returnStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "returnStmt")) return false;
    if (!nextTokenIs(b, RETURN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RETURN);
    r = r && returnStmt_1(b, l + 1);
    exit_section_(b, m, RETURN_STMT, r);
    return r;
  }

  // assignExpr?
  private static boolean returnStmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "returnStmt_1")) return false;
    assignExpr(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // additiveExpr ((LESS LESS | GREATER GREATER) additiveExpr)?
  public static boolean shiftExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shiftExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SHIFT_EXPR, "<shift expr>");
    r = additiveExpr(b, l + 1);
    r = r && shiftExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ((LESS LESS | GREATER GREATER) additiveExpr)?
  private static boolean shiftExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shiftExpr_1")) return false;
    shiftExpr_1_0(b, l + 1);
    return true;
  }

  // (LESS LESS | GREATER GREATER) additiveExpr
  private static boolean shiftExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shiftExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = shiftExpr_1_0_0(b, l + 1);
    r = r && additiveExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LESS LESS | GREATER GREATER
  private static boolean shiftExpr_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shiftExpr_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = parseTokens(b, 0, LESS, LESS);
    if (!r) r = parseTokens(b, 0, GREATER, GREATER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // SIZEOF LPAREN (assignExpr | TYPE dataType) RPAREN
  public static boolean sizeOfCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sizeOfCall")) return false;
    if (!nextTokenIs(b, SIZEOF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SIZEOF, LPAREN);
    r = r && sizeOfCall_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, SIZE_OF_CALL, r);
    return r;
  }

  // assignExpr | TYPE dataType
  private static boolean sizeOfCall_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sizeOfCall_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = assignExpr(b, l + 1);
    if (!r) r = sizeOfCall_2_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // TYPE dataType
  private static boolean sizeOfCall_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sizeOfCall_2_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TYPE);
    r = r && dataType(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // CONST | SIGNED | UNSIGNED | INLINE | PUBLIC
  public static boolean specifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "specifier")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SPECIFIER, "<specifier>");
    r = consumeToken(b, CONST);
    if (!r) r = consumeToken(b, SIGNED);
    if (!r) r = consumeToken(b, UNSIGNED);
    if (!r) r = consumeToken(b, INLINE);
    if (!r) r = consumeToken(b, PUBLIC);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // specifier+
  public static boolean specifierLst(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "specifierLst")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SPECIFIER_LST, "<specifier lst>");
    r = specifier(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!specifier(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "specifierLst", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (mainFunctionDef | functionDef | procedureDef | structDef | genericTypeDef | globalVarDef | importStmt | extDecl | lineCom | blockCom)*
  static boolean spiceFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "spiceFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!spiceFile_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "spiceFile", c)) break;
    }
    return true;
  }

  // mainFunctionDef | functionDef | procedureDef | structDef | genericTypeDef | globalVarDef | importStmt | extDecl | lineCom | blockCom
  private static boolean spiceFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "spiceFile_0")) return false;
    boolean r;
    r = mainFunctionDef(b, l + 1);
    if (!r) r = functionDef(b, l + 1);
    if (!r) r = procedureDef(b, l + 1);
    if (!r) r = structDef(b, l + 1);
    if (!r) r = genericTypeDef(b, l + 1);
    if (!r) r = globalVarDef(b, l + 1);
    if (!r) r = importStmt(b, l + 1);
    if (!r) r = extDecl(b, l + 1);
    if (!r) r = lineCom(b, l + 1);
    if (!r) r = blockCom(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // (declStmt | assignExpr | returnStmt | breakStmt | continueStmt) SEMICOLON
  public static boolean stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STMT, "<stmt>");
    r = stmt_0(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // declStmt | assignExpr | returnStmt | breakStmt | continueStmt
  private static boolean stmt_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmt_0")) return false;
    boolean r;
    r = declStmt(b, l + 1);
    if (!r) r = assignExpr(b, l + 1);
    if (!r) r = returnStmt(b, l + 1);
    if (!r) r = breakStmt(b, l + 1);
    if (!r) r = continueStmt(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // (stmt | forLoop | foreachLoop | whileLoop | ifStmt | assertStmt | threadDef | unsafeBlockDef)*
  public static boolean stmtLst(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmtLst")) return false;
    Marker m = enter_section_(b, l, _NONE_, STMT_LST, "<stmt lst>");
    while (true) {
      int c = current_position_(b);
      if (!stmtLst_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "stmtLst", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  // stmt | forLoop | foreachLoop | whileLoop | ifStmt | assertStmt | threadDef | unsafeBlockDef
  private static boolean stmtLst_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmtLst_0")) return false;
    boolean r;
    r = stmt(b, l + 1);
    if (!r) r = forLoop(b, l + 1);
    if (!r) r = foreachLoop(b, l + 1);
    if (!r) r = whileLoop(b, l + 1);
    if (!r) r = ifStmt(b, l + 1);
    if (!r) r = assertStmt(b, l + 1);
    if (!r) r = threadDef(b, l + 1);
    if (!r) r = unsafeBlockDef(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // specifierLst? TYPE IDENTIFIER (LESS typeLst GREATER)? STRUCT LBRACE field* RBRACE
  public static boolean structDef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "structDef")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRUCT_DEF, "<struct def>");
    r = structDef_0(b, l + 1);
    r = r && consumeTokens(b, 0, TYPE, IDENTIFIER);
    r = r && structDef_3(b, l + 1);
    r = r && consumeTokens(b, 0, STRUCT, LBRACE);
    r = r && structDef_6(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // specifierLst?
  private static boolean structDef_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "structDef_0")) return false;
    specifierLst(b, l + 1);
    return true;
  }

  // (LESS typeLst GREATER)?
  private static boolean structDef_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "structDef_3")) return false;
    structDef_3_0(b, l + 1);
    return true;
  }

  // LESS typeLst GREATER
  private static boolean structDef_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "structDef_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LESS);
    r = r && typeLst(b, l + 1);
    r = r && consumeToken(b, GREATER);
    exit_section_(b, m, null, r);
    return r;
  }

  // field*
  private static boolean structDef_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "structDef_6")) return false;
    while (true) {
      int c = current_position_(b);
      if (!field(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "structDef_6", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // identifierExpr (DOT identifierExpr)* (LESS typeLst GREATER)? LBRACE argLst? RBRACE
  public static boolean structInstantiation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "structInstantiation")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifierExpr(b, l + 1);
    r = r && structInstantiation_1(b, l + 1);
    r = r && structInstantiation_2(b, l + 1);
    r = r && consumeToken(b, LBRACE);
    r = r && structInstantiation_4(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, STRUCT_INSTANTIATION, r);
    return r;
  }

  // (DOT identifierExpr)*
  private static boolean structInstantiation_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "structInstantiation_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!structInstantiation_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "structInstantiation_1", c)) break;
    }
    return true;
  }

  // DOT identifierExpr
  private static boolean structInstantiation_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "structInstantiation_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOT);
    r = r && identifierExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (LESS typeLst GREATER)?
  private static boolean structInstantiation_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "structInstantiation_2")) return false;
    structInstantiation_2_0(b, l + 1);
    return true;
  }

  // LESS typeLst GREATER
  private static boolean structInstantiation_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "structInstantiation_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LESS);
    r = r && typeLst(b, l + 1);
    r = r && consumeToken(b, GREATER);
    exit_section_(b, m, null, r);
    return r;
  }

  // argLst?
  private static boolean structInstantiation_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "structInstantiation_4")) return false;
    argLst(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // LESS typeLst GREATER
  public static boolean templateDef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "templateDef")) return false;
    if (!nextTokenIs(b, LESS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LESS);
    r = r && typeLst(b, l + 1);
    r = r && consumeToken(b, GREATER);
    exit_section_(b, m, TEMPLATE_DEF, r);
    return r;
  }

  /* ********************************************************** */
  // logicalOrExpr (QUESTION_MARK logicalOrExpr COLON logicalOrExpr)?
  public static boolean ternaryExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ternaryExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TERNARY_EXPR, "<ternary expr>");
    r = logicalOrExpr(b, l + 1);
    r = r && ternaryExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (QUESTION_MARK logicalOrExpr COLON logicalOrExpr)?
  private static boolean ternaryExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ternaryExpr_1")) return false;
    ternaryExpr_1_0(b, l + 1);
    return true;
  }

  // QUESTION_MARK logicalOrExpr COLON logicalOrExpr
  private static boolean ternaryExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ternaryExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUESTION_MARK);
    r = r && logicalOrExpr(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && logicalOrExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // THREAD LBRACE stmtLst RBRACE
  public static boolean threadDef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "threadDef")) return false;
    if (!nextTokenIs(b, THREAD)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, THREAD, LBRACE);
    r = r && stmtLst(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, THREAD_DEF, r);
    return r;
  }

  /* ********************************************************** */
  // TID LPAREN RPAREN
  public static boolean tidCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tidCall")) return false;
    if (!nextTokenIs(b, TID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, TID, LPAREN, RPAREN);
    exit_section_(b, m, TID_CALL, r);
    return r;
  }

  /* ********************************************************** */
  // dataType (BITWISE_OR dataType)*
  public static boolean typeAlts(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeAlts")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_ALTS, "<type alts>");
    r = dataType(b, l + 1);
    r = r && typeAlts_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (BITWISE_OR dataType)*
  private static boolean typeAlts_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeAlts_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!typeAlts_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "typeAlts_1", c)) break;
    }
    return true;
  }

  // BITWISE_OR dataType
  private static boolean typeAlts_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeAlts_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BITWISE_OR);
    r = r && dataType(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // dataType (COMMA dataType)*
  public static boolean typeLst(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeLst")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_LST, "<type lst>");
    r = dataType(b, l + 1);
    r = r && typeLst_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA dataType)*
  private static boolean typeLst_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeLst_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!typeLst_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "typeLst_1", c)) break;
    }
    return true;
  }

  // COMMA dataType
  private static boolean typeLst_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeLst_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && dataType(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // typeLst ELLIPSIS?
  public static boolean typeLstEllipsis(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeLstEllipsis")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_LST_ELLIPSIS, "<type lst ellipsis>");
    r = typeLst(b, l + 1);
    r = r && typeLstEllipsis_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ELLIPSIS?
  private static boolean typeLstEllipsis_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeLstEllipsis_1")) return false;
    consumeToken(b, ELLIPSIS);
    return true;
  }

  /* ********************************************************** */
  // UNSAFE LBRACE stmtLst RBRACE
  public static boolean unsafeBlockDef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unsafeBlockDef")) return false;
    if (!nextTokenIs(b, UNSAFE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, UNSAFE, LBRACE);
    r = r && stmtLst(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, UNSAFE_BLOCK_DEF, r);
    return r;
  }

  /* ********************************************************** */
  // primitiveValue | functionCall | arrayInitialization | structInstantiation | NIL LESS dataType GREATER
  public static boolean value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE, "<value>");
    r = primitiveValue(b, l + 1);
    if (!r) r = functionCall(b, l + 1);
    if (!r) r = arrayInitialization(b, l + 1);
    if (!r) r = structInstantiation(b, l + 1);
    if (!r) r = value_4(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NIL LESS dataType GREATER
  private static boolean value_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, NIL, LESS);
    r = r && dataType(b, l + 1);
    r = r && consumeToken(b, GREATER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // WHILE assignExpr LBRACE stmtLst RBRACE
  public static boolean whileLoop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whileLoop")) return false;
    if (!nextTokenIs(b, WHILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHILE);
    r = r && assignExpr(b, l + 1);
    r = r && consumeToken(b, LBRACE);
    r = r && stmtLst(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, WHILE_LOOP, r);
    return r;
  }

}
