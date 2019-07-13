package fiuba.algo3.vista.imagen;

import fiuba.algo3.modelo.jugador.Item;
import fiuba.algo3.modelo.mapa.Mapa;
import fiuba.algo3.modelo.mapa.Posicion;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CrearImagen {

    private Mapa mapa;
    private int tamanio;
    private int cantidad;
    private List<Item> itemsJugador;
    private RetornarImagen retornarImagen;

    public CrearImagen(Mapa mapaActual,List<Item> itemsJugadorActual, int tamanioActual, int cantidadActual){
        mapa = mapaActual;
        tamanio = tamanioActual;
        cantidad = cantidadActual;
        itemsJugador = itemsJugadorActual;
        retornarImagen = new RetornarImagen();
    }

    public void gridpaneMapa(GridPane gridPane){
        Map<Posicion, ImageView> imagenes = new HashMap<>();
        this.mapa(imagenes);
        for (int i = 0; i < cantidad; i++) {
            for (int j = 0; j < cantidad; j++) {
                gridPane.add(imagenes.get(new Posicion(i, j)), i, j);
            }
        }
    }

    public void mapa(Map<Posicion, ImageView> imagenes) {
        for (int i = 0; i < cantidad; i++) {
            for (int j = 0; j < cantidad; j++) {
                Image elemento = retornarImagen.mapa(new Posicion(i, j), mapa);
                ImageView imageView = new ImageView(elemento);
                imageView.setFitHeight(tamanio);
                imageView.setFitWidth(tamanio);
                imagenes.put(new Posicion(i, j), imageView);
            }
        }
    }

    public void gridpaneInventario(GridPane items) {
        Map<Posicion, ImageView> imgItems = new HashMap<>();
        this.inventario(imgItems);
        for (int i = 0; i < itemsJugador.size(); i++) {
            items.add(imgItems.get(new Posicion(i, 0)), i, 0);
        }
    }

    public void inventario(Map<Posicion, ImageView> imgItems) {
        int cantItemsJugador = itemsJugador.size();
        for (int i = 0; i < cantItemsJugador; i++) {
            Image elemento = retornarImagen.items(i,itemsJugador);
            ImageView imageView = new ImageView(elemento);
            imageView.setFitHeight(tamanio);
            imageView.setFitWidth(tamanio);
            imgItems.put(new Posicion(i, 0), imageView);
        }
    }

    public void gridpaneHerramientaEquipada(GridPane herramientaEquipada){
        Map<Posicion, ImageView> imgHerramientaEquipada = new HashMap<>();
        this.herramientaEquipada(imgHerramientaEquipada);
        herramientaEquipada.add(imgHerramientaEquipada.get(new Posicion(0, 0)), 0, 0);
    }

    public void herramientaEquipada(Map<Posicion, ImageView> imgHerramientaEquipada) {
        Image elemento = retornarImagen.herramientaEquipada(mapa);
        ImageView imageView = new ImageView(elemento);
        imageView.setFitHeight(tamanio * 2);
        imageView.setFitWidth(tamanio * 2);
        imgHerramientaEquipada.put(new Posicion(0, 0), imageView);
    }

}
