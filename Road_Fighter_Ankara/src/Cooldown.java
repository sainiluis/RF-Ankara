import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class Cooldown extends GameObject implements Renderable {
	private final int Y = 200;

	private Text coolDown;
	private Text textRestart;
	private VBox render;

	public Cooldown() {
		
		coolDown = new Text("Cooldown");
		coolDown.setFill(Color.RED);
		
		render = new VBox(coolDown);
		render.setSpacing(5);
		render.setAlignment(Pos.CENTER);
		render.setTranslateX(15);
		render.setTranslateY(Y);

		render.setPrefWidth(100);

		coolDown.setTextAlignment(TextAlignment.CENTER);
		Font font = Font.loadFont(ClassLoader.getSystemResource("files/Pixeled.ttf").toString(), 12);
		coolDown.setFont(font);

		DropShadow ds = new DropShadow();
		ds.setColor(Color.BLACK);

		DropShadow ds2 = new DropShadow();
		ds2.setColor(Color.WHITE);
		coolDown.setEffect(ds2);
	}
	
	public void updateCooldown(double dif, double cooldown) {
		
		if(dif >= 0) {
			coolDown.setText("Tiempo activo: " + (int)dif);
			coolDown.setFill(Color.RED);
		}else if(cooldown>=0){
			coolDown.setText("Cooldown: " + (int)cooldown);
			coolDown.setFill(Color.RED);
		}else {
			coolDown.setText("Presione Z \npara activar \n habilidad");
			//coolDown.setEffect(1);
			coolDown.setFill(Color.BLACK);
		}
		
	}

	@Override
	public Node getRender() {
		return render;
	}

	@Override
	public void destroy() {
	}
}