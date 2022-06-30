
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class TextoComenzar extends GameObject implements Renderable {

	private final int Y = (int)(455 * 0.75);

	private Text text;
	private VBox render;

	public TextoComenzar() {
		text = new Text("Interactue para comenzar");

		render = new VBox(text);
		render.setAlignment(Pos.TOP_CENTER);
		render.setTranslateY(Y);
		// Esto deberÃ­a heredarse?
		render.setPrefWidth(755);

		Font font = Font.font("Bauhaus 93", FontWeight.NORMAL, 40);
		text.setTextAlignment(TextAlignment.CENTER);
		text.setFont(font);
		text.setFill(Color.BLACK);
		text.setStroke(Color.WHITE);
	}

	@Override
	public Node getRender() {
		return render;
	}

	@Override
	public void destroy() {	}
	
}
