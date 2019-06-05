import Desgastes.Desgaste;
import Materiales.Material;

public abstract class Herramienta {
    /*Para nuestra implementacion no seria necesario guardar una referencia al material con el que esta hecha
    la herramienta, ya que esta va a devolver un objeto de tipo Herramienta+Material y se va a manipular la
    herramienta y no el materia, pero si en el futuro se quisiese hacer algo con el material con el que esta hecha
    la herramienta, seria util poder acceder directo desde la herramienta y ver cuanta durabilidad tiene el objeto
    material. EJEMPLO: Queres reparar o mejorar la herramienta y tal material necesita una durabilidad mas para
    convertirse en una mejor herramienta...*/
    protected Material tipoDeMaterial;
    protected Desgaste tipoDeDesgaste;
    //protected int durabilidadHerramienta;
    //protected int fuerza;
    //public int getDurabilidad(){
     //   return this.durabilidadHerramienta;
    public Herramienta(){
        this.inicializarDesgaste();
    }
    public abstract void inicializarDesgaste();
    public int getDurabilidad(){
        return this.tipoDeDesgaste.getDurabilidad();
    }
    public int getFuerza(){
        return this.tipoDeDesgaste.getFuerza();
    }
    public void usar(){
        this.tipoDeDesgaste.usar();
    }
}
    //public int getFuerza(){
      //  return this.fuerza;
    //

