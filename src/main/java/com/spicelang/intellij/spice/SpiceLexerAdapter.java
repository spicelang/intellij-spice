package com.spicelang.intellij.spice;

import com.intellij.lexer.FlexAdapter;

public class SpiceLexerAdapter extends FlexAdapter {
    public SpiceLexerAdapter() {
        super(new SpiceLexer(null));
    }
}