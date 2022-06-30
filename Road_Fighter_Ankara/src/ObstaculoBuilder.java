import javafx.scene.layout.VBox;

public class ObstaculoBuilder extends GameObject implements Updatable {
	private boolean speedUp=true;
	private VBox render;
	
	private final long NANOS_IN_SECOND = 1_000_000_000;

	private boolean running = false;
	private long pipeTime;

	
	
	public ObstaculoBuilder() {

	}
	
	//@Override
	public void update(double deltaTime) {
	
			long currentNano = System.nanoTime();

			if (currentNano - pipeTime > 0 && speedUp && running) {
				pipeTime = currentNano + (long) (0.5 * NANOS_IN_SECOND);
				createAutoBot();
			}
	}

	public void startBuilding(long delayInNano, boolean b) {
		speedUp=b;
		running = true;
		this.pipeTime = System.nanoTime() + delayInNano;
	}

	public void stopBuilding() {
		running = false;
	}

	public void createAutoBot() {
		
		Obstaculo o = new Obstaculo(new Punto((int)(Math.random()*(500-250+1)+250),-100));

		GameObjectBuilder.getInstance().add(o);
		o.setSpeedUp(speedUp);
		
	}
	
	
	public void destroy() {	}
}
