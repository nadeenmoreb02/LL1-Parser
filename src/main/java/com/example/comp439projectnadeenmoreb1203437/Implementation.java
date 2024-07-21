package com.example.comp439projectnadeenmoreb1203437;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

import static com.example.comp439projectnadeenmoreb1203437.LL1Parser.*;
import static com.example.comp439projectnadeenmoreb1203437.Tknizer.returnTkns;

public class Implementation extends Application {

    @Override
    public void start(final Stage s) {
        s.setTitle("Code Text File Chooser");

        final FileChooser fc = new FileChooser();

//        preparing ui
        final Button openCodeTextFileButton = new Button("Open code text file");

        openCodeTextFileButton.setStyle(
                "-fx-font-size: 16pt; " +
                        "-fx-background-color: #1A2551;" +
                        "-fx-text-fill: white; " +
                        "-fx-padding: 10 20 10 20; " +
                        "-fx-border-color: transparent;" +
                        "-fx-border-width: 2px;" +
                        "-fx-border-radius: 5px;"
        );

        openCodeTextFileButton.setOnMouseEntered(e -> openCodeTextFileButton.setStyle(
                "-fx-font-size: 16pt; " +
                        "-fx-background-color:#1A2551;" +
                        "-fx-text-fill: white; " +
                        "-fx-padding: 10 20 10 20; " +
                        "-fx-border-color: #4b3b65;" +
                        "-fx-border-width: 2px;" +
                        "-fx-border-radius: 5px;"
        ));

        openCodeTextFileButton.setOnMouseExited(e -> openCodeTextFileButton.setStyle(
                "-fx-font-size: 16pt; " +
                        "-fx-background-color: #1A2551;" +
                        "-fx-text-fill: white; " +
                        "-fx-padding: 10 20 10 20; " +
                        "-fx-border-color: transparent;" +
                        "-fx-border-width: 2px;" +
                        "-fx-border-radius: 5px;"
        ));

        TextArea fileContentArea = new TextArea();
        fileContentArea.setEditable(false);
        TextArea parsingMessageArea = new TextArea();
        parsingMessageArea.setEditable(false);

        GridPane codeInputGridPane = new GridPane();
        codeInputGridPane.setHgap(6);
        codeInputGridPane.setVgap(6);
        ColumnConstraints col1 = new ColumnConstraints();
        col1.setHgrow(Priority.ALWAYS);
        codeInputGridPane.getColumnConstraints().addAll(col1, new ColumnConstraints(), col1);

        GridPane.setConstraints(openCodeTextFileButton, 1, 0);
        GridPane.setHalignment(openCodeTextFileButton, HPos.CENTER);
        codeInputGridPane.getChildren().add(openCodeTextFileButton);

        VBox codeContentBox = new VBox(12);
        codeContentBox.getChildren().addAll(fileContentArea, parsingMessageArea);
        VBox.setVgrow(fileContentArea, Priority.ALWAYS);
        VBox.setVgrow(parsingMessageArea, Priority.ALWAYS);

        VBox rg = new VBox(12);
        rg.getChildren().addAll(codeInputGridPane, codeContentBox);
        rg.setPadding(new Insets(12, 12, 12, 12));
        rg.setStyle(
                "-fx-background-color: linear-gradient(to bottom, #1A2551, #4C5768, #1A2551, #1A1A1F, #4C5768, #4b3b65, #4C5768, #1A1A1F, #1A2551); "

        );

        Scene scene = new Scene(rg, 800, 600);
        s.setScene(scene);
        s.show();

        openCodeTextFileButton.setOnAction(
                new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(final ActionEvent e) {

                        try {

//                            file chooser
                            File txtfile = fc.showOpenDialog(s);
                            String fileContent = readFile(txtfile);
                            if (txtfile != null) {
                                if (fileContent != null) {
                                    fileContentArea.setText(fileContent);
//                    System.out.println("File content:");
//                    System.out.println(fileContent);
                                    String s = fileContent;
//                                    remove spaces
                                    s = s.replaceAll("\\s+", " ");
                                    String[] words = s.split(" ");

//                                    put resulted words in string list
//                                    List<String> myList = new ArrayList<String>(Arrays.asList(words));


//                                  pass strings list to the method returnTkns that generates the tokens of the passed code words and store them in list of tokens
                                    List<Tkn> tknList = returnTkns(readFileLines(txtfile));

                                    List<String> strList = new ArrayList<>();
                                    List<String> stringTknList = new ArrayList<>();
                                    for (Tkn tkn : tknList) {
                                        stringTknList.add(tkn.getV());
                                        strList.add(tkn.rawValue);
                                    }
                                    System.out.println("strList: " + strList);
                                    System.out.println("stringTknList: " + stringTknList);

//                                  Read parsing table from the excel file that has its content stored
                                    Map<String, Map<String, String>> parsingTable = new LinkedHashMap<>();
//                                    parsingTable = new ReadParsingTable().returnParsingTable();
                                    parsingTable = new ReadParsingTable().returnParsingTableStatically();

//                                  pass the tokens list to a queue
                                    Queue<Tkn> inputTokensQ = new LinkedList<>(tknList);

//                                    pass the parsing table map and tokens queue to the method that parse based on ll1 parsing table and rules and set the isSuccessful flag to true if parsing is successful
                                    compareInputToProductionRule(parsingTable, inputTokensQ);

                                    if (LL1Parser.isIsSuccessful()) {
//                                        print the results
                                        parsingMessageArea.setText(("strings List: " + strList + '\n' + "string values tokens list: " + stringTknList + '\n' + '\n' + '\n' + "Grammar is Valid :) Parsing is successful!"));
                                    } else {
                                        parsingMessageArea.setText(("strings List: " + strList + '\n' + "string values tokens list: " + stringTknList + '\n' + '\n' + '\n'  + errorMessage + '\n' +"Grammar is Invalid :( Parsing has Failed!"));
                                    }

                                }
                            }
                        } catch (NullPointerException ex) {
                            fileContentArea.setText("choose a file, no file is chosen");
                            parsingMessageArea.setText(lastTkn);
                        }
                     }});

    }

    public static void main(String[] args) {
        Application.launch(args);
    }

//    read the content of the code text file
        private static String readFile(File codeTextFile) {
            StringBuilder codeFilecontent = new StringBuilder();
            try {
                BufferedReader bfReader = new BufferedReader(new FileReader(codeTextFile));
//                l is the line
                String l;
                int count = 1;
                while ((l = bfReader.readLine()) != null) {
                    codeFilecontent.append(count++ + ". ").append(l).append("\n");
                }
            } catch (IOException ex) {
                ex.printStackTrace();
                return null;
            }
            return codeFilecontent.toString();
        }


    //    read the content of the code text file as lines
    private static HashMap<Integer, List<String>> readFileLines(File codeTextFile) {
        StringBuilder codeFilecontent = new StringBuilder();
        HashMap<Integer, List<String>> linesMap= new HashMap<>();
        try {
            BufferedReader bfReader = new BufferedReader(new FileReader(codeTextFile));
//                l is the line
            String l;
            while ((l = bfReader.readLine()) != null) {
                codeFilecontent.append(l).append("\n");
            }
            String[] lines = codeFilecontent.toString().split("\n");
            for(int i = 0; i < lines.length; i++) {
                List<String> words = new ArrayList<>(Arrays.asList(lines[i].split(" ")));
                linesMap.put(i+1, words);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return linesMap;
    }

}