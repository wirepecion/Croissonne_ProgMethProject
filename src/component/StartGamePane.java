package component;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;

public class StartGamePane extends VBox {
	private static final String  TITLE_TEXT = "Croissonne";
	private static final String  SUBTITLE_TEXT = "Click Start To Begin!";
	private Label titleLabel;
	private Label subtitleLabel;
	private Button startButton;
	
	public StartGamePane() {
		initializeLabel();
		initializeStartButton();
		setBackground(new Background(new BackgroundFill(Color.LIGHTGRAY, CornerRadii.EMPTY, Insets.EMPTY)));
		setPrefHeight(750);
		setPrefWidth(1200);
		setAlignment(Pos.CENTER);
		getChildren().addAll(titleLabel, subtitleLabel, startButton);
	}
	
	private void initializeLabel() {
		titleLabel = new Label(TITLE_TEXT);
		titleLabel.setFont(new Font("Georgia", 120));
		titleLabel.setPadding(new Insets(10));
//		titleLabel.setMinWidth(40);
//		titleLabel.setMinHeight(40);
		
		subtitleLabel = new Label(SUBTITLE_TEXT);
		subtitleLabel.setFont(new Font("Cambria", 36));
//		subtitleLabel.setPadding(new Insets(10));
		VBox.setMargin(subtitleLabel, new Insets(0, 10, 70, 10));
	}
	
	private void initializeStartButton() {
		startButton = new Button("START");
		startButton.setAlignment(Pos.CENTER);
		startButton.setFont(new Font("Arial", 60));
		startButton.setPadding(new Insets(10, 100, 10, 100));
		VBox.setMargin(startButton, new Insets(100, 0, 0, 0));
	}
}
