import java.io.*;
import java.util.*;

public class KnightsTour{

    private int[][] board;
    private int currentNum;
    private int maxNum;
    private boolean complete;
    private int counter;


    public KnightsTour(){
	this(5,5);
    }

    public KnightsTour(int rows, int cols){
	currentNum = 1;
	board = new int[rows][cols];
	maxNum = rows*cols;
	counter = 0;
    }

    public void delay(int n){
	try{
	    Thread.sleep(n);
	} catch (Exception e){
	    System.exit(0);
	}
       
    }

    public void solve(int x, int y){
	//delay(1);
	try{
	    if (currentNum > maxNum){
		return;
	    }
	    int temp = board[x][y];
	    if (temp == 0){
		if (currentNum == maxNum){
		    board[x][y] = maxNum;
		    complete = true;
		    currentNum++;
		    return;
		} else {
		    board[x][y] = currentNum;
		    currentNum++;
		    if (!complete){
			solve(x+2,y+1);
			System.out.println(this);
		    }
		    if (!complete){
			solve(x+1,y+2);
			System.out.println(this);
		    }
		    if (!complete){
			solve(x-2,y+1);
			System.out.println(this);
		    }
		    if (!complete){
			solve(x-1,y+2);
			System.out.println(this);
		    }
		    if (!complete){
			solve(x+2,y-1);
			System.out.println(this);
		    }
		    if (!complete){
			solve(x+1,y-2);
			System.out.println(this);
		    }
		    if (!complete){
			solve(x-2,y-1);
			System.out.println(this);
		    }
		    if (!complete){
			solve(x-1,y-2);
			System.out.println(this);
		    }
		    if (!complete){
			board[x][y] = 0;
			currentNum--;
		    }
		}
	    } else {
		return;
	    }
	} catch(Exception e){
	    return;
	}
	System.out.println(this);
    }

    public String toString(){
	counter++;
	String s = "[0;0H";
	//s += "[2J";
	//String s = "^[[0;0H";
	//return s + "BLAH";
	for (int x = 0; x < board.length;x++){
	    for (int y = 0; y < board[x].length;y++){
		s+= board[x][y] + " ";
	    }
	    s+= "\n";
	}
	s += "Iteration: " + counter + "\n";
	
	return s;

    }

}
