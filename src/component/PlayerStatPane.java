package component;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import utils.PlayerColor;

public class PlayerStatPane extends GridPane{
	
	private Player player;
	
	public PlayerStatPane(Player player) {		
		setPlayer(player);
		setPrefHeight(100);
		setPrefWidth(300);
		setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	
	public void setPlayer(Player player) {
		this.player = player;
	}
}
