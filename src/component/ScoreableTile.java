package component;

import java.util.ArrayList;

import interfaces.Scoreable;
import logic.GameLogic;
import utils.TileArea;
import utils.TileType;

public class ScoreableTile extends Tile implements Scoreable {
	
	private final boolean isCastle;
	
	public ScoreableTile(TileType tileType) {
		super(tileType);
		this.isCastle = tileType.toString().contains("CASTLE");
	}
	
	public void collectScore() {
		if (isCastle) {
			GameLogic.getInstance().addToCastleScoreList(xPosition, yPosition);
		} else {
			checkRiverSide();
		}
	}
	
	private void checkRiverSide() {
		ArrayList<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < EDGE_DIRECTIONS; i++) {
			if (edge.get(i).equals(TileArea.RIVER)) {
				System.out.println("river " + i);
				list.add(i);
			}
		}
		addPositionToScoreList(list);
	}
	
	private void addPositionToScoreList(ArrayList<Integer> list) {
		if (list.size() == 2) {
			System.out.println(
					positionDeterminer(list.get(0))[0] + " " +
					positionDeterminer(list.get(0))[1] + " " +
				positionDeterminer(list.get(1))[0] + " " +
				positionDeterminer(list.get(1))[1]
					
					);
			GameLogic.getInstance().addToRiverScoreList(
				positionDeterminer(list.get(0)), 
				positionDeterminer(list.get(1))
			);
		} else {
			for (int i = 0; i < list.size(); i++) {
				System.out.println("side: " + positionDeterminer(list.get(i))[0] + " " + positionDeterminer(list.get(i))[1]);
				GameLogic.getInstance().addToRiverScoreList(
					new double[] { -1.0, -1.0 }, 
					positionDeterminer(list.get(i))
				);
			}
		}
	}
	
	private double[] positionDeterminer(int area) {
		System.out.println("area = " + area + " " + xPosition + " " + yPosition);
		switch (area) {
		case 0 :
			System.out.println(0);
			return new double[] { xPosition, yPosition + 0.5 };
		case 1 :
			System.out.println(1);
			return new double[] { xPosition + 0.5, yPosition + 1 };
		case 2 :
			System.out.println(2);
			return new double[] { xPosition + 1, yPosition + 0.5 };
		case 3 :
			System.out.println(3);
			return new double[] { xPosition + 0.5, yPosition };
		}
		return null;
	}
	
	public boolean isCastle() {
		return isCastle;
	}

}
