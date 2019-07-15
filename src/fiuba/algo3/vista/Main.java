package fiuba.algo3.vista;

import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.mapa.Posicion;
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

    private static Juego juego;
    static private String path;


    public static void main(String[] args) {
        Path currentPath = Paths.get(System.getProperty("user.dir"));
        path = "file:" + currentPath.toString();
        juego = new Juego();
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

        CrearImagen crearImagen = new CrearImagen(juego,tamanio,cantidad);
        crearImagen.mapa(imagenes);
        crearImagen.gridpaneMapa(gridpane);
        crearImagen.gridpaneInventario(items);
        crearImagen.gridpaneHerramientaEquipada(herramientaEquipada);

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
        ActualizarImagen actualizarImagen = new ActualizarImagen(juego,tamanio,cantidad);
        BotonMoverse botonMoverse = new BotonMoverse();
        BotonDesgastarMaterial botonDesgastarMaterial = new BotonDesgastarMaterial();
        Posicion posicionActual;
        PosicionAtacar posicionAtacar;
        switch (event.getCode()) {
            case W:
                posicionActual = juego.obtenerPosicionDelJugador();
                botonMoverse.eventoMoverArriba(juego);
                actualizarImagen.movimiento(posicionActual,imagenes,gridpane);
                break;
            case A:
                posicionActual = juego.obtenerPosicionDelJugador();
                botonMoverse.eventoMoverALaIzquierda(juego);
                actualizarImagen.movimiento(posicionActual,imagenes,gridpane);
                break;
            case S:
                posicionActual = juego.obtenerPosicionDelJugador();
                botonMoverse.eventoMoverAbajo(juego);
                actualizarImagen.movimiento(posicionActual,imagenes,gridpane);
                break;
            case D:
                posicionActual = juego.obtenerPosicionDelJugador();
                botonMoverse.eventoMoverALaDerecha(juego);
                actualizarImagen.movimiento(posicionActual,imagenes,gridpane);
                break;
            case I:
                posicionAtacar = botonDesgastarMaterial.eventoDesgastarMaterialArriba(juego);
                if (posicionAtacar.fueAtacada()) {
                    actualizarImagen.materialDesgastado(posicionAtacar.getPosicionAtacada(),imagenes,gridpane);
                    actualizarImagen.items(items);
                    actualizarImagen.herramientaEquipada(herramientaEquipada);
                }
                break;
            case J:
                posicionAtacar = botonDesgastarMaterial.eventoDesgastarMaterialALaIzquierda(juego);
                if (posicionAtacar.fueAtacada()) {
                    actualizarImagen.materialDesgastado(posicionAtacar.getPosicionAtacada(),imagenes,gridpane);
                    actualizarImagen.items(items);
                    actualizarImagen.herramientaEquipada(herramientaEquipada);
                }
                break;
            case K:
                posicionAtacar = botonDesgastarMaterial.eventoDesgastarMaterialAbajo(juego);
                if (posicionAtacar.fueAtacada()) {
                    actualizarImagen.materialDesgastado(posicionAtacar.getPosicionAtacada(),imagenes,gridpane);
                    actualizarImagen.items(items);
                    actualizarImagen.herramientaEquipada(herramientaEquipada);
                }
                break;
            case L:
                posicionAtacar = botonDesgastarMaterial.eventoDesgastarMaterialALaDerecha(juego);
                if (posicionAtacar.fueAtacada()) {
                    actualizarImagen.materialDesgastado(posicionAtacar.getPosicionAtacada(),imagenes,gridpane);
                    actualizarImagen.items(items);
                    actualizarImagen.herramientaEquipada(herramientaEquipada);
                }
                break;
            case SPACE:
                BotonCambiarHerramienta botonCambiarHerramienta = new BotonCambiarHerramienta();
                botonCambiarHerramienta.eventoCambiarHerramientaEquipada(juego);
                actualizarImagen.herramientaEquipada(herramientaEquipada);
        }
    }
}
