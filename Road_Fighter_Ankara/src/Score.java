
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;


public class Score extends GameObject implements Renderable {
	private final int Y = 15;
	private int score = 0;

	private Text scoreText;
	private Text maxScoreText;
	private VBox render;

//	private Animation zoomAnimation;
//	private AudioClip pointAudio;

	public Score() {
		scoreText = new Text(" Score:\n" + score);

		render = new VBox(scoreText);
		render.setSpacing(5);
		render.setAlignment(Pos.TOP_RIGHT);
		render.setTranslateY(Y);
		render.setPrefWidth(100);

		scoreText.setTextAlignment(TextAlignment.RIGHT);
		scoreText.setFont(Font.font("Bauhaus 93", 40));
		scoreText.setFill(Color.BLACK);
		

		DropShadow ds = new DropShadow();
		ds.setColor(Color.WHITE);
		scoreText.setEffect(ds);
	}

	@Override
	public Node getRender() {
		return render;
	}

	public void increase(double score) {
		scoreText.setText(" Score:\n" + (int)score/10);
	}

	@Override
	public void destroy() {	}
	
}
