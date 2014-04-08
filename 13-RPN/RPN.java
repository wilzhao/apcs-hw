import java.util.Scanner;

public class RPN{

    //Didn't have any time to attempt writing this class
    private MyStackArray S;
    
    public RPN(){
	S = new MyStackArray();
    }
    
    public double parse(String str){
	Scanner scan = new Scanner(str);

	while (scan.hasNextLine()){
	    String line = scan.nextLine();
	    try{
		double d = Double.parseDouble(line);
		S.push(d);
	    } catch (NumberFormatException E){
		double temp = 0;
		if (line.equals("+")){
		    temp = S.pop() + S.pop();
		} else if (line.equals("-")){
		    temp = S.pop() - S.pop();
		} else if (line.equals("/")){
		    temp = S.pop()/S.pop();
		} else if (line.equals("*")){
		    temp = S.pop()*S.pop();
		}
		S.push(temp);
	    }
	    System.out.println(S);
	}
	return S.pop();
	
    }

}
