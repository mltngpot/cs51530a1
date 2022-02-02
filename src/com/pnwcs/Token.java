package com.pnwcs;

public class Token {
    public SymbolType type;
    public String lexeme;

    @Override
    public String toString() {
        return "[" +
                type +
                "]:[" +
                value +
                "]";
    }
}
