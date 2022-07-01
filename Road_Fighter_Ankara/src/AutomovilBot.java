
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;


public class AutomovilBot extends Automovil implements Updatable, Renderable, Collideable {

	private final int VELOCIDAD_CONSTANTE = 30;
	private ImageView render;
	private boolean speedUp;
	private double posY = 0;

	public AutomovilBot(int color, Punto posicion) {
		super(color, posicion);
		this.velocidad = VELOCIDAD_CONSTANTE;
		
		int r = (int) (Math.random() * (7));

		Image spriteImages = new Image("file:src/files/bot" + "0" + r + ".png", 40, 78, false, false);

		render = new ImageView(spriteImages);

		speedUp = true;

		collider = new Rectangle(posicion.getX() - width / 2, posicion.getY()  - height , width, height);
		collider.setFill(null);
		collider.setStroke(Color.FUCHSIA);
		
		render.setViewOrder(10);

		setX(posicion.getX());
		setY(posicion.getY());
	}

	@Override
	public void explotar() {
		// TODO Auto-generated method stub
		// Eliminar auto
	}

	@Override
	public void update(double deltaTime) {
		if (speedUp) {
			posY += 500 * deltaTime;
			render.setTranslateY(posY);
			collider.setY(posY-100);
		} else {
			posY -= 500 * deltaTime;
			render.setTranslateY(posY);
			collider.setY(posY-100);
		}
	}

	public void serChocado(Automovil chocador) {

		if (!chocador.isModoFantasma()) {
			int sentidoChoque = -1;
			if (this.posicion.getX() > chocador.posicion.getX()) {
				sentidoChoque = 1;
			}
			this.perderControl(sentidoChoque);
			this.acelerar();
			chocador.frenar();
			chocador.perderControl(sentidoChoque * -1);
		}
	}

	@Override
	public void perderControl(int sentido) {
		this.posicion.sumarX(sentido);

	}

	@Override
	public Node getRender() {
		return render;
	}

	public void setSpeedUp(boolean b) {
		speedUp = b;
	}

	public void setX(double x) {
		posicion.setX(x);
		render.setX(x);
		collider.setX(x);
	}

	public void setY(double y) {
		posicion.setY(y);
		render.setY(y);
		collider.setY(y);
	}

	public double getX() {
		return posicion.getX();
	}

	public double getY() {
		return posicion.getY();
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

	@Override
	public Shape getCollider() {
		return collider;
	}

	public void collide(Collidator collidator) {
		// TODO Auto-generated method stub
	}

}
