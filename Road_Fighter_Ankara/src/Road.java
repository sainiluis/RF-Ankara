import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.control.Slider;


public class Road extends GameObject implements Updatable, Renderable {
	private VBox render;
	private double posY = 0;

	private final int backgroundMenuWidth = 755;
	private final int backgroundMenuHeight = 900;
	private boolean speedUp=false;
	
	ImageView background;
	ImageView background2;
	Slider speedSlider;
	
	public Road() {

		Image backgroundImage = new Image("file:src/files/road.png", backgroundMenuWidth, backgroundMenuHeight, false, true);

		ImagePattern image_pattern = new ImagePattern(backgroundImage, 755, 900, 755, 900, false);

		Rectangle road = new Rectangle(755, 900);

		render = new VBox(road);
		
		road.setFill(Color.rgb(84, 192, 201));

		render = new VBox(road);
		road.setFill(image_pattern);
		// TODO zIndex list
		render.setViewOrder(15);
	}

	@Override
	public Node getRender() {
		return render;
	}

	public double getY() {
		return posY;
	}
	
	public void setSpeedUp(boolean b) {
		speedUp=b;
	}
	
	public boolean getSpeedUp() {
		return this.speedUp;
	}

	@Override
	public void update(double deltaTime) {
		if(speedUp) {
			posY += 500 * deltaTime;
			render.setTranslateY((posY - 456));
			if(posY > 450) {
				render.setTranslateY(0);
				posY=0;
			}
		}
	}
	
	public double getScore() {
		return -posY;
	}

	@Override
	public void destroy() { }

}
