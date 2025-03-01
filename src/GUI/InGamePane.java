package GUI;

import javafx.geometry.Pos;
import component.Board;
import javafx.geometry.Insets;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;

public class InGamePane extends HBox {
	
	 private BoardPane boardPane;
	 private ControlPane controlPane;

	 public InGamePane() {
		 
	   boardPane = new BoardPane();
	   controlPane = new ControlPane();

	   setAlignment(Pos.CENTER);  
	   setSpacing(20);
	   setPrefWidth(1200);
	   setPrefHeight(750);
	   setBackground(new Background(new BackgroundFill(Color.DARKGREY, CornerRadii.EMPTY, Insets.EMPTY)));
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
