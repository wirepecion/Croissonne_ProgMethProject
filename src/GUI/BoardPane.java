package GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;

public class BoardPane extends GridPane {

	public BoardPane() {
		setHgap(10); setVgap(10);
		setPadding(new Insets(10));
		setPrefWidth(800);
		setAlignment(Pos.CENTER);
		setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	
}
