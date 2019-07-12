package fiuba.algo3.modelo.juego;

import fiuba.algo3.modelo.jugador.Jugador;
import fiuba.algo3.modelo.mapa.Mapa;
import fiuba.algo3.modelo.mapa.Posicion;
import fiuba.algo3.modelo.materiales.Diamante;
import fiuba.algo3.modelo.materiales.Madera;
import fiuba.algo3.modelo.materiales.Metal;
import fiuba.algo3.modelo.materiales.Piedra;

import java.util.Random;

public class Juego {

    private Mapa mapaDeJuego;
    private Jugador jugador;

    public Juego(){
        /*Crea el mapa, crea el jugador en una posicion definida(cambiarla si quieren)*/

        this.mapaDeJuego = new Mapa(20);
        this.jugador = new Jugador();
        this.jugador.setPosicion(new Posicion(10,10));
        this.mapaDeJuego.añadirJugador(this.jugador);
        this.setMapa();

    }
    /*Habria que modularizar bien esta parte del codigo, porque hay mucho repetido*/

    public void setMapa(){
        this.setMaderaEnElMapa(16);
        this.setMetalEnElMapa(4);
        this.setDiamanteEnElMapa(4);
        this.setPiedraEnElMapa(4);
    }

    public void setMaderaEnElMapa(Integer cantidad) {
        Random random = new Random();
        int i = 0;
        Integer lugares = this.mapaDeJuego.getLugares();
        while (i < cantidad){
            Posicion posicion = new Posicion(random.nextInt(lugares),random.nextInt(lugares));
            if(!this.mapaDeJuego.perteneceAlMapa(posicion)){
                Madera madera = new Madera();
                madera.setPosicion(posicion);
                this.mapaDeJuego.añadirElemento(madera);
                i++;
            }
        }
    }

    public void setMetalEnElMapa(Integer cantidad){
        Random random = new Random();
        int i = 0;
        Integer lugares = this.mapaDeJuego.getLugares();
        while(i < cantidad){
            Posicion posicion = new Posicion(random.nextInt(lugares),random.nextInt(lugares));
            if(!this.mapaDeJuego.perteneceAlMapa(posicion)){
                Metal metal = new Metal();
                metal.setPosicion(posicion);
                this.mapaDeJuego.añadirElemento(metal);
                i++;
            }
        }
    }

    public void setDiamanteEnElMapa(Integer cantidad){
        Random random = new Random();
        int i = 0;
        Integer lugares = this.mapaDeJuego.getLugares();
        while(i < cantidad){
            Posicion posicion = new Posicion(random.nextInt(lugares),random.nextInt(lugares));
            if(!this.mapaDeJuego.perteneceAlMapa(posicion)){
                Diamante diamante = new Diamante();
                diamante.setPosicion(posicion);
                this.mapaDeJuego.añadirElemento(diamante);
                i++;
            }
        }
    }

    public void setPiedraEnElMapa(Integer cantidad){
        Random random = new Random();
        int i = 0;
        Integer lugares = this.mapaDeJuego.getLugares();
        while(i < cantidad){
            Posicion posicion = new Posicion(random.nextInt(lugares),random.nextInt(lugares));
            if(!this.mapaDeJuego.perteneceAlMapa(posicion)){
                Piedra piedra = new Piedra();
                piedra.setPosicion(posicion);
                this.mapaDeJuego.añadirElemento(piedra);
                i++;
            }
        }
    }

    public Mapa getMapa() {
        return this.mapaDeJuego;
    }
    public int cantidadItemsDelJugador(){return jugador.cantidadItems();}

}
