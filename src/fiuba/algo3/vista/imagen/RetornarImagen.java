package fiuba.algo3.vista.imagen;

import fiuba.algo3.modelo.herramientas.Herramienta;
import fiuba.algo3.modelo.herramientas.PicoFino;
import fiuba.algo3.modelo.jugador.Item;
import fiuba.algo3.modelo.mapa.ElementoDelJuego;
import fiuba.algo3.modelo.mapa.Mapa;
import fiuba.algo3.modelo.mapa.Posicion;
import fiuba.algo3.modelo.materiales.Madera;
import fiuba.algo3.modelo.materiales.Material;
import fiuba.algo3.modelo.materiales.Metal;
import fiuba.algo3.modelo.materiales.Piedra;
import javafx.scene.image.Image;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

public class RetornarImagen {

    static private String path;

    public RetornarImagen(){
        Path currentPath = Paths.get(System.getProperty("user.dir"));
        path = "file:" + currentPath.toString();
    }

    public Image mapa(Posicion posicion, Mapa mapa) {
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

    public Image items(int posicion, List<Item> itemsJugador) {
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

    public Image herramientaEquipada(Mapa mapa) {
        Path imagenPath = Paths.get(path, "imagenes");
        Item elemento = mapa.jugador.getHerramientaEquipada();
        if (elemento == null) {
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
}
