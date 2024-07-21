package com.example.comp439projectnadeenmoreb1203437;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

//tokenizer class which acts as a scanner
//has methods to scan the input string and divides it and returns the tokens in a list of tokens that has type and value
public class Tknizer {

    //    this method returns all tokens as a list of token objects
//    it takes a list of strings of the input code string that is divided based on spaces and lines as a parameter
//    then it passes this list to returnStrings method to get the list of string tokens values
//    each of these token strings is classified into one of the types : reserved word, operator, symbol, name, real value, integer-value
//    the returned list contains these classified tokens, where each stores a value and its corresponding type
    public static List<Tkn> returnTkns(HashMap<Integer, List<String>> list){

        List<Tkn> tknList = new ArrayList<Tkn>();
for(int line=1; line<list.size()+1;line++){
        List<String> myList = returnStrings(list.get(line));
//        System.out.println("myList: " + myList);
        for (int i = 0; i < myList.size(); i++) {
            String element = myList.get(i);
            element = element.replaceAll("\\s", "");
            element = element.replaceAll("\n", "");
            if(element.equals("begin"))
            {
                tknList.add(new Tkn("reserved", "begin",line, element));
            }
            else if(element.equals("end"))
            {
                tknList.add(new Tkn("reserved", "end",line, element));
            }
            else if(element.equals("module")){
                tknList.add(new Tkn("reserved", "module",line, element));
            }
            else if(element.equals("procedure"))
            {
                tknList.add(new Tkn("reserved", "procedure",line, element));
            }
            else if(element.equals("var"))
            {
                tknList.add(new Tkn("reserved", "var", line, element));
            }
            else if(element.equals("const"))
            {
                tknList.add(new Tkn("reserved", "const", line, element));
            }
            else if(element.equals("writechar"))
            {
                tknList.add(new Tkn("reserved", "writechar", line, element));
            }
            else if(element.equals("readchar"))
            {
                tknList.add(new Tkn("reserved", "readchar", line, element));
            }
            else if(element.equals("writeln"))
            {
                tknList.add(new Tkn("reserved", "writeln", line, element));
            }
            else if(element.equals("readln"))
            {
                tknList.add(new Tkn("reserved", "readln", line, element));
            }
            else if(element.equals("writeint"))
            {
                tknList.add(new Tkn("reserved", "writeint", line, element));
            }
            else if(element.equals("readint"))
            {
                tknList.add(new Tkn("reserved", "readint", line, element));
            }
            else if(element.equals("writereal"))
            {
                tknList.add(new Tkn("reserved", "writereal", line, element));
            }
            else if(element.equals("readreal"))
            {
                tknList.add(new Tkn("reserved", "readreal", line, element));
            }
            else if(element.equals("call"))
            {
                tknList.add(new Tkn("reserved", "call", line, element));
            }
            else if(element.equals("if"))
            {
                tknList.add(new Tkn("reserved", "if", line, element));
            }
            else if(element.equals("else"))
            {
                tknList.add(new Tkn("reserved", "else", line, element));
            }
            else if(element.equals("then"))
            {
                tknList.add(new Tkn("reserved", "then", line, element));
            }
            else if(element.equals("until"))
            {
                tknList.add(new Tkn("reserved", "until", line, element));
            }
            else if(element.equals("loop"))
            {
                tknList.add(new Tkn("reserved", "loop", line, element));
            }
            else if(element.equals("do"))
            {
                tknList.add(new Tkn("reserved", "do", line, element));
            }
            else if(element.equals("while"))
            {
                tknList.add(new Tkn("reserved", "while", line, element));
            }
            else if(element.equals("exit"))
            {
                tknList.add(new Tkn("reserved", "exit", line, element));
            }
            else if(element.equals("char"))
            {
                tknList.add(new Tkn("reserved", "char", line, element));
            }
            else if(element.equals("real"))
            {
                tknList.add(new Tkn("reserved", "real", line, element));
            }
            else if(element.equals("integer"))
            {
                tknList.add(new Tkn("reserved", "integer", line, element));
            }
            else if(element.equals(";"))
            {
                tknList.add(new Tkn("symbol", ";", line, element));
            }
            else if(element.equals("="))
            {
                tknList.add(new Tkn("operator", "=", line, element));
            }
            else if(element.equals(","))
            {
                tknList.add(new Tkn("symbol", ",", line, element));
            }
            else if(element.equals(":"))
            {
                tknList.add(new Tkn("symbol", ":", line, element));
            }
            else if(element.equals("("))
            {
                tknList.add(new Tkn("symbol", "(", line, element));
            }
            else if(element.equals(")"))
            {
                tknList.add(new Tkn("symbol", ")", line, element));
            }
            else if(element.equals("*"))
            {
                tknList.add(new Tkn("operator", "*", line, element));
            }
            else if(element.equals("+"))
            {
                tknList.add(new Tkn("operator", "+", line, element));
            }
            else if(element.equals("/"))
            {
                tknList.add(new Tkn("operator", "/", line, element));
            }
            else if(element.equals("div"))
            {
                tknList.add(new Tkn("operator", "div", line, element));
            }
            else if(element.equals("-"))
            {
                tknList.add(new Tkn("operator", "-", line, element));
            }
            else if(element.equals("mod"))
            {
                tknList.add(new Tkn("operator", "mod", line, element));
            }
            else if(element.equals("$"))
            {
                tknList.add(new Tkn("symbol", "$", line, element));
            }
            else if(element.equals(":="))
            {
                tknList.add(new Tkn("operator", ":=", line, element));
            }
            else if(element.equals(">="))
            {
                tknList.add(new Tkn("operator", ">=", line, element));
            }
            else if(element.equals(">"))
            {
                tknList.add(new Tkn("operator", ">", line, element));
            }
            else if(element.equals("<="))
            {
                tknList.add(new Tkn("operator", "<=", line, element));
            }
            else if(element.equals("<"))
            {
                tknList.add(new Tkn("operator", "<", line, element));
            }
            else if(element.equals("|="))
            {
                tknList.add(new Tkn("operator", "|=", line, element));
            }

            else if(element.equals("."))
            {
                tknList.add(new Tkn("symbol", ".", line, element));
            }
            else if(isRealNumberMatch(element))
            {
                tknList.add(new Tkn("real-value", "real-value", line, element));
            }
            else if(isNameMatch(element))
            {
                tknList.add(new Tkn("name", "name", line, element));
            }

            else if(isIntegerNumberMatch(element))
            {
                tknList.add(new Tkn("integer-value", "integer-value", line, element));
            }
            else tknList.add(new Tkn("error", "error", line, element));

        }}
        return tknList;
    }


