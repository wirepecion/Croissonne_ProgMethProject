package component;

import java.util.ArrayList;

import enums.TileArea;

public class Tile implements Rotatable {
	private TileArea northArea;
	private TileArea eastArea;
	private TileArea southtArea;
	private TileArea westArea;
	private TileArea tileType;
	
	
	public Tile(TileArea northArea, TileArea eastArea, TileArea southArea, TileArea westArea, TileArea tileType) {
		
	}
	
	public void placeTile() {
		
	}
	
	public void rotate() {
		
	}

	public TileArea getNorthArea() {
		return northArea;
	}

	public void setNorthArea(TileArea northArea) {
		this.northArea = areaIsNotCastle(northArea);
	}

	public TileArea getEastArea() {
		return eastArea;
	}

	public void setEastArea(TileArea eastArea) {
		this.eastArea = areaIsNotCastle(eastArea);
	}

	public TileArea getSouthtArea() {
		return southtArea;
	}

	public void setSouthtArea(TileArea southtArea) {
		this.southtArea = areaIsNotCastle(southtArea);
	}

	public TileArea getWestArea() {
		return westArea;
	}

	public void setWestArea(TileArea westArea) {
		this.westArea = areaIsNotCastle(westArea);
	}

	public TileArea getTileType() {
		return tileType;
	}

	public void setTileType(TileArea tileType) {
		this.tileType = tileType;
	}
	
	private TileArea areaIsNotCastle(TileArea tileArea) {
		if (tileArea == TileArea.CASTLE) return TileArea.ABYSS;
		return tileArea;
	}
}
