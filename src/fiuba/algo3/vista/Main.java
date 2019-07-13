package fiuba.algo3.vista;

import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.mapa.*;
import fiuba.algo3.modelo.direccion.*;
import fiuba.algo3.controlador.manejadores.*;
import fiuba.algo3.vista.imagen.*;
import fiuba.algo3.vista.sonido.Musica;
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
        path = "file:" + currentPath.toString();
        Juego juego = new Juego();
        mapa = juego.getMapa();
        // Para probar distintas herramientas;
        //mapa.jugador.equiparHerramienta(new PicoFino());
        //mapa.jugador.equiparHerramienta(new Pico(new Metal()));

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

        // Musica de fondo
        Musica musica = new Musica();
        musica.playMainTheme();

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
                    actualizarImagen.actualizarImagenDeDesgaste(posicionActual,imagenes,gridpane);
                }
                actualizarImagen.actualizarImagenItems(items);
                actualizarImagen.actualizarImagenHerramientaEquipada(herramientaEquipada);
                break;
            case J:
                posicionActual = mapa.posDeAtaque(new DireccionIzquierda());
                if (botonDesgastarMaterial.eventoDesgastarMaterial(posicionActual, mapa)) {
                    actualizarImagen.actualizarImagenDeDesgaste(posicionActual,imagenes,gridpane);
                }
                actualizarImagen.actualizarImagenItems(items);
                actualizarImagen.actualizarImagenHerramientaEquipada(herramientaEquipada);
                break;
            case K:
                posicionActual = mapa.posDeAtaque(new DireccionAbajo());
                if (botonDesgastarMaterial.eventoDesgastarMaterial(posicionActual, mapa)) {
                    actualizarImagen.actualizarImagenDeDesgaste(posicionActual,imagenes,gridpane);
                }
                actualizarImagen.actualizarImagenItems(items);
                actualizarImagen.actualizarImagenHerramientaEquipada(herramientaEquipada);
                break;
            case L:
                posicionActual = mapa.posDeAtaque(new DireccionDerecha());
                if (botonDesgastarMaterial.eventoDesgastarMaterial(posicionActual, mapa)) {
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


}
