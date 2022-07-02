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
	
	@Test
	public void testRestarVida() {
		
		AutomovilJugador a1 = new AutomovilJugador(2,new Punto(200,50));
		
		a1.restarHealth();
		
		assertEquals(2,a1.getHealth());
		
	}
	
	@Test
	public void testHabilidad() {
		
		AutomovilJugador a1 = new AutomovilJugador(2,new Punto(200,50));
		
		a1.setModoFantasma(true);
		
		a1.restarHealth();
		
		assertEquals(3,a1.getHealth());
		
	}
	
	@Test
	public void testDead() {

		AutomovilJugador a1 = new AutomovilJugador(2,new Punto(200,50));

		a1.restarHealth();
		a1.restarHealth();
		a1.restarHealth();

		assertEquals(0,a1.getHealth());
		assertEquals(true,a1.isDead());

	}
	
	@Test
	public void testTiempoDeModoFantasma() {

		AutomovilJugador a1 = new AutomovilJugador(2,new Punto(200,50));
		
		a1.iniciarHabilidad();

		while(a1.isModoFantasma()) {
			a1.updateModoFantasma();
		}
		
		assertEquals(false, a1.isModoFantasma());

	}
	
	@Test
	public void testTiempoDeCooldown() {

		AutomovilJugador a1 = new AutomovilJugador(2,new Punto(200,50));
		
		a1.iniciarHabilidad();

		while(a1.isModoFantasma()) {
			a1.updateModoFantasma();
		}
		
		//Chequeamos que no te permita iniciar habilidad si no se cumplió el Cooldown
		a1.iniciarHabilidad();
		
		assertEquals(false, a1.isModoFantasma());
		
		while(!a1.isModoFantasma()) {
			a1.iniciarHabilidad();
		}
		
		assertEquals(true, a1.isModoFantasma());

	}
	
	
}
