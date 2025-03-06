package gui;

import component.Board;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.GridPane;

public class BoardPane extends GridPane {

	public BoardPane(Board board) {
		setHgap(10); setVgap(10);
		setPadding(new Insets(10));
		setPrefWidth(750);
		setAlignment(Pos.CENTER);
		for (int row = 0; row < Board.getBoardSize(); row++) {
			for (int col = 0; col < Board.getBoardSize(); col++) {
				TilePane tilePane = new TilePane(board.getTile(row, col));
				tilePane.draw();
				add(tilePane, col, row);
			}
		}
	}
	
}
