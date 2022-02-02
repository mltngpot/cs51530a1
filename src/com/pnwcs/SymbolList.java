package com.pnwcs;

import java.util.List;

public class SymbolList extends List<Symbol> {
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
