package fiuba.algo3.vista;

import fiuba.algo3.vista.eventos.BotonEntrarEventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;


public class MenuDeInicio extends VBox{
    Stage stage;
    //VBox contenedor;
    //static private String path;
    public MenuDeInicio(Stage stage, Scene proximaEscena, String path){
        super();

        this.stage = stage;
        //VBox contenedor = new VBox();
        //this.contenedor = new VBox();
        this.setAlignment(Pos.CENTER);
        this.setSpacing(20);
        this.setPadding(new Insets(25));
        Image imagen = new Image(path);
        BackgroundImage imagenDeFondo = new BackgroundImage(imagen, BackgroundRepeat.SPACE, BackgroundRepeat.ROUND, BackgroundPosition.DEFAULT, BackgroundSize.DEFAULT);
        this.setBackground(new Background(imagenDeFondo));

        Button botonEntrar = new Button();
        botonEntrar.setText("Jugar");

        Label etiqueta = new Label();
        etiqueta.setFont(Font.font("Arial", FontWeight.BOLD, 40));

        etiqueta.setText("AlgoCraft-2019.");
        etiqueta.setTextFill(Color.web("#000000"));

        BotonEntrarEventHandler botonEntrarHandler = new BotonEntrarEventHandler(stage, proximaEscena);
        botonEntrar.setOnAction(botonEntrarHandler);
        this.getChildren().addAll(etiqueta, botonEntrar);
    }
}