    //    I give this the list of strings that is divided based on spaces or lines
//    it returns a list of string tokens
    public static List<String> returnStrings(List<String> myList){
        List<String> newList = new ArrayList<String>();
//        System.out.println(myList);
        for (int i = 0; i < myList.size(); i++) {
            String element = myList.get(i);
            if(element.equals("begin"))
            {
                newList.add("begin");
            }
            else if(element.equals("end"))
            {
                newList.add("end");
            }
            else if(element.equals("procedure"))
            {
                newList.add("procedure");
            }
            else if(element.equals("var"))
            {
                newList.add("var");
            }
            else if(element.equals("const"))
            {
                newList.add("const");
            }
            else if(element.equals("module")){
                newList.add("module");
            }
            else if(element.equals("writereal"))
            {
                newList.add("writereal");
            }
            else if(element.equals("readreal"))
            {
                newList.add("readreal");
            }

            else if(element.equals("writeint"))
            {
                newList.add("writeint");
            }
            else if(element.equals("readint"))
            {
                newList.add("readint");
            }

            else if(element.equals("writeln"))
            {
                newList.add("writeln");
            }
            else if(element.equals("readln"))
            {
                newList.add("readln");
            }
            else if(element.equals("writechar"))
            {
                newList.add("writechar");
            }
            else if(element.equals("readchar"))
            {
                newList.add("readchar");
            }
            else if(element.equals("if"))
            {
                newList.add("if");
            }
            else if(element.equals("then"))
            {
                newList.add("then");
            }
            else if(element.equals("else"))
            {
                newList.add("else");
            }
            else if(element.equals("char"))
            {
                newList.add("char");
            }
            else if(element.equals("real"))
            {
                newList.add("real");
            }
            else if(element.equals("integer"))
            {
                newList.add("integer");
            }

            else if(element.equals("until"))
            {
                newList.add("until");
            }
            else if(element.equals("loop"))
            {
                newList.add("loop");
            }
            else if(element.equals("do"))
            {
                newList.add("do");
            }
            else if(element.equals("while"))
            {
                newList.add("while");
            }
            else if(element.equals("exit"))
            {
                newList.add("exit");
            }
            else if(element.equals("call"))
            {
                newList.add("call");
            }
            else if(element.equals("="))
            {
                newList.add("=");
            }
            else if(element.equals(","))
            {
                newList.add(",");
            }
            else if(element.equals(";"))
            {
                newList.add(";");
            }
            else if(element.equals(":"))
            {
                newList.add(":");
            }
            else if(element.equals("("))
            {
                newList.add("(");
            }
            else if(element.equals(")"))
            {
                newList.add(")");
            }

            else if(element.equals("*"))
            {
                newList.add("*");
            }
            else if(element.equals("+"))
            {
                newList.add("+");
            }
            else if(element.equals("/"))
            {
                newList.add("/");
            }
            else if(element.equals("div"))
            {
                newList.add("div");
            }
            else if(element.equals("-"))
            {
                newList.add("-");
            }
            else if(element.equals("mod"))
            {
                newList.add("mod");
            }
            else if(element.equals("$"))
            {
                newList.add("$");
            }
            else if(element.equals(":="))
            {
                newList.add(":=");
            }
            else if(element.equals(">="))
            {
                newList.add(">=");
            }
            else if(element.equals(">"))
            {
                newList.add(">");
            }
            else if(element.equals("<="))
            {
                newList.add("<=");
            }
            else if(element.equals("<"))
            {
                newList.add("<");
            }
            else if(element.equals("|="))
            {
                newList.add("|=");
            }

            else if(element.equals("."))
            {
                newList.add(".");
            }
            else if(isIntegerNumberMatch(element))
            {
                newList.add(element);
            }
            else if(isRealNumberMatch(element))
            {
                newList.add(element);
            }
            else if(isNameMatch(element))
            {
                newList.add(element);
            }
//          here if there is no spaces between them, the first character (or first two) is checked and if it is a symbol or operator, it is added
//          otherwise it is checked if it is a real number, integer number or a name by finding the first symbol or operator in it
//          this is done till element is empty
            else{
                String symbols = "*/()+|<>=;,:$.";

                while (!element.isEmpty()){
                    if(element.startsWith("|=")){
                        newList.add("|=");
                        element = element.substring(2);
                    }
                    else if(element.startsWith("<=")){
                        newList.add("<=");
                        element = element.substring(2);
                    }
                    else if(element.startsWith(">=")){
                        newList.add("<=");
                        element = element.substring(2);
                    }
                    else if(element.startsWith(":")){
                        newList.add(":");
                        element = element.substring(1);
                    }
                    else if(element.startsWith("=")){
                        newList.add("=");
                        element = element.substring(1);
                    }
                    else if(element.startsWith("<")){
                        newList.add("<");
                        element = element.substring(1);
                    }
                    else if(element.startsWith(">")){
                        newList.add(">");
                        element = element.substring(1);
                    }
                    else if(element.startsWith("+")){
                        newList.add("+");
                        element = element.substring(1);
                    }
                    else if(element.startsWith("-")){
                        newList.add("-");
                        element = element.substring(1);
                    }
                    else if(element.startsWith("*")){
                        newList.add("*");
                        element = element.substring(1);
                    }
                    else if(element.startsWith("/")){
                        newList.add("/");
                        element = element.substring(1);
                    }
                    else if(element.startsWith(";")){
                        newList.add(";");
                        element = element.substring(1);
                    }
                    else if(element.startsWith(",")){
                        newList.add(",");
                        element = element.substring(1);
                    }
                    else if(element.startsWith("(")){
                        newList.add("(");
                        element = element.substring(1);
                    }
                    else if(element.startsWith(")")){
                        newList.add(")");
                        element = element.substring(1);
                    }
                    else if(element.startsWith("$")){
                        newList.add("$");
                        element = element.substring(1);
                    }
                    else if(element.equals(".")){
                        newList.add(".");
                        element = "";
                    }
                    else if(isRealNumberMatch(element))
                    {
                        newList.add(element);
                        element = "";
                    }
                    else if(isIntegerNumberMatch(element))
                    {
                        newList.add(element);
                        element = "";
                    }
                    else if(isNameMatch(element))
                    {
                        newList.add(element);
                        element = "";
                    }

                    else{
                        int flag = 0;
                        for(int j=0; j<element.length();j++){
                            if(element.charAt(j)=='.' && j!=element.length()-1){
                                j++;
                            }
                            if (symbols.contains(Character.toString(element.charAt(j)))){
                                newList.add(element.substring(0,j));
                                element = element.substring(j);
                                flag = 1;
                                break;
                            }

                        }
                        if(flag == 0){
                            newList.add(element);
                            element = "";
                        }
                    }
                }
            }
        }
        return newList;
    }


    //    a method to check name match regex
    public static boolean isNameMatch(String element){
        if(element.matches("\\b^[a-zA-Z][a-zA-Z0-9]*$\\b")){
            return true;
        }
        return false;
    }
    //     a method to check integers match regex
    public static boolean isIntegerNumberMatch(String element){
        if(element.matches("\\b[0-9]+\\b")){
            return true;
        }
        return false;
    }
    //    a method to check real numbers match regex
    public static boolean isRealNumberMatch(String element){
        if(element.matches("\\b[0-9]+\\.[0-9]+\\b")){
            return true;
        }
        return false;
    }
}