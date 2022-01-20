package com.spicelang.intellij.spice;

import com.google.common.collect.Lists;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.text.StringUtil;
import com.intellij.openapi.vfs.VirtualFile;
import com.intellij.psi.PsiComment;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiManager;
import com.intellij.psi.PsiWhiteSpace;
import com.intellij.psi.search.FileTypeIndex;
import com.intellij.psi.search.GlobalSearchScope;
import com.intellij.psi.util.PsiTreeUtil;
import com.spicelang.intellij.spice.psi.SpiceAtomicExpr;
import com.spicelang.intellij.spice.psi.SpiceFile;
import com.spicelang.intellij.spice.psi.SpiceIdentifierExpr;
import org.jetbrains.annotations.NotNull;

import java.util.*;

public class SpiceUtil {

    public static List<SpiceIdentifierExpr> findIdentifiers(Project project, String identifier) {
        List<SpiceIdentifierExpr> result = new ArrayList<>();
        for (SpiceIdentifierExpr identifierExpr : findIdentifiers(project)) {
            if (identifierExpr.getIdentifier().equals(identifier)) result.add(identifierExpr);
        }
        return result;
    }

    public static List<SpiceIdentifierExpr> findIdentifiers(Project project) {
        List<SpiceIdentifierExpr> result = new ArrayList<>();
        Collection<VirtualFile> virtualFiles = FileTypeIndex.getFiles(SpiceFileType.INSTANCE, GlobalSearchScope.allScope(project));
        for (VirtualFile virtualFile : virtualFiles) {
            SpiceFile spiceFile = (SpiceFile) PsiManager.getInstance(project).findFile(virtualFile);
            if (spiceFile != null) {
                SpiceIdentifierExpr[] idenExpressions = PsiTreeUtil.getChildrenOfType(spiceFile, SpiceIdentifierExpr.class);
                if (idenExpressions != null) Collections.addAll(result, idenExpressions);
            }
        }
        return result;
    }

    public static @NotNull String findDocumentationComment(SpiceAtomicExpr atomicExpr) {
        List<String> result = new LinkedList<>();
        PsiElement element = atomicExpr.getPrevSibling();
        while (element instanceof PsiComment || element instanceof PsiWhiteSpace) {
            if (element instanceof PsiComment) {
                String commentText = element.getText().replaceFirst("[/ ]+", "");
                result.add(commentText);
            }
            element = element.getPrevSibling();
        }
        return StringUtil.join(Lists.reverse(result),"\n ");
    }
}
