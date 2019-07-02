package fiuba.algo3.vision;

import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.mapa.*;
import fiuba.algo3.modelo.materiales.*;
import javafx.application.Application;

import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.stage.StageStyle;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application{

    private static Mapa mapa;
    public static void main(String[] args) {
        Juego juego = new Juego();
        mapa = juego.getMapa();
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("AlgoCraft");
        GridPane gridpane = new GridPane();

        int cantidad = 20;
        int tamanio = 50;
        for (int i = 0; i < cantidad; i++) {
            for(int j = 0; j < cantidad; j++) {
                Image test = this.retornarImagen(new Posicion(i,j), mapa);
                ImageView imageView = new ImageView(test);
                imageView.setFitHeight(tamanio);
                imageView.setFitWidth(tamanio);
                gridpane.add(imageView, i, j);
            }
        }

        VBox contenedorPrincipal = new VBox(gridpane);
        stage.getIcons().add(new Image("imagenes/icon.png"));
        Scene scene = new Scene(contenedorPrincipal, cantidad * tamanio, cantidad * tamanio);

        stage.setScene(scene);
        stage.setResizable(false);

        stage.show();
    }

    private Image retornarImagen(Posicion posicion, Mapa mapa) {
        if(mapa.perteneceAlMapa(posicion)) {
            ElementoDelJuego elemento = mapa.retornarElemento(posicion);
            if(elemento instanceof Material) {
                if(elemento instanceof Madera) {
                    return new Image("imagenes/wood.jpg");
                } else if(elemento instanceof Piedra) {
                    return new Image("imagenes/stone.png");
                } else if(elemento instanceof Metal) {
                    return new Image("imagenes/iron.png");
                } else { //if(elemento instanceof Diamante) {
                    return new Image("imagenes/diamond.jpg");
                }
            } else {
                return new Image("imagenes/player.png");
            }
        } else {
            return new Image("imagenes/grass.png");
        }
    }
}
