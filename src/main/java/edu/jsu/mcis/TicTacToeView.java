package edu.jsu.mcis;

public class TicTacToeView {

    private TicTacToeModel model;
    
    /* CONSTRUCTOR */
	
    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;
        
    }
	
    public void viewModel() {
        
        /* Print the board to the console (see examples) */
        
        /* INSERT YOUR CODE HERE */
        //needs 29 fields
        System.out.print("\n  "); // 2 blank lines with 2 spaces on next line
        for (int i = 0; i < model.getWidth(); i++){
            System.out.print(i);
        }
        System.out.println("\n");
        // Loop through rows
        for (int i = 0; i < model.getWidth(); i++) { 
            System.out.print(i + " ");       
            // Loop through columns
            for (int j = 0; j < model.getWidth(); j++) {
                System.out.print(model.getMark(i,j)); // number of line with 1 space followed by grid
                if(j == model.getWidth() - 1){
                    System.out.print("\n");
                }
            }
        } 
        System.out.println("");
    }

    public void showNextMovePrompt() {

        /* Display a prompt for the player's next move (see examples) */

        /* INSERT YOUR CODE HERE */
        if (model.isXTurn()){
            System.out.println("Player 1 (X) Move:");
        }
        else{
            System.out.println("Player 2 (O) Move:");          
        }
        System.out.print("Enter the row and column numbers, separated by a space: ");
    }

    public void showInputError() {

        /* Display an error if input is invalid (see examples) */

        /* INSERT YOUR CODE HERE */


        System.out.println("Invalid Input. Please try again.");
    }

    public void showResult(String r) {

        /* Display final winner */

        System.out.println(r + "!");

    }
	
}