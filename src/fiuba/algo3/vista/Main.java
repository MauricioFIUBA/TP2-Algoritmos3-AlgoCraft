package fiuba.algo3.vista;

import fiuba.algo3.modelo.direccion.*;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.mapa.ElementoDelJuego;
import fiuba.algo3.modelo.mapa.Mapa;
import fiuba.algo3.modelo.mapa.Posicion;
import fiuba.algo3.modelo.materiales.Madera;
import fiuba.algo3.modelo.materiales.Material;
import fiuba.algo3.modelo.materiales.Metal;
import fiuba.algo3.modelo.materiales.Piedra;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

public class Main extends Application implements EventHandler<KeyEvent> {

    private static Mapa mapa;
    static private String path;

    public static void main(String[] args) {
        Path currentPath = Paths.get(System.getProperty("user.dir"));
        path = "file:"+currentPath.toString();
        Juego juego = new Juego();
        mapa = juego.getMapa();
        launch(args);
    }

    //private AudioClip audio = new AudioClip("file:/home/gonza/Escritorio/algocraft/TP2-Algoritmos3-AlgoCraft/bip_1.mp3");

    private GridPane gridpane = new GridPane();
    private int cantidad = 20;
    private int tamanio = 25;
    Map<Posicion, ImageView> imagenes;


    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("AlgoCraft");

        imagenes = this.crearImagenes();
        for (int i = 0; i < cantidad; i++) {
            for(int j = 0; j < cantidad; j++) {
                gridpane.add(imagenes.get(new Posicion(i,j)), i, j);
            }
        }


        VBox contenedorPrincipal = new VBox(gridpane);
        Path iconPath = Paths.get(path, "imagenes", "icon.png");
        stage.getIcons().add(new Image(iconPath.toString()));
        Scene scene = new Scene(contenedorPrincipal, cantidad * tamanio,  cantidad * tamanio);

        scene.setOnKeyPressed(this);

        stage.setScene(scene);
        stage.setResizable(false);

        stage.show();
    }
    private void actualizarImagen(Posicion posicionVieja, Posicion posicionNueva) {
        if(!posicionNueva.equals(posicionVieja)) {
            ImageView imagenVieja = imagenes.get(posicionVieja);
            ImageView imagenNueva = imagenes.get(posicionNueva);
            imagenes.replace(posicionVieja, imagenNueva);
            imagenes.replace(posicionNueva, imagenVieja);
            gridpane.getChildren().remove(imagenVieja);
            gridpane.getChildren().remove(imagenNueva);
            gridpane.add(imagenes.get(posicionVieja), posicionVieja.getCoordenadaX(), posicionVieja.getCoordenadaY());
            gridpane.add(imagenes.get(posicionNueva), posicionNueva.getCoordenadaX(), posicionNueva.getCoordenadaY());
        }
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

    private Map<Posicion, ImageView> crearImagenes() {
        Map<Posicion, ImageView> aRetornar = new HashMap<>();

        for (int i = 0; i < cantidad; i++) {
            for(int j = 0; j < cantidad; j++) {
                Image elemento = this.retornarImagen(new Posicion(i,j), mapa);
                ImageView imageView = new ImageView(elemento);
                imageView.setFitHeight(tamanio);
                imageView.setFitWidth(tamanio);
                aRetornar.put(new Posicion(i,j), imageView);
            }
        }
        return aRetornar;
    }


    private void eventoMover(Direccion unaDireccion){
        Posicion posicionVieja;
        Posicion posicionNueva;
        posicionVieja = mapa.obtenerPosicionDelJugador();
        mapa.moverJugador(unaDireccion);
        //audio.play();
        posicionNueva = mapa.obtenerPosicionDelJugador();
        this.actualizarImagen(posicionVieja, posicionNueva);
    }

    @Override
    public void handle(KeyEvent event) {
        switch (event.getCode()) {
            case W:
                this.eventoMover(new DireccionArriba());
                System.out.println("Se movio W");
                break;
            case A:
                this.eventoMover(new DireccionIzquierda());
                System.out.println("Se movio A");
                break;
            case S:
                this.eventoMover(new DireccionAbajo());
                System.out.println("Se movio S");
                break;
            case D:
                this.eventoMover(new DireccionDerecha());
                System.out.println("Se movio D");
                break;
        }


    }

}
