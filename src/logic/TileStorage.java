package logic;

import java.io.File;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

import component.Tile;
import utils.TileType;

public class TileStorage {
	private static final TileStorage instance = new TileStorage();
	
	private static final int TOTAL_TILES = 61;
	private static ArrayList<Tile> tileList;
	private static int tileCount;
	
	public static void init() {
		tileList = new ArrayList<Tile>();
		tileCount = TOTAL_TILES;
		populateWordTile();
	}

	public static void populateWordTile() {
		File file = new File("res/tiles.txt");
		
		Scanner sc;
		try {
			sc = new Scanner(file);
			
			while (sc.hasNext()) {
				String tileTypeString = sc.next();
				int total = sc.nextInt();
				
				for (int i = 0; i < total; i++) {
					tileList.add(Tile.createTile(TileType.valueOf(tileTypeString)));
				}
			}
			sc.close();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		} 
	}
	
	public static Tile getRandomTile() {
		 int idx = new Random().nextInt(tileCount);
		 Tile tile = tileList.get(idx);
		 for (int i=0;i<4;i++) {
			 System.out.println(tile.getEdge(i));
		 }
		 tileList.remove(idx);
		 System.out.println(tileCount);
		 tileCount--;
		 return tile;
	}
	
	public static TileStorage getInstance() {
		return instance;
	}

	public static ArrayList<Tile> getTileList() {
		return tileList;
	}

	public static int getTileCount() {
		return tileCount;
	}

}
