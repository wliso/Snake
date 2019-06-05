package sample;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.text.Font;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class SmallInfoLabel extends Label {

    private final static String FONT_PATH = "resources/menu/kenvector_future_thin.ttf";


    public SmallInfoLabel(String text){
        setPrefHeight(10);
        setPrefWidth(150);
        BackgroundImage backgroundImage = new BackgroundImage(new Image("resources/uipack_fixed/PNG/green_button00.png",130,50,false,true),
                BackgroundRepeat.NO_REPEAT, BackgroundRepeat.NO_REPEAT, BackgroundPosition.DEFAULT, null);
        setBackground(new Background((backgroundImage)));
        setAlignment(Pos.CENTER_LEFT);
        setLabelFont();
        setPadding(new Insets(10,10,10,10));
        setText(text);
    }
    private void setLabelFont(){

        try {
            setFont(Font.loadFont(new FileInputStream(new File(FONT_PATH)), 15));
        } catch (FileNotFoundException e) {
            setFont(Font.font("Verdana", 15));
        }
    }
}
