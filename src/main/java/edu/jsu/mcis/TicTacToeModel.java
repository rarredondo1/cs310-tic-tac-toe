package edu.jsu.mcis;

public class TicTacToeModel {
    
    private static final int DEFAULT_WIDTH = 3;
    
    /* Mark (represents X, O, or an empty square */
    
    public enum Mark {
        
        X("X"), 
        O("O"), 
        EMPTY("-");

        private String message;
        
        private Mark(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    /* Result (represents the final state of the game: X wins, O wins, a tie,
       or NONE if the game is not yet over) */
    
    public enum Result {
        
        X("X"), 
        O("O"), 
        TIE("Tie"), 
        NONE("none");

        private String message;
        
        private Result(String msg) {
            message = msg;
        }
        
        @Override
        public String toString() {
            return message;
        }
        
    };
    
    private Mark[][] grid; /* Game grid */
    private boolean xTurn; /* True if X is current player */
    private int width;     /* Size of game grid */
    
    /* DEFAULT CONSTRUCTOR */
    
    public TicTacToeModel() {
        
        /* No arguments (call main constructor; use default size) */
        
        this(DEFAULT_WIDTH);
        
    }
    
    /* CONSTRUCTOR */
    
    public TicTacToeModel(int width) {
        
        /* Initialize width; X goes first */
        
        this.width = width;
        xTurn = true;
        
        /* Create grid (width x width) as a 2D Mark array */

        /* INSERT YOUR CODE HERE */

        grid = new Mark[width][width];

        /* Initialize grid by filling every square with empty marks */

        /* INSERT YOUR CODE HERE */

        // Loop through rows
        for (int i = 0; i < width; i++) {           
            // Loop through columns
            for (int j = 0; j < width; j++) {
                grid[i][j] = Mark.EMPTY; // Fill grid with marks
            }
        } 
    }
	
    public boolean makeMark(int row, int col) {
        
        /* Place the current player's mark in the square at the specified
           location, but only if the location is valid and if the square is
           empty! */
        
        /* INSERT YOUR CODE HERE */

        //check if square is empty and within limits
        if(isValidSquare(row, col) && !isSquareMarked(row, col)){

            if(isXTurn()){
                this.grid[row][col] = Mark.X;
                xTurn = false;
            }
            else{
                this.grid[row][col] = Mark.O;
                xTurn = true;
            }
            return true;
        }
        else{
            return false;
        }
        
    }
	
    private boolean isValidSquare(int row, int col) {
        
        /* Return true if specified location is within grid bounds */
        
        /* INSERT YOUR CODE HERE */

        if(row < width && col < width && row >= 0 && col >= 0){
            return true;
        }
        return false;
    }
	
    private boolean isSquareMarked(int row, int col) {
        
        /* Return true if square at specified location is marked */
        
        /* INSERT YOUR CODE HERE */

        if (grid[row][col] != Mark.EMPTY){
            return true;
        }
        else{
            return false;
        }
    }
	
    public Mark getMark(int row, int col) {
        
        /* Return mark from the square at the specified location */
        
        /* INSERT YOUR CODE HERE */

        return grid[row][col];
        
    }
	
    public Result getResult() {
        
        /* Use isMarkWin() to see if X or O is the winner, if the game is a
           tie, or if the game is not over, and return the corresponding Result
           value */
        
        /* INSERT YOUR CODE HERE */
        Result gameResult = Result.NONE;
        if (isMarkWin(Mark.X)){
            gameResult = Result.X;
        }
        if (isMarkWin(Mark.O)){
            gameResult = Result.O;
        }
        else if (isTie()){
            gameResult = Result.TIE;
        }
        return gameResult;
    }
	
    private boolean isMarkWin(Mark mark) {
        
        /* Check the squares of the board to see if the specified mark is the
           winner */

        /* INSERT YOUR CODE HERE */
        
        int[] rowCount = new int[width];
		int[] colCount = new int[width];
		
		for(int i = 0; i < width; i++){
			for(int j = 0; j < width; j++){
                // check if square is marked then compares with mark
                //if mark equals X or O then add that mark to the list
				if(isSquareMarked(i, j)){
					if(getMark(i, j) == mark){
						rowCount[j] += 1;
						colCount[i] += 1;
					}
				}
			}
		}
        //return true if the list of marks are equal to the width
        //indicating a win of the specified mark
		for(int i = 0; i < width; i++){
			if(rowCount[i] == width || colCount[i] == width){
				return true;
			}
			
		}
		//Top left to bottom right diagonal
		boolean TLBRdiag = true;
		for(int i = 0; i < width; i++){
			if(!(grid[i][i] == mark)){
				TLBRdiag = false;
			}
        }
        //Bottom left to top right diagonal
		boolean BLTRdiag = true;
		for(int i = 0; i < width; i++){
			if(!(grid[width-1-i][i] == mark)){
				BLTRdiag = false;
			}
		}
		//return true if the list diag list is equal to the width
        //indicating a win of the specified mark
		if(TLBRdiag || BLTRdiag){
			return true;
		}
		
        return false;
        
    }
	
    private boolean isTie() {
        
        /* Check the squares of the board to see if the game is a tie */

        /* INSERT YOUR CODE HERE */
        boolean gridFull = true;          //doesnt work if last move is a winning mark
        for (int i = 0; i < width; i++) {
            for (int j = 0; j < width; j++) {
                if(!isSquareMarked(i,j)){
                    gridFull = false;
                }              
            }
        }
        if(gridFull == true){
            return true;
        }
        return false;

    }

    public boolean isGameover() {
        
        /* Return true if the game is over */
        
        return Result.NONE != getResult();
        
    }

    public boolean isXTurn() {
        
        /* Getter for xTurn */
        
        return xTurn;
        
    }

    public int getWidth() {
        
        /* Getter for width */
        
        return width;
        
    }
    
}