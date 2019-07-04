package fiuba.algo3.modelo.mapa;

import fiuba.algo3.modelo.jugador.Item;
import fiuba.algo3.modelo.jugador.Jugador;
import fiuba.algo3.modelo.materiales.Material;
import fiuba.algo3.modelo.direccion.Direccion;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mapa {
    private Integer capacidadMaxima;
    private Map<Posicion, ElementoDelJuego> mapa;
    private Integer lugares;
    public Jugador jugador;

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

    public void añadirElemento(Material material) {
        if((this.obtenerCapacidadDelMapa()!=0) && (material.obtenerPosicion().estaDentroDeLos(this.capacidadMaxima)) && (!this.perteneceAlMapa(material.obtenerPosicion()))){
            mapa.put(material.obtenerPosicion(),material);
            this.capacidadMaxima--;
        }
    }

    /*Vos fijate que todos los metodos van a ser iguales
    */
    public void moverJugador(Direccion unaDireccion){
        Posicion nuevaPosicion = unaDireccion.posSiguiente(this.jugador.obtenerPosicion());
        this.modificarPosicion(nuevaPosicion);
    }

    public ElementoDelJuego obtenerElemento(Posicion posicion){
        return mapa.get(posicion);
    }

    public List<Item> getItems(){
        return jugador.getItems();
    }

    public void modificarPosicion(Posicion posSiguiente){
        if(!this.perteneceAlMapa(posSiguiente) && posSiguiente.estaDentroDeLos(this.lugares)){
            this.eliminar(this.jugador.obtenerPosicion());
            this.jugador.setPosicion(posSiguiente);
            this.añadirJugador(this.jugador);
        }
    }
    public void eliminar(Posicion pos){
        this.mapa.remove(pos);
        this.capacidadMaxima++;
    }
    public void añadirJugador(Jugador unJugador) {
        this.mapa.put(unJugador.obtenerPosicion(), unJugador);
        jugador = unJugador;
        this.capacidadMaxima--;
    }

    public Posicion obtenerPosicionDelJugador() {
        return jugador.obtenerPosicion();
    }
    public ElementoDelJuego retornarElemento(Posicion pos) {
        return mapa.get(pos);
    }
    public boolean esMaterial(Posicion posicion){
        return perteneceAlMapa(posicion) && (mapa.get(posicion) instanceof Material);
    }
    public void atacarEn(Direccion unaDireccion) {
        Posicion posicionDeAtaque = this.posDeAtaque(unaDireccion);
        if (esMaterial(posicionDeAtaque)) {
            Material material = (Material) mapa.get(posicionDeAtaque);
            material.esDesgastadoPor(jugador.getHerramientaEquipada());
            if (material.roto()){
                jugador.añadirItem(material);
                this.eliminar(posicionDeAtaque);
            }
        }
    }
    public Posicion posDeAtaque(Direccion unaDireccion){
        return unaDireccion.posSiguiente(obtenerPosicionDelJugador());
    }
}


