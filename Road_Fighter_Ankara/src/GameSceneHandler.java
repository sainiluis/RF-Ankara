import java.util.List;
import javafx.animation.TranslateTransition;
import javafx.event.EventHandler;
import javafx.geometry.Bounds;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.media.AudioClip;
import javafx.scene.paint.Color;
import javafx.scene.shape.Shape;
import javafx.util.Duration;


public class GameSceneHandler extends SceneHandler {

	private AutomovilJugador a1;
	private Road road;
	private BotBuilder botBuilder;
	private ObstaculoBuilder obstaculoBuilder;
	private Score score;
	GameOver gameOver;

	boolean started = false;
	boolean ended = false;
	double scoreFinal;
	private boolean gano=false;
	
	Cooldown coolDownText;
	
	private boolean movimiento;
	private AudioClip frenar = AudioResources.getFrenaAudio();
	private AudioClip acelerar = AudioResources.getAceleraAudio();
	private AudioClip ganador = AudioResources.getWinnerAudio();
	
	
	public GameSceneHandler(RoadFighterGame g) {
		super(g);

	}

	protected void prepareScene() {
		Group rootGroup = new Group();
		scene = new Scene(rootGroup, 755, 455, Color.BLACK);
		// scene2 = new Scene();
	}

	protected void defineEventHandlers() {

		mouseEventHandler = new EventHandler<MouseEvent>() {
			@Override
			public void handle(MouseEvent event) {
				if (event.getButton() == MouseButton.PRIMARY) {
					// makeAction();
				}
			}
		};

		scene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent e) {
				switch (e.getCode()) {
				case W:
				case UP:
					//score.increase(true);
					makeAction(true);
					
					
					break;
				case A:
				case LEFT:
					//score.increase(true);
					if(movimiento) {
						a1.setDirectionLeft(true);
					}
					
					break;
				case D:
				case RIGHT:
					//score.increase(true);
					if(movimiento) {
						a1.setDirectionRight(true);
					}
					break;
				case R:
					restart();
					break;
				case Q:
				case ESCAPE:
					g.startMenu();
					break;
				case Z:
                    a1.iniciarHabilidad();
                    break;
				default:
					break;
				}
			}
		});

		scene.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent e) {
				switch (e.getCode()) {
				case W:
				case UP:
					//score.increase(false);
					makeAction(false);
					botBuilder.stopBuilding();
					obstaculoBuilder.stopBuilding();
//					acelerar.stop();
//					frenar.play();
//					estaAcelerando=0;
					
					break;
				case A:
				case LEFT:
					//score.increase(false);
					a1.setDirectionLeft(false);
					break;
				case D:
				case RIGHT:
					//score.increase(false);
					a1.setDirectionRight(false);
					break;
				case R:
					restart();
					break;
				case Q:
				case ESCAPE:
					g.startMenu();
					break;
				default:
					break;
				}
			}
		});
	}

	public void load(boolean fullStart) {
		Group rootGroup = new Group();
		scene.setRoot(rootGroup);

		score = new Score();
		ganador.stop();
		a1 = new AutomovilJugador(2, new Punto(380, 340));
		a1.iniciarFX();
		road = new Road();
		botBuilder = new BotBuilder();
		obstaculoBuilder = new ObstaculoBuilder();
		coolDownText = new Cooldown();

		// Add to builder
		GameObjectBuilder gameOB = GameObjectBuilder.getInstance();
		gameOB.setRootNode(rootGroup);
		gameOB.add(road, a1, botBuilder, obstaculoBuilder, score,coolDownText);

		if (fullStart) {
			addTimeEventsAnimationTimer();
			addInputEvents();
		}
	}

	public void restart() {
		cleanData();
		load(false);
	}

	private void cleanData() {
		GameObjectBuilder.getInstance().removeAll();
		ended = false;
		started = false;
		// Config.baseSpeed = 250;
	}

	private void makeAction(boolean b) {
		
		movimiento=b;
		
		if(b && road.getSpeedUp()==false) {
			frenar.stop();
			acelerar.play();
			//estaAcelerando=1;
			
		}else if (!b && road.getSpeedUp()) {
			acelerar.stop();
			frenar.play();
			
		}

		if (!ended) {
			started = b;
			road.setSpeedUp(b);
			botBuilder.startBuilding(NANOS_IN_SECOND, b);
			obstaculoBuilder.startBuilding(NANOS_IN_SECOND, b);
			GameObjectBuilder.getInstance().getBots(b);
			GameObjectBuilder.getInstance().getObstaculos(b);
			
		} else {
			road.setSpeedUp(false);
			acelerar.stop();
			frenar.stop();
			GameObjectBuilder.getInstance().getBots(false);
			GameObjectBuilder.getInstance().remove(score);

		}
	}

	public void update(double delta) {
		super.update(delta);
		
		a1.updateModoFantasma();
		coolDownText.updateCooldown(a1.getTiempoActivo(),a1.getCoolDown());
		
		if(movimiento) {
			score.increase(1);
		}
		
		scoreFinal = road.getScore();

		checkFinish();
		if (!ended) {
			checkColliders();
			if (a1.isDead()) {

				a1.deadAnimation();
				gameOver = new GameOver(scoreFinal, !a1.isDead());
				GameObjectBuilder.getInstance().add(gameOver);
				ended = true;
				botBuilder.stopBuilding();
				obstaculoBuilder.stopBuilding();
				a1.setSpeedUp(false);
				road.setSpeedUp(false);
				// Improve
				TranslateTransition tt = new TranslateTransition(Duration.millis(50), scene.getRoot());

				tt.playFromStart();
				tt.setOnFinished(event -> {
					scene.getRoot().setTranslateY(0);
				});
			}
		} else {
			gameOver = new GameOver(scoreFinal, !a1.isDead());
			GameObjectBuilder.getInstance().add(gameOver);
		
		}
	}

	public void checkFinish() {
		
		if (score.getScore() > 1000) {
			ended = true;
			if(!gano) {
				ganador.play();
				gano=true;
			}
			
			botBuilder.stopBuilding();
			obstaculoBuilder.stopBuilding();
			a1.setSpeedUp(false);
			road.setSpeedUp(false);
			TranslateTransition tt = new TranslateTransition(Duration.millis(50), scene.getRoot());

			tt.playFromStart();
			tt.setOnFinished(event -> {
				scene.getRoot().setTranslateY(0);
				
			});
			
			
		}
	}

	private void checkColliders() {
		List<Collidator> collidators = GameObjectBuilder.getInstance().getCollidators();
		List<Collideable> collideables = GameObjectBuilder.getInstance().getCollideables();

		for (int i = 0; i < collidators.size(); i++) {
			Collidator collidator = collidators.get(i);

			for (int j = 0; j < collideables.size(); j++) {
				Collideable collideable = collideables.get(j);
				Shape intersect = Shape.intersect(collidator.getCollider(), collideable.getCollider());

				// TODO test times
				// XXX Si el substract es distinto???
				// Check intersects
				if (intersect.getBoundsInLocal().getWidth() != -1) {
					collidator.collide(collideable);
					if(!a1.isModoFantasma()) {
						score.decrease(20);
					}
					
					if(score.getScore()<=0) {
						a1.setDead(true);
					}

				} else {
					// Check contains
					Bounds collideableBounds = collideable.getCollider().getBoundsInLocal();
					Bounds collidatorBounds = collidator.getCollider().getBoundsInLocal();
					if (collideableBounds.contains(collidatorBounds.getCenterX(), collidatorBounds.getCenterY())) {
						
					}
				}
				
			}
		}
	}

	public void unload() {
		cleanData();
		super.unload();
	}

}
