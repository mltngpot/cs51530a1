package com.pnwcs;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;

public class Token {
    public SymbolType type;
    public String lexeme;

    public Token(String lexeme, SymbolType type)
    {
        this.lexeme = lexeme;
        this.type = type;
    }
    public static Token[] seperateTokens(String line)
    {
        Queue<Token> result = new Queue<Token>();
        result.enqueue(seperateTokens(line, Main.seperators));
        result.enqueue(seperateTokens(line, Main.operators));
        result.enqueue(seperateTokens(line, Main.keywords);
        result.enqueue(seperateTokens(line, Main.identifiers));
        result.enqueue(seperateTokens(line, Main.literals));
        return result;
    }

    public static Token[] seperateTokens(String line, List<Symbol> symbols)
    {

        Queue<Token> result = new Queue<Token>();
        for(Symbol symbol: symbols)
        {
            Pattern pattern = Pattern.compile(symbol.regex);
            Matcher matcher = pattern.matcher(line);
            // pull out the other peices here and queue them up
        }
        return result;
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
