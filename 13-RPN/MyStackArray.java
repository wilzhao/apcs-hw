

public class MyStackArray{

    private int top;
    private double[] stack;

    public MyStackArray(){
	stack = new double[10];
	top = -1;
    }

    public void push(double s){
	if (top + 1 == stack.length){
	    grow();
	}
	stack[top + 1] = s;
	top++;
	
    }

    public double pop(){
	double res = stack[top];
	stack[top] = 0;
	top--;
	return res;
    }

    public double peek(){
	return stack[top];
    }

    private void grow(){
	double[] newStack = new double[stack.length*2];
	for (int x = 0; x < stack.length;x++){
	    newStack[x] = stack[x];
	}
	stack = newStack;
    }

    public String toString(){
	String res = "";
	int temp = top;
	while (temp != -1){
	    res += stack[temp] + " ";
	    temp--;
	}
	return res;
    }
   
}
