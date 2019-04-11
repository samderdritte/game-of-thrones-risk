import java.util.Set;

/**
 * A player has a name, a number of units and occupied territories.
 * If the number of territories and units becomes zero, hasLost becomes true.
 * 
 * @author SpycherS
 *
 */
public class Player {
	String playerName;
	int numUnits;
	Set<Territory> occupiedTerritories;
	
	public Player(String playerName) {
		this.playerName = playerName;
	}
	
	public String getPlayerName() {
		return playerName;
	}
	
	public int getNumUnits() {
		return numUnits;
	}
	
	public Set<Territory> getTerritories(){
		return occupiedTerritories;
	}
	
	// increase number of units by 1
	public void addUnit() {
		numUnits++;
	}
	
	// decrease number of units by 1
	public void removeUnit() {
		numUnits--;
	}
	
	// increase the number of units by a certain amount
	public void addMultipleUnits(int numUnits) {
		this.numUnits += numUnits;
	}
	
	// add a territory to the list of occupied territories
	public void addTerritory(Territory name) {
		occupiedTerritories.add(name);
	}
	
	// remove a territory from the list of occupied territories
	public void removeTerritory(Territory name) {
		occupiedTerritories.remove(name);
	}

}
