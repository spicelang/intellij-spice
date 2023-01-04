/*
 * Copyright (c) 2022-2023 ChilliBits. All rights reserved.
 */

package com.spicelang.intellij.spice;

import com.intellij.lang.Language;

public class SpiceLanguage extends Language {

    public static final SpiceLanguage INSTANCE = new SpiceLanguage();

    private SpiceLanguage() {
        super("Spice");
    }
}