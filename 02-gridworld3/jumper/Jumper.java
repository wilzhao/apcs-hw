import info.gridworld.actor.*;
import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

public class Jumper extends Actor{

    public Jumper(){
	
    }

    public void act(){
	if (canJump()){
	    jump();
	} else if (canMove()){
	    move();
	} else {
	    turn();
	}
    }

    private void jump(){
	Grid<Actor> grid = getGrid();
	if (grid == null){
	    return;
	}
	Location current = getLocation();
	Location target = current.getAdjacentLocation(getDirection()).getAdjacentLocation(getDirection());
	if (grid.isValid(target)){
	    moveTo(target);
	} else {
	    removeSelfFromGrid();
	}
    }

    private void move(){
	Grid<Actor> grid = getGrid();
	if (grid == null){
	    return;
	}
	Location current = getLocation();
	Location target = current.getAdjacentLocation(getDirection());
	if (grid.isValid(target)){
	    moveTo(target);
	} else {
	    removeSelfFromGrid();
	}
    }

    private void turn(){
	setDirection(getDirection() + Location.HALF_RIGHT);
    }

    private boolean canJump(){
	Grid<Actor> grid = getGrid();
	if (grid == null){
	    return false;
	}
	Location current = getLocation();
	Location target = current.getAdjacentLocation(getDirection()).getAdjacentLocation(getDirection());

	if (!grid.isValid(target)){
	    return false;
	}

	Actor targetActor = grid.get(target);
	return targetActor == null;
    }

    private boolean canMove(){
		Grid<Actor> grid = getGrid();
	if (grid == null){
	    return false;
	}
	Location current = getLocation();
	Location target = current.getAdjacentLocation(getDirection());

	if (!grid.isValid(target)){
	    return false;
	}

	Actor targetActor = grid.get(target);
	return targetActor == null;
    }

}
