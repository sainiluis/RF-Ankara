
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class Vida extends GameObject implements Renderable {
	private final int Y = 200;

	private Text vidaText;
	private Text corazones;
	private Text textRestart;
	private VBox render;

	public Vida() {
		
		vidaText = new Text("Vida:");
		corazones = new Text("♥ ♥ ♥");
		corazones.setFill(Color.GREEN);
		vidaText.setFill(Color.BLACK);
		
		render = new VBox(vidaText,corazones);
		render.setSpacing(5);
		render.setAlignment(Pos.CENTER);
		render.setTranslateY(Y);

		render.setPrefWidth(1300);

		vidaText.setTextAlignment(TextAlignment.CENTER);
		vidaText.setFont(Font.font("Bauhaus 93", 40));
		corazones.setTextAlignment(TextAlignment.CENTER);
		corazones.setFont(Font.font("Arial", 40));

	}
	
	public void updateVida(int vida) {
		
		if(vida == 2) {
			corazones.setText("♥ ♥" );
			corazones.setFill(Color.ORANGE);
		}else if(vida == 1){
			corazones.setText("♥" );
			corazones.setFill(Color.RED);
		}else if(vida == 0){
			corazones.setText("------" );
			corazones.setFill(Color.RED);
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