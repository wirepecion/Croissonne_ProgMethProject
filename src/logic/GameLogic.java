package logic;

import component.Board;
import component.OwnableTile;
import component.Player;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;

import gui.ControlPane;
import gui.TilePane;
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
	private static ArrayList<RiverScoreCollector> riverScoreList;
	private static ArrayList<int[]> castleScoreList;
	
	static {
		TileStorage.init();
	}
	
	public void newGame(int NumberOfplayer, String[] playerName, PlayerColor[] playerColor) {
		board = new Board();
		playerList = new Player[NumberOfplayer];
		for (int i = 0; i < NumberOfplayer; i++) {
			playerList[i] = new Player(playerName[i], playerColor[i]);
		}
		riverScoreList = new ArrayList<RiverScoreCollector>();
		castleScoreList = new ArrayList<int[]>();
	}
	
	public static void startGame() {
		currentPlayerNumber = 0;
		riverScoreList.add(new RiverScoreCollector(
				new double[] { 6.5, 6.0 }, 1, new double[] { 6.5, 7.0 }));
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
		System.out.println("here");
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
				currentTile.getTilePane().getImageOfTile(), 
				0, 0, TilePane.getTileSize() * 2, TilePane.getTileSize() * 2);
		nextPlayer();
	}
	
	public void placeCurrentTile(int x, int y) {
		if (currentTile instanceof OwnableTile) {
			((OwnableTile) currentTile).collectScore();
			if (!(((OwnableTile) currentTile).isCastle())) {
				System.out.println("river check");
				riverScoreCheck();
			}
		}
		castleScoreCheck();
		currentTile.setPlace(true);
		board.addOnBoard(currentTile, x, y);
		board.getBoardPane().paintComponent();
		randomTile();
	}
	
	private static void riverScoreCheck() {
		for (int i = riverScoreList.size() - 1; i >= 0; i--) {
			System.out.println(i);
			if (riverScoreList.get(i).isLoop()) {
				getCurrentPlayer().updateScore(riverScoreList.get(i).getScore());
				riverScoreList.remove(i);
			}
		}
	}
	
	private static void castleScoreCheck() {
		for (int[] pos : castleScoreList) {
			boolean isScore = true;
			for (int i = pos[0] - 1; i <= pos[0] + 1; i++) {
				for (int j = pos[1] - 1; j <= pos[1] + 1; j++) {
					if (board.getTile(j, i) == null) continue;
					if (board.getTile(i, j).isEmpty()) {
						isScore = false;
						break;
					}
				}
				if (!isScore) break;
			}
			if (isScore) getCurrentPlayer().updateScore(8);
		}
	}
	
	public void addToRiverScoreList(double[] x, double[] y) {
		for (RiverScoreCollector collector : riverScoreList) {
			System.out.println(collector.getLeft()[0] + " " + collector.getLeft()[1] + " " + collector.getScore() + " " + collector.getRight()[0] + " " + collector.getRight()[1]);
			System.out.println(x[0] + " " + x[1] + " " + y[0] + " " + y[1]);
			if (checkCollectorLeft(collector, x, y)) return;
			if (checkCollectorRight(collector, x, y)) return;
		}
		riverScoreList.add(new RiverScoreCollector(x, 1, y));
	}
	
	private boolean checkCollectorLeft(RiverScoreCollector collector, double[] x, double[] y) {
		if (Arrays.equals(collector.getLeft(), x)) {
			collector.setLeft(y);
			collector.addScore();
			return true;
		} 
		if (Arrays.equals(collector.getLeft(), y)) {
			collector.setLeft(x);
			collector.addScore();
			return true;
		}
		return false;
	}
	
	private boolean checkCollectorRight(RiverScoreCollector collector, double[] x, double[] y) {
		if (Arrays.equals(collector.getRight(), x)) {
			collector.setRight(y);
			collector.addScore();
			return true;
		} 
		if (Arrays.equals(collector.getRight(), y)) {
			collector.setRight(x);
			collector.addScore();
			return true;
		}
		return false;
	}
	
	public void addToCastleScoreList(int x, int y) {
		castleScoreList.add(new int[] {x, y});
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
	
	public static Player[] getPlayer() {
		return playerList;
	}
	
}
