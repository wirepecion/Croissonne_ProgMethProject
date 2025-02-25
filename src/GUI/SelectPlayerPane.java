package GUI;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;

public class SelectPlayerPane extends HBox {
	private Button playerButton;
	
	public SelectPlayerPane() {
		Button twoPlayerButton = new Button("2 Players");
		Button threePlayerButton = new Button("3 Players");
		Button fourPlayerButton = new Button("4 Players");
		
		setPlayerButton(twoPlayerButton);
		setPlayerButton(threePlayerButton);
		setPlayerButton(fourPlayerButton);
	}
	
	private void setPlayerButton(Button playerButton) {
		playerButton.setAlignment(Pos.CENTER);
		playerButton.setFont(new Font("Arial", 50));
		playerButton.setPadding(new Insets(10, 70, 10, 70));
		
		playerButton.setOnMouseClicked(e -> {
			
		});
	}
}
