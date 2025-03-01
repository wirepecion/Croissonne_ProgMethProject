package component;

import GUI.PlayerStatPane;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import utils.PlayerColor;

public class Player {
	
	private PlayerColor color;
	private PlayerStatPane playerStatPane;
	private String name;
	private int score;
	private int penalty;
	
	public Player(String name, PlayerColor playerColor) {
		setColor(playerColor);
		setScore(0);
		setPenalty(0);
		playerStatPane = new PlayerStatPane(this);
	}
	
	public void updateScore(int value) {
		score += value;
		playerStatPane.setScoreText(new Text("Score: " + score));
	}
	
	public void updatePenalty(int value) {
		penalty -= value;
		playerStatPane.setPenaltyText(new Text("Penalty: " + penalty));
	}

	public PlayerColor getColor() {
		return color;
	}

	public void setColor(PlayerColor color) {
		this.color = color;
	}

	public PlayerStatPane getPlayerStatPane() {
		return playerStatPane;
	}

	public void setPlayerStatPane(PlayerStatPane playerStatPane) {
		this.playerStatPane = playerStatPane;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score > 0 ? score : 0;
	}

	public int getPenalty() {
		return penalty;
	}

	public void setPenalty(int penalty) {
		this.penalty = penalty < 0 ? penalty : 0;
	}

}
