package logic;

import component.Board;
import component.OwnableTile;
import component.Player;
import GUI.ControlPane;
import component.Tile;
import utils.PlayerColor;
import utils.TileType;

public class GameLogic {
	
	private static GameLogic instance = null;
	private static Board board;
	private static boolean isGameEnd;
	private static Tile currentTile;
	private static Player[] playerList;
	private static int currentPlayerNumber;
	
	static {
		TileStorage.init();
	}
	
	public void newGame(int NumberOfplayer, String[] playerName, PlayerColor[] playerColor) {
		board = new Board();
		playerList = new Player[NumberOfplayer];
		for (int i = 0; i < NumberOfplayer; i++) {
			playerList[i] = new Player(playerName[i], playerColor[i]);
		}
		currentPlayerNumber = 0;
	}
	
	private static void nextPlayer() {
		currentPlayerNumber = (currentPlayerNumber + 1) % playerList.length;
	}
	
	public static Player getCurrentPlayer() {
		return playerList[currentPlayerNumber];
	}
	
	public boolean isPlaceable(int x, int y) {
		if (!board.getTile(x, y).isEmpty() || isNotBesideOtherTile(x, y)) return false;
		Tile tile = currentTile;
		tile.setxPosition(x);
		tile.setyPosition(y);
		return 	isMatchEdge(tile, x - 1, y) &&
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
		if (board.getTile(x, y) == null || board.getTile(x, y).isEmpty()) return true;
		Tile anotherTile = board.getTile(x, y);
		System.out.println(tile.getxPosition() + " " + x + " " + tile.getyPosition() + " " + y);
		if (tile.getxPosition() - 1 == x) {
			System.out.println("1 " + tile.getEdge(0) + " " + anotherTile.getEdge(2));
			return tile.getEdge(0).equals(anotherTile.getEdge(2));
		}
		if (tile.getxPosition() + 1 == x) {
			System.out.println("2 " + tile.getEdge(2) + " " + anotherTile.getEdge(0));
			return tile.getEdge(2).equals(anotherTile.getEdge(0));
		}	
		if (tile.getyPosition() - 1 == y) {
			System.out.println("3 " + tile.getEdge(3) + " " + anotherTile.getEdge(1));
			return tile.getEdge(3).equals(anotherTile.getEdge(1));
		}
		if (tile.getyPosition() + 1 == y) {
			System.out.println("4 " + tile.getEdge(1) + " " + anotherTile.getEdge(3));
			return tile.getEdge(1).equals(anotherTile.getEdge(3));
		}
		return false;
	}
	
	public static void randomTile() {
		if (update()) return;
		currentTile = TileStorage.getRandomTile();
		currentTile.setPlace(false);
		ControlPane.resetTilepane();
		ControlPane.getTilePane().getGraphicsContext2D().drawImage(
				currentTile.getImageOfTile(), 
				0, 0, Tile.getTileSize() * 2, Tile.getTileSize() * 2);
		nextPlayer();
	}
	
	public static void placeCurrentTile(int x, int y) {
		currentTile.setPlace(true);
		board.addOnBoard(currentTile, x, y);
		board.paintComponent();
		getCurrentPlayer().updateScore(1);
		randomTile();
	}
	
	public static boolean update() {
		if (TileStorage.getTileCount() == 0) {
			isGameEnd = true;
			return true;
		}
		return false;
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

	public static Tile getCurrentTile() {
		return currentTile;
	}
	
}
