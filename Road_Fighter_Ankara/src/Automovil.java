
import javafx.scene.Node;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;

public abstract class Automovil extends GameObject implements Updatable, Renderable {

	protected double velocidad;
	protected Punto posicion;
	private final int VELOCIDAD_MAXIMA = 50;
	

	protected final int width = 40;
	protected final int height = 78;

	protected Rectangle collider;

	Text gameOverText;

	public Automovil(int color, Punto posicion) {

		this.posicion = posicion;

	}

	public abstract Node getRender();

	protected abstract void setY(double d);

	protected abstract void setX(double d);

	public abstract void explotar();

	public abstract void perderControl(int sentido);

	public void avanzar() {
		this.posicion.incY(this.velocidad);
	}

	public void acelerar() {

		for (int i = 0; i < 5; i++) {
			if (this.velocidad + 1 <= VELOCIDAD_MAXIMA) {
				this.velocidad++;
			}
		}
		this.avanzar();
	}

	public void frenar() {

		for (int i = 0; i < 10; i++) {
			if (this.velocidad - 1 >= 0) {
				this.velocidad--;
			}
		}
	}

	public void chocar(AutomovilBot chocado) {
		chocado.serChocado(this);
	}

	public double getVelocidad() {
		return velocidad;
	}




}
