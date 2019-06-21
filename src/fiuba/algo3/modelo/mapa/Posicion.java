package fiuba.algo3.modelo.mapa;

public class Posicion {
    private Integer coordenadaX;
    private Integer coordenadaY; //Arrancan en -1 asi cuando se cree una nueva posicion inicia en 0.

    public Posicion(int x, int y) {
        this.coordenadaX = x;
        this.coordenadaY = y;
    }

    public int getCoordenadaX() {
        return this.coordenadaX;
    }

    public int getCoordenadaY() {
        return this.coordenadaY;
    }

    /*Metodos sobreescritos para que el hash pueda comparar dos objetos por Posicion*/
    @Override
    public boolean equals(Object obj) {
        boolean ok = obj instanceof Posicion;
        int coordenadaXDelObjeto = ((Posicion) obj).getCoordenadaX();
        int coordenadaYDelObjeto = ((Posicion) obj).getCoordenadaY();
        return ((ok) && (this.coordenadaX == coordenadaXDelObjeto) && (this.coordenadaY == coordenadaYDelObjeto));
    }


    //Para no recalcular su hash si ya se calculo una vez
    private int hashCode;

    @Override
    public int hashCode() {
        int resultado = hashCode;
        if (resultado == 0) {
            resultado = (this.coordenadaX);
            resultado = 31 * resultado + (this.coordenadaY);
            hashCode = resultado;
        }
        return resultado;
        //Entonces cuando tengan las mismas coordenadas me los manda al mismo Bucket, lo cual llama a Equals
    }

    public boolean estaDentroDeLos(Integer lugares) {
        return ((this.coordenadaX>= 0 && this.coordenadaX<=lugares) && (this.coordenadaY>=0 && this.coordenadaY<=lugares));
    }
}