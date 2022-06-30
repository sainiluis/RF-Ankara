
import javafx.scene.Node;
import javafx.scene.layout.VBox;


public class BotBuilder extends GameObject implements Updatable {
	private boolean speedUp=true;
	private VBox render;
	
	private final long NANOS_IN_SECOND = 1_000_000_000;

	private boolean running = false;
	private long pipeTime;
	
	AutomovilBot autoBot;
	
	public BotBuilder() {

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
		double random = Math.random();
		
		AutomovilBot autoBot = new AutomovilBot(2,new Punto((int)(Math.random()*(500-250+1)+250),-100));

		GameObjectBuilder.getInstance().add(autoBot);
		autoBot.setSpeedUp(speedUp);
		
	}
	
	
	public void destroy() {	}
}
