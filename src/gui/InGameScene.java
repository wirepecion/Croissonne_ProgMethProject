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
import logic.TileStorage;
import utils.PlayerColor;

public class InGameScene extends HBox {
	
	private BoardPane boardPane;
	private ControlPane controlPane;
	
	public InGameScene() {
		
		GameLogic.getInstance().newGame();
		TileStorage.getInstance().init();
		
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
		String winners = "Player ";
		Player winner = GameLogic.getPlayer()[0];
		int maxPoint = GameLogic.getPlayer()[0].getScore() + GameLogic.getPlayer()[0].getPenalty();
		for (Player player : GameLogic.getPlayer()) {
			if (player.getScore() + player.getPenalty() > maxPoint) {
				maxPoint = player.getScore() + player.getPenalty();
				winner = player;
			}
		}
		for (Player player : GameLogic.getPlayer()) {
			if (player.getScore() + player.getPenalty() ==  maxPoint) {
				winners += player.getName().charAt(player.getName().length()-1) + " ";
			}
		}
		Text winnerText = new Text(winners + "Wins!");
		winnerText.setFont(new Font(30));
		controlPane.getChildren().add(winnerText);
	}
	
	public void addPlayerStatPane() {
		for (int i = 0; i < GameLogic.getPlayer().length; i++) {
			controlPane.getChildren().addAll(GameLogic.getPlayer()[i].getPlayerStatPane());
		}
	}
	
	public void addExitOption() {
		
		HBox exitOption = new HBox();
		exitOption.setSpacing(30);
		exitOption.setAlignment(Pos.CENTER);
		
		Button playAgainButton = new Button("PLAY AGAIN");
		playAgainButton.setPrefWidth(150);
		playAgainButton.setPrefHeight(50);
		playAgainButton.setBackground(new Background(new BackgroundFill(
				Color.GREEN, CornerRadii.EMPTY, Insets.EMPTY)));
		playAgainButton.setFont(new Font("Arial Bold", 14));
		playAgainButton.setStyle("-fx-text-fill: white;");
		playAgainButton.setOnMouseClicked(e -> {
			GameManager.getInstance().switchToInGameScene();
		});
		
		Button menuButton = new Button("MENU");
		menuButton.setPrefWidth(150);
		menuButton.setPrefHeight(50);
		menuButton.setBackground(new Background(new BackgroundFill(
				Color.ORANGE, CornerRadii.EMPTY, Insets.EMPTY)));
		menuButton.setFont(new Font("Arial Bold", 15));
		menuButton.setStyle("-fx-text-fill: white;");
		menuButton.setOnMouseClicked(e -> {
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
		
		exitOption.getChildren().addAll(playAgainButton,menuButton,exitButton);
		
		controlPane.getChildren().add(exitOption);
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
