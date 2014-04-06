

public class MyStackArray{

    private int top;
    private String[] stack;

    public MyStackArray(){
	stack = new String[10];
	top = -1;
    }

    public void push(String s){
	if (top + 1 == stack.length){
	    grow();
	}
	stack[top + 1] = s;
	top++;
	
    }

    public String pop(){
	String res = stack[top];
	stack[top] = null;
	top--;
	return res;
    }

    public String peek(){
	return stack[top];
    }

    private void grow(){
	String[] newStack = new String[stack.length*2];
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
