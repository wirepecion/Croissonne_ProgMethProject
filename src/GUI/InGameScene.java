package GUI;

import component.Board;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class InGameScene extends HBox {
	private Board board;
	private ControlPane controlPane;
	 
	public InGameScene() {
		
		//initialize component
		board = new Board();
		controlPane = new ControlPane();

		setAlignment(Pos.CENTER);  
		setSpacing(20);
		setPrefWidth(1200);
		setPrefHeight(750);
		setBackground(new Background(new BackgroundFill(Color.DARKGREY, CornerRadii.EMPTY, Insets.EMPTY)));
		getChildren().addAll(board, controlPane);
	}
	
	public Board getBoard() {
		return board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public ControlPane getControlPane() {
		return controlPane;
	}

	public void setControlPane(ControlPane controlPane) {
		this.controlPane = controlPane;
	}
}
