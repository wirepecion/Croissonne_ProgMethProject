package gui;

import data.ResourceLoader;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.Pane;

public class HowToPlayPane extends Pane {
	
	public HowToPlayPane() {
		setPrefHeight(750);
		setPrefWidth(1200);
		setBackground(new Background(new BackgroundImage(ResourceLoader.getHowToPlayImage(), null, null, null, null)));;
	}
}
