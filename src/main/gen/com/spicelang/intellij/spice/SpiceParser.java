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
  // specifierLst? TYPE TYPE_IDENTIFIER ALIAS dataType SEMICOLON
  public static boolean aliasDef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "aliasDef")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ALIAS_DEF, "<alias def>");
    r = aliasDef_0(b, l + 1);
    r = r && consumeTokens(b, 0, TYPE, TYPE_IDENTIFIER, ALIAS);
    r = r && dataType(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // specifierLst?
  private static boolean aliasDef_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "aliasDef_0")) return false;
    specifierLst(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ALIGNOF (LPAREN assignExpr RPAREN | LESS dataType GREATER LPAREN RPAREN)
  public static boolean alignOfCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alignOfCall")) return false;
    if (!nextTokenIs(b, ALIGNOF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ALIGNOF);
    r = r && alignOfCall_1(b, l + 1);
    exit_section_(b, m, ALIGN_OF_CALL, r);
    return r;
  }

  // LPAREN assignExpr RPAREN | LESS dataType GREATER LPAREN RPAREN
  private static boolean alignOfCall_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alignOfCall_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = alignOfCall_1_0(b, l + 1);
    if (!r) r = alignOfCall_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LPAREN assignExpr RPAREN
  private static boolean alignOfCall_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alignOfCall_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && assignExpr(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // LESS dataType GREATER LPAREN RPAREN
  private static boolean alignOfCall_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "alignOfCall_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LESS);
    r = r && dataType(b, l + 1);
    r = r && consumeTokens(b, 0, GREATER, LPAREN, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // stmtLst
  public static boolean anonymousBlockStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "anonymousBlockStmt")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = stmtLst(b, l + 1);
    exit_section_(b, m, ANONYMOUS_BLOCK_STMT, r);
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
  // LBRACKET argLst? RBRACKET
  public static boolean arrayInitialization(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "arrayInitialization")) return false;
    if (!nextTokenIs(b, LBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACKET);
    r = r && arrayInitialization_1(b, l + 1);
    r = r && consumeToken(b, RBRACKET);
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
  // prefixUnaryExpr assignOp assignExpr | ternaryExpr
  public static boolean assignExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assignExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSIGN_EXPR, "<assign expr>");
    r = assignExpr_0(b, l + 1);
    if (!r) r = ternaryExpr(b, l + 1);
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
  // value | (identifierExpr SCOPE_ACCESS)* identifierExpr | builtinCall | LPAREN assignExpr RPAREN
  public static boolean atomicExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atomicExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ATOMIC_EXPR, "<atomic expr>");
    r = value(b, l + 1);
    if (!r) r = atomicExpr_1(b, l + 1);
    if (!r) r = builtinCall(b, l + 1);
    if (!r) r = atomicExpr_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (identifierExpr SCOPE_ACCESS)* identifierExpr
  private static boolean atomicExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atomicExpr_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = atomicExpr_1_0(b, l + 1);
    r = r && identifierExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (identifierExpr SCOPE_ACCESS)*
  private static boolean atomicExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atomicExpr_1_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!atomicExpr_1_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "atomicExpr_1_0", c)) break;
    }
    return true;
  }

  // identifierExpr SCOPE_ACCESS
  private static boolean atomicExpr_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "atomicExpr_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = identifierExpr(b, l + 1);
    r = r && consumeToken(b, SCOPE_ACCESS);
    exit_section_(b, m, null, r);
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
  // IDENTIFIER (DOT IDENTIFIER)* (ASSIGN constant)?
  public static boolean attr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attr")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && attr_1(b, l + 1);
    r = r && attr_2(b, l + 1);
    exit_section_(b, m, ATTR, r);
    return r;
  }

  // (DOT IDENTIFIER)*
  private static boolean attr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!attr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "attr_1", c)) break;
    }
    return true;
  }

  // DOT IDENTIFIER
  private static boolean attr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ASSIGN constant)?
  private static boolean attr_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attr_2")) return false;
    attr_2_0(b, l + 1);
    return true;
  }

  // ASSIGN constant
  private static boolean attr_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attr_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGN);
    r = r && constant(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // attr (COMMA attr)*
  public static boolean attrLst(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attrLst")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = attr(b, l + 1);
    r = r && attrLst_1(b, l + 1);
    exit_section_(b, m, ATTR_LST, r);
    return r;
  }

  // (COMMA attr)*
  private static boolean attrLst_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attrLst_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!attrLst_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "attrLst_1", c)) break;
    }
    return true;
  }

  // COMMA attr
  private static boolean attrLst_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "attrLst_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && attr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // TYPE_DOUBLE | TYPE_INT | TYPE_SHORT | TYPE_LONG | TYPE_BYTE | TYPE_CHAR | TYPE_STRING | TYPE_BOOL | TYPE_DYN | customDataType | functionDataType
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
    if (!r) r = functionDataType(b, l + 1);
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
  // BREAK INT_LIT?
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

  // INT_LIT?
  private static boolean breakStmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "breakStmt_1")) return false;
    consumeToken(b, INT_LIT);
    return true;
  }

  /* ********************************************************** */
  // printfCall | sizeOfCall | alignOfCall | typeIdCall | lenCall | panicCall | sysCall
  public static boolean builtinCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "builtinCall")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BUILTIN_CALL, "<builtin call>");
    r = printfCall(b, l + 1);
    if (!r) r = sizeOfCall(b, l + 1);
    if (!r) r = alignOfCall(b, l + 1);
    if (!r) r = typeIdCall(b, l + 1);
    if (!r) r = lenCall(b, l + 1);
    if (!r) r = panicCall(b, l + 1);
    if (!r) r = sysCall(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // CASE caseConstant (COMMA caseConstant)* COLON stmtLst
  public static boolean caseBranch(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseBranch")) return false;
    if (!nextTokenIs(b, CASE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, CASE);
    r = r && caseConstant(b, l + 1);
    r = r && caseBranch_2(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && stmtLst(b, l + 1);
    exit_section_(b, m, CASE_BRANCH, r);
    return r;
  }

  // (COMMA caseConstant)*
  private static boolean caseBranch_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseBranch_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!caseBranch_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "caseBranch_2", c)) break;
    }
    return true;
  }

  // COMMA caseConstant
  private static boolean caseBranch_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseBranch_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && caseConstant(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // constant | (IDENTIFIER SCOPE_ACCESS)? TYPE_IDENTIFIER (SCOPE_ACCESS TYPE_IDENTIFIER)*
  public static boolean caseConstant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseConstant")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CASE_CONSTANT, "<case constant>");
    r = constant(b, l + 1);
    if (!r) r = caseConstant_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (IDENTIFIER SCOPE_ACCESS)? TYPE_IDENTIFIER (SCOPE_ACCESS TYPE_IDENTIFIER)*
  private static boolean caseConstant_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseConstant_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = caseConstant_1_0(b, l + 1);
    r = r && consumeToken(b, TYPE_IDENTIFIER);
    r = r && caseConstant_1_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (IDENTIFIER SCOPE_ACCESS)?
  private static boolean caseConstant_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseConstant_1_0")) return false;
    caseConstant_1_0_0(b, l + 1);
    return true;
  }

  // IDENTIFIER SCOPE_ACCESS
  private static boolean caseConstant_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseConstant_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, SCOPE_ACCESS);
    exit_section_(b, m, null, r);
    return r;
  }

  // (SCOPE_ACCESS TYPE_IDENTIFIER)*
  private static boolean caseConstant_1_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseConstant_1_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!caseConstant_1_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "caseConstant_1_2", c)) break;
    }
    return true;
  }

  // SCOPE_ACCESS TYPE_IDENTIFIER
  private static boolean caseConstant_1_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "caseConstant_1_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SCOPE_ACCESS, TYPE_IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // prefixUnaryExpr | CAST LESS dataType GREATER LPAREN assignExpr RPAREN
  public static boolean castExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "castExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CAST_EXPR, "<cast expr>");
    r = prefixUnaryExpr(b, l + 1);
    if (!r) r = castExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // CAST LESS dataType GREATER LPAREN assignExpr RPAREN
  private static boolean castExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "castExpr_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, CAST, LESS);
    r = r && dataType(b, l + 1);
    r = r && consumeTokens(b, 0, GREATER, LPAREN);
    r = r && assignExpr(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DOUBLE_LIT | INT_LIT | SHORT_LIT | LONG_LIT | CHAR_LIT | STRING_LIT | TRUE | FALSE
  public static boolean constant(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "constant")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONSTANT, "<constant>");
    r = consumeToken(b, DOUBLE_LIT);
    if (!r) r = consumeToken(b, INT_LIT);
    if (!r) r = consumeToken(b, SHORT_LIT);
    if (!r) r = consumeToken(b, LONG_LIT);
    if (!r) r = consumeToken(b, CHAR_LIT);
    if (!r) r = consumeToken(b, STRING_LIT);
    if (!r) r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, FALSE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // CONTINUE INT_LIT?
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

  // INT_LIT?
  private static boolean continueStmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "continueStmt_1")) return false;
    consumeToken(b, INT_LIT);
    return true;
  }

  /* ********************************************************** */
  // (IDENTIFIER SCOPE_ACCESS)* TYPE_IDENTIFIER (LESS typeLst GREATER)?
  public static boolean customDataType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "customDataType")) return false;
    if (!nextTokenIs(b, "<custom data type>", IDENTIFIER, TYPE_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CUSTOM_DATA_TYPE, "<custom data type>");
    r = customDataType_0(b, l + 1);
    r = r && consumeToken(b, TYPE_IDENTIFIER);
    r = r && customDataType_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (IDENTIFIER SCOPE_ACCESS)*
  private static boolean customDataType_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "customDataType_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!customDataType_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "customDataType_0", c)) break;
    }
    return true;
  }

  // IDENTIFIER SCOPE_ACCESS
  private static boolean customDataType_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "customDataType_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, SCOPE_ACCESS);
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
  // specifierLst? baseDataType (MUL | BITWISE_AND | LBRACKET (INT_LIT | TYPE_IDENTIFIER)? RBRACKET)*
  public static boolean dataType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataType")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DATA_TYPE, "<data type>");
    r = dataType_0(b, l + 1);
    r = r && baseDataType(b, l + 1);
    r = r && dataType_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // specifierLst?
  private static boolean dataType_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataType_0")) return false;
    specifierLst(b, l + 1);
    return true;
  }

  // (MUL | BITWISE_AND | LBRACKET (INT_LIT | TYPE_IDENTIFIER)? RBRACKET)*
  private static boolean dataType_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataType_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!dataType_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "dataType_2", c)) break;
    }
    return true;
  }

  // MUL | BITWISE_AND | LBRACKET (INT_LIT | TYPE_IDENTIFIER)? RBRACKET
  private static boolean dataType_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataType_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, MUL);
    if (!r) r = consumeToken(b, BITWISE_AND);
    if (!r) r = dataType_2_0_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LBRACKET (INT_LIT | TYPE_IDENTIFIER)? RBRACKET
  private static boolean dataType_2_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataType_2_0_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACKET);
    r = r && dataType_2_0_2_1(b, l + 1);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, null, r);
    return r;
  }

  // (INT_LIT | TYPE_IDENTIFIER)?
  private static boolean dataType_2_0_2_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataType_2_0_2_1")) return false;
    dataType_2_0_2_1_0(b, l + 1);
    return true;
  }

  // INT_LIT | TYPE_IDENTIFIER
  private static boolean dataType_2_0_2_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "dataType_2_0_2_1_0")) return false;
    boolean r;
    r = consumeToken(b, INT_LIT);
    if (!r) r = consumeToken(b, TYPE_IDENTIFIER);
    return r;
  }

  /* ********************************************************** */
  // dataType IDENTIFIER (ASSIGN assignExpr)?
  public static boolean declStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declStmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DECL_STMT, "<decl stmt>");
    r = dataType(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && declStmt_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (ASSIGN assignExpr)?
  private static boolean declStmt_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declStmt_2")) return false;
    declStmt_2_0(b, l + 1);
    return true;
  }

  // ASSIGN assignExpr
  private static boolean declStmt_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "declStmt_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGN);
    r = r && assignExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // DEFAULT COLON stmtLst
  public static boolean defaultBranch(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "defaultBranch")) return false;
    if (!nextTokenIs(b, DEFAULT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DEFAULT, COLON);
    r = r && stmtLst(b, l + 1);
    exit_section_(b, m, DEFAULT_BRANCH, r);
    return r;
  }

  /* ********************************************************** */
  // DO stmtLst WHILE assignExpr SEMICOLON
  public static boolean doWhileLoop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "doWhileLoop")) return false;
    if (!nextTokenIs(b, DO)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DO);
    r = r && stmtLst(b, l + 1);
    r = r && consumeToken(b, WHILE);
    r = r && assignExpr(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, DO_WHILE_LOOP, r);
    return r;
  }

  /* ********************************************************** */
  // DOC_COMMENT
  public static boolean docCom(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "docCom")) return false;
    if (!nextTokenIs(b, DOC_COMMENT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DOC_COMMENT);
    exit_section_(b, m, DOC_COM, r);
    return r;
  }

  /* ********************************************************** */
  // ELSE ifStmt | ELSE stmtLst
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

  // ELSE stmtLst
  private static boolean elseStmt_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "elseStmt_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSE);
    r = r && stmtLst(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // specifierLst? TYPE TYPE_IDENTIFIER ENUM LBRACE enumItemLst RBRACE
  public static boolean enumDef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumDef")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENUM_DEF, "<enum def>");
    r = enumDef_0(b, l + 1);
    r = r && consumeTokens(b, 0, TYPE, TYPE_IDENTIFIER, ENUM, LBRACE);
    r = r && enumItemLst(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // specifierLst?
  private static boolean enumDef_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumDef_0")) return false;
    specifierLst(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // TYPE_IDENTIFIER (ASSIGN INT_LIT)?
  public static boolean enumItem(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumItem")) return false;
    if (!nextTokenIs(b, TYPE_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TYPE_IDENTIFIER);
    r = r && enumItem_1(b, l + 1);
    exit_section_(b, m, ENUM_ITEM, r);
    return r;
  }

  // (ASSIGN INT_LIT)?
  private static boolean enumItem_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumItem_1")) return false;
    enumItem_1_0(b, l + 1);
    return true;
  }

  // ASSIGN INT_LIT
  private static boolean enumItem_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumItem_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, ASSIGN, INT_LIT);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // enumItem (COMMA enumItem)*
  public static boolean enumItemLst(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumItemLst")) return false;
    if (!nextTokenIs(b, TYPE_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = enumItem(b, l + 1);
    r = r && enumItemLst_1(b, l + 1);
    exit_section_(b, m, ENUM_ITEM_LST, r);
    return r;
  }

  // (COMMA enumItem)*
  private static boolean enumItemLst_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumItemLst_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!enumItemLst_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "enumItemLst_1", c)) break;
    }
    return true;
  }

  // COMMA enumItem
  private static boolean enumItemLst_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "enumItemLst_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && enumItem(b, l + 1);
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
  // assignExpr
  public static boolean exprStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exprStmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPR_STMT, "<expr stmt>");
    r = assignExpr(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // topLevelDefAttr? EXT (F LESS dataType GREATER | P) (IDENTIFIER | TYPE_IDENTIFIER) LPAREN (typeLst ELLIPSIS?)? RPAREN SEMICOLON
  public static boolean extDecl(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extDecl")) return false;
    if (!nextTokenIs(b, "<ext decl>", EXT, TOPLEVEL_ATTR_PREAMBLE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXT_DECL, "<ext decl>");
    r = extDecl_0(b, l + 1);
    r = r && consumeToken(b, EXT);
    r = r && extDecl_2(b, l + 1);
    r = r && extDecl_3(b, l + 1);
    r = r && consumeToken(b, LPAREN);
    r = r && extDecl_5(b, l + 1);
    r = r && consumeTokens(b, 0, RPAREN, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // topLevelDefAttr?
  private static boolean extDecl_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extDecl_0")) return false;
    topLevelDefAttr(b, l + 1);
    return true;
  }

  // F LESS dataType GREATER | P
  private static boolean extDecl_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extDecl_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = extDecl_2_0(b, l + 1);
    if (!r) r = consumeToken(b, P);
    exit_section_(b, m, null, r);
    return r;
  }

  // F LESS dataType GREATER
  private static boolean extDecl_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extDecl_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, F, LESS);
    r = r && dataType(b, l + 1);
    r = r && consumeToken(b, GREATER);
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENTIFIER | TYPE_IDENTIFIER
  private static boolean extDecl_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extDecl_3")) return false;
    boolean r;
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, TYPE_IDENTIFIER);
    return r;
  }

  // (typeLst ELLIPSIS?)?
  private static boolean extDecl_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extDecl_5")) return false;
    extDecl_5_0(b, l + 1);
    return true;
  }

  // typeLst ELLIPSIS?
  private static boolean extDecl_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extDecl_5_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = typeLst(b, l + 1);
    r = r && extDecl_5_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ELLIPSIS?
  private static boolean extDecl_5_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "extDecl_5_0_1")) return false;
    consumeToken(b, ELLIPSIS);
    return true;
  }

  /* ********************************************************** */
  // FALLTHROUGH
  public static boolean fallthroughStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fallthroughStmt")) return false;
    if (!nextTokenIs(b, FALLTHROUGH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FALLTHROUGH);
    exit_section_(b, m, FALLTHROUGH_STMT, r);
    return r;
  }

  /* ********************************************************** */
  // dataType IDENTIFIER (ASSIGN assignExpr)?
  public static boolean field(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD, "<field>");
    r = dataType(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && field_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (ASSIGN assignExpr)?
  private static boolean field_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_2")) return false;
    field_2_0(b, l + 1);
    return true;
  }

  // ASSIGN assignExpr
  private static boolean field_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGN);
    r = r && assignExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
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
  // FOR (forHead | LPAREN forHead RPAREN) stmtLst
  public static boolean forLoop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "forLoop")) return false;
    if (!nextTokenIs(b, FOR)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FOR);
    r = r && forLoop_1(b, l + 1);
    r = r && stmtLst(b, l + 1);
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
  // FOREACH (foreachHead | LPAREN foreachHead RPAREN) stmtLst
  public static boolean foreachLoop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "foreachLoop")) return false;
    if (!nextTokenIs(b, FOREACH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FOREACH);
    r = r && foreachLoop_1(b, l + 1);
    r = r && stmtLst(b, l + 1);
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
  // (IDENTIFIER SCOPE_ACCESS)* (IDENTIFIER DOT)* identifierExpr (LESS typeLst GREATER)? LPAREN argLst? RPAREN
  public static boolean functionCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall")) return false;
    if (!nextTokenIs(b, "<function call>", IDENTIFIER, TYPE_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_CALL, "<function call>");
    r = functionCall_0(b, l + 1);
    r = r && functionCall_1(b, l + 1);
    r = r && identifierExpr(b, l + 1);
    r = r && functionCall_3(b, l + 1);
    r = r && consumeToken(b, LPAREN);
    r = r && functionCall_5(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (IDENTIFIER SCOPE_ACCESS)*
  private static boolean functionCall_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!functionCall_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "functionCall_0", c)) break;
    }
    return true;
  }

  // IDENTIFIER SCOPE_ACCESS
  private static boolean functionCall_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, SCOPE_ACCESS);
    exit_section_(b, m, null, r);
    return r;
  }

  // (IDENTIFIER DOT)*
  private static boolean functionCall_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!functionCall_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "functionCall_1", c)) break;
    }
    return true;
  }

  // IDENTIFIER DOT
  private static boolean functionCall_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, DOT);
    exit_section_(b, m, null, r);
    return r;
  }

  // (LESS typeLst GREATER)?
  private static boolean functionCall_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall_3")) return false;
    functionCall_3_0(b, l + 1);
    return true;
  }

  // LESS typeLst GREATER
  private static boolean functionCall_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LESS);
    r = r && typeLst(b, l + 1);
    r = r && consumeToken(b, GREATER);
    exit_section_(b, m, null, r);
    return r;
  }

  // argLst?
  private static boolean functionCall_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionCall_5")) return false;
    argLst(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (P | F LESS dataType GREATER) LPAREN typeLst? RPAREN
  public static boolean functionDataType(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDataType")) return false;
    if (!nextTokenIs(b, "<function data type>", F, P)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_DATA_TYPE, "<function data type>");
    r = functionDataType_0(b, l + 1);
    r = r && consumeToken(b, LPAREN);
    r = r && functionDataType_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // P | F LESS dataType GREATER
  private static boolean functionDataType_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDataType_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, P);
    if (!r) r = functionDataType_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // F LESS dataType GREATER
  private static boolean functionDataType_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDataType_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, F, LESS);
    r = r && dataType(b, l + 1);
    r = r && consumeToken(b, GREATER);
    exit_section_(b, m, null, r);
    return r;
  }

  // typeLst?
  private static boolean functionDataType_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDataType_2")) return false;
    typeLst(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // topLevelDefAttr? specifierLst? F LESS dataType GREATER functionName (LESS typeLst GREATER)? LPAREN paramLst? RPAREN stmtLst
  public static boolean functionDef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDef")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_DEF, "<function def>");
    r = functionDef_0(b, l + 1);
    r = r && functionDef_1(b, l + 1);
    r = r && consumeTokens(b, 0, F, LESS);
    r = r && dataType(b, l + 1);
    r = r && consumeToken(b, GREATER);
    r = r && functionName(b, l + 1);
    r = r && functionDef_7(b, l + 1);
    r = r && consumeToken(b, LPAREN);
    r = r && functionDef_9(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && stmtLst(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // topLevelDefAttr?
  private static boolean functionDef_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDef_0")) return false;
    topLevelDefAttr(b, l + 1);
    return true;
  }

  // specifierLst?
  private static boolean functionDef_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDef_1")) return false;
    specifierLst(b, l + 1);
    return true;
  }

  // (LESS typeLst GREATER)?
  private static boolean functionDef_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDef_7")) return false;
    functionDef_7_0(b, l + 1);
    return true;
  }

  // LESS typeLst GREATER
  private static boolean functionDef_7_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDef_7_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LESS);
    r = r && typeLst(b, l + 1);
    r = r && consumeToken(b, GREATER);
    exit_section_(b, m, null, r);
    return r;
  }

  // paramLst?
  private static boolean functionDef_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionDef_9")) return false;
    paramLst(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (TYPE_IDENTIFIER DOT)? IDENTIFIER | OPERATOR overloadableOp
  public static boolean functionName(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionName")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTION_NAME, "<function name>");
    r = functionName_0(b, l + 1);
    if (!r) r = functionName_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (TYPE_IDENTIFIER DOT)? IDENTIFIER
  private static boolean functionName_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionName_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = functionName_0_0(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // (TYPE_IDENTIFIER DOT)?
  private static boolean functionName_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionName_0_0")) return false;
    functionName_0_0_0(b, l + 1);
    return true;
  }

  // TYPE_IDENTIFIER DOT
  private static boolean functionName_0_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionName_0_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, TYPE_IDENTIFIER, DOT);
    exit_section_(b, m, null, r);
    return r;
  }

  // OPERATOR overloadableOp
  private static boolean functionName_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functionName_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, OPERATOR);
    r = r && overloadableOp(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // TYPE TYPE_IDENTIFIER typeAltsLst SEMICOLON
  public static boolean genericTypeDef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "genericTypeDef")) return false;
    if (!nextTokenIs(b, TYPE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, TYPE, TYPE_IDENTIFIER);
    r = r && typeAltsLst(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, GENERIC_TYPE_DEF, r);
    return r;
  }

  /* ********************************************************** */
  // dataType TYPE_IDENTIFIER (ASSIGN MINUS? value)? SEMICOLON
  public static boolean globalVarDef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "globalVarDef")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, GLOBAL_VAR_DEF, "<global var def>");
    r = dataType(b, l + 1);
    r = r && consumeToken(b, TYPE_IDENTIFIER);
    r = r && globalVarDef_2(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (ASSIGN MINUS? value)?
  private static boolean globalVarDef_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "globalVarDef_2")) return false;
    globalVarDef_2_0(b, l + 1);
    return true;
  }

  // ASSIGN MINUS? value
  private static boolean globalVarDef_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "globalVarDef_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGN);
    r = r && globalVarDef_2_0_1(b, l + 1);
    r = r && value(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // MINUS?
  private static boolean globalVarDef_2_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "globalVarDef_2_0_1")) return false;
    consumeToken(b, MINUS);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER | TYPE_IDENTIFIER
  public static boolean identifierExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "identifierExpr")) return false;
    if (!nextTokenIs(b, "<identifier expr>", IDENTIFIER, TYPE_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IDENTIFIER_EXPR, "<identifier expr>");
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, TYPE_IDENTIFIER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // IF assignExpr stmtLst elseStmt?
  public static boolean ifStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifStmt")) return false;
    if (!nextTokenIs(b, IF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && assignExpr(b, l + 1);
    r = r && stmtLst(b, l + 1);
    r = r && ifStmt_3(b, l + 1);
    exit_section_(b, m, IF_STMT, r);
    return r;
  }

  // elseStmt?
  private static boolean ifStmt_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ifStmt_3")) return false;
    elseStmt(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IMPORT STRING_LIT (AS IDENTIFIER)? SEMICOLON
  public static boolean importDef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "importDef")) return false;
    if (!nextTokenIs(b, IMPORT)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IMPORT, STRING_LIT);
    r = r && importDef_2(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, m, IMPORT_DEF, r);
    return r;
  }

  // (AS IDENTIFIER)?
  private static boolean importDef_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "importDef_2")) return false;
    importDef_2_0(b, l + 1);
    return true;
  }

  // AS IDENTIFIER
  private static boolean importDef_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "importDef_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, AS, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // topLevelDefAttr? specifierLst? TYPE TYPE_IDENTIFIER (LESS typeLst GREATER)? INTERFACE LBRACE signature* RBRACE
  public static boolean interfaceDef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "interfaceDef")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INTERFACE_DEF, "<interface def>");
    r = interfaceDef_0(b, l + 1);
    r = r && interfaceDef_1(b, l + 1);
    r = r && consumeTokens(b, 0, TYPE, TYPE_IDENTIFIER);
    r = r && interfaceDef_4(b, l + 1);
    r = r && consumeTokens(b, 0, INTERFACE, LBRACE);
    r = r && interfaceDef_7(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // topLevelDefAttr?
  private static boolean interfaceDef_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "interfaceDef_0")) return false;
    topLevelDefAttr(b, l + 1);
    return true;
  }

  // specifierLst?
  private static boolean interfaceDef_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "interfaceDef_1")) return false;
    specifierLst(b, l + 1);
    return true;
  }

  // (LESS typeLst GREATER)?
  private static boolean interfaceDef_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "interfaceDef_4")) return false;
    interfaceDef_4_0(b, l + 1);
    return true;
  }

  // LESS typeLst GREATER
  private static boolean interfaceDef_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "interfaceDef_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LESS);
    r = r && typeLst(b, l + 1);
    r = r && consumeToken(b, GREATER);
    exit_section_(b, m, null, r);
    return r;
  }

  // signature*
  private static boolean interfaceDef_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "interfaceDef_7")) return false;
    while (true) {
      int c = current_position_(b);
      if (!signature(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "interfaceDef_7", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // LBRACKET LBRACKET attrLst RBRACKET RBRACKET
  public static boolean lambdaAttr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdaAttr")) return false;
    if (!nextTokenIs(b, LBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LBRACKET, LBRACKET);
    r = r && attrLst(b, l + 1);
    r = r && consumeTokens(b, 0, RBRACKET, RBRACKET);
    exit_section_(b, m, LAMBDA_ATTR, r);
    return r;
  }

  /* ********************************************************** */
  // LPAREN paramLst? RPAREN ARROW assignExpr
  public static boolean lambdaExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdaExpr")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && lambdaExpr_1(b, l + 1);
    r = r && consumeTokens(b, 0, RPAREN, ARROW);
    r = r && assignExpr(b, l + 1);
    exit_section_(b, m, LAMBDA_EXPR, r);
    return r;
  }

  // paramLst?
  private static boolean lambdaExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdaExpr_1")) return false;
    paramLst(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // F LESS dataType GREATER LPAREN paramLst? RPAREN lambdaAttr? stmtLst
  public static boolean lambdaFunc(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdaFunc")) return false;
    if (!nextTokenIs(b, F)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, F, LESS);
    r = r && dataType(b, l + 1);
    r = r && consumeTokens(b, 0, GREATER, LPAREN);
    r = r && lambdaFunc_5(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && lambdaFunc_7(b, l + 1);
    r = r && stmtLst(b, l + 1);
    exit_section_(b, m, LAMBDA_FUNC, r);
    return r;
  }

  // paramLst?
  private static boolean lambdaFunc_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdaFunc_5")) return false;
    paramLst(b, l + 1);
    return true;
  }

  // lambdaAttr?
  private static boolean lambdaFunc_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdaFunc_7")) return false;
    lambdaAttr(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // P LPAREN paramLst? RPAREN lambdaAttr? stmtLst
  public static boolean lambdaProc(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdaProc")) return false;
    if (!nextTokenIs(b, P)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, P, LPAREN);
    r = r && lambdaProc_2(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && lambdaProc_4(b, l + 1);
    r = r && stmtLst(b, l + 1);
    exit_section_(b, m, LAMBDA_PROC, r);
    return r;
  }

  // paramLst?
  private static boolean lambdaProc_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdaProc_2")) return false;
    paramLst(b, l + 1);
    return true;
  }

  // lambdaAttr?
  private static boolean lambdaProc_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "lambdaProc_4")) return false;
    lambdaAttr(b, l + 1);
    return true;
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
  // topLevelDefAttr? F LESS TYPE_INT GREATER MAIN LPAREN paramLst? RPAREN stmtLst
  public static boolean mainFunctionDef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mainFunctionDef")) return false;
    if (!nextTokenIs(b, "<main function def>", F, TOPLEVEL_ATTR_PREAMBLE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MAIN_FUNCTION_DEF, "<main function def>");
    r = mainFunctionDef_0(b, l + 1);
    r = r && consumeTokens(b, 0, F, LESS, TYPE_INT, GREATER, MAIN, LPAREN);
    r = r && mainFunctionDef_7(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && stmtLst(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // topLevelDefAttr?
  private static boolean mainFunctionDef_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mainFunctionDef_0")) return false;
    topLevelDefAttr(b, l + 1);
    return true;
  }

  // paramLst?
  private static boolean mainFunctionDef_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "mainFunctionDef_7")) return false;
    paramLst(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // MOD_ATTR_PREAMBLE LBRACKET attrLst RBRACKET
  public static boolean modAttr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "modAttr")) return false;
    if (!nextTokenIs(b, MOD_ATTR_PREAMBLE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, MOD_ATTR_PREAMBLE, LBRACKET);
    r = r && attrLst(b, l + 1);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, MOD_ATTR, r);
    return r;
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
  // PLUS | MINUS | MUL | DIV | EQUAL | NOT_EQUAL | LESS LESS | GREATER GREATER | PLUS_EQUAL | MINUS_EQUAL | MUL_EQUAL | DIV_EQUAL | PLUS_PLUS | MINUS_MINUS | LBRACKET RBRACKET
  public static boolean overloadableOp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "overloadableOp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OVERLOADABLE_OP, "<overloadable op>");
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, MUL);
    if (!r) r = consumeToken(b, DIV);
    if (!r) r = consumeToken(b, EQUAL);
    if (!r) r = consumeToken(b, NOT_EQUAL);
    if (!r) r = parseTokens(b, 0, LESS, LESS);
    if (!r) r = parseTokens(b, 0, GREATER, GREATER);
    if (!r) r = consumeToken(b, PLUS_EQUAL);
    if (!r) r = consumeToken(b, MINUS_EQUAL);
    if (!r) r = consumeToken(b, MUL_EQUAL);
    if (!r) r = consumeToken(b, DIV_EQUAL);
    if (!r) r = consumeToken(b, PLUS_PLUS);
    if (!r) r = consumeToken(b, MINUS_MINUS);
    if (!r) r = parseTokens(b, 0, LBRACKET, RBRACKET);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // PANIC LPAREN assignExpr RPAREN
  public static boolean panicCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "panicCall")) return false;
    if (!nextTokenIs(b, PANIC)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PANIC, LPAREN);
    r = r && assignExpr(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, PANIC_CALL, r);
    return r;
  }

  /* ********************************************************** */
  // declStmt (COMMA declStmt)*
  public static boolean paramLst(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paramLst")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARAM_LST, "<param lst>");
    r = declStmt(b, l + 1);
    r = r && paramLst_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (COMMA declStmt)*
  private static boolean paramLst_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paramLst_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!paramLst_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "paramLst_1", c)) break;
    }
    return true;
  }

  // COMMA declStmt
  private static boolean paramLst_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "paramLst_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && declStmt(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // atomicExpr (LBRACKET assignExpr RBRACKET | DOT postfixUnaryExpr | PLUS_PLUS | MINUS_MINUS | SCOPE_ACCESS postfixUnaryExpr)*
  public static boolean postfixUnaryExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "postfixUnaryExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, POSTFIX_UNARY_EXPR, "<postfix unary expr>");
    r = atomicExpr(b, l + 1);
    r = r && postfixUnaryExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (LBRACKET assignExpr RBRACKET | DOT postfixUnaryExpr | PLUS_PLUS | MINUS_MINUS | SCOPE_ACCESS postfixUnaryExpr)*
  private static boolean postfixUnaryExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "postfixUnaryExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!postfixUnaryExpr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "postfixUnaryExpr_1", c)) break;
    }
    return true;
  }

  // LBRACKET assignExpr RBRACKET | DOT postfixUnaryExpr | PLUS_PLUS | MINUS_MINUS | SCOPE_ACCESS postfixUnaryExpr
  private static boolean postfixUnaryExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "postfixUnaryExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = postfixUnaryExpr_1_0_0(b, l + 1);
    if (!r) r = postfixUnaryExpr_1_0_1(b, l + 1);
    if (!r) r = consumeToken(b, PLUS_PLUS);
    if (!r) r = consumeToken(b, MINUS_MINUS);
    if (!r) r = postfixUnaryExpr_1_0_4(b, l + 1);
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

  // SCOPE_ACCESS postfixUnaryExpr
  private static boolean postfixUnaryExpr_1_0_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "postfixUnaryExpr_1_0_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SCOPE_ACCESS);
    r = r && postfixUnaryExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // postfixUnaryExpr | (MINUS | PLUS_PLUS | MINUS_MINUS | NOT | BITWISE_NOT | MUL | BITWISE_AND) prefixUnaryExpr
  public static boolean prefixUnaryExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefixUnaryExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, PREFIX_UNARY_EXPR, "<prefix unary expr>");
    r = postfixUnaryExpr(b, l + 1);
    if (!r) r = prefixUnaryExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (MINUS | PLUS_PLUS | MINUS_MINUS | NOT | BITWISE_NOT | MUL | BITWISE_AND) prefixUnaryExpr
  private static boolean prefixUnaryExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefixUnaryExpr_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = prefixUnaryExpr_1_0(b, l + 1);
    r = r && prefixUnaryExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // MINUS | PLUS_PLUS | MINUS_MINUS | NOT | BITWISE_NOT | MUL | BITWISE_AND
  private static boolean prefixUnaryExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefixUnaryExpr_1_0")) return false;
    boolean r;
    r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, PLUS_PLUS);
    if (!r) r = consumeToken(b, MINUS_MINUS);
    if (!r) r = consumeToken(b, NOT);
    if (!r) r = consumeToken(b, BITWISE_NOT);
    if (!r) r = consumeToken(b, MUL);
    if (!r) r = consumeToken(b, BITWISE_AND);
    return r;
  }

  /* ********************************************************** */
  // PRINTF LPAREN STRING_LIT (COMMA assignExpr)* RPAREN
  public static boolean printfCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "printfCall")) return false;
    if (!nextTokenIs(b, PRINTF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, PRINTF, LPAREN, STRING_LIT);
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
  // topLevelDefAttr? specifierLst? P functionName (LESS typeLst GREATER)? LPAREN paramLst? RPAREN stmtLst
  public static boolean procedureDef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "procedureDef")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROCEDURE_DEF, "<procedure def>");
    r = procedureDef_0(b, l + 1);
    r = r && procedureDef_1(b, l + 1);
    r = r && consumeToken(b, P);
    r = r && functionName(b, l + 1);
    r = r && procedureDef_4(b, l + 1);
    r = r && consumeToken(b, LPAREN);
    r = r && procedureDef_6(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && stmtLst(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // topLevelDefAttr?
  private static boolean procedureDef_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "procedureDef_0")) return false;
    topLevelDefAttr(b, l + 1);
    return true;
  }

  // specifierLst?
  private static boolean procedureDef_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "procedureDef_1")) return false;
    specifierLst(b, l + 1);
    return true;
  }

  // (LESS typeLst GREATER)?
  private static boolean procedureDef_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "procedureDef_4")) return false;
    procedureDef_4_0(b, l + 1);
    return true;
  }

  // LESS typeLst GREATER
  private static boolean procedureDef_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "procedureDef_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LESS);
    r = r && typeLst(b, l + 1);
    r = r && consumeToken(b, GREATER);
    exit_section_(b, m, null, r);
    return r;
  }

  // paramLst?
  private static boolean procedureDef_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "procedureDef_6")) return false;
    paramLst(b, l + 1);
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
  // additiveExpr ((LESS LESS | GREATER GREATER) additiveExpr)*
  public static boolean shiftExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shiftExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SHIFT_EXPR, "<shift expr>");
    r = additiveExpr(b, l + 1);
    r = r && shiftExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ((LESS LESS | GREATER GREATER) additiveExpr)*
  private static boolean shiftExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "shiftExpr_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!shiftExpr_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "shiftExpr_1", c)) break;
    }
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
  // specifierLst? (F LESS dataType GREATER | P) IDENTIFIER (LESS typeLst GREATER)? LPAREN typeLst? RPAREN SEMICOLON
  public static boolean signature(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "signature")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SIGNATURE, "<signature>");
    r = signature_0(b, l + 1);
    r = r && signature_1(b, l + 1);
    r = r && consumeToken(b, IDENTIFIER);
    r = r && signature_3(b, l + 1);
    r = r && consumeToken(b, LPAREN);
    r = r && signature_5(b, l + 1);
    r = r && consumeTokens(b, 0, RPAREN, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // specifierLst?
  private static boolean signature_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "signature_0")) return false;
    specifierLst(b, l + 1);
    return true;
  }

  // F LESS dataType GREATER | P
  private static boolean signature_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "signature_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = signature_1_0(b, l + 1);
    if (!r) r = consumeToken(b, P);
    exit_section_(b, m, null, r);
    return r;
  }

  // F LESS dataType GREATER
  private static boolean signature_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "signature_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, F, LESS);
    r = r && dataType(b, l + 1);
    r = r && consumeToken(b, GREATER);
    exit_section_(b, m, null, r);
    return r;
  }

  // (LESS typeLst GREATER)?
  private static boolean signature_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "signature_3")) return false;
    signature_3_0(b, l + 1);
    return true;
  }

  // LESS typeLst GREATER
  private static boolean signature_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "signature_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LESS);
    r = r && typeLst(b, l + 1);
    r = r && consumeToken(b, GREATER);
    exit_section_(b, m, null, r);
    return r;
  }

  // typeLst?
  private static boolean signature_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "signature_5")) return false;
    typeLst(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // SIZEOF (LPAREN assignExpr RPAREN | LESS dataType GREATER LPAREN RPAREN)
  public static boolean sizeOfCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sizeOfCall")) return false;
    if (!nextTokenIs(b, SIZEOF)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SIZEOF);
    r = r && sizeOfCall_1(b, l + 1);
    exit_section_(b, m, SIZE_OF_CALL, r);
    return r;
  }

  // LPAREN assignExpr RPAREN | LESS dataType GREATER LPAREN RPAREN
  private static boolean sizeOfCall_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sizeOfCall_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = sizeOfCall_1_0(b, l + 1);
    if (!r) r = sizeOfCall_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LPAREN assignExpr RPAREN
  private static boolean sizeOfCall_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sizeOfCall_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && assignExpr(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // LESS dataType GREATER LPAREN RPAREN
  private static boolean sizeOfCall_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sizeOfCall_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LESS);
    r = r && dataType(b, l + 1);
    r = r && consumeTokens(b, 0, GREATER, LPAREN, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // CONST | SIGNED | UNSIGNED | INLINE | PUBLIC | HEAP | COMPOSE
  public static boolean specifier(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "specifier")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SPECIFIER, "<specifier>");
    r = consumeToken(b, CONST);
    if (!r) r = consumeToken(b, SIGNED);
    if (!r) r = consumeToken(b, UNSIGNED);
    if (!r) r = consumeToken(b, INLINE);
    if (!r) r = consumeToken(b, PUBLIC);
    if (!r) r = consumeToken(b, HEAP);
    if (!r) r = consumeToken(b, COMPOSE);
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
  // (mainFunctionDef | functionDef | procedureDef | structDef | interfaceDef | enumDef | genericTypeDef | aliasDef | globalVarDef | importDef | extDecl | modAttr | docCom | lineCom | blockCom)*
  static boolean spiceFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "spiceFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!spiceFile_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "spiceFile", c)) break;
    }
    return true;
  }

  // mainFunctionDef | functionDef | procedureDef | structDef | interfaceDef | enumDef | genericTypeDef | aliasDef | globalVarDef | importDef | extDecl | modAttr | docCom | lineCom | blockCom
  private static boolean spiceFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "spiceFile_0")) return false;
    boolean r;
    r = mainFunctionDef(b, l + 1);
    if (!r) r = functionDef(b, l + 1);
    if (!r) r = procedureDef(b, l + 1);
    if (!r) r = structDef(b, l + 1);
    if (!r) r = interfaceDef(b, l + 1);
    if (!r) r = enumDef(b, l + 1);
    if (!r) r = genericTypeDef(b, l + 1);
    if (!r) r = aliasDef(b, l + 1);
    if (!r) r = globalVarDef(b, l + 1);
    if (!r) r = importDef(b, l + 1);
    if (!r) r = extDecl(b, l + 1);
    if (!r) r = modAttr(b, l + 1);
    if (!r) r = docCom(b, l + 1);
    if (!r) r = lineCom(b, l + 1);
    if (!r) r = blockCom(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // (declStmt | exprStmt | returnStmt | breakStmt | continueStmt | fallthroughStmt) SEMICOLON
  public static boolean stmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmt")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STMT, "<stmt>");
    r = stmt_0(b, l + 1);
    r = r && consumeToken(b, SEMICOLON);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // declStmt | exprStmt | returnStmt | breakStmt | continueStmt | fallthroughStmt
  private static boolean stmt_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmt_0")) return false;
    boolean r;
    r = declStmt(b, l + 1);
    if (!r) r = exprStmt(b, l + 1);
    if (!r) r = returnStmt(b, l + 1);
    if (!r) r = breakStmt(b, l + 1);
    if (!r) r = continueStmt(b, l + 1);
    if (!r) r = fallthroughStmt(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // LBRACE (stmt | forLoop | foreachLoop | whileLoop | doWhileLoop | ifStmt | switchStmt | assertStmt | unsafeBlock | anonymousBlockStmt)* RBRACE
  public static boolean stmtLst(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmtLst")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACE);
    r = r && stmtLst_1(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, STMT_LST, r);
    return r;
  }

  // (stmt | forLoop | foreachLoop | whileLoop | doWhileLoop | ifStmt | switchStmt | assertStmt | unsafeBlock | anonymousBlockStmt)*
  private static boolean stmtLst_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmtLst_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!stmtLst_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "stmtLst_1", c)) break;
    }
    return true;
  }

  // stmt | forLoop | foreachLoop | whileLoop | doWhileLoop | ifStmt | switchStmt | assertStmt | unsafeBlock | anonymousBlockStmt
  private static boolean stmtLst_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stmtLst_1_0")) return false;
    boolean r;
    r = stmt(b, l + 1);
    if (!r) r = forLoop(b, l + 1);
    if (!r) r = foreachLoop(b, l + 1);
    if (!r) r = whileLoop(b, l + 1);
    if (!r) r = doWhileLoop(b, l + 1);
    if (!r) r = ifStmt(b, l + 1);
    if (!r) r = switchStmt(b, l + 1);
    if (!r) r = assertStmt(b, l + 1);
    if (!r) r = unsafeBlock(b, l + 1);
    if (!r) r = anonymousBlockStmt(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // topLevelDefAttr? specifierLst? TYPE TYPE_IDENTIFIER (LESS typeLst GREATER)? STRUCT (COLON typeLst)? LBRACE field* RBRACE
  public static boolean structDef(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "structDef")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRUCT_DEF, "<struct def>");
    r = structDef_0(b, l + 1);
    r = r && structDef_1(b, l + 1);
    r = r && consumeTokens(b, 0, TYPE, TYPE_IDENTIFIER);
    r = r && structDef_4(b, l + 1);
    r = r && consumeToken(b, STRUCT);
    r = r && structDef_6(b, l + 1);
    r = r && consumeToken(b, LBRACE);
    r = r && structDef_8(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // topLevelDefAttr?
  private static boolean structDef_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "structDef_0")) return false;
    topLevelDefAttr(b, l + 1);
    return true;
  }

  // specifierLst?
  private static boolean structDef_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "structDef_1")) return false;
    specifierLst(b, l + 1);
    return true;
  }

  // (LESS typeLst GREATER)?
  private static boolean structDef_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "structDef_4")) return false;
    structDef_4_0(b, l + 1);
    return true;
  }

  // LESS typeLst GREATER
  private static boolean structDef_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "structDef_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LESS);
    r = r && typeLst(b, l + 1);
    r = r && consumeToken(b, GREATER);
    exit_section_(b, m, null, r);
    return r;
  }

  // (COLON typeLst)?
  private static boolean structDef_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "structDef_6")) return false;
    structDef_6_0(b, l + 1);
    return true;
  }

  // COLON typeLst
  private static boolean structDef_6_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "structDef_6_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COLON);
    r = r && typeLst(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // field*
  private static boolean structDef_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "structDef_8")) return false;
    while (true) {
      int c = current_position_(b);
      if (!field(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "structDef_8", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // (IDENTIFIER SCOPE_ACCESS)* TYPE_IDENTIFIER (LESS typeLst GREATER)? LBRACE argLst? RBRACE
  public static boolean structInstantiation(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "structInstantiation")) return false;
    if (!nextTokenIs(b, "<struct instantiation>", IDENTIFIER, TYPE_IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRUCT_INSTANTIATION, "<struct instantiation>");
    r = structInstantiation_0(b, l + 1);
    r = r && consumeToken(b, TYPE_IDENTIFIER);
    r = r && structInstantiation_2(b, l + 1);
    r = r && consumeToken(b, LBRACE);
    r = r && structInstantiation_4(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (IDENTIFIER SCOPE_ACCESS)*
  private static boolean structInstantiation_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "structInstantiation_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!structInstantiation_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "structInstantiation_0", c)) break;
    }
    return true;
  }

  // IDENTIFIER SCOPE_ACCESS
  private static boolean structInstantiation_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "structInstantiation_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, SCOPE_ACCESS);
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
  // SWITCH assignExpr LBRACE caseBranch* defaultBranch? RBRACE
  public static boolean switchStmt(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switchStmt")) return false;
    if (!nextTokenIs(b, SWITCH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SWITCH);
    r = r && assignExpr(b, l + 1);
    r = r && consumeToken(b, LBRACE);
    r = r && switchStmt_3(b, l + 1);
    r = r && switchStmt_4(b, l + 1);
    r = r && consumeToken(b, RBRACE);
    exit_section_(b, m, SWITCH_STMT, r);
    return r;
  }

  // caseBranch*
  private static boolean switchStmt_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switchStmt_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!caseBranch(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "switchStmt_3", c)) break;
    }
    return true;
  }

  // defaultBranch?
  private static boolean switchStmt_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "switchStmt_4")) return false;
    defaultBranch(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // SYSCALL LPAREN assignExpr (COMMA assignExpr)* RPAREN
  public static boolean sysCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sysCall")) return false;
    if (!nextTokenIs(b, SYSCALL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, SYSCALL, LPAREN);
    r = r && assignExpr(b, l + 1);
    r = r && sysCall_3(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, SYS_CALL, r);
    return r;
  }

  // (COMMA assignExpr)*
  private static boolean sysCall_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sysCall_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!sysCall_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "sysCall_3", c)) break;
    }
    return true;
  }

  // COMMA assignExpr
  private static boolean sysCall_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sysCall_3_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && assignExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // logicalOrExpr (QUESTION_MARK logicalOrExpr? COLON logicalOrExpr)?
  public static boolean ternaryExpr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ternaryExpr")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TERNARY_EXPR, "<ternary expr>");
    r = logicalOrExpr(b, l + 1);
    r = r && ternaryExpr_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (QUESTION_MARK logicalOrExpr? COLON logicalOrExpr)?
  private static boolean ternaryExpr_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ternaryExpr_1")) return false;
    ternaryExpr_1_0(b, l + 1);
    return true;
  }

  // QUESTION_MARK logicalOrExpr? COLON logicalOrExpr
  private static boolean ternaryExpr_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ternaryExpr_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, QUESTION_MARK);
    r = r && ternaryExpr_1_0_1(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && logicalOrExpr(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // logicalOrExpr?
  private static boolean ternaryExpr_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ternaryExpr_1_0_1")) return false;
    logicalOrExpr(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // TOPLEVEL_ATTR_PREAMBLE LBRACKET attrLst RBRACKET
  public static boolean topLevelDefAttr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "topLevelDefAttr")) return false;
    if (!nextTokenIs(b, TOPLEVEL_ATTR_PREAMBLE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, TOPLEVEL_ATTR_PREAMBLE, LBRACKET);
    r = r && attrLst(b, l + 1);
    r = r && consumeToken(b, RBRACKET);
    exit_section_(b, m, TOP_LEVEL_DEF_ATTR, r);
    return r;
  }

  /* ********************************************************** */
  // dataType (BITWISE_OR dataType)*
  public static boolean typeAltsLst(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeAltsLst")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TYPE_ALTS_LST, "<type alts lst>");
    r = dataType(b, l + 1);
    r = r && typeAltsLst_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (BITWISE_OR dataType)*
  private static boolean typeAltsLst_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeAltsLst_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!typeAltsLst_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "typeAltsLst_1", c)) break;
    }
    return true;
  }

  // BITWISE_OR dataType
  private static boolean typeAltsLst_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeAltsLst_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BITWISE_OR);
    r = r && dataType(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // TYPEID (LPAREN assignExpr RPAREN | LESS dataType GREATER LPAREN RPAREN)
  public static boolean typeIdCall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeIdCall")) return false;
    if (!nextTokenIs(b, TYPEID)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, TYPEID);
    r = r && typeIdCall_1(b, l + 1);
    exit_section_(b, m, TYPE_ID_CALL, r);
    return r;
  }

  // LPAREN assignExpr RPAREN | LESS dataType GREATER LPAREN RPAREN
  private static boolean typeIdCall_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeIdCall_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = typeIdCall_1_0(b, l + 1);
    if (!r) r = typeIdCall_1_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // LPAREN assignExpr RPAREN
  private static boolean typeIdCall_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeIdCall_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && assignExpr(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // LESS dataType GREATER LPAREN RPAREN
  private static boolean typeIdCall_1_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "typeIdCall_1_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LESS);
    r = r && dataType(b, l + 1);
    r = r && consumeTokens(b, 0, GREATER, LPAREN, RPAREN);
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
  // UNSAFE stmtLst
  public static boolean unsafeBlock(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unsafeBlock")) return false;
    if (!nextTokenIs(b, UNSAFE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, UNSAFE);
    r = r && stmtLst(b, l + 1);
    exit_section_(b, m, UNSAFE_BLOCK, r);
    return r;
  }

  /* ********************************************************** */
  // constant | functionCall | arrayInitialization | structInstantiation | lambdaFunc | lambdaProc | lambdaExpr | NIL LESS dataType GREATER
  public static boolean value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE, "<value>");
    r = constant(b, l + 1);
    if (!r) r = functionCall(b, l + 1);
    if (!r) r = arrayInitialization(b, l + 1);
    if (!r) r = structInstantiation(b, l + 1);
    if (!r) r = lambdaFunc(b, l + 1);
    if (!r) r = lambdaProc(b, l + 1);
    if (!r) r = lambdaExpr(b, l + 1);
    if (!r) r = value_7(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NIL LESS dataType GREATER
  private static boolean value_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, NIL, LESS);
    r = r && dataType(b, l + 1);
    r = r && consumeToken(b, GREATER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // WHILE assignExpr stmtLst
  public static boolean whileLoop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "whileLoop")) return false;
    if (!nextTokenIs(b, WHILE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHILE);
    r = r && assignExpr(b, l + 1);
    r = r && stmtLst(b, l + 1);
    exit_section_(b, m, WHILE_LOOP, r);
    return r;
  }

}
