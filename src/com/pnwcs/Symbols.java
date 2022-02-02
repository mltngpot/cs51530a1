package com.pnwcs;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class Symbols {

    public List<Symbol> operators = new List<Symbol>();

    public void read(String arg) {
        // read from json file
        // {
        //   "operator" : [
        //     { "name" : "plus",
        //       "regex" : "[+]"
        //   ],
        // ...
        // }
    }

    public Queue<Token> ResolveToken(Token token) {
        // using the regex values of the symbols match the tokens.
        // follow some order of operations so the more common things go first
    }
}
