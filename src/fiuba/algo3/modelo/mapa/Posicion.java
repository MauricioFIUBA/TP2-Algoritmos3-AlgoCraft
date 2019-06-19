package fiuba.algo3.modelo.mapa;

public class Posicion {
    private  Integer coordenadaX;
    private  Integer coordenadaY; //Arrancan en -1 asi cuando se cree una nueva posicion inicia en 0.

    public Posicion(int x, int y){
        this.coordenadaX = x;
        this.coordenadaY = y;
    }
    public int getCoordenadaX() {
        return this.coordenadaX;
    }

    public int getCoordenadaY(){
        return this.coordenadaY;
    }

    /*Metodos sobreescritos para que el hash pueda comparar dos objetos por Posicion*/
    public boolean equals(Object obj){
        boolean ok = obj instanceof Posicion;
        int coordenadaXDelObjeto = ((Posicion) obj).getCoordenadaX();
        int coordenadaYDelObjeto = ((Posicion) obj).getCoordenadaY();
        return ((ok) && (this.coordenadaX == coordenadaXDelObjeto) && (this.coordenadaY == coordenadaYDelObjeto)) ;
    }

    public int hashCode(){
        int resul = (this.coordenadaX)+(this.coordenadaY);
        return resul;
        //Entonces cuando tengan las mismas coordenadas me los manda al mismo Bucket, lo cual llama a Equals
    }
}
