package com.pnwcs;

import java.util.PriorityQueue;

public class Main {
    public static void main(String[] args) {
        // read command arguments pass, if successful continue on
        if(!readArgs(args)) {
            System.exit(-1);
        }
        var tokenQueue = new PriorityQueue<Token>();
        tokenQueue.add(new Token("StartToken", SymbolType.start));
        while (System.in.read) {
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
