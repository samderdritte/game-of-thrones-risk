import java.util.HashSet;
import java.util.Set;

/**
 * A territory is the smallest object of the game.
 * Multiple territories form a region.
 * A territory must belong to a region, and must have at least one adjacent territory.
 * In its initial state, a territory is unoccupied. After the layout phase of the game,
 * a territory always must have an owner and at least one unit in it.
 * 
 * @author SpycherS
 *
 */

public class Territory {
	private String territoryName;
	private Region regionName;
	private Set<Territory> adjacentTerritories;
	private int numAdjacentTerritories;
	private Player owner;
	private int numUnits;
	
	public Territory(String territoryName, int numAdjacentTerritories) {
		this.territoryName = territoryName;
		this.numAdjacentTerritories = numAdjacentTerritories;
		adjacentTerritories = new HashSet<Territory>();
	}
	
	public String getTerritoryName() {
		return territoryName;
	}
	
	public Region getRegion() {
		return regionName;
	}
	
	public Set<Territory> getAdjacentTerritories() {
		return adjacentTerritories;
	}
	
	public int getNumOfAdjacentTerritories() {
		return numAdjacentTerritories;
	}
	
	public Player getOwner() {
		return owner;
	}
	
	public int getNumOfUnits() {
		return numUnits;
	}
	
	public void addTerritory(Territory name) {
		adjacentTerritories.add(name);
	}
	// add a single unit
	public void addUnit() {
		numUnits++;
	}
	// remove a single unit
	public void removeUnit() {
		numUnits--;
	}
	// add a number of units
	public void addUnits(int numUnits) {
		this.numUnits += numUnits;
	}
	// remove a number of units
	public void removeUnits(int numUnits) {
		this.numUnits -= numUnits;
	}
	

}
