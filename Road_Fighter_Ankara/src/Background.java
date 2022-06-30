
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;


public class Background extends GameObject implements Updatable, Renderable {

	private VBox render;
	private double posY = 0;

	private final int roadWidth = 755;
	private final int roadHeight = 900;

	public Background() {
 
		Image backgroundImage = new Image("file:src/files/background.png", roadWidth, roadHeight, false, true);

		ImagePattern image_pattern = new ImagePattern(backgroundImage, 755, 456, 755, 456, false);

		Rectangle road = new Rectangle(755, 456);

		road.setFill(Color.rgb(84, 192, 201));

		render = new VBox(road);
		road.setFill(image_pattern);
		// TODO zIndex list
		render.setViewOrder(30);
	}
	
	public double getPosY() {
		return posY;
	}

	@Override
	public Node getRender() {
		return render;
	}

	@Override
	public void update(double deltaTime) {
	}

	@Override
	public void destroy() { }

}
