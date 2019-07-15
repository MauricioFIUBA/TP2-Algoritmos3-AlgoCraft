package fiuba.algo3.vista.imagen;

import fiuba.algo3.modelo.juego.Juego;
import fiuba.algo3.modelo.jugador.Item;
import fiuba.algo3.modelo.mapa.Mapa;
import fiuba.algo3.modelo.mapa.Posicion;
import fiuba.algo3.vista.sonido.EfectosDeSonido;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActualizarImagen{

    private Juego juego;
    private Mapa mapa;
    private String path;
    private int tamanio;
    private int cantidad;
    private List<Item> itemsJugador;
    private EfectosDeSonido efecto = new EfectosDeSonido();

    public ActualizarImagen(Juego juegoActual, int tamanioActual, int cantidadActual){
        Path currentPath = Paths.get(System.getProperty("user.dir"));
        juego = juegoActual;
        mapa = juegoActual.getMapa();
        path = "file:" + currentPath.toString();
        tamanio = tamanioActual;
        cantidad = cantidadActual;
        itemsJugador = juegoActual.getMapa().getItems();
    }

    public void movimiento(Posicion posicionAnterior, Map<Posicion, ImageView> imagenes, GridPane gridpane) {
        Posicion posicionNueva;
        posicionNueva = mapa.obtenerPosicionDelJugador();
        if (!posicionNueva.equals(posicionAnterior)) {
            efecto.playSonidoPasos();
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

    public void items(GridPane items) {
        CrearImagen crearImagen = new CrearImagen(juego, tamanio, cantidad);
        int cantItemsJugador = itemsJugador.size();
        Map<Posicion, ImageView> imgItems = new HashMap<>();
        crearImagen.inventario(imgItems);
        items.getChildren().clear();
        for (int i = 0; i < cantItemsJugador; i++) {
            items.add(imgItems.get(new Posicion(i, 0)), i, 0);
        }
    }

    public void herramientaEquipada(GridPane herramientaEquipada) {
        CrearImagen crearImagen = new CrearImagen(juego, tamanio, cantidad);
        Map<Posicion, ImageView> imgHerramientaEquipada = new HashMap<>();
        crearImagen.herramientaEquipada(imgHerramientaEquipada);
        herramientaEquipada.getChildren().clear();
        herramientaEquipada.add(imgHerramientaEquipada.get(new Posicion(0, 0)), 0, 0);
    }

    public void materialDesgastado(Posicion posicionDeAtaque, Map<Posicion, ImageView> imagenes, GridPane gridpane) {
        if (!mapa.perteneceAlMapa(posicionDeAtaque)) {
            efecto.playSonidoRecolectar();
            this.materialRoto(posicionDeAtaque,imagenes,gridpane);
        } else {
            efecto.playSonidoGolpear();
        }
    }

    private void materialRoto(Posicion posicion, Map<Posicion, ImageView> imagenes, GridPane gridpane) {
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
}
