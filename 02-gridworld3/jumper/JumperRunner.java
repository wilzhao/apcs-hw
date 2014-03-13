import info.gridworld.actor.ActorWorld;
import info.gridworld.grid.Location;
import java.awt.Color;

public class JumperRunner{

    public static void main(String[] args){
	ActorWorld world = new ActorWorld();
	Jumper AJ = new Jumper();

	world.add(new Location(5,5),AJ);
	world.show();
	
    }

}
