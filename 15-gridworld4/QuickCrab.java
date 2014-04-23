import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.awt.Color;

public class QuickCrab extends CrabCritter{


	public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        int[] dirs =
            { Location.LEFT, Location.RIGHT };
        for (Location loc : getLocationsInDirections(dirs))
            if (getGrid().get(loc) == null)
                locs.add(loc);

        return locs;
    }

    public ArrayList<Location> getLocationsInDirections(int[] directions)
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        Grid gr = getGrid();
        Location loc = getLocation();
    
        for (int d : directions)
        {
            Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
            Location nextNeighborLoc = neighborLoc.getAdjacentLocation(getDirection() + d);
            if (gr.isValid(nextNeighborLoc) && gr.isValid(neighborLoc))
                locs.add(nextNeighborLoc);
        }
        if (locs.size() == 0){
			for (int d : directions)
		        {
		            Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
		            if (gr.isValid(neighborLoc))
		                locs.add(neighborLoc);
		        }
        }
        return locs;
    }    
    

}