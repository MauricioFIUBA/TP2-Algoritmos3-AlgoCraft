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
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
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
    private static Juego juego;

    public static void main(String[] args) {
        Path currentPath = Paths.get(System.getProperty("user.dir"));
        path = "file:"+currentPath.toString();
        juego = new Juego();
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
        Path menuPath = Paths.get(path, "imagenes", "menu.jpg");
        stage.getIcons().add(new Image(iconPath.toString()));
        Scene scenePrincipal = new Scene(contenedorPrincipal, cantidad * tamanio,  cantidad * tamanio);
        MenuDeInicio menu = new MenuDeInicio(stage,scenePrincipal, menuPath.toString());
        Scene sceneMenu = new Scene(menu,cantidad * tamanio, cantidad * tamanio);
        stage.setScene(sceneMenu);
        scenePrincipal.setOnKeyPressed(this);
        //stage.setScene(menu);

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
        /*ACA ROMPE PORQUE SE PASAN LAS MISMAS POSICIONES Y HACE CAGADA.
        * Y ESTA ROMPIENDO TODOS LOS MATERIALES O ESO ES LO QUE SE VE.*/
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
            case U:
                this.eventoDesgastarMaterial(new DireccionArriba());
                System.out.println("Ataco Arriba");
                break;
            case H:
                this.eventoDesgastarMaterial(new DireccionIzquierda());
                System.out.println("Ataco Izquierda");
                break;
            case M:
                this.eventoDesgastarMaterial(new DireccionAbajo());
                System.out.println("Ataco Abajo");
                break;
            case K:
                this.eventoDesgastarMaterial(new DireccionDerecha());
                System.out.println("Ataco Derecha");
                break;
        }
    }
    public void eventoDesgastarMaterial(Direccion unaDireccion){
        mapa.atacarEn(unaDireccion);
        Posicion posDeAtaque = mapa.posDeAtaque(unaDireccion);
        if(!mapa.perteneceAlMapa(posDeAtaque)){
            this.actualizarImagen(posDeAtaque);
        }

    }
    public void actualizarImagen(Posicion posicion){
        /*Caso de borrar material y reemplazar con icon*/
        ImageView imagenVieja = imagenes.get(posicion);
        Path imagenPath = Paths.get(path,"imagenes/grass.png");
        Image img = new Image(imagenPath.toString());
        ImageView imagenNueva = new ImageView(img);
        imagenNueva.setFitWidth(tamanio);
        imagenNueva.setFitHeight(tamanio);
        gridpane.getChildren().remove(imagenVieja);
        imagenes.replace(posicion,imagenNueva);
        gridpane.add(imagenes.get(posicion),posicion.getCoordenadaX(),posicion.getCoordenadaY());
    }

}
