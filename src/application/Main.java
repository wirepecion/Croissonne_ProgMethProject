package application;

import logic.TileStorage;

public class Main {
	public static void main(String[] args) {
		TileStorage.init();
		for (int i=0;i<61;i++) {
			System.out.println(TileStorage.getRandomTile());
		}
	}
}
