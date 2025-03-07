package gui;

import java.awt.event.MouseEvent;

import component.Player;
import data.ImageLoader;
import javafx.application.Platform;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import logic.GameLogic;
import logic.TileStorage;
import utils.MouseEventHandler;

public class InGamePane extends HBox {
	
	private BoardPane boardPane;
	private ControlPane controlPane;
	
	public InGamePane() {
		
		GameLogic.getInstance().newGame();
		TileStorage.init();
		
		boardPane = new BoardPane(GameLogic.getInstance().getBoard());
		controlPane = new ControlPane();
		
		setAlignment(Pos.CENTER);  
		setSpacing(20);
		setPrefWidth(1200);
		setPrefHeight(750);
		setBackground(new Background(new BackgroundImage(ImageLoader.getInGameBackgroundImage(), null, null, null, null)));
		getChildren().addAll(boardPane, controlPane);
   
	}
	public void clearControlPane() {
		controlPane.getChildren().clear();
	}
	
	public void addGameOverText() {
		Button gameOverText = new Button("Game Over");
		gameOverText.setFont(new Font(48));
		gameOverText.setBackground(new Background(new BackgroundFill(Color.WHEAT, CornerRadii.EMPTY, Insets.EMPTY)));
		controlPane.getChildren().add(gameOverText);
	}
	
	public void addWinnerText() {
		String winners = "Player ";
		int maxPoint = GameLogic.getPlayer()[0].getScore() + GameLogic.getPlayer()[0].getPenalty();
		for (Player player : GameLogic.getPlayer()) {
			if (player.getScore() + player.getPenalty() > maxPoint) {
				maxPoint = player.getScore() + player.getPenalty();
			}
		}
		for (Player player : GameLogic.getPlayer()) {
			if (player.getScore() + player.getPenalty() == maxPoint) {
				winners += player.getName().charAt(player.getName().length() - 1) + " ";
			}
		}
		Button winnerText = new Button(winners + "Wins!");
		winnerText.setFont(new Font(30));
		winnerText.setBackground(new Background(new BackgroundFill(Color.ANTIQUEWHITE, CornerRadii.EMPTY, Insets.EMPTY)));
		controlPane.getChildren().add(winnerText);
	}
	
	public void addPlayerStatPane() {
		for (int i = 0; i < GameLogic.getPlayer().length; i++) {
			controlPane.getChildren().addAll(GameLogic.getPlayer()[i].getPlayerStatPane());
		}
	}
	
	public void addEndGameOption() {
		
		HBox endGameOption = new HBox();
		endGameOption.setSpacing(30);
		endGameOption.setAlignment(Pos.CENTER);
		
		Button playAgainButton = new Button("PLAY AGAIN");
		playAgainButton.setPrefWidth(150);
		playAgainButton.setPrefHeight(50);
		playAgainButton.setBackground(new Background(new BackgroundImage(ImageLoader.getPlayAgainBackground(), null, null, null, null)));
		playAgainButton.setFont(new Font("Arial Bold", 14));
		playAgainButton.setStyle("-fx-text-fill: white;");
		playAgainButton.setOnMouseClicked(e -> {
			GameManager.getInstance().switchToInGameScene();
		});
		playAgainButton.setOnMouseEntered(event -> playAgainButton.setCursor(Cursor.HAND));
		playAgainButton.setOnMouseExited(event -> playAgainButton.setCursor(Cursor.DEFAULT));
		
		Button menuButton = new Button("MENU");
		menuButton.setPrefWidth(150);
		menuButton.setPrefHeight(50);
		menuButton.setBackground(new Background(new BackgroundImage(ImageLoader.getMenuBackground(), null, null, null, null)));
		menuButton.setFont(new Font("Arial Bold", 15));
		menuButton.setStyle("-fx-text-fill: white;");
		menuButton.setOnMouseClicked(e -> {
			GameManager.getInstance().setToStartGamePane();
		});
		menuButton.setOnMouseEntered(event -> menuButton.setCursor(Cursor.HAND));
		menuButton.setOnMouseExited(event -> menuButton.setCursor(Cursor.DEFAULT));
		
		Button exitButton = new Button("EXIT");
		exitButton.setPrefWidth(150);
		exitButton.setPrefHeight(50);
		exitButton.setBackground(new Background(new BackgroundImage(ImageLoader.getExitBackground(), null, null, null, null)));
		exitButton.setFont(new Font("Arial Bold", 15));
		exitButton.setStyle("-fx-text-fill: white;");
		exitButton.setOnMouseClicked(e -> {
			Platform.exit();
		});
		exitButton.setOnMouseEntered(event -> exitButton.setCursor(Cursor.HAND));
		exitButton.setOnMouseExited(event -> exitButton.setCursor(Cursor.DEFAULT));
		
		endGameOption.getChildren().addAll(playAgainButton, menuButton, exitButton);
		
		controlPane.getChildren().add(endGameOption);
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