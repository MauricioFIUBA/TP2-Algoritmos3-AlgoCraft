package fiuba.algo3.vista;

import fiuba.algo3.controlador.manejadores.*;
import fiuba.algo3.modelo.direccion.*;
import fiuba.algo3.modelo.herramientas.*;
import fiuba.algo3.modelo.juego.*;
import fiuba.algo3.modelo.jugador.*;
import fiuba.algo3.modelo.mapa.*;
import fiuba.algo3.modelo.materiales.*;
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
import java.util.List;
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

    private static int cantItemsJugador;

    public static void main(String[] args) {
        Path currentPath = Paths.get(System.getProperty("user.dir"));
        path = "file:" + currentPath.toString();

        Juego juego;

        juego = new Juego();
        mapa = juego.getMapa();
        // Para probar distintas herramientas;
//        mapa.jugador.equiparHerramienta(new PicoFino());
//        mapa.jugador.equiparHerramienta(new Pico(new Metal()));
        cantItemsJugador = juego.cantidadItemsDelJugador();

        launch(args);
    }


    private GridPane gridpane = new GridPane();
    private GridPane items = new GridPane();
    private GridPane herramientaEquipada = new GridPane();
    private int cantidad = 20;
    private int tamanio = 25;
    private Map<Posicion, ImageView> imagenes;
    private Map<Posicion, ImageView> imgItems;
    private Map<Posicion, ImageView> imgHerramientaEquipada;

    private List<Item> itemsJugador = mapa.getItems();

    @Override
    public void start(Stage stage) throws Exception {

        stage.setTitle("AlgoCraft");

        imagenes = this.crearImagenesMapa();
        for (int i = 0; i < cantidad; i++) {
            for (int j = 0; j < cantidad; j++) {
                gridpane.add(imagenes.get(new Posicion(i, j)), i, j);
            }
        }

        imgItems = this.crearImagenesInventario();
        for (int i = 0; i < cantItemsJugador; i++) {
            items.add(imgItems.get(new Posicion(i, 0)), i, 0);
        }

        imgHerramientaEquipada = this.crearImagenesHerramientaEquipada();
        herramientaEquipada.add(imgHerramientaEquipada.get(new Posicion(0, 0)), 0, 0);
        VBox contenedorPrincipal = new VBox(gridpane);
        HBox contenedorItems = new HBox(items);
        VBox contenedorHerramientaEquipada = new VBox(herramientaEquipada);

        BorderPane root = new BorderPane();
        root.setTop(contenedorPrincipal);
        root.setBottom(contenedorItems);
        root.setLeft(contenedorHerramientaEquipada);

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


    private Map<Posicion, ImageView> crearImagenesMapa() {
        Map<Posicion, ImageView> aRetornar = new HashMap<>();

        for (int i = 0; i < cantidad; i++) {
            for (int j = 0; j < cantidad; j++) {
                Image elemento = this.retornarImagenMapa(new Posicion(i, j), mapa);
                ImageView imageView = new ImageView(elemento);
                imageView.setFitHeight(tamanio);
                imageView.setFitWidth(tamanio);
                aRetornar.put(new Posicion(i, j), imageView);
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
            aRetornar.put(new Posicion(i, 0), imageView);
        }
        return aRetornar;
    }

    private Map<Posicion, ImageView> crearImagenesHerramientaEquipada() {
        Map<Posicion, ImageView> aRetornar = new HashMap<>();

        Image elemento = this.retornarImagenHerramientaEquip();
        ImageView imageView = new ImageView(elemento);
        imageView.setFitHeight(tamanio * 2);
        imageView.setFitWidth(tamanio * 2);
        aRetornar.put(new Posicion(0, 0), imageView);
        return aRetornar;
    }

    private void actualizarImagenMovimiento(Posicion posicionAnterior) {
        Posicion posicionNueva;
        posicionNueva = mapa.obtenerPosicionDelJugador();
        if (!posicionNueva.equals(posicionAnterior)) {
            this.playSonidoPasos();
            ImageView imagenVieja = imagenes.get(posicionAnterior);
            ImageView imagenNueva = imagenes.get(posicionNueva);
            imagenes.replace(posicionAnterior, imagenNueva);
            imagenes.replace(posicionNueva, imagenVieja);
            gridpane.getChildren().remove(imagenVieja);
            gridpane.getChildren().remove(imagenNueva);
            gridpane.add(imagenes.get(posicionAnterior), posicionAnterior.getCoordenadaX(), posicionAnterior.getCoordenadaY());
            gridpane.add(imagenes.get(posicionNueva), posicionNueva.getCoordenadaX(), posicionNueva.getCoordenadaY());
        }
    }

    private void actualizarImagen(Posicion posicion) {
        /*Caso de borrar material y reemplazar con icon*/
        ImageView imagenVieja = imagenes.get(posicion);
        Path imagenPath = Paths.get(path, "imagenes", "grass.png");
        Image img = new Image(imagenPath.toString());
        ImageView imagenNueva = new ImageView(img);
        imagenNueva.setFitWidth(tamanio);
        imagenNueva.setFitHeight(tamanio);
        gridpane.getChildren().remove(imagenVieja);
        imagenes.replace(posicion, imagenNueva);
        gridpane.add(imagenes.get(posicion), posicion.getCoordenadaX(), posicion.getCoordenadaY());
    }

    private void actualizarImagenItems() {
        cantItemsJugador = itemsJugador.size();
        imgItems = this.crearImagenesInventario();
        items.getChildren().clear();
        for (int i = 0; i < cantItemsJugador; i++) {
            items.add(imgItems.get(new Posicion(i, 0)), i, 0);
        }
    }

    private void actualizarImagenHerramientaEquipada() {
        imgHerramientaEquipada = this.crearImagenesHerramientaEquipada();
        herramientaEquipada.getChildren().clear();
        herramientaEquipada.add(imgHerramientaEquipada.get(new Posicion(0, 0)), 0, 0);
    }

    private Image retornarImagenMapa(Posicion posicion, Mapa mapa) {
        Path imagenPath = Paths.get(path, "imagenes");
        if (mapa.perteneceAlMapa(posicion)) {
            ElementoDelJuego elemento = mapa.retornarElemento(posicion);
            if (elemento instanceof Material) {
                if (elemento instanceof Madera) {
                    imagenPath = Paths.get(imagenPath.toString(), "wood.jpg");
                } else if (elemento instanceof Piedra) {
                    imagenPath = Paths.get(imagenPath.toString(), "stone.png");
                } else if (elemento instanceof Metal) {
                    imagenPath = Paths.get(imagenPath.toString(), "iron.png");
                } else { //if(elemento instanceof Diamante) {
                    imagenPath = Paths.get(imagenPath.toString(), "diamond.jpg");
                }
            } else {
                imagenPath = Paths.get(imagenPath.toString(), "player.png");
            }
        } else {
            imagenPath = Paths.get(imagenPath.toString(), "grass.png");
        }
        return new Image(imagenPath.toString());
    }

    private Image retornarImagenItems(int posicion) {
        Path imagenPath = Paths.get(path, "imagenes");
        Item elemento = itemsJugador.get(posicion);
        if (elemento instanceof Herramienta) {
            if (elemento instanceof PicoFino) {
                imagenPath = Paths.get(imagenPath.toString(), "PicoFino.jpg");

            } else {
                Herramienta herramientaAactual = (Herramienta) itemsJugador.get(posicion);
                imagenPath = Paths.get(imagenPath.toString(),
                        herramientaAactual.getClass().getSimpleName() +
                                "De" +
                                herramientaAactual.getMaterial().getClass().getSimpleName() +
                                ".png");
            }
        } else {
            Material materialActual = (Material) itemsJugador.get(posicion);
            imagenPath = Paths.get(imagenPath.toString(), materialActual.getClass().getSimpleName() + ".png");
        }
        return new Image(imagenPath.toString());
    }

    private Image retornarImagenHerramientaEquip() {
        Path imagenPath = Paths.get(path, "imagenes");
        Item elemento = mapa.jugador.getHerramientaEquipada();
        if (elemento == null) {
            System.out.println("Entro aca");
            imagenPath = Paths.get(imagenPath.toString(), "none.png");
        } else if (elemento instanceof PicoFino) {
            imagenPath = Paths.get(imagenPath.toString(), "PicoFino.jpg");
        } else {
            Herramienta herramientaAactual = (Herramienta) elemento;
            imagenPath = Paths.get(imagenPath.toString(),
                    herramientaAactual.getClass().getSimpleName() +
                            "De" +
                            herramientaAactual.getMaterial().getClass().getSimpleName() +
                            ".png");
        }
        return new Image(imagenPath.toString());
    }

    private void actualizarImagenSonidoDeDesgaste(Posicion posicionDeAtaque) {
        if (!mapa.perteneceAlMapa(posicionDeAtaque)) {
            this.playSonido("recolecting.mp3");
            this.actualizarImagen(posicionDeAtaque);
        }
    }

    @Override
    public void handle(KeyEvent event) {
        BotonMoverse botonMoverse = new BotonMoverse();
        BotonDesgastarMaterial botonDesgastarMaterial = new BotonDesgastarMaterial();
        Posicion posicionActual;
        switch (event.getCode()) {
            case W:
                posicionActual = mapa.obtenerPosicionDelJugador();
                botonMoverse.eventoMover(new DireccionArriba(), mapa);
                this.actualizarImagenMovimiento(posicionActual);
                break;
            case A:
                posicionActual = mapa.obtenerPosicionDelJugador();
                botonMoverse.eventoMover(new DireccionIzquierda(), mapa);
                this.actualizarImagenMovimiento(posicionActual);
                break;
            case S:
                posicionActual = mapa.obtenerPosicionDelJugador();
                botonMoverse.eventoMover(new DireccionAbajo(), mapa);
                this.actualizarImagenMovimiento(posicionActual);
                break;
            case D:
                posicionActual = mapa.obtenerPosicionDelJugador();
                botonMoverse.eventoMover(new DireccionDerecha(), mapa);
                this.actualizarImagenMovimiento(posicionActual);
                break;
            case I:
                posicionActual = mapa.posDeAtaque(new DireccionArriba());
                if (botonDesgastarMaterial.eventoDesgastarMaterial(posicionActual, mapa)) {
                    this.playSonido("mining.mp3");
                    this.actualizarImagenSonidoDeDesgaste(posicionActual);
                }
                actualizarImagenItems();
                actualizarImagenHerramientaEquipada();
                break;
            case J:
                posicionActual = mapa.posDeAtaque(new DireccionIzquierda());
                if (botonDesgastarMaterial.eventoDesgastarMaterial(posicionActual, mapa)) {
                    this.playSonido("mining.mp3");
                    this.actualizarImagenSonidoDeDesgaste(posicionActual);
                }
                actualizarImagenItems();
                actualizarImagenHerramientaEquipada();

                break;
            case K:
                posicionActual = mapa.posDeAtaque(new DireccionAbajo());
                if (botonDesgastarMaterial.eventoDesgastarMaterial(posicionActual, mapa)) {
                    this.playSonido("mining.mp3");
                    this.actualizarImagenSonidoDeDesgaste(posicionActual);
                }
                actualizarImagenItems();
                actualizarImagenHerramientaEquipada();
                break;
            case L:
                posicionActual = mapa.posDeAtaque(new DireccionDerecha());
                if (botonDesgastarMaterial.eventoDesgastarMaterial(posicionActual, mapa)) {
                    this.playSonido("mining.mp3");
                    this.actualizarImagenSonidoDeDesgaste(posicionActual);
                }
                actualizarImagenItems();
                actualizarImagenHerramientaEquipada();
                break;
            case SPACE:
                BotonCambiarHerramienta botonCambiarHerramienta = new BotonCambiarHerramienta();
                botonCambiarHerramienta.eventoCambiarHerramientaEquipada(mapa);
                actualizarImagenHerramientaEquipada();
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
