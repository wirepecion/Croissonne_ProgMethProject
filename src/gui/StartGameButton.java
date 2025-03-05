package gui;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;

public class StartGameButton extends Button {
	
	public StartGameButton() {
		//initialize button
		initializeStartButton();
	}
	
	private void initializeStartButton() {
		
		//set's button style
		setText("START");
		setAlignment(Pos.CENTER);
		setFont(new Font("Arial", 60));
		setPadding(new Insets(10, 100, 10, 100));
		VBox.setMargin(this, new Insets(100, 0, 0, 0));
		
		//set event-handler
		setOnMouseClicked(e -> {
			GameManager.getInstance().switchToSelectPlayerScene();
		});
	}
}
