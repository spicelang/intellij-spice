package com.spicelang.intellij.spice.psi;

import com.intellij.openapi.project.Project;
import com.intellij.psi.PsiFileFactory;
import com.spicelang.intellij.spice.SpiceFileType;

public class SpiceElementFactory {
    public static SpiceIdentifierExpr createIdentifier(Project project, String name) {
        final SpiceFile file = createFile(project, name);
        return (SpiceIdentifierExpr) file.getFirstChild();
    }

    public static SpiceFile createFile(Project project, String text) {
        String name = "dummy.spice";
        return (SpiceFile) PsiFileFactory.getInstance(project).createFileFromText(name, SpiceFileType.INSTANCE, text);
    }
}
