package fiuba.algo3.modelo.mapa;

import java.util.HashMap;
import java.util.Map;

public class Mapa {
    private Integer capacidadMaxima;
    private Map<Posicion, ElementoDelJuego> mapa;
    private Integer lugares;

    public Mapa(int capacidad){
        mapa = new HashMap<Posicion, ElementoDelJuego>();
        this.capacidadMaxima = Math.abs(capacidad) * Math.abs(capacidad);
        this.lugares = Math.abs(capacidad);
    }

    public Integer getLugares(){
        return this.lugares;
    }

    public boolean perteneceAlMapa(Posicion posicion){
        return this.mapa.containsKey(posicion);
    }

    /*Cantidad de elemtentos. O sea si hay 20 pares de lugares (i,j) con 0<= i <= 20, 0<= j <= 20
    tenes 20*20 cantidad de elementos disponibles.*/

    public Integer obtenerCapacidadDelMapa() {
        return this.capacidadMaxima;
    }


    public void añadirElemento(ElementoDelJuego elemento) {
        if((this.obtenerCapacidadDelMapa()!=0) && (!this.perteneceAlMapa(elemento.obtenerPosicion()))){
            mapa.put(elemento.obtenerPosicion(),elemento);
            this.capacidadMaxima--;
        }
    }
}


