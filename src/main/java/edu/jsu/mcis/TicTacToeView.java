package edu.jsu.mcis;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

@SuppressWarnings("serial")
public class TicTacToeView extends JPanel implements ActionListener{

    private TicTacToeModel model;

    private JButton[][] squares;
    private JPanel squaresPanel;
    private JLabel resultLabel;

    /* CONSTRUCTOR */
	
    public TicTacToeView(TicTacToeModel model) {
        
        this.model = model;   

        /***************GUI VIEW****************/
        int width = model.getWidth();

        this.setLayout(new BoxLayout(this, BoxLayout.PAGE_AXIS));
        squares = new JButton[width][width];
        squaresPanel = new JPanel(new GridLayout(width,width));
        resultLabel = new JLabel();
        resultLabel.setName("ResultLabel");
        
        for (int row = 0; row < width; row++){
            
            for (int col = 0; col < width; col++){
                
                squares[row][col] = new JButton(); 
                squares[row][col].addActionListener(this);
                squares[row][col].setName("Square" + row + col);
                squares[row][col].setPreferredSize(new Dimension(64,64));
                squaresPanel.add(squares[row][col]);
            }
        }

        this.add(squaresPanel);
        this.add(resultLabel);
        
        resultLabel.setText("Welcome to Tic-Tac-Toe!");

    }
/*  //code for part one
    public void viewModel() {
        
        /* Print the board to the console (see examples) */
        
        /* INSERT YOUR CODE HERE 
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

        /* INSERT YOUR CODE HERE 
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

        /* INSERT YOUR CODE HERE 


        System.out.println("Invalid Input. Please try again.");
    }
*/
    @Override
    public void actionPerformed(ActionEvent event) {
        
        /* Handle button clicks.  Extract the row and col values from the name
           of the button that was clicked, then make the mark in the grid using
           the Model's "makeMark()" method.  Finally, use the "updateSquares()"
           method to refresh the View.  If the game is over, show the result
           (from the Model's "getResult()" method) in the result label. */
        
        String name = ((JButton) event.getSource()).getName(); // Get button name
        //all pass
        String rowName = "" + name.charAt(6);
        String colName = "" + name.charAt(7);

        int row = Integer.parseInt(rowName);
		int col = Integer.parseInt(colName);
		
		model.makeMark(row, col);
		
        updateSquares();

        if(model.isGameover()){
			showResult(model.getResult().toString());
		}
    }

    public void updateSquares() {

        /* Loop through all View buttons and (re)set the text of each button
           to reflect the grid contents (use the Model's "getMark()" method). */
           
           
        for(int i = 0; i < model.getWidth(); i++){
            for(int j = 0; j < model.getWidth(); j++){
                squares[i][j].setText(model.getMark(i, j).toString());	
            }
		}
    }
    public void showResult(String message) {
        resultLabel.setText(message);
    }
}