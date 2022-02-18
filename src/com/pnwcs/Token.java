package com.pnwcs;

import java.util.PriorityQueue;
import java.util.Queue;

public class Token {
    public SymbolType type;
    public String lexeme;

    public Token(String lexeme, SymbolType type)
    {
        this.lexeme = lexeme;
        this.type = type;
    }

    @Override
    public String toString() {
        return "[" +
                type +
                "]:[" +
                value +
                "]";
    }
}
