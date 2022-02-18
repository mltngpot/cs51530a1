package com.pnwcs;

import java.util.Arrays;
import java.util.Collection;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.regex.Matcher;

public class Scanner {
    public static Queue<Token> readTokens(String line, Symbol[] symbols)
    {
        if (line.length() == 0) return null; // well... we aren't going to find anything

        var result = new PriorityQueue<Token>();
        
        // its stupid, i don't like it, but it wouldn't let me create a new Matcher
        // there also seems to be a better way to do this, i dont know what it is right now...
        var matcher = symbols[0].patten.matcher(line); 
        
        // lets go through the remaining symbols
        for(int i = 0; i < symbols.length; ++i)
        {
            // update the matcher with the new pattern
            matcher.usePattern(symbols[i].patten);
            if(!matcher.find()) continue; // our symbol isn't there, lets on to the next one

            // we have a match
            // call the separateToken and queue up the results
            result.addAll(separateToken(line, Arrays.copyOfRange(symbols, i, symbols.length)));
            break; // recursive call gets us all the symbols that might be there

        }

        return result;
    }

    private static Queue<Token> separateToken(String line, Symbol[] symbols) {
        var symbol = symbols[0];
        var result = new PriorityQueue<Token>();
        
        // we have a match, lets separate this token out and see what we get
        // first lets be sure it is not an identifier or a literal
        if(symbol.type == SymbolType.identifier || symbol.type == SymbolType.literal)
        {
            // these get handled a bit differently since we want to keep the value
            // they should also be the end of the line as everything else (operators, separators, and keywords) should have been removed
        } else {
            handleStaticTokens(line, symbols, symbol, result);
        }
        return result;
    }

    private static void handleStaticTokens(String line, Symbol[] symbols, Symbol symbol, PriorityQueue<Token> result) {
        // lets split the line into segments around our symbol
        var segments = line.split(symbol.regex);

        // we don't know where our token is, maybe there is one at the beginning
        if(line.charAt(0) != segments.charAt(0)) {
            // yup there was one
            result.add(new Token(symbol.lexeme, symbol.type));
        }
        // now add most lines 
        for(int i = 0; i < segments.length -1; ++i)
        {
            result.addAll(readTokens(segments[i], Arrays.copyOfRange(symbols, 1, symbols.length))); // Its Recursion! 
            result.add(new Token(symbol.lexeme, symbol.type));
        }
        // ok, one left
        result.addAll(readTokens(segments[segments.length], Arrays.copyOfRange(symbols, 1, symbols.length)));

        // was there a token at the end?
        if(line.length() - line.lastIndexOf(segments[segments.length]) != segments.length)
        {
            // there was...
            result.add(new Token(symbol.lexeme, symbol.type));
        }
    }
}
