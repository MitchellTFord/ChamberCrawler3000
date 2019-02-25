package edu.century.testfinal;

public class Entity
{
	private Tile currentTile;
	EntityType entityType;
	
	public Tile getCurrentTile()
	{
		return this.currentTile;
	}
	public void setCurrentTile(Tile currentTile)
	{
		this.currentTile = currentTile;
	}
	
	public int getGridX()
	{
		return this.currentTile.getGridX();
	}
	public int getGridY()
	{
		return this.currentTile.getGridY();
	}
}