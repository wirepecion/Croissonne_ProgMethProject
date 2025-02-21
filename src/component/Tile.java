package component;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import utils.TileArea;
import utils.Constant;
import interfaces.Rotatable;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public class Tile extends Pane implements Rotatable {
	private TileArea[] border;
	private boolean isCastle;
	private TileArea tileType;
//	private final Image boardImage = new Image(ClassLoader.getSystemResource("res/board.png").toString());
	// border contains 4 TileArea 
	// (1) north border
	// (2) east border
	// (3) south border
	// (4) west border
	
	public Tile(TileArea northArea, TileArea eastArea, TileArea southArea, TileArea westArea, boolean isCastle) {
		TileArea[] border = new TileArea[] {northArea, eastArea, southArea, westArea};
		checkTileArea(border);
		
		setTileType(tileType);
	}
	
	// rotate clockwise
	public void rotate() {
		TileArea oldNorthArea = getNorthArea();
		setSouthtArea(getEastArea());
		setWestArea(getSouthtArea());
		setNorthArea(getWestArea());
		setEastArea(oldNorthArea);
	}

	public TileArea getTileType() {
		return tileType;
	}

	public void setTileType(TileArea tileType) {
		this.tileType = tileType;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(border);
		result = prime * result + Objects.hash(isCastle);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Tile other = (Tile) obj;
		return Arrays.equals(border, other.border) && isCastle == other.isCastle;
	}

	private void checkTileArea(TileArea[] arr) {
		TileArea tileType = TileArea.ABYSS;
		for (TileArea eachTileArea : arr) {
			if (eachTileArea.equals(TileArea.CASTLE)) {
				eachTileArea = TileArea.ABYSS;
			}
		}
	}
}
