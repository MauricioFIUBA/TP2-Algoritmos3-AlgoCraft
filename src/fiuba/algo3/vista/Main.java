package fiuba.algo3.vista;

import fiuba.algo3.controlador.manejadores.BotonCambiarHerramienta;
import fiuba.algo3.controlador.manejadores.BotonDesgastarMaterial;
import fiuba.algo3.controlador.manejadores.BotonMoverse;
import fiuba.algo3.modelo.direccion.DireccionAbajo;
import fiuba.algo3.modelo.direccion.DireccionArriba;
import fiuba.algo3.modelo.direccion.DireccionDerecha;
import fiuba.algo3.modelo.direccion.DireccionIzquierda;
import fiuba.algo3.modelo.herramientas.Pico;
import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.mapa.Mapa;
import fiuba.algo3.modelo.mapa.Posicion;
import fiuba.algo3.modelo.materiales.Metal;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import static javafx.scene.media.AudioClip.INDEFINITE;

//import javafx.geometry.Pos;
//import javafx.scene.input.MouseButton;
//import javafx.scene.input.MouseEvent;

public class Main extends Application implements EventHandler<KeyEvent> {

    private static Mapa mapa;
    static private String path;
    private float volumenCaminar = (float) (Math.log(1.01) / Math.log(10.0) * 20.0);

    public static void main(String[] args) {
        Path currentPath = Paths.get(System.getProperty("user.dir"));
        path = "file:" + currentPath.toString();
        Juego juego = new Juego();
        mapa = juego.getMapa();
        // Para probar distintas herramientas;
        //mapa.jugador.equiparHerramienta(new PicoFino());
        mapa.jugador.equiparHerramienta(new Pico(new Metal()));

        launch(args);
    }

    private GridPane gridpane = new GridPane();
    private GridPane items = new GridPane();
    private GridPane herramientaEquipada = new GridPane();
    private Map<Posicion, ImageView> imagenes = new HashMap<>();
    private int tamanio = 25;
    private int cantidad = 20;

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("AlgoCraft");

        CrearImagen crearImagen = new CrearImagen(mapa,mapa.getItems(),tamanio,cantidad);
        crearImagen.crearImagenesMapa(imagenes);
        crearImagen.crearGridpaneMapa(gridpane);
        crearImagen.crearGridpaneInventario(items);
        crearImagen.crearGridpaneHerramientaEquipada(herramientaEquipada);

        VBox contenedorPrincipal = new VBox(gridpane);
        HBox contenedorItems = new HBox(items);
        VBox contenedorHerramientaEquipada = new VBox(herramientaEquipada);

        BorderPane root = new BorderPane();
        root.setTop(contenedorPrincipal);
        root.setLeft(contenedorHerramientaEquipada);
        root.setBottom(contenedorItems);


        Path soundPath = Paths.get(path, "sonidos");

        // Musica de fondo
        Path themePath = Paths.get(soundPath.toString(), "theme.mp3");
        AudioClip sonidoAmbiente = new AudioClip(themePath.toString());
        sonidoAmbiente.setCycleCount(INDEFINITE);
        sonidoAmbiente.play();

        // Creacion del menu principal
        Path menuPath = Paths.get(path, "imagenes", "menu.jpg");
        Scene scenePrincipal = new Scene(root);
        MenuDeInicio menu = new MenuDeInicio(stage, scenePrincipal, menuPath.toString());
        Scene sceneMenu = new Scene(menu, cantidad * tamanio, (cantidad + 3) * tamanio);

        Path iconPath = Paths.get(path, "imagenes", "icon.png");
        stage.getIcons().add(new Image(iconPath.toString()));
        scenePrincipal.setOnKeyPressed(this);

        stage.setScene(sceneMenu);
        stage.setResizable(false);
        stage.sizeToScene();

