

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.util.ArrayList;
import java.awt.Color;

public class BlusterCritter extends Critter{
	
	private int courage;

	public BlusterCritter(int c){
		courage = c;
	}

	public ArrayList<Actor> getActors(){
		ArrayList<Location> validNeighborLocs = getGrid().getValidAdjacentLocations(getLocation());
		for (Location neighborLoc : validNeighborLocs){
			ArrayList<Location> temp = getGrid().getValidAdjacentLocations(neighborLoc);
			for (Location possibleNeighbor: temp){
				if (!(validNeighborLocs.contains(possibleNeighbor)) && (!(possibleNeighbor.equals(getLocation())))){
					validNeighborLocs.add(possibleNeighbor);
				}
			}
		}

		return null;
	}

	public void processActors(ArrayList<Actor> actors){
		int count = 0;
		for (Actor a : actors){
			if (a instanceof Critter){
				count++;
			}
		}
		if (count < courage){
			changeColor(true);
		} else {
			changeColor(false);
		}

	}

	public void changeColor(boolean isBrightening){
		double DARKENING_FACTOR = 0.05;
		if (isBrightening){
			DARKENING_FACTOR = -DARKENING_FACTOR;
		}
		Color c = getColor();
        int red = (int) (c.getRed() * (1 - DARKENING_FACTOR));
        int green = (int) (c.getGreen() * (1 - DARKENING_FACTOR));
        int blue = (int) (c.getBlue() * (1 - DARKENING_FACTOR));

        setColor(new Color(red, green, blue));
	}

}