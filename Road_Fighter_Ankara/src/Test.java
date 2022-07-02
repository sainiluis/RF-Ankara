import junit.framework.TestCase;

public class Test extends TestCase {

//	public void testAcelerar() {
//		AutomovilJugador auto1 = new AutomovilJugador(1, new Punto(5.00, 0.00));
//
//		// Al pulsar acelerar, acelera 5
//		auto1.acelerar();// 5
//
//		assertEquals(auto1.getVelocidad(), 5.00);
//
//		auto1.acelerar();// 10
//
//		assertEquals(auto1.getVelocidad(), 10.00);
//
//		auto1.acelerar();// 15
//		auto1.acelerar();// 20
//		auto1.acelerar();// 25
//		auto1.acelerar();// 30
//		auto1.acelerar();// 35
//		auto1.acelerar();// 40
//		auto1.acelerar();// 45
//		auto1.acelerar();// 50
//		auto1.acelerar();// 55
//
//		// testeo que la velocidad m�xima sea 50
//		assertEquals(auto1.getVelocidad(), 50.00);
//
//		// testeo de frenado
//
//		auto1.frenar();// 40
//
//		assertEquals(auto1.getVelocidad(), 40.00);
//
//		auto1.frenar();// 30
//		auto1.frenar();// 20
//		auto1.frenar();// 10
//		auto1.frenar();// 0
//		auto1.frenar();// -10
//
//		// verifico que luego de frenar varias veces, la velocidad no sea menor a cero
//
//		assertEquals(auto1.getVelocidad(), 0.00);
//
//		// verifico que el choque realice el efecto esperado
//
//		AutomovilBot bot1 = new AutomovilBot(1, new Punto(10.00, 15.00));
//
//		// posici�n del auto1 x=5
//		// posici�n del bot1 x=10
//		// caso en que auto1 choca por la izquierda al bot1.
//
//		auto1.chocar(bot1);
//
//		assertEquals(auto1.getX(), 4.00); // auto1 se mover� hacia la izquierda (x=4)
//		assertEquals(bot1.getX(), 11.00); // bot1 se mover� hacia la derecha (x=11)
//
//		// El choque tambi�n puede ser frontal o trasero
//		// caso en que auto1 choca a bot2 por atr�s
//
//		AutomovilBot bot2 = new AutomovilBot(1, new Punto(4.00, 15.00));
//		auto1.acelerar(); // 5
//		auto1.acelerar(); // 10
//		auto1.acelerar(); // 15
//		auto1.acelerar(); // 20
//		auto1.acelerar(); // 25
//		auto1.acelerar(); // 30
//		auto1.acelerar(); // 35
//		auto1.acelerar(); // 40
//
//		auto1.chocar(bot2);// auto1 choca al bot2
//
//		assertEquals(bot2.getVelocidad(), 35.00); // bot2 acelerara por el efecto del choque trasero
//		// por defecto ya viene con una velocidad constante de 30
//
//		assertEquals(auto1.getVelocidad(), 30.00); // auto1 reducir� su velocidad por el choque
//		// auto1 ven�a con una velocidad de 40 antes del choque
//
//		// testo el choque de un auto contra un obst�culo
//
//		Obstaculo obstaculo1 = new Obstaculo(1, new Punto(4.00, 20.00));
//
//		// Si el auto choca un obst�culo, explota
//		// esto producir� que su velocidad se haga cero.
//		auto1.chocar(obstaculo1); // dentro de chocar() se llama a explotar()
//
//		assertEquals(auto1.getVelocidad(), 0.00);
//
//		// testeo que si inicio la habilidad modo fantasma
//		// no genera ningun efecto al chocar un obst�culo
//
//		AutomovilJugador auto2 = new AutomovilJugador(2, new Punto(4.00, 18.00));
//
//		auto2.acelerar();// 5
//		auto2.acelerar();// 10
//
//		auto2.iniciarHabilidad();
//		auto2.chocar(obstaculo1);
//
//		assertEquals(auto2.getVelocidad(), 10.00);// el auto no se detuvo
//		// la velocidad sigue siendo la misma
//	}

}
