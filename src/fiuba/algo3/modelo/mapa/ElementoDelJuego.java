package fiuba.algo3.modelo.mapa;

public abstract class ElementoDelJuego{
    protected Posicion posicion;

    /*protected Posicion obtenerCoordenadaX(){
        return posicion.obtenerCoordenadaX();
    }
    protected Posicion obtenerCoordenadaY(){
        return posicion.obtenerCoordenadaY();
    }*/
    public void setPosicion(Posicion unaPosicion){
        this.posicion = unaPosicion;
    }
    public Posicion obtenerPosicion() {
        return this.posicion;
    }
}
