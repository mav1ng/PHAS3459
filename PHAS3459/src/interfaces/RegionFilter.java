package interfaces;

import java.util.List;

/**
 * 
 * Represents a way of filtering a list of regions
 *
 */
public interface RegionFilter {
	/**
	 * 
	 * @param regions
	 * @return
	 */
	public List<Region> filter(List<Region> regions);
}
