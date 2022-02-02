package com.pnwcs;

public class Token {
    public SymbolType type;
    public String value;

    @Override
    public String toString() {
        return "[" +
                type +
                "]:[" +
                value +
                "]";
    }
}
