package fiuba.algo3.ejemplo1;

import junit.framework.Assert;
import org.junit.Test;

public class HolaMundoTest {

	@Test
	public void returnNone(){
        HolaMundo hola = new HolaMundo();
	String result = hola.Hola("mundo!");
        Assert.assertEquals("Hola mundo!", result);
	}
}
