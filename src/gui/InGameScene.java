package gui;

import component.Board;
import component.Player;
import data.ResourceLoader;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import logic.GameLogic;
import utils.PlayerColor;

public class InGameScene extends HBox {
	
	private BoardPane boardPane;
	private ControlPane controlPane;
	
	public InGameScene() {
		
		GameLogic.getInstance().newGame();
		
		boardPane = new BoardPane(GameLogic.getInstance().getBoard());
		controlPane = new ControlPane();
		
		setAlignment(Pos.CENTER);  
		setSpacing(20);
		setPrefWidth(1200);
		setPrefHeight(750);
		setBackground(new Background(new BackgroundImage(ResourceLoader.getInGameBackgroundImage(), null, null, null, null)));
		getChildren().addAll(boardPane, controlPane);
   
	}
	public void clearControlPane() {
		controlPane.getChildren().clear();
	}
	
	public void addGameOverText() {
		Text gameOverText = new Text("Game Over");
		gameOverText.setFont(new Font(48));
		controlPane.getChildren().add(gameOverText);
	}
	
	public void addWinnerText() {
		Player winner = GameLogic.getPlayer()[0];
		int maxPoint = GameLogic.getPlayer()[0].getScore() + GameLogic.getPlayer()[0].getPenalty();
		for (Player player : GameLogic.getPlayer()) {
			if (player.getScore() - player.getPenalty() > maxPoint) {
				maxPoint = player.getScore() + player.getPenalty();
				winner = player;
			}
		}
		Text winnerText = new Text(winner + " Wins!");
		winnerText.setFont(new Font(30));
		controlPane.getChildren().add(winnerText);
	}
	
	public void addPlayerStatPane() {
		for (int i = 0; i < GameLogic.getPlayer().length; i++) {
			controlPane.getChildren().addAll(GameLogic.getPlayer()[i].getPlayerStatPane());
		}
	}
	
	public void addPlayAgainAndExitButton() {
		
		HBox playAgainAndExitButton = new HBox();
		playAgainAndExitButton.setSpacing(30);
		playAgainAndExitButton.setAlignment(Pos.CENTER);
		
		Button playAgainButton = new Button("PLAY AGAIN");
		playAgainButton.setPrefWidth(150);
		playAgainButton.setPrefHeight(50);
		playAgainButton.setBackground(new Background(new BackgroundFill(
				Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
		playAgainButton.setFont(new Font("Arial Bold", 15));
		playAgainButton.setStyle("-fx-text-fill: white;");
		playAgainButton.setOnMouseClicked(e -> {
			GameManager.getInstance().setToStartGamePane();
		});
		
		Button exitButton = new Button("EXIT");
		exitButton.setPrefWidth(150);
		exitButton.setPrefHeight(50);
		exitButton.setBackground(new Background(new BackgroundFill(
				Color.DARKRED, CornerRadii.EMPTY, Insets.EMPTY)));
		exitButton.setFont(new Font("Arial Bold", 15));
		exitButton.setStyle("-fx-text-fill: white;");
		exitButton.setOnMouseClicked(e -> {
			Platform.exit();
		});
		
		playAgainAndExitButton.getChildren().addAll(playAgainButton,exitButton);
		
		controlPane.getChildren().add(playAgainAndExitButton);
 	}

	public BoardPane getBoardPane() {
		return boardPane;
	}

	public void setBoard(BoardPane boardPane) {
		this.boardPane = boardPane;
	}

	public ControlPane getControlPane() {
		return controlPane;
	}

	public void setControlPane(ControlPane controlPane) {
		this.controlPane = controlPane;
	}
}
