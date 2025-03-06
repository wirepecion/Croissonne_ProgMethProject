package component;

import gui.BoardPane;
import gui.GameManager;
import utils.TileType;

public class Board {
	
	private static final int BOARD_SIZE = 12;
	private Tile[][] allTiles = new Tile[BOARD_SIZE + 1][BOARD_SIZE + 1];
	private BoardPane boardPane;
	
	public Board() {
		initializeBoard();
		boardPane = new BoardPane(this);
	}
	
	private void initializeBoard() {
		for(int row = 0; row < BOARD_SIZE; row++) {
			for(int col = 0; col < BOARD_SIZE; col++) {
				Tile tile = Tile.createTile();
				if (row == 6 && col == 6) {
					tile = Tile.createTile(TileType.STRAIGHT_RIVER_BESIDE_ABYSS);
					tile.setPlace(true);
				}
				tile.setxPosition(row);
				tile.setyPosition(col);
				allTiles[row][col] = tile;
			}
		}
	}
	
	public void addOnBoard(Tile tile, int x, int y) {
		GameManager.getInstance().getInGameScene().getBoardPane().add(tile.getTilePane(), y, x);
		allTiles[x][y] = tile;
	}
	
	public static int getBoardSize() {
		return BOARD_SIZE;
	}
	
	public Tile[][] getTile() {
		return allTiles;
	}
	
	public Tile getTile(int row, int col) {
		if (row < 0 || col < 0 || row > BOARD_SIZE || col > BOARD_SIZE) return null;
		return allTiles[row][col];
	}
	
	public void setTileOnBoard(Tile tile, int row, int col) {
		allTiles[row][col] = tile; 
	}

	public BoardPane getBoardPane() {
		return boardPane;
	}
	
}
