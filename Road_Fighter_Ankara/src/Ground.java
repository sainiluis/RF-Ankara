
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;

public class Ground /*extends GameObject implements Updatable, Renderable, Collideable*/ {
	
//	private double posX = 0;
//
//	private VBox render;
//	
//	private Rectangle collider;
//
//	public Ground() {
//		Image backgroundImage = new Image("file:src/files/grass.png", 24, 88, false, false);
//
//		ImagePattern image_pattern = new ImagePattern(backgroundImage, 24, 88, 24, 88, false);
//
//		Rectangle ground = new Rectangle(100+ 24, 88);
//		ground.setFill(image_pattern);
//
//		render = new VBox(ground);
//		render.setTranslateY(100 - 50);
//
//		collider = new Rectangle(0, 100 - 50, 100, 100);
//		collider.setFill(null);
//		collider.setStroke(Color.FUCHSIA);
//		collider.setStrokeWidth(2);
//	}
//
//	public double getPosX() {
//		return posX;
//	}
//
//	@Override
//	public Node getRender() {
//		return render;
//	}
//
//	@Override
//	public void update(double deltaTime) {
//		posX += -150 * deltaTime;
//
//		render.setTranslateX(posX % 24);
//	}
//	
//	@Override
//	public Shape getCollider() {
//		return collider;
//	}
//	
//	@Override
//	public void destroy() {	}
}
