package fiuba.algo3.vista;

import fiuba.algo3.modelo.direccion.*;
import fiuba.algo3.modelo.herramientas.*;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.jugador.Item;
import fiuba.algo3.modelo.mapa.ElementoDelJuego;
import fiuba.algo3.modelo.mapa.Mapa;
import fiuba.algo3.modelo.mapa.Posicion;
import fiuba.algo3.modelo.materiales.Madera;
import fiuba.algo3.modelo.materiales.Material;
import fiuba.algo3.modelo.materiales.Metal;
import fiuba.algo3.modelo.materiales.Piedra;
import javafx.application.Application;
import javafx.event.EventHandler;
//import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
//import javafx.scene.input.MouseButton;
//import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static javafx.scene.media.AudioClip.INDEFINITE;

public class Main extends Application implements EventHandler<KeyEvent> {

    private static Mapa mapa;
    static private String path;

    private AudioClip caminar;
    private float volumenCaminar = (float) (Math.log(1.01) / Math.log(10.0) * 20.0);

    private static int cantItemsJugador;

    public static void main(String[] args) {
        Path currentPath = Paths.get(System.getProperty("user.dir"));
        path = "file:"+currentPath.toString();

        Juego juego;

        juego = new Juego();
        mapa = juego.getMapa();
        // Para probar distintas herramientas;
        juego.jugador.equiparHerramienta(new PicoFino());
        cantItemsJugador = juego.cantidadItemsDelJugador();

        System.out.println(juego.jugador.getHerramientaEquipada());
        launch(args);
    }


    private GridPane gridpane = new GridPane();
    private GridPane items = new GridPane();
    private int cantidad = 20;
    private int tamanio = 25;
    private Map<Posicion, ImageView> imagenes;
    private Map<Posicion, ImageView> imgItems;

    private List<Item> itemsJugador = mapa.getItems();

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("AlgoCraft");

        imagenes = this.crearImagenesMapa();
        for (int i = 0; i < cantidad; i++) {
            for(int j = 0; j < cantidad; j++) {
                gridpane.add(imagenes.get(new Posicion(i,j)), i, j);
            }
        }

        imgItems = this.crearImagenesInventario();
        for(int i = 0; i < cantItemsJugador; i++) {
            items.add(imgItems.get(new Posicion(i,0)),i,0);
        }


        VBox contenedorPrincipal = new VBox(gridpane);
        HBox contenedorItems = new HBox(items);

        BorderPane root = new BorderPane();
        root.setTop(contenedorPrincipal);
        root.setBottom(contenedorItems);

        Path soundPath = Paths.get(path, "sonidos");

        Path walkPath = Paths.get(soundPath.toString(), "walk.mp3");
        caminar = new AudioClip(walkPath.toString());
        caminar.setVolume(volumenCaminar);

        // Musica de fondo
        Path themePath = Paths.get(soundPath.toString(), "theme.mp3");
        AudioClip sonidoAmbiente = new AudioClip(themePath.toString());
        sonidoAmbiente.setCycleCount(INDEFINITE);
        sonidoAmbiente.play();


        Path iconPath = Paths.get(path, "imagenes", "icon.png");
        stage.getIcons().add(new Image(iconPath.toString()));
        Scene scene = new Scene(root);


        scene.setOnKeyPressed(this);
        stage.setScene(scene);
        stage.setResizable(false);

        stage.show();
    }


    private Map<Posicion, ImageView> crearImagenesMapa() {
        Map<Posicion, ImageView> aRetornar = new HashMap<>();

        for (int i = 0; i < cantidad; i++) {
            for(int j = 0; j < cantidad; j++) {
                Image elemento = this.retornarImagenMapa(new Posicion(i,j), mapa);
                ImageView imageView = new ImageView(elemento);
                imageView.setFitHeight(tamanio);
                imageView.setFitWidth(tamanio);
                aRetornar.put(new Posicion(i,j), imageView);
            }
        }
        return aRetornar;
    }

    private Map<Posicion, ImageView> crearImagenesInventario() {
        Map<Posicion, ImageView> aRetornar = new HashMap<>();

        for (int i = 0; i < cantItemsJugador; i++) {
            Image elemento = this.retornarImagenItems(i);
            ImageView imageView = new ImageView(elemento);
            imageView.setFitHeight(tamanio);
            imageView.setFitWidth(tamanio);
            aRetornar.put(new Posicion(i,0), imageView);
        }
        return aRetornar;
    }

    private void actualizarImagen(Posicion posicionVieja, Posicion posicionNueva) {
        /*Caso de movimiento del jugador*/
        if(!posicionNueva.equals(posicionVieja)) {
            caminar.play();
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

    private void actualizarImagen(Posicion posicion) {
        /*Caso de borrar material y reemplazar con icon*/
        ImageView imagenVieja = imagenes.get(posicion);
        Path imagenPath = Paths.get(path,"imagenes","grass.png");
        Image img = new Image(imagenPath.toString());
        ImageView imagenNueva = new ImageView(img);
        imagenNueva.setFitWidth(tamanio);
        imagenNueva.setFitHeight(tamanio);
        gridpane.getChildren().remove(imagenVieja);
        imagenes.replace(posicion,imagenNueva);
        gridpane.add(imagenes.get(posicion),posicion.getCoordenadaX(),posicion.getCoordenadaY());
    }

    private Image retornarImagenMapa(Posicion posicion, Mapa mapa) {
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

    private Image retornarImagenItems(int posicion) {
        Path imagenPath = Paths.get(path,"imagenes");
        Item elemento = itemsJugador.get(posicion);
        if(elemento instanceof Herramienta){
            if(elemento instanceof PicoFino){
                imagenPath = Paths.get(imagenPath.toString(), "PicoFino.jpg");

            }
            else {
                Herramienta herramientaAactual = (Herramienta) itemsJugador.get(posicion);
                imagenPath = Paths.get(imagenPath.toString(),
                        herramientaAactual.getClass().getSimpleName()+
                                "De"+
                                herramientaAactual.getMaterial().getClass().getSimpleName()+
                                ".png");
            }
        }
        else{
            Material materialActual = (Material) itemsJugador.get(posicion);
            imagenPath = Paths.get(imagenPath.toString(),materialActual.getClass().getSimpleName()+".png");
        }
        return new Image(imagenPath.toString());
    }

    private void eventoDesgastarMaterial(Direccion unaDireccion){
        mapa.atacarEn(unaDireccion);
        Posicion posDeAtaque = mapa.posDeAtaque(unaDireccion);
        if(!mapa.perteneceAlMapa(posDeAtaque)){
            this.actualizarImagen(posDeAtaque);
        }

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
            case I:
                this.eventoDesgastarMaterial(new DireccionArriba());
                System.out.println("Ataco Arriba");
                break;
            case J:
                this.eventoDesgastarMaterial(new DireccionIzquierda());
                System.out.println("Ataco Izquierda");
                break;
            case K:
                this.eventoDesgastarMaterial(new DireccionAbajo());
                System.out.println("Ataco Abajo");
                break;
            case L:
                this.eventoDesgastarMaterial(new DireccionDerecha());
                System.out.println("Ataco Derecha");
                break;
        }
    }

}
