package component;

import interfaces.Ownable;
import utils.TileType;

public class OwnableTile extends Tile implements Ownable {
	
	private final boolean isCastle;
	private boolean isOwned;
	private Player owner;
	
	public OwnableTile(TileType tileType) {
		super(tileType);
		this.isCastle = tileType.toString().contains("CASTLE");
		this.isOwned = false;
		this.owner = null;
	}

	@Override
	public void ownBy(Player player) {
		this.isOwned = true;
		this.owner = player;
	}
	
	public boolean isCastle() {
		return isCastle;
	}

	public boolean isOwned() {
		return isOwned;
	}

	public Player getOwner() {
		return owner;
	}

}
