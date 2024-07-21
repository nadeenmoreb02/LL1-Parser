package com.example.comp439projectnadeenmoreb1203437;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;

public class ReadParsingTable {
    Map<String, Map<String, String>> staticParsingTable = new LinkedHashMap<>();

//    inserting parsing table values function
    public Map<String, Map<String, String>> returnParsingTableStatically(){


Map<String, String> declarationsInnerMap = new LinkedHashMap<>();
declarationsInnerMap.put("begin", "const-decl var-decl procedure-decl");
declarationsInnerMap.put("const", "const-decl var-decl procedure-decl");
declarationsInnerMap.put("var", "const-decl var-decl procedure-decl");
declarationsInnerMap.put("procedure", "const-decl var-decl procedure-decl");
staticParsingTable.put("declarations", declarationsInnerMap);
staticParsingTable.put("module-decl", new LinkedHashMap<String, String>(){{put("module", "module-heading declarations block name .");}});
staticParsingTable.put("module-heading", new LinkedHashMap<String, String>(){{put("module", "module name ;");}});
staticParsingTable.put("block", new LinkedHashMap<String, String>(){{put("begin", "begin stmt-list end");}});
Map<String, String> constDeclInnerMap = new LinkedHashMap<>();
constDeclInnerMap.put("begin", "λ");
constDeclInnerMap.put("const", "const const-list");
constDeclInnerMap.put("var", "λ");
constDeclInnerMap.put("procedure", "λ");
staticParsingTable.put("const-decl", constDeclInnerMap);
Map<String, String> constListInnerMap = new LinkedHashMap<>();
constListInnerMap.put("name", "name = value ; const-list");
constListInnerMap.put("begin", "λ");
constListInnerMap.put("var", "λ");
constListInnerMap.put("procedure", "λ");
staticParsingTable.put("const-list", constListInnerMap);
Map<String, String> varDeclInnerMap = new LinkedHashMap<>();
varDeclInnerMap.put("begin", "λ");
varDeclInnerMap.put("var", "var var-list");
varDeclInnerMap.put("procedure", "λ");
staticParsingTable.put("var-decl", varDeclInnerMap);
Map<String, String> varListInnerMap = new LinkedHashMap<>();
varListInnerMap.put("name", "var-item ; var-list");
varListInnerMap.put("begin", "λ");
varListInnerMap.put("procedure", "λ");
staticParsingTable.put("var-list", varListInnerMap);
staticParsingTable.put("var-item", new LinkedHashMap<String, String>(){{put("name", "name-list : data-type");}});
staticParsingTable.put("name-list", new LinkedHashMap<String, String>(){{put("name", "name more-names");}});
staticParsingTable.put("more-names", new LinkedHashMap<String, String>(){{put(":", "λ");} {put(")", "λ");} {put(",", ", name-list");} });
staticParsingTable.put("data-type", new LinkedHashMap<String, String>(){{put("integer", "integer");} {put("real", "real");} {put("char", "char");}});
staticParsingTable.put("procedure-decl", new LinkedHashMap<String, String>(){{put("begin", "λ");} {put("procedure", "procedure-heading declarations block name ; procedure-decl");}});
staticParsingTable.put("procedure-heading", new LinkedHashMap<String, String>(){{put("procedure", "procedure name ;");}});
Map<String, String> stmtListInnerMap = new LinkedHashMap<>();
stmtListInnerMap.put("name", "statement ; stmt-list");
stmtListInnerMap.put("begin", "statement ; stmt-list");
stmtListInnerMap.put("end", "λ");
stmtListInnerMap.put("writeint", "statement ; stmt-list");
stmtListInnerMap.put("writereal", "statement ; stmt-list");
stmtListInnerMap.put("writechar", "statement ; stmt-list");
stmtListInnerMap.put("writeln", "statement ; stmt-list");
stmtListInnerMap.put("readint", "statement ; stmt-list");
stmtListInnerMap.put("readreal", "statement ; stmt-list");
stmtListInnerMap.put("readchar", "statement ; stmt-list");
stmtListInnerMap.put("readln", "statement ; stmt-list");
stmtListInnerMap.put("else", "λ");
stmtListInnerMap.put("if", "statement ; stmt-list");
stmtListInnerMap.put("call", "statement ; stmt-list");
stmtListInnerMap.put("loop", "statement ; stmt-list");
stmtListInnerMap.put("until", "λ");
stmtListInnerMap.put("while", "statement ; stmt-list");
stmtListInnerMap.put("exit", "statement ; stmt-list");
stmtListInnerMap.put(";", "statement ; stmt-list");
staticParsingTable.put("stmt-list", stmtListInnerMap);
Map<String, String> statementInnerMap = new LinkedHashMap<>();

statementInnerMap.put("name", "ass-stmt");

statementInnerMap.put("begin", "block");
statementInnerMap.put("writeint", "write-stmt");
statementInnerMap.put("writereal", "write-stmt");
statementInnerMap.put("writechar", "write-stmt");
statementInnerMap.put("writeln", "write-stmt");
statementInnerMap.put("readint", "read-stmt");
statementInnerMap.put("readreal", "read-stmt");
statementInnerMap.put("readchar", "read-stmt");
statementInnerMap.put("readln", "read-stmt");
statementInnerMap.put("exit", "exit-stmt");
statementInnerMap.put("call", "call-stmt");
statementInnerMap.put("if", "if-stmt");
statementInnerMap.put("loop", "loop-stmt");
statementInnerMap.put("while", "while-stmt");
statementInnerMap.put(";", "λ");
staticParsingTable.put("statement", statementInnerMap);
staticParsingTable.put("ass-stmt", new LinkedHashMap<String, String>(){{put("name", "name := exp");}});

Map<String, String> expInnerMap = new LinkedHashMap<>();
expInnerMap.put("name", "term exp-prime");
expInnerMap.put("integer-value", "term exp-prime");
expInnerMap.put("real-value", "term exp-prime");
expInnerMap.put("(", "term exp-prime");
staticParsingTable.put("exp", expInnerMap);

Map<String, String> expPrimeInnerMap = new LinkedHashMap<>();
expPrimeInnerMap.put("+", "add-oper term exp-prime");
expPrimeInnerMap.put("-", "add-oper term exp-prime");
expPrimeInnerMap.put(";", "λ");
expPrimeInnerMap.put(")", "λ");
staticParsingTable.put("exp-prime", expPrimeInnerMap);

Map<String, String> termInnerMap = new LinkedHashMap<>();
termInnerMap.put("name", "factor term-prime");
termInnerMap.put("real-value", "factor term-prime");
termInnerMap.put("integer-value", "factor term-prime");
termInnerMap.put("(", "factor term-prime");
staticParsingTable.put("term", termInnerMap);

Map<String, String> termPrimeInnerMap = new LinkedHashMap<>();
termPrimeInnerMap.put("+", "λ");
termPrimeInnerMap.put("*", "mul-oper factor term-prime");
termPrimeInnerMap.put("-", "λ");
termPrimeInnerMap.put("/", "mul-oper factor term-prime");
termPrimeInnerMap.put("div", "mul-oper factor term-prime");
termPrimeInnerMap.put("mod", "mul-oper factor term-prime");
termPrimeInnerMap.put(";", "λ");
termPrimeInnerMap.put(")", "λ");
staticParsingTable.put("term-prime", termPrimeInnerMap);

Map<String, String> factorInnerMap = new LinkedHashMap<>();
factorInnerMap.put("name", "name-value");
factorInnerMap.put("real-value", "real-value");
factorInnerMap.put("integer-value", "integer-value");
factorInnerMap.put("(", "( exp )");
staticParsingTable.put("factor", factorInnerMap);

staticParsingTable.put("add-oper", new LinkedHashMap<String, String>(){{put("-", "-");} {put("+", "+");}});
staticParsingTable.put("mul-oper", new LinkedHashMap<String, String>(){{put("*", "*");} {put("/", "/");} {put("mod", "mod");} {put("div", "div");}});

Map<String, String> readStmtInnerMap = new LinkedHashMap<>();
readStmtInnerMap.put("readint", "readint ( name-list )");
readStmtInnerMap.put("readreal", "readreal ( name-list )");
readStmtInnerMap.put("readchar", "readchar ( name-list )");
readStmtInnerMap.put("readln", "readln");
staticParsingTable.put("read-stmt", readStmtInnerMap);

Map<String, String> writeStmtInnerMap = new LinkedHashMap<>();
writeStmtInnerMap.put("writeint", "writeint ( write-list )");
writeStmtInnerMap.put("writereal", "writereal ( write-list )");
writeStmtInnerMap.put("writechar", "writechar ( write-list )");
writeStmtInnerMap.put("writeln", "writeln");
staticParsingTable.put("write-stmt", writeStmtInnerMap);


Map<String, String> writeListInnerMap = new LinkedHashMap<>();
writeListInnerMap.put("name", "write-item more-write-value");
writeListInnerMap.put("integer-value", "write-item more-write-value");
writeListInnerMap.put("real-value", "write-item more-write-value");
staticParsingTable.put("write-list", writeListInnerMap);

Map<String, String> moreWriteValueInnerMap = new LinkedHashMap<>();
moreWriteValueInnerMap.put(")", "λ");
moreWriteValueInnerMap.put(",", ", write-list");
staticParsingTable.put("more-write-value", moreWriteValueInnerMap);

Map<String, String> writeItemInnerMap = new LinkedHashMap<>();
writeItemInnerMap.put("name", "name");
writeItemInnerMap.put("integer-value", "value");
writeItemInnerMap.put("real-value", "value");
staticParsingTable.put("write-item", writeItemInnerMap);

Map<String, String> ifStmtInnerMap = new LinkedHashMap<>();
ifStmtInnerMap.put("if", "if condition then stmt-list else-part end");
staticParsingTable.put("if-stmt", ifStmtInnerMap);

Map<String, String> elsePartInnerMap = new LinkedHashMap<>();
elsePartInnerMap.put("end", "λ");
elsePartInnerMap.put("else", "else stmt-list");
staticParsingTable.put("else-part", elsePartInnerMap);

Map<String, String> whileStmtInnerMap = new LinkedHashMap<>();
whileStmtInnerMap.put("while", "while condition do stmt-list end");
staticParsingTable.put("while-stmt", whileStmtInnerMap);

Map<String, String> loopStmtInnerMap = new LinkedHashMap<>();
loopStmtInnerMap.put("loop", "loop stmt-list until condition");
staticParsingTable.put("loop-stmt", loopStmtInnerMap);

Map<String, String> exitStmtInnerMap = new LinkedHashMap<>();
exitStmtInnerMap.put("exit", "exit");
staticParsingTable.put("exit-stmt", exitStmtInnerMap);

Map<String, String> callStmtInnerMap = new LinkedHashMap<>();
callStmtInnerMap.put("call", "call name");
staticParsingTable.put("call-stmt", callStmtInnerMap);

Map<String, String> conditionInnerMap = new LinkedHashMap<>();
conditionInnerMap.put("name", "name-value relational-oper name-value");
conditionInnerMap.put("integer-value", "name-value relational-oper name-value");
conditionInnerMap.put("real-value", "name-value relational-oper name-value");
staticParsingTable.put("condition", conditionInnerMap);

Map<String, String> relationalOperInnerMap = new LinkedHashMap<>();
relationalOperInnerMap.put("=", "=");
relationalOperInnerMap.put("|=", "|=");
relationalOperInnerMap.put("<", "<");
relationalOperInnerMap.put("<=", "<=");
relationalOperInnerMap.put(">=", ">=");
relationalOperInnerMap.put(">", ">");
staticParsingTable.put("relational-oper", relationalOperInnerMap);

Map<String, String> nameValueInnerMap = new LinkedHashMap<>();
nameValueInnerMap.put("name", "name");
nameValueInnerMap.put("integer-value", "value");
nameValueInnerMap.put("real-value", "value");
staticParsingTable.put("name-value", nameValueInnerMap);

Map<String, String> valueInnerMap = new LinkedHashMap<>();
valueInnerMap.put("integer-value", "integer-value");
valueInnerMap.put("real-value", "real-value");
staticParsingTable.put("value", valueInnerMap);


        return staticParsingTable;
    }

}