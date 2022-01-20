package com.spicelang.intellij.spice.psi.impl;

import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.spicelang.intellij.spice.psi.*;

public class SpicePsiImplUtil {

    public static String getName(SpiceIdentifierExpr element) {
        return getIdentifier(element);
    }

    public static PsiElement setName(SpiceIdentifierExpr element, String newName) {
        ASTNode identifierNode = element.getNode().findChildByType(SpiceTypes.IDENTIFIER);
        if (identifierNode != null) {
            SpiceIdentifierExpr identifierExpr = SpiceElementFactory.createIdentifier(element.getProject(), newName);
            ASTNode newIdentifierNode = identifierExpr.getFirstChild().getNode();
            element.getNode().replaceChild(identifierNode, newIdentifierNode);
        }
        return element;
    }

    public static PsiElement getNameIdentifier(SpiceIdentifierExpr element) {
        ASTNode keyNode = element.getNode().findChildByType(SpiceTypes.IDENTIFIER);
        if (keyNode == null) return null;
        return keyNode.getPsi();
    }

    public static String getIdentifier(SpiceIdentifierExpr element) {
        ASTNode keyNode = element.getNode().findChildByType(SpiceTypes.IDENTIFIER);
        if (keyNode == null) return null;
        return keyNode.getText();
    }

    public static String getFunctionName(SpiceFunctionDef element) {
        ASTNode keyNode = element.getNode().findChildByType(SpiceTypes.IDENTIFIER);
        if (keyNode == null) return null;
        return keyNode.getText();
    }

    public static String getProcedureName(SpiceProcedureDef element) {
        ASTNode keyNode = element.getNode().findChildByType(SpiceTypes.IDENTIFIER);
        if (keyNode == null) return null;
        return keyNode.getText();
    }

    public static String getStructName(SpiceStructDef element) {
        ASTNode keyNode = element.getNode().findChildByType(SpiceTypes.IDENTIFIER);
        if (keyNode == null) return null;
        return keyNode.getText();
    }
}
