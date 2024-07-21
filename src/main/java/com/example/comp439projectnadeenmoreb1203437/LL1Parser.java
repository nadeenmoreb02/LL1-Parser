package com.example.comp439projectnadeenmoreb1203437;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.Queue;

public class LL1Parser {
    public static boolean isSuccessful = false;
    public static String lastTkn = "";
    public static int errorLine = 0;
    public static String errorMessage = "";

    public static void setSuccessful(boolean successful) {
        isSuccessful = successful;
    }

    public static boolean isIsSuccessful() {
        return isSuccessful;
    }

    public static void compareInputToProductionRule(Map<String, Map<String, String>> parsingTable, Queue<Tkn> inputTokensQ){
        Deque<String> pRuleDQueue = new ArrayDeque<>();
        pRuleDQueue.push("module-decl");


        while (!inputTokensQ.isEmpty()){
            Tkn inputCurrentToken  = inputTokensQ.peek();

//        if it was wrong name string, it is error and parsing is failed

            if(inputCurrentToken.getV().equals("error")){
                errorLine = inputCurrentToken.line;
                lastTkn = inputCurrentToken.rawValue;
                errorMessage = "the token " + lastTkn + " at line: " + errorLine +" is not recognized! - scanner error";
                System.out.println("Parsing failed!");
                break;
            }

//        if it was empty string, lambda in other words, it is removed and is continued to next token
            else if(pRuleDQueue.peek().equals("λ")){
                pRuleDQueue.pop();
//    System.out.println("Stack λ: " + pRuleDQueue);
            }

            //if it was a terminal token and they match remove them each from tokens buffer and from production rule stack
            else if(inputCurrentToken.getV().equals(pRuleDQueue.peek())){
                inputTokensQ.poll();
                pRuleDQueue.pop();
//              System.out.println("Matched: " + inputCurrentToken);
            }

            //if it was a non-terminal go to parsing table hashmap and get the corresponding productions rule
            //also compare the terminals that this non-terminal has to get the one that matches with the input token
            //after getting it, get its corresponding production rule and push it to stack
       else if(parsingTable.get(pRuleDQueue.peek()) != null && parsingTable.get(pRuleDQueue.peek()).containsKey(inputCurrentToken.getV())){
//           System.out.println("Stack: " + pRuleDQueue + " Current Token: " + inputCurrentToken + " left input: " + inputTokensQ);
                parsingTable.get(pRuleDQueue.peek()).forEach((key, value) -> {
                    //key is the terminal
                    if(key.equals(inputCurrentToken.getV())){
                        pRuleDQueue.pop();
                        String[] termsArr = value.split(" ");
                        for(int i= termsArr.length - 1; i >= 0; i--){
                            pRuleDQueue.push(termsArr[i]);
                        }
                    }
                }); }

//          if it was null and not found in parsing table
            else if(parsingTable.get(pRuleDQueue.peek()) == null){
                errorLine = inputCurrentToken.line;
                lastTkn = inputCurrentToken.rawValue;
                errorMessage = "rule of the token " + lastTkn + " at line: " + errorLine +" is not found or specified in parsing table! - parser error";
                System.out.println("Parsing failed!");
                break;
            }

//            if it didn't match the grammar
            else {
                errorLine = inputCurrentToken.line;
                lastTkn = inputCurrentToken.rawValue;
                errorMessage = "the token " + lastTkn + " at line: " + errorLine +" does not have a match from production rules! - parser error";
                System.out.println("Parsing failed!");
                break;
            }

            }
        if(inputTokensQ.isEmpty() && pRuleDQueue.isEmpty()){
            setSuccessful(true);
            System.out.println("Parsing successful!");
        }
        else{
            System.out.println("Parsing failed!");
        }


    }
}
