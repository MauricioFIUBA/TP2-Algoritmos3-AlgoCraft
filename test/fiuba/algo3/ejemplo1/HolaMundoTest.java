package fiuba.algo3.ejemplo1;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

public class HolaMundoTest {

	@Test
	public void returnNone(){
        HolaMundo hola = new HolaMundo();
	String result = hola.Hola("mundo!");
		assertEquals("Hola mundo!", result);
	}
}
