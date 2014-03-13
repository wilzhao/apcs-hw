

public class KnightsTourRunner{

    public static void main(String[] args){
	KnightsTour k = new KnightsTour(8,8);
	//5,5 -> 668994 iterations
	//6,6 -> 658934 iterations 
	//7,7 -> 11960945 iterations
	System.out.println("[2J");

	k.solve(0,0);
    }

}
