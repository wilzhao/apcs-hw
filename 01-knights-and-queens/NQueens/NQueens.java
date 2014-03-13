

public class NQueens{

    private char[][] board;
    private int[] queenXs,queenYs;
    private int totalQueens,numQueens;
    private boolean[][] changelog;
    private final char queen = 'Q';
    private final char blocked = 'X';
    private final char open = '.';

    private int counter;
    //s += "[2J"; clear
    //String s = "^[[0;0H"; place cursor at front
    public NQueens(){
	this(5);
    }

    public NQueens(int x){
	board = new char[x][x];
	changelog = new boolean[x][x];
	totalQueens = x;//also the length of the board
	numQueens = 0;
	queenXs = new int[x];
	queenYs = new int[x];
	counter = 0;
	for (int a = 0; a < x;a++){
	    for (int b = 0;b < x; b++){
		board[a][b] = open;
	    }
	}
    }

    private void updateBoard(){//updates the board to indicate blocked spaces
	for (int x = 0;x < numQueens;x++){
	    int qX = queenXs[x];
	    int qY = queenYs[x];
	    int a = 0, b = 0;
	    
	    while (a < totalQueens && b < totalQueens){
		try{
		    if (board[qX][qY+b] != queen){
			board[qX][qY+b] = blocked;
			changelog[qX][qY+b] = true;
		    }
		} catch (Exception e){}
		try{
		    if (board[qX][qY-b] != queen){
			board[qX][qY-b] = blocked;
			changelog[qX][qY-b] = true;
		    }
		} catch (Exception e){}
		try{
		    if (board[qX-a][qY] != queen){
			board[qX-a][qY] = blocked;
			changelog[qX-a][qY] = true;
		    }
		} catch (Exception e){}
		try{
		    if (board[qX+a][qY] != queen){
			board[qX+a][qY] = blocked;
			changelog[qX+a][qY] = true;
		    }
		} catch (Exception e){}
		try{		
		    if (board[qX+a][qY+b] != queen){
			board[qX+a][qY+b] = blocked;
			changelog[qX+a][qY+b] = true;
		    }
		} catch (Exception e){}
		try{
		    if (board[qX+a][qY-b] != queen){
			board[qX+a][qY-b] = blocked;
			changelog[qX+a][qY-b] = true;
		    }
		} catch (Exception e){}
		try{
		    if (board[qX-a][qY+b] != queen){
			board[qX-a][qY+b] = blocked;
			changelog[qX-a][qY+b] = true;
		    }
		} catch (Exception e){}
		try{
		    if (board[qX-a][qY-b] != queen){
			board[qX-a][qY-b] = blocked;
			changelog[qX-a][qY-b] = true;
		    }
		} catch (Exception e){}
		a++;b++;
	    }	    
    	}
	for (int i = 0; i < totalQueens;i++){
	    for (int j = 0; j < totalQueens;j++){
		if (!changelog[i][j] && board[i][j] == blocked){
		    board[i][j] = open;
		}
		changelog[i][j] = false;
	    }
	}
    }

    public void solve(int x, int y){
	//delay(20);
	try{
	    if (numQueens == totalQueens){
		return;
	    }
	    char loc = board[x][y];
	    
	    if (loc == open){
		board[x][y] = queen;
		queenXs[numQueens] = x;
		queenYs[numQueens] = y;
		numQueens++;

		updateBoard();
		System.out.println(this);
		solve(0,y+1);
	    } else {
		solve(x+1,y);
	    }
	} catch (Exception e){//goes here when the x-cor goes off the board
	    numQueens--;
	    int tbrQueenX = queenXs[numQueens];//tbr stands for "to be removed"
	    int tbrQueenY = queenYs[numQueens];
	    board[tbrQueenX][tbrQueenY] = open;
	    updateBoard();
	    System.out.println(this);
	    solve(tbrQueenX+1,tbrQueenY);
	}
    }

    public void delay(int n){
	try{
	    Thread.sleep(n);
	} catch (Exception e){
	    System.exit(0);
	}
       
    }

    public String toString(){
	String s = "[0;0H";
	counter++;
	for (int x = 0;x < board.length;x++){
	    for (int y = 0; y<board[x].length;y++){
		s+= board[x][y] + " ";
	    }
	    s += "\n";
	}

	s += "Iteration: " + counter + "\n";
	s += "Number of Queens: " + numQueens + "/" + totalQueens;//slightly strange with multiple digit numbers
	return s;
    }

}
