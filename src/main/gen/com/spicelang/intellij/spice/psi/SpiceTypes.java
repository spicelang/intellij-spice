// This is a generated file. Not intended for manual editing.
package com.spicelang.intellij.spice.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.spicelang.intellij.spice.psi.impl.*;

public interface SpiceTypes {

  IElementType ADDITIVE_EXPR = new SpiceElementType("ADDITIVE_EXPR");
  IElementType ARG_LST = new SpiceElementType("ARG_LST");
  IElementType ARRAY_INITIALIZATION = new SpiceElementType("ARRAY_INITIALIZATION");
  IElementType ASSERT_STMT = new SpiceElementType("ASSERT_STMT");
  IElementType ASSIGN_EXPR = new SpiceElementType("ASSIGN_EXPR");
  IElementType ASSIGN_OP = new SpiceElementType("ASSIGN_OP");
  IElementType ATOMIC_EXPR = new SpiceElementType("ATOMIC_EXPR");
  IElementType BASE_DATA_TYPE = new SpiceElementType("BASE_DATA_TYPE");
  IElementType BITWISE_AND_EXPR = new SpiceElementType("BITWISE_AND_EXPR");
  IElementType BITWISE_OR_EXPR = new SpiceElementType("BITWISE_OR_EXPR");
  IElementType BITWISE_XOR_EXPR = new SpiceElementType("BITWISE_XOR_EXPR");
  IElementType BLOCK_COM = new SpiceElementType("BLOCK_COM");
  IElementType BREAK_STMT = new SpiceElementType("BREAK_STMT");
  IElementType BUILTIN_CALL = new SpiceElementType("BUILTIN_CALL");
  IElementType CAST_EXPR = new SpiceElementType("CAST_EXPR");
  IElementType CONTINUE_STMT = new SpiceElementType("CONTINUE_STMT");
  IElementType CUSTOM_DATA_TYPE = new SpiceElementType("CUSTOM_DATA_TYPE");
  IElementType DATA_TYPE = new SpiceElementType("DATA_TYPE");
  IElementType DECL_STMT = new SpiceElementType("DECL_STMT");
  IElementType ELSE_STMT = new SpiceElementType("ELSE_STMT");
  IElementType ENUM_DEF = new SpiceElementType("ENUM_DEF");
  IElementType ENUM_ITEM = new SpiceElementType("ENUM_ITEM");
  IElementType ENUM_ITEM_LST = new SpiceElementType("ENUM_ITEM_LST");
  IElementType EQUALITY_EXPR = new SpiceElementType("EQUALITY_EXPR");
  IElementType EXT_DECL = new SpiceElementType("EXT_DECL");
  IElementType FIELD = new SpiceElementType("FIELD");
  IElementType FOREACH_HEAD = new SpiceElementType("FOREACH_HEAD");
  IElementType FOREACH_LOOP = new SpiceElementType("FOREACH_LOOP");
  IElementType FOR_HEAD = new SpiceElementType("FOR_HEAD");
  IElementType FOR_LOOP = new SpiceElementType("FOR_LOOP");
  IElementType FUNCTION_CALL = new SpiceElementType("FUNCTION_CALL");
  IElementType FUNCTION_DEF = new SpiceElementType("FUNCTION_DEF");
  IElementType GENERIC_TYPE_DEF = new SpiceElementType("GENERIC_TYPE_DEF");
  IElementType GLOBAL_VAR_DEF = new SpiceElementType("GLOBAL_VAR_DEF");
  IElementType IDENTIFIER_EXPR = new SpiceElementType("IDENTIFIER_EXPR");
  IElementType IF_STMT = new SpiceElementType("IF_STMT");
  IElementType IMPORT_STMT = new SpiceElementType("IMPORT_STMT");
  IElementType INTERFACE_DEF = new SpiceElementType("INTERFACE_DEF");
  IElementType JOIN_CALL = new SpiceElementType("JOIN_CALL");
  IElementType LEN_CALL = new SpiceElementType("LEN_CALL");
  IElementType LINE_COM = new SpiceElementType("LINE_COM");
  IElementType LOGICAL_AND_EXPR = new SpiceElementType("LOGICAL_AND_EXPR");
  IElementType LOGICAL_OR_EXPR = new SpiceElementType("LOGICAL_OR_EXPR");
  IElementType MAIN_FUNCTION_DEF = new SpiceElementType("MAIN_FUNCTION_DEF");
  IElementType MULTIPLICATIVE_EXPR = new SpiceElementType("MULTIPLICATIVE_EXPR");
  IElementType PARAM_LST = new SpiceElementType("PARAM_LST");
  IElementType POSTFIX_UNARY_EXPR = new SpiceElementType("POSTFIX_UNARY_EXPR");
  IElementType PREFIX_UNARY_EXPR = new SpiceElementType("PREFIX_UNARY_EXPR");
  IElementType PREFIX_UNARY_OP = new SpiceElementType("PREFIX_UNARY_OP");
  IElementType PRIMITIVE_VALUE = new SpiceElementType("PRIMITIVE_VALUE");
  IElementType PRINTF_CALL = new SpiceElementType("PRINTF_CALL");
  IElementType PROCEDURE_DEF = new SpiceElementType("PROCEDURE_DEF");
  IElementType RELATIONAL_EXPR = new SpiceElementType("RELATIONAL_EXPR");
  IElementType RETURN_STMT = new SpiceElementType("RETURN_STMT");
  IElementType SHIFT_EXPR = new SpiceElementType("SHIFT_EXPR");
  IElementType SIGNATURE = new SpiceElementType("SIGNATURE");
  IElementType SIZE_OF_CALL = new SpiceElementType("SIZE_OF_CALL");
  IElementType SPECIFIER = new SpiceElementType("SPECIFIER");
  IElementType SPECIFIER_LST = new SpiceElementType("SPECIFIER_LST");
  IElementType STMT = new SpiceElementType("STMT");
  IElementType STMT_LST = new SpiceElementType("STMT_LST");
  IElementType STRUCT_DEF = new SpiceElementType("STRUCT_DEF");
  IElementType STRUCT_INSTANTIATION = new SpiceElementType("STRUCT_INSTANTIATION");
  IElementType TERNARY_EXPR = new SpiceElementType("TERNARY_EXPR");
  IElementType THREAD_DEF = new SpiceElementType("THREAD_DEF");
  IElementType TID_CALL = new SpiceElementType("TID_CALL");
  IElementType TYPE_ALTS_LST = new SpiceElementType("TYPE_ALTS_LST");
  IElementType TYPE_LST = new SpiceElementType("TYPE_LST");
  IElementType UNSAFE_BLOCK_DEF = new SpiceElementType("UNSAFE_BLOCK_DEF");
  IElementType VALUE = new SpiceElementType("VALUE");
  IElementType WHILE_LOOP = new SpiceElementType("WHILE_LOOP");

