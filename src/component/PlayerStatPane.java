package component;

import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import utils.PlayerColor;

public class PlayerStatPane extends GridPane{
	private PlayerColor color;
	private String name;
	private int score;
	private int penalty;
	
	
	public PlayerStatPane(String name, int score, int penalty) {
		setName(name);
		setScore(score);
		setPenalty(penalty);
		
		setPrefHeight(100);
		setPrefWidth(300);
		setBackground(new Background(new BackgroundFill(Color.DARKRED, CornerRadii.EMPTY, Insets.EMPTY)));
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public void setPenalty(int penalty) {
		this.penalty = penalty;
	}
}
