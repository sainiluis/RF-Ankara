
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Stage;


public class Main /*extends Application*/ {
	
//	private Stage stage;
//	
//	private MenuSceneHandler menuSceneHandler;
//	private GameSceneHandler gameSceneHandler;
//	
//	AutomovilJugador auto1;
//	AutomovilBot auto2;
//	long previousNanoFrame;
//	
//	Text gameOverText;
//	Group root;
//	
//	int choque;
//	
//	@Override
//	public void start(Stage stage) throws Exception {
//		
//		
//		menuSceneHandler = new MenuSceneHandler(this);
//		Scene scene = menuSceneHandler.getScene();
//		stage.setScene(scene);
//		
//		menuSceneHandler.load();
//		
//		stage.setTitle("Road Fighter - Ankara");
//		stage.getIcons().add(new Image("file:src/files/car1.png"));
//		stage.show();
//
//		root = new Group();
//		Scene currentScene = new Scene(root);
//
//		stage.centerOnScreen();
//		Image background = new Image("file:src/files/background2.png", 755, 456, false, false);
//		ImageView imageView = new ImageView(background);
//	
//		//Application Icon
//
//		root.getChildren().add(imageView);
//
//		stage.setScene(currentScene);
//
//		auto1 = new AutomovilJugador(1, new Punto(500,400));
//		root.getChildren().add(auto1.getRender());
//
//		auto2 = new AutomovilBot(1, new Punto(450,250));
//		root.getChildren().add(auto2.getRender());
//		addUpdateEachFrameTimer();
//		
///////////////////		
//		currentScene.addEventHandler(KeyEvent.KEY_PRESSED, new EventHandler<KeyEvent>() { 
//
//			@Override
//			public void handle(KeyEvent e) {
//				switch (e.getCode()) {
//				case RIGHT:
//				case D:
//					auto1.setDirectionRight(true);
//					break;
//				case LEFT:
//				case A:
//					auto1.setDirectionLeft(true);
//					break;
//				case UP:
//				case W:
//					auto1.setSpeedUp(true);
//					break;
//				default:
//					break;
//				}
//			}
//			
//		});
//
//		currentScene.addEventHandler(KeyEvent.KEY_RELEASED, new EventHandler<KeyEvent>() {
//
//			@Override
//			public void handle(KeyEvent e) {
//				switch (e.getCode()) {
//				case RIGHT:
//				case D:
//					auto1.setDirectionRight(false);
//					break;
//				case LEFT:
//				case A:
//					auto1.setDirectionLeft(false);
//					break;
//				case UP:
//				case W:
//					auto1.setSpeedUp(false);
//					break;
//				default:
//					break;
//				}
//			}
//		});
//	}
////////////////
//
//	private void addUpdateEachFrameTimer() {
//		previousNanoFrame = System.nanoTime();
//		AnimationTimer gameTimer = new AnimationTimer() {
//			@Override
//			public void handle(long currentNano) {
//				//Update tick
//				update((currentNano-previousNanoFrame)/1_000_000_000.0);//cant de nanos en un segundo
//				previousNanoFrame = currentNano;
//			}
//		};
//		gameTimer.start();
//	}
//	
//	protected void update(double deltaTime) {
//		choque=auto1.update(deltaTime, auto2.getX(), auto2.getY());
//		if(choque==-1) {
//			GameOverText();
//		}
//	}
//	
//	public static void main(String[] args) {
//		launch();
//	}
//	
//	public void startGame() {
//		menuSceneHandler.unload();
//		gameSceneHandler = new GameSceneHandler(this);
//		Scene scene = gameSceneHandler.getScene();
//		stage.setScene(scene);
//		gameSceneHandler.load(true);
//	}
//
//	public void startMenu() {
//		gameSceneHandler.unload();
//		menuSceneHandler = new MenuSceneHandler(this);
//		Scene scene = menuSceneHandler.getScene();
//		stage.setScene(scene);
//		menuSceneHandler.load();
//	}
//
//	public void GameOverText() {
//        gameOverText = new Text(140, 200, "\tGAME OVER!\n");
//        gameOverText.setFill(Color.WHITE);
//        gameOverText.setFont(new Font(35));
//        root.getChildren().add(gameOverText);
//    }
}
