package GUI;

import component.Player;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class PlayerStatPane extends GridPane{
	
	private Player player;
	private String playerIconURL;
	private Text playerName;
	private Text scoreText;
	private Text penaltyText;
	
	public PlayerStatPane(Player player) {		
		
		ImageView playerIconImg = new ImageView(new Image(ClassLoader.getSystemResource("playerIcons/" + player.getColor().toString() + ".png").toString()));
		playerIconImg.setFitWidth(75);
		playerIconImg.setFitHeight(100);
		
		setPadding(new Insets(10));
		setPrefWidth(300);
		setPrefHeight(100);
		setAlignment(Pos.CENTER);
		setBackground(new Background(new BackgroundFill(Color.AQUA, CornerRadii.EMPTY, Insets.EMPTY)));
		
		VBox playerIcon = new VBox();
		playerIcon.setPrefWidth(110);
		playerIcon.setPrefHeight(100);
		playerIcon.setAlignment(Pos.CENTER);
		playerIcon.getChildren().add(playerIconImg);
		
		VBox playerStats = new VBox();
		playerStats.setPrefWidth(110);
		playerStats.setPrefHeight(100);
		playerStats.setAlignment(Pos.CENTER);
		playerStats.setSpacing(5);
		
		Text playerName = new Text(player.getName());
		playerName.setFont(Font.font("Arial", FontWeight.BOLD, 20));
		
		Text playerScore = new Text("Score: " + player.getScore());
		playerScore.setFont(Font.font("Arial", FontWeight.BOLD, 15));
		
		Text playerPenalty = new Text("Penalty: " + player.getPenalty());
		playerPenalty.setFont(Font.font("Arial", FontWeight.BOLD, 15));
		
		playerStats.getChildren().addAll(playerName, playerScore, playerPenalty);
		
		add(playerIcon, 0, 0);
		add(playerStats, 1, 0);
		
	}
	
	public Player getPlayer() {
		return player;
	}


	public void setPlayer(Player player) {
		this.player = player;
	}


	public String getPlayerIconURL() {
		return playerIconURL;
	}


	public void setPlayerIconURL(String playerIconURL) {
		this.playerIconURL = playerIconURL;
	}


	public Text getPlayerName() {
		return playerName;
	}


	public void setPlayerName(Text playerName) {
		this.playerName = playerName;
	}


	public Text getScoreText() {
		return scoreText;
	}


	public void setScoreText(Text scoreText) {
		this.scoreText = scoreText;
	}


	public Text getPenaltyText() {
		return penaltyText;
	}


	public void setPenaltyText(Text penaltyText) {
		this.penaltyText = penaltyText;
	}

}
