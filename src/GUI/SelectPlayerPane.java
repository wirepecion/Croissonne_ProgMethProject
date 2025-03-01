package GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class SelectPlayerPane extends HBox {
	private Button twoPlayerButton;
	private Button threePlayerButton; 
	private Button fourPlayerButton;
	
	public SelectPlayerPane() {
		//initialize button
		twoPlayerButton = new Button("2 Players");
		threePlayerButton = new Button("3 Players");
		fourPlayerButton = new Button("4 Players");
		
		//set button's style and event-handler
		setPlayerButton(twoPlayerButton);
		setPlayerButton(threePlayerButton);
		setPlayerButton(fourPlayerButton);
		
		//set this pane's style
		setAlignment(Pos.CENTER);
		VBox.setMargin(this, new Insets(100, 0, 0, 0));
		
		getChildren().addAll(twoPlayerButton, threePlayerButton, fourPlayerButton);
	}
	
	private void setPlayerButton(Button playerButton) {
		//set button's style
		playerButton.setAlignment(Pos.CENTER);
		playerButton.setFont(new Font("Arial", 50));
		playerButton.setPadding(new Insets(10, 70, 10, 70));
		
		//set button's event-handler
		playerButton.setOnMouseClicked(e -> {
			GameManager.getInstance().switchToInGameScene();
		});
	}
}
