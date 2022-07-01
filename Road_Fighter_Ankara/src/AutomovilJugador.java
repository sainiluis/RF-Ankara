
import java.util.Timer;
import java.util.TimerTask;
import javafx.animation.Animation;
import javafx.geometry.Rectangle2D;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class AutomovilJugador extends Automovil implements Updatable, Renderable, Collidator {
	private double coolDown;
	private double duracionSkill;
	private ImageView render;
	private int health = 2;

	private final int speed = 300; // pixeles x seg
	private boolean directionLeft = false;
	private boolean directionRight = false;
	private boolean speedUp = false;
	private boolean dead = false;
	SpriteAnimation explotionAnimation;
	private double deltaTime;
	private boolean fx=false;
	
	private boolean modoFantasma=false;
	private long CooldownmodoFantasma=5000;
	private long timeModoFantasma=-1;
	private long  timeExecutionModoFantasma=10000;
	
	
	
	private boolean choque=false;
	
	public AutomovilJugador(int color, Punto posicion) {
		super(color, posicion);
		this.coolDown = 25;
		this.duracionSkill = 7;
		this.velocidad = 0;

		setX(posicion.getX());
		setY(posicion.getY());
	}
	
	public void iniciarFX() {
		collider = new Rectangle(posicion.getX() - width / 2, posicion.getY() - height , 45, 88);
		collider.setFill(null);
		collider.setStroke(Color.FUCHSIA);

		Image spriteImages = new Image("file:src/files/sprites.png", 530, 100, false, false);

		render = new ImageView(spriteImages);
		render.setX(posicion.getX() - width / 2);
		render.setY(posicion.getY() - height);
		resetViewport();
		
		render.setViewOrder(10);
		
		explotionAnimation = new SpriteAnimation(render, Duration.millis(200), 6, 1, 81, 7, 24, 43, 86);

		explotionAnimation.setCycleCount(Animation.INDEFINITE);
		
		fx=true;
	}

	private void resetViewport() {
		render.setViewport(new Rectangle2D(11, 5, 43, 86));
	}

	public void setX(double x) {
		posicion.setX(x);
		if(fx) {
			render.setX(x);
			collider.setX(x);
		}
	}

	public void setY(double y) {
		posicion.setY(y);
		if(fx) {
			render.setY(y);
			collider.setY(y);
		}
	}

	@Override
	public void explotar() {
		if (this.isModoFantasma() == false) {
			this.velocidad = 0;
		}

	}

	@Override
	public void perderControl(int sentido) {
		if (this.isModoFantasma() == false) {
			this.posicion.sumarX(sentido);
		}
	}

	public void moverse(double sentido) {
		this.posicion.sumarX(sentido);
	}

	public void serChocado(Automovil chocador) {

		if (!this.isModoFantasma()) {
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

	public void setModoFantasma(boolean modoFantasma) {
		this.modoFantasma = modoFantasma;
	}
	
	public void iniciarHabilidad() {

		if(System.currentTimeMillis() > timeModoFantasma + (CooldownmodoFantasma) ) {
			System.out.println("Tiempo sistema" + System.currentTimeMillis());
			System.out.println("Tiempo modoFantasma" + timeModoFantasma);
			this.setModoFantasma(true);
			timeModoFantasma=System.currentTimeMillis();
		}
	}
	public void updateModoFantasma() {
		if(System.currentTimeMillis() > timeModoFantasma + (timeExecutionModoFantasma)  ) {
			this.setModoFantasma(false);
		}
	}

	public void destroy() {
		// TODO Auto-generated method stub

	}

	public Node getRender() {
		return render;
	}

	public ImageView getRender2() {
		return render;
	}

	public double getX() {
		return posicion.getX();
	}

	public double getY() {
		return posicion.getY();
	}

	public void setDirectionRight(boolean a) {
		if (!dead) {
			this.directionRight = a;
		}
		checkHorizontal();
	}

	private void checkHorizontal() {
		if (directionLeft) {

		}
	}

	public void setSpeedUp(boolean a) {
		this.speedUp = a;
		checkHorizontal();
	}

	public void setDirectionLeft(boolean a) {
		if (!dead) {
			this.directionLeft = a;
		}

		checkHorizontal();
	}

	@Override
	public void update(double deltaTime) {
		this.deltaTime=deltaTime;
		if (directionLeft || directionRight) {
			int direction = directionLeft ? -1 : (directionRight ? 1 : 0);
			if ((posicion.getX() + direction * speed * deltaTime > 180)
					&& (posicion.getX() + direction * speed * deltaTime < 520)) {
				setX(posicion.getX() + direction * speed * deltaTime);
				if(fx) {
					collider.setX(posicion.getX());
				}
			}
		}
	}

	public Shape getCollider() {
		return collider;
	}

	public void collide(Collideable collideable) {
		//Si choco un obstaculo pierdo el control
		if(collideable.getClass().equals(Obstaculo.class) && !modoFantasma) {
				setX(posicion.getX() + speed * deltaTime * 4 );
				collider.setX(posicion.getX());
		}
		else if(collideable.getClass().equals(AutomovilBot.class) && !modoFantasma) {
			setX(posicion.getX() + speed * deltaTime * 4 );
			collider.setX(posicion.getX());
			System.out.println("Chocó");
		}
	}

	public boolean isDead() {
		return dead;
	}

	public void deadAnimation() {
		explotionAnimation.play();
	}
	
	public int getHealth() {
		return health;
	}
	
	public void restarHealth() {
		health--;
	}
	
	public void setDead(boolean b) {
		this.dead = b;
	}
	
	public boolean getChoque() {
		return choque;
	}
	
	public void setChoque(boolean b) {
		this.choque=b;
	}
	public boolean isModoFantasma() {
		return this.modoFantasma;
	}
}
