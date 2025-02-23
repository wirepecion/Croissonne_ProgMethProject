package component;

import sharedObject.IRenderable;

public abstract class Entity implements IRenderable {
	
	protected double x, y;
	protected int z;
	protected boolean visible, removed;
	
	protected Entity(){
		visible = true;
		removed = false;
	}
	
	@Override
	public boolean isRemoved(){
		return removed;
	}
	
	@Override
	public boolean isVisible(){
		return visible;
	}
	
	@Override
	public int getZ(){
		return z;
	}
}
