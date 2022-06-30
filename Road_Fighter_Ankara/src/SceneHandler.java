import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import javafx.animation.AnimationTimer;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public abstract class SceneHandler {
	protected final long NANOS_IN_SECOND = 1_000_000_000;
	protected final double NANOS_IN_SECOND_D = 1_000_000_000.0;

	protected int frames = 0;
	protected int last_fps_frame = 0;
	protected AtomicInteger fps = new AtomicInteger(0);

	protected AnimationTimer gameTimer;
	protected long previousNanoFrame;
	protected long previousNanoSecond;
	protected RoadFighterGame g;

	protected Scene scene;
	
	protected EventHandler<KeyEvent> keyEventHandlerPressed;
	protected EventHandler<KeyEvent> keyEventHandlerReleased;
	protected EventHandler<MouseEvent> mouseEventHandler;

	public SceneHandler(RoadFighterGame g) {
			this.g = g;
			prepareScene();
			defineEventHandlers();
	}

	public void oneSecondUpdate(double delta) {
		fps.set(frames - last_fps_frame);
		last_fps_frame = frames;
	}

	public Scene getScene() {
		return scene;
	}

	public void update(double delta) {
		frames++;

//		AutomovilJugador a1 = new AutomovilJugador(1, new Punto(500,400));
//		AutomovilBot a2 = new AutomovilBot(1, new Punto(450,250));

		//updatable.update(delta);
		
		List<Updatable> updatables = GameObjectBuilder.getInstance().getUpdatables();
		for (Updatable updatable : updatables) {

			
			updatable.update(delta);
		}
	}

	protected void addTimeEventsAnimationTimer() {
		gameTimer = new AnimationTimer() {
			@Override
			public void handle(long currentNano) {
				// Update tick
				update((currentNano - previousNanoFrame) / NANOS_IN_SECOND_D);
				previousNanoFrame = currentNano;
	
				// Update second
				if (currentNano - previousNanoSecond > NANOS_IN_SECOND) {
					oneSecondUpdate((currentNano - previousNanoSecond) / NANOS_IN_SECOND_D);
					previousNanoSecond = currentNano;
				}
	
			}
		};
	
		previousNanoSecond = System.nanoTime();
		previousNanoFrame = System.nanoTime();
		gameTimer.start();
	}

	protected void addInputEvents() {
		//scene.addEventHandler(KeyEvent.KEY_PRESSED, keyEventHandlerPressed);
		//scene.addEventHandler(KeyEvent.KEY_RELEASED, keyEventHandlerReleased);
		scene.addEventHandler(MouseEvent.MOUSE_PRESSED, mouseEventHandler);
	}
 
	protected void removeInputEvents() {
		//scene.removeEventHandler(KeyEvent.KEY_PRESSED, keyEventHandlerPressed);
		//scene.removeEventHandler(KeyEvent.KEY_RELEASED, keyEventHandlerReleased);
		scene.removeEventHandler(MouseEvent.MOUSE_PRESSED, mouseEventHandler);
	}
	
	protected abstract void prepareScene();
	protected abstract void defineEventHandlers();

	protected void unload() {
		GameObjectBuilder.getInstance().removeAll();
		gameTimer.stop();
		removeInputEvents();
	}
}
