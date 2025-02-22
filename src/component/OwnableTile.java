package component;

import interfaces.Ownable;
import utils.TileType;

public class OwnableTile extends Tile implements Ownable {
	
	private boolean isOwned;
	private Player owner;
	
	public OwnableTile(TileType tileType) {
		super(tileType);
		this.isOwned = false;
		this.owner = null;
	}

	@Override
	public void ownBy(Player player) {
		this.isOwned = true;
		this.owner = player;
	}

	public boolean isOwned() {
		return isOwned;
	}

	public Player getOwner() {
		return owner;
	}

}
