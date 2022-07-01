import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import junit.framework.TestCase;

public class Tests extends TestCase {
	
	@Test
	public void testMoverseEnX() {

		AutomovilJugador a1 = new AutomovilJugador(2,new Punto(200,50));
		
		a1.setDead(false);
		
		//Moverse a la derecha
		a1.setDirectionRight(true);
		a1.update(0.2);
		assertEquals(260.00,a1.getX());
		
		//Moverse a la izquierda
		a1.setDirectionRight(false);
		a1.setDirectionLeft(true);
		a1.update(0.2);
		assertEquals(200.00,a1.getX());
	}
	
	
}
