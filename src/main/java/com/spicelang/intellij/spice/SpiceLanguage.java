package com.spicelang.intellij.spice;

import com.intellij.lang.Language;

public class SpiceLanguage extends Language {

    public static final SpiceLanguage INSTANCE = new SpiceLanguage();

    private SpiceLanguage() {
        super("Spice");
    }
}