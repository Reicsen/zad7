package com.zad7;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.Scene;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Screen;
import javafx.stage.Stage;

public class PotegowanieZespolone extends Application
{

    @Override
    public void start(Stage baza)
    {
        Label polecenie1 = new Label("Podaj część rzeczywistą liczby zespolonej");
        polecenie1.setAlignment(Pos.CENTER);
        polecenie1.setFont(Font.font("Callibri", FontWeight.BOLD, 25));
        polecenie1.setBackground(new Background(new BackgroundFill(Color.CORNSILK, null, null)));
        polecenie1.setWrapText(true);
        polecenie1.setMaxWidth(Double.POSITIVE_INFINITY);
        TextArea podajczrzeczywista = new TextArea();
        podajczrzeczywista.setFont(Font.font("Callibri", 30));
        podajczrzeczywista.setWrapText(true);
        Label polecenie2 = new Label("Podaj część urojoną liczby zespolonej");
        polecenie2.setAlignment(Pos.CENTER);
        polecenie2.setFont(Font.font("Callibri", FontWeight.BOLD, 25));
        polecenie2.setBackground(new Background(new BackgroundFill(Color.CORNSILK, null, null)));
        polecenie2.setWrapText(true);
        polecenie2.setMaxWidth(Double.POSITIVE_INFINITY);
        TextArea podajczurojona = new TextArea();
        podajczurojona.setFont(Font.font("Callibri", 30));
        podajczurojona.setWrapText(true);
        Label polecenie3 = new Label("Podaj potęgę");
        polecenie3.setAlignment(Pos.CENTER);
        polecenie3.setFont(Font.font("Callibri", FontWeight.BOLD, 25));
        polecenie3.setBackground(new Background(new BackgroundFill(Color.CORNSILK, null, null)));
        polecenie3.setWrapText(true);
        polecenie3.setMaxWidth(Double.POSITIVE_INFINITY);
        TextArea podajpotege = new TextArea();
        podajpotege.setFont(Font.font("Callibri", 15));
        podajpotege.setWrapText(true);
        Button uruchom = new Button("Oblicz");
        uruchom.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        uruchom.setMaxWidth(500);
        uruchom.setMinWidth(500);
        uruchom.setAlignment(Pos.CENTER);
        Label wynik = new Label();
        wynik.setFont(Font.font("Callibri", 40));
        wynik.setMaxWidth(Double.POSITIVE_INFINITY);
        polecenie2.setAlignment(Pos.CENTER);
        polecenie2.setBackground(new Background(new BackgroundFill(Color.ALICEBLUE, null, null)));
        polecenie2.setWrapText(true);
        Button wyczysc = new Button("Wyczyść wszystko");
        wyczysc.setFont(Font.font("Arial", FontWeight.BOLD, 30));
        wyczysc.setMaxWidth(500);
        wyczysc.setMinWidth(500);
        wyczysc.setAlignment(Pos.CENTER);
        VBox siatka = new VBox(polecenie1, podajczrzeczywista, polecenie2, podajczurojona, polecenie3, podajpotege, uruchom, wynik, wyczysc);
        baza.setTitle("Zadanie 7.");
        siatka.setPrefWidth(Screen.getPrimary().getVisualBounds().getWidth());
        siatka.setPrefHeight(Screen.getPrimary().getVisualBounds().getHeight());
        Scene scena = new Scene(siatka);
        baza.setScene(scena);
        baza.setMinHeight(Screen.getPrimary().getVisualBounds().getWidth());
        baza.setMinWidth(Screen.getPrimary().getVisualBounds().getWidth());
        baza.show();
    
        EventHandler<ActionEvent> oblicz = new EventHandler<ActionEvent>()
        {
            @Override
            public void handle(ActionEvent event)
            {
                try
                {
                    double re = Double.parseDouble(podajczrzeczywista.getText());
                    try
                    {
                        double im = Double.parseDouble(podajczurojona.getText());
                        try 
                        {
                            int pot = Integer.parseInt(podajpotege.getText());
                            PostacZwykla zwykla = new PostacZwykla(re, im);
                            PostacTrygonometryczna trygonometryczna = new PostacTrygonometryczna(zwykla);
                            try
                            {
                                wynik.setText(PostacZwykla.wypisz(new PostacZwykla(PostacTrygonometryczna.potega(trygonometryczna, pot))));
                            }
                            catch (PrzekroczonoZakres e)
                            {
                                wynik.setText("Minimum jedna z części liczby wykracza poza zakres double.");
                                podajczrzeczywista.setText("");
                                podajczurojona.setText("");
                                podajpotege.setText("");
                            }
                        }
                        catch (Exception e)
                        {
                            wynik.setText("Podano niepoprawne dane.");
                            podajczrzeczywista.setText("");
                            podajczurojona.setText("");
                            podajpotege.setText("");
                        }
                    }
                    catch (Exception e)
                    {
                        wynik.setText("Podano niepoprawne dane.");
                        podajczrzeczywista.setText("");
                        podajczurojona.setText("");
                        podajpotege.setText("");
                    }
                }
                catch (Exception e)
                {
                    wynik.setText("Podano niepoprawne dane.");
                    podajczrzeczywista.setText("");
                    podajczurojona.setText("");
                    podajpotege.setText("");
                }
            }
        };

        EventHandler<ActionEvent> usun = new EventHandler<ActionEvent>()
        {
            @Override
            public void handle (ActionEvent event)
            {
                wynik.setText("");
                podajczrzeczywista.setText("");
                podajczurojona.setText("");
                podajpotege.setText("");
            }            
        };

        uruchom.setOnAction(oblicz);
        wyczysc.setOnAction(usun);
    }

    public static void main(String[] args)
    {
        launch(args);
    }
}
