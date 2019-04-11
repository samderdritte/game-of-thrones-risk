import java.util.HashSet;
import java.util.Set;

/**
 * A region is a collection of territories.
 * Every region has a number of bonus units which a player receives, who has occupied
 * all territories of this region. 
 * @author SpycherS
 *
 */
public class Region {
	String regionName;
	int numBonusUnits;
	Set<Territory> territories;
	
	public Region(String regionName, int numBonusUnits) {
		this.regionName = regionName;
		this.numBonusUnits = numBonusUnits;
		territories = new HashSet<Territory>();
	}
	
	public String getRegionName() {
		return regionName;
	}
	
	public int getNumBonusUnits() {
		return numBonusUnits;
	}
	
	public Set<Territory> getTerritories(){
		return territories;
	}
	
	//add a territory to this region
	public void addTerritory(Territory name) {
		territories.add(name);
	}
	
}
