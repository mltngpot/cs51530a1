package com.pnwcs;

import java.util.regex.Pattern;

public class Symbol {
    public SymbolType type;
    public String lexeme;
    public String regex;
    public Pattern patten;
    public Symbol(SymbolType type, String regex, String lexeme)
    {
        this.type = type;
        this.lexeme = lexeme;
        this.regex = regex;
        this.patten = Pattern.compile(regex);
    }
}
