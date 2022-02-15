package com.pnwcs;

import java.util.List;
import java.util.Queue;

public class Main {

    public static TokenQueue tokenQueue = new TokenQueue();
    public static Symbols seperators = new Symbols();
    public static Symbols operators = new Symbols();
    public static Symbols keywords = new Symbols();
    public static Symbols identifiers = new Symbols();
    public static Symbols literals = new Symbols();


    public static void main(String[] args) {
        // read command arguments pass, if successful continue on
        if(!readArgs(args)) {
            System.exit(-1);
        }
        tokenQueue.enqueue(new Token(StartToken));
        while (!System.in.eof) {

            String line = System.in.readLine();
            tokenQueue.enqueue(Token.seperateTokens(line));
        }
    }

    private static void writeTokens(Token resolveToken) {
        var tokens = symbols.ResolveToken(token);
        // we hit the start token, time to print everything
        for (Token token: resolveToken) {
            System.WriteLine(Token.ToString());
        }
    }

    public static boolean readArgs(String[] args)
    {
        for(int i = 0; i < args.length; ++i)
        {
            switch (args[i]){
                case "--symbols":
                    // handle the parameter
                    ++i;
                    if(args[i]) // if string ! null, or empty
                    {
                        symbols.read(args[i]);
                    }
                    break;
                case "--source":
                    // handle the parameter
                    ++i;
                    if(args[i]) // if string ! null, or empty
                    {
                        tokenQueue.read(args[i]); // read the file
                    }
                    break;
                case "--outfile":
                    // handle the parameter
                    ++i;
                    if(args[i]) // if string ! null, or empty
                    {
                        // change the output steam
                    }
                    break;
            }
        }
    }

}
