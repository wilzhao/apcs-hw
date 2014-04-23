import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.awt.Color;


public class ChameleonKid extends ChameleonCritter{

public ArrayList<Actor> getActors(){
 	ArrayList<Actor> actors = new ArrayList<Actor>();
 	Location loc = getLocation();
 	int d = getDirection();
 	Location neighborLoc = loc.getAdjacentLocation(d);
 	if (getGrid().isValid(neighborLoc)){
 		actors.add(getGrid().get(neighborLoc));
 	}
 	d = (d + Location.HALF_CIRCLE)%360; 
  	neighborLoc = loc.getAdjacentLocation(d);
 	if (getGrid().isValid(neighborLoc)){
 		actors.add(getGrid().get(neighborLoc));
 	}
 	return actors;

 	/*ArrayList<Location> locs = new ArrayList<Location>();
    ArrayList<Actor> actors = new ArrayList<Actor>();
     	Location loc = getLocation();
        int d = Location.NORTH;
        for (int i = 0; i < Location.FULL_CIRCLE / Location.HALF_CIRCLE; i++)
        {
            Location neighborLoc = loc.getAdjacentLocation(d);
            if (isValid(neighborLoc))
                locs.add(neighborLoc);
            	actors.add(get(neighborLoc));

            d = d + Location.HALF_CIRCLE;
        }

*/
}//copied some from abstract grid 

public void processActors(ArrayList<Actor> actors){
	
}



}