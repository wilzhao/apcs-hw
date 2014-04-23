import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.awt.Color;

public class KingCrab extends CrabCritter{

	public void processActors(ArrayList<Actor> actors)
    {
    	int dir = getDirection();
        for (Actor a : actors)
        {
            if (getGrid().isValid(a.getLocation().getAdjacentLocation(dir))){
            	a.moveTo(a.getLocation().getAdjacentLocation(dir));
            } else {
            	a.removeSelfFromGrid();
            }
        }
    }

}