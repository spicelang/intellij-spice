/*
 * Copyright (c) 2022-2026 ChilliBits. All rights reserved.
 */

package com.spicelang.intellij.spice.debug;

import com.intellij.openapi.util.text.StringUtil;
import com.jetbrains.cidr.execution.debugger.backend.gdb.GDBDriverConfiguration;
import org.jetbrains.annotations.NotNull;

/**
 * GDB driver configuration that points the native debugger at a user-provided (or the system) GDB
 * binary. Spice executables built with {@code spice build -g} carry DWARF debug info that maps back
 * to the {@code .spice} sources, so the standard native debugger drives them like C/C++ binaries.
 */
public class SpiceGDBDriverConfiguration extends GDBDriverConfiguration {

    private final String gdbExecutablePath;

    public SpiceGDBDriverConfiguration(String gdbExecutablePath) {
        this.gdbExecutablePath = StringUtil.isEmptyOrSpaces(gdbExecutablePath) ? "gdb" : gdbExecutablePath.trim();
    }

    @NotNull
    @Override
    public String getDriverName() {
        return "Spice GDB";
    }

    @Override
    protected String getGDBExecutablePath() {
        return gdbExecutablePath;
    }
}
