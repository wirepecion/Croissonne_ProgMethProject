package logic;

import component.Board;
import component.Tile;
import utils.TileType;

public class GameLogic {
	
	private static GameLogic instance = null;
	private Board board;
	private boolean isGameEnd;
	private static Tile currentTile;
	
	private GameLogic() {
		this.newGame();
	}
	
	public void newGame() {
		TileStorage.init();
		this.board = new Board();
	}
	
	public boolean isPlaceable(int x, int y) {
		if (!board.getTile(x, y).isEmpty() || isNotBesideOtherTile(x, y)) return false;
		Tile tile = currentTile;
		tile.setxPosition(x);
		tile.setyPosition(y);
		return  isMatchEdge(tile, x - 1, y) &&
				isMatchEdge(tile, x + 1, y) &&
				isMatchEdge(tile, x, y - 1) &&
				isMatchEdge(tile, x, y + 1);
	}
	
	private boolean isNotBesideOtherTile(int x, int y) {
		return 	(board.getTile(x - 1, y) == null || board.getTile(x - 1, y).isEmpty()) &&
				(board.getTile(x + 1, y) == null || board.getTile(x + 1, y).isEmpty()) &&
				(board.getTile(x, y - 1) == null || board.getTile(x, y - 1).isEmpty()) &&
				(board.getTile(x, y + 1) == null || board.getTile(x, y + 1).isEmpty());
	}
	
	private boolean isMatchEdge(Tile tile, int x, int y) {
		if (board.getTile(x, y) == null) return true;
		if (board.getTile(x, y).isEmpty()) return true;
		Tile anotherTile = board.getTile(x, y);
		if (tile.getxPosition() - 1 == x)
			return tile.getEdge(0).equals(anotherTile.getEdge(2));
		if (tile.getxPosition() + 1 == x)
			return tile.getEdge(2).equals(anotherTile.getEdge(0));
		if (tile.getyPosition() - 1 == y)
			return tile.getEdge(3).equals(anotherTile.getEdge(1));
		if (tile.getyPosition() + 1 == y)
			return tile.getEdge(1).equals(anotherTile.getEdge(3));
		return false;
	}
	
	public static Tile randomTile() {
		TileStorage.getInstance();
		currentTile = TileStorage.getRandomTile();
		return currentTile;
	}
	
	public static GameLogic getInstance() {
		if(instance == null) {
			instance = new GameLogic();
		}
		return instance;
	}

	public Board getBoard() {
		return board;
	}

	public boolean isGameEnd() {
		return isGameEnd;
	}

	public void setGameEnd(boolean isGameEnd) {
		this.isGameEnd = isGameEnd;
	}

	public Tile getCurrentTile() {
		return currentTile;
	}
	
}
