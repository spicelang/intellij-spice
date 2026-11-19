/*
 * Copyright (c) 2022-2026 ChilliBits. All rights reserved.
 */

package com.spicelang.intellij.spice.settings;

import com.intellij.openapi.application.ApplicationManager;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.Service;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.openapi.util.text.StringUtil;
import org.jetbrains.annotations.NotNull;

/**
 * IDE-wide settings of the Spice plugin, editable under Settings | Languages &amp; Frameworks | Spice.
 */
@Service(Service.Level.APP)
@State(name = "SpiceSettings", storages = @Storage("spice.xml"))
public final class SpiceSettings implements PersistentStateComponent<SpiceSettings.State> {

    /**
     * Compiler, that is used, if no path is configured. It is looked up on the PATH.
     */
    public static final String DEFAULT_COMPILER = "spice";

    public static final class State {
        public String compilerPath = "";
        public boolean useSpiceFormatter = true;
    }

    private State state = new State();

    @NotNull
    public static SpiceSettings getInstance() {
        return ApplicationManager.getApplication().getService(SpiceSettings.class);
    }

    @NotNull
    @Override
    public State getState() {
        return state;
    }

    @Override
    public void loadState(@NotNull State state) {
        this.state = state;
    }

    /**
     * Path of the Spice compiler, as configured by the user. Empty, if not configured.
     */
    @NotNull
    public String getCompilerPath() {
        return StringUtil.notNullize(state.compilerPath);
    }

    public void setCompilerPath(@NotNull String compilerPath) {
        state.compilerPath = compilerPath.trim();
    }

    /**
     * Spice compiler to run: the configured path or {@link #DEFAULT_COMPILER} from the PATH.
     */
    @NotNull
    public String getCompilerToRun() {
        return StringUtil.defaultIfEmpty(getCompilerPath().trim(), DEFAULT_COMPILER);
    }

    /**
     * Whether "Reformat Code" formats Spice files with 'spice format' instead of the built-in indentation formatter.
     */
    public boolean isUseSpiceFormatter() {
        return state.useSpiceFormatter;
    }

    public void setUseSpiceFormatter(boolean useSpiceFormatter) {
        state.useSpiceFormatter = useSpiceFormatter;
    }
}
