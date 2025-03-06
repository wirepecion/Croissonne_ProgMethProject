package gui;

import data.ResourceLoader;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;

public class HowToPlayPane extends StackPane {
	
	private MyButton homeButton;
	private Pane howToPlayPage01;
	
	public HowToPlayPane() {
		setPrefHeight(750);
		setPrefWidth(1200);
		setBackground(new Background(new BackgroundImage(ResourceLoader.getHowToPlayImage(), null, null, null, null)));
		
		howToPlayPage01 = new Pane();
		initializePage(howToPlayPage01, ResourceLoader.getHowToPlayPageOneBackground());
		initializeHomeButton();
		getChildren().addAll(howToPlayPage01, homeButton);
	}
	
	private void initializePage(Pane pane, Image image) {
		pane.setBackground(new Background(new BackgroundImage(image, null, null, null, null)));
		pane.setPrefHeight(750);
		pane.setPrefWidth(850);
		pane.setLayoutX(200);
	}
	
	private void initializeHomeButton() {
		homeButton = new MyButton();
		homeButton.setPrefHeight(62);
		homeButton.setPrefWidth(62);
		homeButton.setLayoutX(225);
		homeButton.setLayoutY(50);
		homeButton.setOnMouseClicked(e -> {
			GameManager.getInstance().setToStartGamePane();
		});
	}
}
