package fiuba.algo3.modelo.materiales;

import fiuba.algo3.modelo.herramientas.*;

public class Metal extends Material {
    public Metal() {
        durabilidad = 50;
    }

    public void desgastarse (Pico pico) {
        pico.usar();
        Material material = pico.getMaterial();

        try {
            if(!Class.forName("fiuba.algo3.modelo.materiales.Madera").isInstance(material)) {
                durabilidad -= pico.getFuerza();
            }
        } catch(Exception e) {
            System.out.println(e + "ErrorFatal");
        }

    }
}
