package gui;

import component.Board;
import data.ResourceLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
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
		setBackground(new Background(new BackgroundImage(
			ResourceLoader.getBackgroundImage(), 
			BackgroundRepeat.NO_REPEAT, 
			BackgroundRepeat.NO_REPEAT, 
			BackgroundPosition.CENTER, 
			BackgroundSize.DEFAULT
		)));
		HBox.setMargin(boardPane, new Insets(25));
		getChildren().addAll(boardPane, controlPane);
   
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
