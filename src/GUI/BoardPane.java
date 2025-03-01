package GUI;

import component.Board;
import component.Tile;
import data.ResourceLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import utils.TileType;

public class BoardPane extends GridPane {

	public BoardPane(Board board) {
		setHgap(10); setVgap(10);
		setPadding(new Insets(10));
		setPrefWidth(800);
		setAlignment(Pos.CENTER);
		setBackground(new Background(new BackgroundFill(Color.RED, CornerRadii.EMPTY, Insets.EMPTY)));
		for (int row = 0; row < Board.getBoardSize(); row++) {
			for (int col = 0; col < Board.getBoardSize(); col++) {
				TilePane tilePane = new TilePane(board.getTile(row, col));
				add(tilePane, col, row);
				ResourceLoader.getInstance().add(tilePane);
			}
		}
		paintComponent();
	}
	
	public void paintComponent() {
		for (TilePane tilePane : ResourceLoader.getInstance().getTilePaneList()) {
			tilePane.draw(tilePane.getGraphicsContext2D());
		}
	}
	
}
