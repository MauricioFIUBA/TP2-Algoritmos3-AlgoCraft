package fiuba.algo3.vista;

import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.mapa.*;
import fiuba.algo3.modelo.materiales.*;
import javafx.application.Application;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.Scene;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.nio.file.Path;
import java.nio.file.Paths;

public class Main extends Application{

    private static Mapa mapa;
    static private String path;

    public static void main(String[] args) {
        Path currentPath = Paths.get(System.getProperty("user.dir"));
        path = "file:"+currentPath.toString();
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
                Image elemento = this.retornarImagen(new Posicion(i,j), mapa);
                ImageView imageView = new ImageView(elemento);
                imageView.setFitHeight(tamanio);
                imageView.setFitWidth(tamanio);
                gridpane.add(imageView, i, j);
            }
        }



        VBox contenedorPrincipal = new VBox(gridpane);
        Path iconPath = Paths.get(path, "imagenes", "icon.png");
        stage.getIcons().add(new Image(iconPath.toString()));
        Scene scene = new Scene(contenedorPrincipal, cantidad * tamanio, cantidad * tamanio);

        stage.setScene(scene);
        stage.setResizable(false);

        stage.show();
    }

    private Image retornarImagen(Posicion posicion, Mapa mapa) {
        Path imagenPath = Paths.get(path,"imagenes");
        if(mapa.perteneceAlMapa(posicion)) {
            ElementoDelJuego elemento = mapa.retornarElemento(posicion);
            if(elemento instanceof Material) {
                if(elemento instanceof Madera) {
                    imagenPath = Paths.get(imagenPath.toString(),"wood.jpg");
                } else if(elemento instanceof Piedra) {
                    imagenPath = Paths.get(imagenPath.toString(),"stone.png");
                } else if(elemento instanceof Metal) {
                    imagenPath = Paths.get(imagenPath.toString(),"iron.png");
                } else { //if(elemento instanceof Diamante) {
                    imagenPath = Paths.get(imagenPath.toString(),"diamond.jpg");
                }
            } else {
                imagenPath = Paths.get(imagenPath.toString(),"player.png");
            }
        } else {
            imagenPath = Paths.get(imagenPath.toString(),"grass.png");
        }
        return new Image(imagenPath.toString());
    }
}
