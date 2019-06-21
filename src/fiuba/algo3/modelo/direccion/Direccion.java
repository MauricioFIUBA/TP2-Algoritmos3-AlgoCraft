package fiuba.algo3.modelo.direccion;

import fiuba.algo3.modelo.mapa.Posicion;

public abstract class Direccion {
    protected Integer moverseX;
    protected Integer moverseY;

    public Posicion posSiguiente(Posicion posActual){
        return (new Posicion(posActual.getCoordenadaX()+this.moverseX,posActual.getCoordenadaY()+this.moverseY));
    }
}
