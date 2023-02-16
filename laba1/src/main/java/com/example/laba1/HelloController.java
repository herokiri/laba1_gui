package com.example.laba1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import static com.example.laba1.HelloApplication.*;

public class HelloController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button confirm;

    @FXML
    private TextField getAlphaField;

    @FXML
    private TextField getAttrField;

    @FXML
    private Label isCorrect;

    @FXML
    private RadioButton isNumber;

    @FXML
    private RadioButton isWord;

    @FXML
    private ToggleGroup radioGroup;

    @FXML
    private Label setRasField;

    @FXML
    private Label setResultAlphaField;

    @FXML
    private Label setResultWordField;

    @FXML
    void initialize() {
        setRasField.setMaxWidth(662);
        setRasField.setWrapText(true);

        confirm.setOnAction(event -> {
            if(isWord.isSelected()) {
                String s = getAlphaField.getText();
                s = getResultAlpha(s);
                char[] alpha = s.toCharArray();

                String s2 = getAttrField.getText();
                char[] words = s2.toCharArray();

                if(checkWordToCorrect(s, s2)) {
                    isCorrect.setVisible(false);
                    setResultAlphaField.setText(s);

                    int res = wordToNumber(alpha, s2);

                    setRasField.setText(getCalculations());
                    setCalculations();

                    setResultWordField.setText(Integer.toString(res));
                }
                else{
                    isCorrect.setVisible(true);
                }

            }


            if(isNumber.isSelected()) {
                isCorrect.setVisible(false);
                String s = getAlphaField.getText();
                s = getResultAlpha(s);
                char[] alpha = s.toCharArray();

                String s2 = getAttrField.getText();
                if(checkNumberToCorrect(s2)) {
                    isCorrect.setVisible(false);
                    setResultAlphaField.setText(s);

                    Integer res = Integer.parseInt(s2);
                    String result = numberToWord(alpha, res);

                    setRasField.setText(getCalculations());
                    setCalculations();

                    setResultWordField.setText(result);


                }else {
                    isCorrect.setVisible(true);
                }
            }
        });
    }


}
