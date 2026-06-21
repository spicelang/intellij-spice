/*
 * Copyright (c) 2022-2026 ChilliBits. All rights reserved.
 */

package com.spicelang.intellij.spice.debug;

import com.intellij.openapi.fileTypes.FileType;
import com.jetbrains.cidr.execution.debugger.breakpoints.CidrLineBreakpointFileTypesProvider;
import com.spicelang.intellij.spice.SpiceFileType;
import org.jetbrains.annotations.NotNull;

import java.util.Collections;
import java.util.Set;

/**
 * Tells the native (CIDR/GDB) debugger that line breakpoints may be placed in Spice files. Without
 * this, {@code CidrLineBreakpointType.canPutAt} rejects {@code .spice} files and the gutter refuses
 * to set breakpoints.
 */
public class SpiceLineBreakpointFileTypesProvider implements CidrLineBreakpointFileTypesProvider {

    @NotNull
    @Override
    public Set<FileType> getFileTypes() {
        return Collections.singleton(SpiceFileType.INSTANCE);
    }
}