  IElementType AND_EQUAL = new SpiceTokenType("AND_EQUAL");
  IElementType AS = new SpiceTokenType("AS");
  IElementType ASSERT = new SpiceTokenType("ASSERT");
  IElementType ASSIGN = new SpiceTokenType("ASSIGN");
  IElementType BITWISE_AND = new SpiceTokenType("BITWISE_AND");
  IElementType BITWISE_NOT = new SpiceTokenType("BITWISE_NOT");
  IElementType BITWISE_OR = new SpiceTokenType("BITWISE_OR");
  IElementType BITWISE_XOR = new SpiceTokenType("BITWISE_XOR");
  IElementType BLOCK_COMMENT = new SpiceTokenType("BLOCK_COMMENT");
  IElementType BREAK = new SpiceTokenType("BREAK");
  IElementType CHAR_LIT = new SpiceTokenType("CHAR_LIT");
  IElementType COLON = new SpiceTokenType("COLON");
  IElementType COMMA = new SpiceTokenType("COMMA");
  IElementType CONST = new SpiceTokenType("CONST");
  IElementType CONTINUE = new SpiceTokenType("CONTINUE");
  IElementType DIV = new SpiceTokenType("DIV");
  IElementType DIV_EQUAL = new SpiceTokenType("DIV_EQUAL");
  IElementType DLL = new SpiceTokenType("DLL");
  IElementType DOT = new SpiceTokenType("DOT");
  IElementType DOUBLE_LIT = new SpiceTokenType("DOUBLE_LIT");
  IElementType ELLIPSIS = new SpiceTokenType("ELLIPSIS");
  IElementType ELSE = new SpiceTokenType("ELSE");
  IElementType ENUM = new SpiceTokenType("ENUM");
  IElementType EQUAL = new SpiceTokenType("EQUAL");
  IElementType EXT = new SpiceTokenType("EXT");
  IElementType F = new SpiceTokenType("F");
  IElementType FALSE = new SpiceTokenType("FALSE");
  IElementType FOR = new SpiceTokenType("FOR");
  IElementType FOREACH = new SpiceTokenType("FOREACH");
  IElementType GREATER = new SpiceTokenType("GREATER");
  IElementType GREATER_EQUAL = new SpiceTokenType("GREATER_EQUAL");
  IElementType HEAP = new SpiceTokenType("HEAP");
  IElementType IDENTIFIER = new SpiceTokenType("IDENTIFIER");
  IElementType IF = new SpiceTokenType("IF");
  IElementType IMPORT = new SpiceTokenType("IMPORT");
  IElementType INLINE = new SpiceTokenType("INLINE");
  IElementType INTERFACE = new SpiceTokenType("INTERFACE");
  IElementType INT_LIT = new SpiceTokenType("INT_LIT");
  IElementType JOIN = new SpiceTokenType("JOIN");
  IElementType LBRACE = new SpiceTokenType("LBRACE");
  IElementType LBRACKET = new SpiceTokenType("LBRACKET");
  IElementType LEN = new SpiceTokenType("LEN");
  IElementType LESS = new SpiceTokenType("LESS");
  IElementType LESS_EQUAL = new SpiceTokenType("LESS_EQUAL");
  IElementType LINE_COMMENT = new SpiceTokenType("LINE_COMMENT");
  IElementType LOGICAL_AND = new SpiceTokenType("LOGICAL_AND");
  IElementType LOGICAL_OR = new SpiceTokenType("LOGICAL_OR");
  IElementType LONG_LIT = new SpiceTokenType("LONG_LIT");
  IElementType LPAREN = new SpiceTokenType("LPAREN");
  IElementType MAIN = new SpiceTokenType("MAIN");
  IElementType MINUS = new SpiceTokenType("MINUS");
  IElementType MINUS_EQUAL = new SpiceTokenType("MINUS_EQUAL");
  IElementType MINUS_MINUS = new SpiceTokenType("MINUS_MINUS");
  IElementType MUL = new SpiceTokenType("MUL");
  IElementType MUL_EQUAL = new SpiceTokenType("MUL_EQUAL");
  IElementType NIL = new SpiceTokenType("NIL");
  IElementType NOT = new SpiceTokenType("NOT");
  IElementType NOT_EQUAL = new SpiceTokenType("NOT_EQUAL");
  IElementType OR_EQUAL = new SpiceTokenType("OR_EQUAL");
  IElementType P = new SpiceTokenType("P");
  IElementType PLUS = new SpiceTokenType("PLUS");
  IElementType PLUS_EQUAL = new SpiceTokenType("PLUS_EQUAL");
  IElementType PLUS_PLUS = new SpiceTokenType("PLUS_PLUS");
  IElementType PRINTF = new SpiceTokenType("PRINTF");
  IElementType PUBLIC = new SpiceTokenType("PUBLIC");
  IElementType QUESTION_MARK = new SpiceTokenType("QUESTION_MARK");
  IElementType RBRACE = new SpiceTokenType("RBRACE");
  IElementType RBRACKET = new SpiceTokenType("RBRACKET");
  IElementType REM = new SpiceTokenType("REM");
  IElementType REM_EQUAL = new SpiceTokenType("REM_EQUAL");
  IElementType RETURN = new SpiceTokenType("RETURN");
  IElementType RPAREN = new SpiceTokenType("RPAREN");
  IElementType SCOPE_ACCESS = new SpiceTokenType("SCOPE_ACCESS");
  IElementType SEMICOLON = new SpiceTokenType("SEMICOLON");
  IElementType SHL_EQUAL = new SpiceTokenType("SHL_EQUAL");
  IElementType SHORT_LIT = new SpiceTokenType("SHORT_LIT");
  IElementType SHR_EQUAL = new SpiceTokenType("SHR_EQUAL");
  IElementType SIGNED = new SpiceTokenType("SIGNED");
  IElementType SIZEOF = new SpiceTokenType("SIZEOF");
  IElementType STRING_LIT = new SpiceTokenType("STRING_LIT");
  IElementType STRUCT = new SpiceTokenType("STRUCT");
  IElementType THREAD = new SpiceTokenType("THREAD");
  IElementType TID = new SpiceTokenType("TID");
  IElementType TRUE = new SpiceTokenType("TRUE");
  IElementType TYPE = new SpiceTokenType("TYPE");
  IElementType TYPE_BOOL = new SpiceTokenType("TYPE_BOOL");
  IElementType TYPE_BYTE = new SpiceTokenType("TYPE_BYTE");
  IElementType TYPE_CHAR = new SpiceTokenType("TYPE_CHAR");
  IElementType TYPE_DOUBLE = new SpiceTokenType("TYPE_DOUBLE");
  IElementType TYPE_DYN = new SpiceTokenType("TYPE_DYN");
  IElementType TYPE_INT = new SpiceTokenType("TYPE_INT");
  IElementType TYPE_LONG = new SpiceTokenType("TYPE_LONG");
  IElementType TYPE_SHORT = new SpiceTokenType("TYPE_SHORT");
  IElementType TYPE_STRING = new SpiceTokenType("TYPE_STRING");
  IElementType UNSAFE = new SpiceTokenType("UNSAFE");
  IElementType UNSIGNED = new SpiceTokenType("UNSIGNED");
  IElementType WHILE = new SpiceTokenType("WHILE");
  IElementType XOR_EQUAL = new SpiceTokenType("XOR_EQUAL");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ADDITIVE_EXPR) {
        return new SpiceAdditiveExprImpl(node);
      }
      else if (type == ARG_LST) {
        return new SpiceArgLstImpl(node);
      }
      else if (type == ARRAY_INITIALIZATION) {
        return new SpiceArrayInitializationImpl(node);
      }
      else if (type == ASSERT_STMT) {
        return new SpiceAssertStmtImpl(node);
      }
      else if (type == ASSIGN_EXPR) {
        return new SpiceAssignExprImpl(node);
      }
      else if (type == ASSIGN_OP) {
        return new SpiceAssignOpImpl(node);
      }
      else if (type == ATOMIC_EXPR) {
        return new SpiceAtomicExprImpl(node);
      }
      else if (type == BASE_DATA_TYPE) {
        return new SpiceBaseDataTypeImpl(node);
      }
      else if (type == BITWISE_AND_EXPR) {
        return new SpiceBitwiseAndExprImpl(node);
      }
      else if (type == BITWISE_OR_EXPR) {
        return new SpiceBitwiseOrExprImpl(node);
      }
      else if (type == BITWISE_XOR_EXPR) {
        return new SpiceBitwiseXorExprImpl(node);
      }
      else if (type == BLOCK_COM) {
        return new SpiceBlockComImpl(node);
      }
      else if (type == BREAK_STMT) {
        return new SpiceBreakStmtImpl(node);
      }
      else if (type == BUILTIN_CALL) {
        return new SpiceBuiltinCallImpl(node);
      }
      else if (type == CAST_EXPR) {
        return new SpiceCastExprImpl(node);
      }
      else if (type == CONTINUE_STMT) {
        return new SpiceContinueStmtImpl(node);
      }
      else if (type == CUSTOM_DATA_TYPE) {
        return new SpiceCustomDataTypeImpl(node);
      }
      else if (type == DATA_TYPE) {
        return new SpiceDataTypeImpl(node);
      }
      else if (type == DECL_STMT) {
        return new SpiceDeclStmtImpl(node);
      }
      else if (type == ELSE_STMT) {
        return new SpiceElseStmtImpl(node);
      }
      else if (type == ENUM_DEF) {
        return new SpiceEnumDefImpl(node);
      }
      else if (type == ENUM_ITEM) {
        return new SpiceEnumItemImpl(node);
      }
      else if (type == ENUM_ITEM_LST) {
        return new SpiceEnumItemLstImpl(node);
      }
      else if (type == EQUALITY_EXPR) {
        return new SpiceEqualityExprImpl(node);
      }
      else if (type == EXT_DECL) {
        return new SpiceExtDeclImpl(node);
      }
      else if (type == FIELD) {
        return new SpiceFieldImpl(node);
      }
      else if (type == FOREACH_HEAD) {
        return new SpiceForeachHeadImpl(node);
      }
      else if (type == FOREACH_LOOP) {
        return new SpiceForeachLoopImpl(node);
      }
      else if (type == FOR_HEAD) {
        return new SpiceForHeadImpl(node);
      }
      else if (type == FOR_LOOP) {
        return new SpiceForLoopImpl(node);
      }
      else if (type == FUNCTION_CALL) {
        return new SpiceFunctionCallImpl(node);
      }
      else if (type == FUNCTION_DEF) {
        return new SpiceFunctionDefImpl(node);
      }
      else if (type == GENERIC_TYPE_DEF) {
        return new SpiceGenericTypeDefImpl(node);
      }
      else if (type == GLOBAL_VAR_DEF) {
        return new SpiceGlobalVarDefImpl(node);
      }
      else if (type == IDENTIFIER_EXPR) {
        return new SpiceIdentifierExprImpl(node);
      }
      else if (type == IF_STMT) {
        return new SpiceIfStmtImpl(node);
      }
      else if (type == IMPORT_STMT) {
        return new SpiceImportStmtImpl(node);
      }
      else if (type == INTERFACE_DEF) {
        return new SpiceInterfaceDefImpl(node);
      }
      else if (type == JOIN_CALL) {
        return new SpiceJoinCallImpl(node);
      }
      else if (type == LEN_CALL) {
        return new SpiceLenCallImpl(node);
      }
      else if (type == LINE_COM) {
        return new SpiceLineComImpl(node);
      }
      else if (type == LOGICAL_AND_EXPR) {
        return new SpiceLogicalAndExprImpl(node);
      }
      else if (type == LOGICAL_OR_EXPR) {
        return new SpiceLogicalOrExprImpl(node);
      }
      else if (type == MAIN_FUNCTION_DEF) {
        return new SpiceMainFunctionDefImpl(node);
      }
      else if (type == MULTIPLICATIVE_EXPR) {
        return new SpiceMultiplicativeExprImpl(node);
      }
      else if (type == PARAM_LST) {
        return new SpiceParamLstImpl(node);
      }
      else if (type == POSTFIX_UNARY_EXPR) {
        return new SpicePostfixUnaryExprImpl(node);
      }
      else if (type == PREFIX_UNARY_EXPR) {
        return new SpicePrefixUnaryExprImpl(node);
      }
      else if (type == PREFIX_UNARY_OP) {
        return new SpicePrefixUnaryOpImpl(node);
      }
      else if (type == PRIMITIVE_VALUE) {
        return new SpicePrimitiveValueImpl(node);
      }
      else if (type == PRINTF_CALL) {
        return new SpicePrintfCallImpl(node);
      }
      else if (type == PROCEDURE_DEF) {
        return new SpiceProcedureDefImpl(node);
      }
      else if (type == RELATIONAL_EXPR) {
        return new SpiceRelationalExprImpl(node);
      }
      else if (type == RETURN_STMT) {
        return new SpiceReturnStmtImpl(node);
      }
      else if (type == SHIFT_EXPR) {
        return new SpiceShiftExprImpl(node);
      }
      else if (type == SIGNATURE) {
        return new SpiceSignatureImpl(node);
      }
      else if (type == SIZE_OF_CALL) {
        return new SpiceSizeOfCallImpl(node);
      }
      else if (type == SPECIFIER) {
        return new SpiceSpecifierImpl(node);
      }
      else if (type == SPECIFIER_LST) {
        return new SpiceSpecifierLstImpl(node);
      }
      else if (type == STMT) {
        return new SpiceStmtImpl(node);
      }
      else if (type == STMT_LST) {
        return new SpiceStmtLstImpl(node);
      }
      else if (type == STRUCT_DEF) {
        return new SpiceStructDefImpl(node);
      }
      else if (type == STRUCT_INSTANTIATION) {
        return new SpiceStructInstantiationImpl(node);
      }
      else if (type == TERNARY_EXPR) {
        return new SpiceTernaryExprImpl(node);
      }
      else if (type == THREAD_DEF) {
        return new SpiceThreadDefImpl(node);
      }
      else if (type == TID_CALL) {
        return new SpiceTidCallImpl(node);
      }
      else if (type == TYPE_ALTS_LST) {
        return new SpiceTypeAltsLstImpl(node);
      }
      else if (type == TYPE_LST) {
        return new SpiceTypeLstImpl(node);
      }
      else if (type == UNSAFE_BLOCK_DEF) {
        return new SpiceUnsafeBlockDefImpl(node);
      }
      else if (type == VALUE) {
        return new SpiceValueImpl(node);
      }
      else if (type == WHILE_LOOP) {
        return new SpiceWhileLoopImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