        stage.show();
    }

    @Override
    public void handle(KeyEvent event) {
        ActualizarImagen actualizarImagen = new ActualizarImagen(mapa,tamanio,cantidad);
        BotonMoverse botonMoverse = new BotonMoverse();
        BotonDesgastarMaterial botonDesgastarMaterial = new BotonDesgastarMaterial();
        Posicion posicionActual;
        switch (event.getCode()) {
            case W:
                posicionActual = mapa.obtenerPosicionDelJugador();
                botonMoverse.eventoMover(new DireccionArriba(), mapa);
                actualizarImagen.actualizarImagenMovimiento(posicionActual,imagenes,gridpane);
                break;
            case A:
                posicionActual = mapa.obtenerPosicionDelJugador();
                botonMoverse.eventoMover(new DireccionIzquierda(), mapa);
                actualizarImagen.actualizarImagenMovimiento(posicionActual,imagenes,gridpane);
                break;
            case S:
                posicionActual = mapa.obtenerPosicionDelJugador();
                botonMoverse.eventoMover(new DireccionAbajo(), mapa);
                actualizarImagen.actualizarImagenMovimiento(posicionActual,imagenes,gridpane);
                break;
            case D:
                posicionActual = mapa.obtenerPosicionDelJugador();
                botonMoverse.eventoMover(new DireccionDerecha(), mapa);
                actualizarImagen.actualizarImagenMovimiento(posicionActual,imagenes,gridpane);
                break;
            case I:
                posicionActual = mapa.posDeAtaque(new DireccionArriba());
                if (botonDesgastarMaterial.eventoDesgastarMaterial(posicionActual, mapa)) {
                    this.playSonido("mining.mp3");
                    actualizarImagen.actualizarImagenDeDesgaste(posicionActual,imagenes,gridpane);
                }
                actualizarImagen.actualizarImagenItems(items);
                actualizarImagen.actualizarImagenHerramientaEquipada(herramientaEquipada);
                break;
            case J:
                posicionActual = mapa.posDeAtaque(new DireccionIzquierda());
                if (botonDesgastarMaterial.eventoDesgastarMaterial(posicionActual, mapa)) {
                    this.playSonido("mining.mp3");
                    actualizarImagen.actualizarImagenDeDesgaste(posicionActual,imagenes,gridpane);
                }
                actualizarImagen.actualizarImagenItems(items);
                actualizarImagen.actualizarImagenHerramientaEquipada(herramientaEquipada);
                break;
            case K:
                posicionActual = mapa.posDeAtaque(new DireccionAbajo());
                if (botonDesgastarMaterial.eventoDesgastarMaterial(posicionActual, mapa)) {
                    this.playSonido("mining.mp3");
                    actualizarImagen.actualizarImagenDeDesgaste(posicionActual,imagenes,gridpane);
                }
                actualizarImagen.actualizarImagenItems(items);
                actualizarImagen.actualizarImagenHerramientaEquipada(herramientaEquipada);
                break;
            case L:
                posicionActual = mapa.posDeAtaque(new DireccionDerecha());
                if (botonDesgastarMaterial.eventoDesgastarMaterial(posicionActual, mapa)) {
                    this.playSonido("mining.mp3");
                    actualizarImagen.actualizarImagenDeDesgaste(posicionActual,imagenes,gridpane);
                }
                actualizarImagen.actualizarImagenItems(items);
                actualizarImagen.actualizarImagenHerramientaEquipada(herramientaEquipada);
                break;
            case SPACE:
                BotonCambiarHerramienta botonCambiarHerramienta = new BotonCambiarHerramienta();
                botonCambiarHerramienta.eventoCambiarHerramientaEquipada(mapa);
                actualizarImagen.actualizarImagenHerramientaEquipada(herramientaEquipada);
        }
    }


    private void playSonidoPasos() {
        AudioClip caminar;
        Path soundPath = Paths.get(path, "sonidos");
        Random rand = new Random();
        Integer numero = rand.nextInt(4) + 1;
        Path walkPath = Paths.get(soundPath.toString(), "walk" + numero.toString() + ".mp3");
        caminar = new AudioClip(walkPath.toString());
        caminar.setVolume(volumenCaminar);
        caminar.play();
    }

    private void playSonido(String nombreSonido) {
        Path soundPath = Paths.get(path, "sonidos");
        soundPath = Paths.get(soundPath.toString(), nombreSonido);
        AudioClip sound = new AudioClip(soundPath.toString());
        sound.play();
    }


}
