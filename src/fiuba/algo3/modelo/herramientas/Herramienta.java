package fiuba.algo3.modelo.herramientas;

import fiuba.algo3.modelo.materiales.*;
import fiuba.algo3.modelo.desgastes.Desgaste;

import java.util.ArrayList;
import java.util.List;

public abstract class Herramienta {
    /*Para nuestra implementacion no seria necesario guardar una referencia al material con el que esta hecha
    la herramienta, ya que esta va a devolver un objeto de tipo Herramienta+Material y se va a manipular la
    herramienta y no el materia, pero si en el futuro se quisiese hacer algo con el material con el que esta hecha
    la herramienta, seria util poder acceder directo desde la herramienta y ver cuanta durabilidad tiene el objeto
    material. EJEMPLO: Queres reparar o mejorar la herramienta y tal material necesita una durabilidad mas para
    convertirse en una mejor herramienta...*/
    protected List<Material> tipoDeMateriales = new ArrayList<Material>();
    protected Desgaste tipoDeDesgaste;

    public int getDurabilidad(){
        return this.tipoDeDesgaste.getDurabilidad();
    }

    public int getFuerza(){
        return this.tipoDeDesgaste.getFuerza();
    }

    public Material getMaterial() {
        return this.tipoDeMateriales.get(0);
    }

    public void usar(Diamante material){
        this.tipoDeDesgaste.usar();
    }
    public void usar(Madera material){
        this.tipoDeDesgaste.usar();
    }
    public void usar(Metal material){
        this.tipoDeDesgaste.usar();
    }
    public void usar(Piedra material){
        this.tipoDeDesgaste.usar();
    }
}
