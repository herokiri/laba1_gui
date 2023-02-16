package com.example.laba1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class HelloApplication extends Application {

    private static String calculations = "(";

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 800, 470);
        stage.setTitle("Лаба1!");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }

    public static boolean checkNumberToCorrect(String word) {

        boolean isOnlyDigits = true;
        for(int i = 0; i < word.length() && isOnlyDigits; i++) {
            if(!Character.isDigit(word.charAt(i))) {
               return false;
            }
        }
        return true; // => true
    }
    public static boolean checkWordToCorrect(String alpha, String word) {
         for(int i = 0; i < word.length(); i++) {
             boolean b = false;
             for(int j = 0; j < alpha.length(); j++) {
                 if(word.charAt(i) == alpha.charAt(j)) {
                     b = true;
                     break;
                 }
             }
             if(!b) {
                 return false;
             }
         }
         return true;
    }
    public static String getResultAlpha(String alpha) {
        String letters = alpha.chars().distinct().collect(StringBuilder::new,
                StringBuilder::appendCodePoint,
                StringBuilder::append).toString();
        return letters;
    }

    public static String numberToWord(char[] alpha, int number){
        String perv = "";
        ArrayList<Integer> koeffs = new ArrayList<Integer>();

        if(number <= alpha.length) {
            return String.valueOf(alpha[number - 1]);
        }
        // 3 * 3 *counter + 2 * counter-1 * 2 * counter - 1 * 1
        int ost = 0;
        String result = "";
        int counter = 0;
        while(!(number <= alpha.length)) {
            if(counter > 0) {
                perv += " * "  + alpha.length + " + " + ost + ")";
            }
            counter++;

            int tmp = number;

            //когда изначально остаток равен 0
            if(number % alpha.length == 0) {

                number = (number / alpha.length) - 1;
                ost = tmp - (number * alpha.length);
                koeffs.add(ost);

                calculations += "(" + number + " * " + alpha.length + " + " + ost + ")" + perv + " = ";
                continue;
            }


            number = number / alpha.length;
            ost = tmp - (number * alpha.length);
            koeffs.add(ost);
            calculations += "(" + number + " * " + alpha.length + " + " + ost + ")" + perv + " = ";
        }
        //number первый коэфф
        koeffs.add(number);


        for(int k = koeffs.size() - 1; k >= 0; k--) {
            counter--;
            if(k != 0) calculations += koeffs.get(k) + " * " + alpha.length + "^" + k + " + ";
            result += alpha[koeffs.get(k) - 1];

        }
        calculations += koeffs.get(0);
        return result;
    }

    public static String getCalculations() {
        return calculations;
    }
    public static void setCalculations() {
        calculations = "";
    }
    public static int wordToNumber(char[] letters, String word) {
        int k = word.length();

        int sum = 0;
        for(char letter : word.toCharArray()) {
            k--;
            int l = 0;
            for(int i = 0; i < letters.length; i++) {
                if(letters[i] == letter) {
                    l = (i+1);
                }
            }
            sum += Math.pow(letters.length, k) * l;
        }

        return sum;
    }
}