import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


public class GameOver extends GameObject implements Renderable {
	private final int Y = 15;

	private Text gameOverText;
	private Text textRestart;
	private VBox render;

	public GameOver(double score, boolean gano) {
		if (gano) {
			gameOverText = new Text("        CONGRATULATIONS\n       Ha ganado!");
			textRestart = new Text("\n\n\n       Press 'R' to restart");
			gameOverText.setFill(Color.GREEN);

		} else {
			if(score <= 0) {
				gameOverText = new Text("      Game Over\n\tSu puntaje fue: " + 0);
				textRestart = new Text("\n\n\n       Press 'R' to restart");
				gameOverText.setFill(Color.RED);
			}
		}
		render = new VBox(gameOverText, textRestart);
		render.setSpacing(5);
		render.setAlignment(Pos.CENTER);
		render.setTranslateY(Y);

		render.setPrefWidth(100);

		gameOverText.setTextAlignment(TextAlignment.CENTER);
		gameOverText.setFont(Font.font("Bauhaus 93", 60));

		textRestart.setTextAlignment(TextAlignment.CENTER);
		textRestart.setFont(Font.font("Consolas", 35));
		textRestart.setFill(Color.BLACK);

		DropShadow ds = new DropShadow();
		ds.setColor(Color.BLACK);

		DropShadow ds2 = new DropShadow();
		ds2.setColor(Color.WHITE);
		textRestart.setEffect(ds2);
		gameOverText.setEffect(ds2);
	}

	@Override
	public Node getRender() {
		return render;
	}

	@Override
	public void destroy() {
	}
}
