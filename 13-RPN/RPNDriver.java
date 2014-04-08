import java.util.Scanner;

public class RPNDriver{

    public static void main(String[] args){
	RPN r = new RPN();
	/*
	System.out.println(r.parse("3\n4\n+"));
	System.out.println(r.parse("3\n4\n+\n5\n*"));
	*/
	Scanner s = new Scanner(System.in);
	System.out.println("Calculator");
	String line = "";
	String inputs = "";
	String readableinputs = "";
	while (!line.equals("quit")){
	    line = s.nextLine();
	    
	    if (line.equals("compute")){
		try {
		    System.out.println(r.parse(inputs));
		    inputs = "";
		    readableinputs = "";
		} catch (ArrayIndexOutOfBoundsException E){
		    System.out.println("Not enough inputs");
		}
	    } else if (line.equals("inputs")){
		System.out.println(readableinputs);
	    } else if (line.equals("clear")){
		System.out.println("Cleared");
		inputs = "";
		readableinputs = "";
	    } else {
		inputs += line + "\n";
		readableinputs += line;
	    }
	}
    }


}
