package fiuba.algo3.vista;

import fiuba.algo3.modelo.direccion.DireccionAbajo;
import fiuba.algo3.modelo.direccion.DireccionArriba;
import fiuba.algo3.modelo.direccion.DireccionDerecha;
import fiuba.algo3.modelo.direccion.DireccionIzquierda;
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
import javafx.geometry.Pos;
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

    @Override
    public void handle(KeyEvent event) {
        Posicion posicionVieja;
        Posicion posicionNueva;
        switch (event.getCode()) {
            case W:
                posicionVieja = mapa.obtenerPosicionDelJugador();
                mapa.moverJugador(new DireccionArriba());
                posicionNueva = mapa.obtenerPosicionDelJugador();
                System.out.println("Se movio W");
                this.actualizarImagen(posicionVieja, posicionNueva);

                break;
            case A:
                posicionVieja = mapa.obtenerPosicionDelJugador();
                mapa.moverJugador(new DireccionIzquierda());
                System.out.println("Se movio A");
                posicionNueva = mapa.obtenerPosicionDelJugador();
                this.actualizarImagen(posicionVieja, posicionNueva);
                break;
            case S:
                posicionVieja = mapa.obtenerPosicionDelJugador();
                mapa.moverJugador(new DireccionAbajo());
                System.out.println("Se movio S");
                posicionNueva = mapa.obtenerPosicionDelJugador();
                this.actualizarImagen(posicionVieja, posicionNueva);
                break;
            case D:
                posicionVieja = mapa.obtenerPosicionDelJugador();
                mapa.moverJugador(new DireccionDerecha());
                System.out.println("Se movio D");
                posicionNueva = mapa.obtenerPosicionDelJugador();
                this.actualizarImagen(posicionVieja, posicionNueva);
                break;
        }


    }

}
