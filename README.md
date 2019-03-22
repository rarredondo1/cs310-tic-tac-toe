[![Tic Tac Toe Image -->](https://static3.scirra.net/images/newstore/products/2063/splash.png)]()
## Tic Tac Toe Project
> by
> Richard Arredondo

**Description**
- The purpose of this project was to learn the model, view, controller development model in order to gain the understanding of how to split
the program into its parts to be able to read it easily without being confused by the parts that work independently.

**Model View Controller**
1. Model
> The model is used to holds the data for the program.
   - The model holds the functions:
      - TicTacToeMode() // constructs the grid of squares for the board
      - makeMark() // places mark if square is valid
      - isValidSquare() // checks to see if mark is in board bounds
      - isSquareMarked() // checks if square is marked
      - getMark() // returns mark of specified square
      - getResult() // returns value of board win or no win
      - isMarkWin() // checks board for win
      - isTie() // checks if tie
      - isGameover() // checks if board is full or if a mark has won
      - isXTurn() // checks for X turn
      - getWidth() // gets the width specified at the beginning of game
2. View
> The view is used to make the program look nice.
   - The view holds the functions:
      - viewModel() // prints the board to the command console
      - showNextMovePrompt() // displays prompt for next player move
      - showInputError() // displays error if input is invalid
      - showResult() // displays winning mark
3. Controller
> The controller is used to control how the program should work.
   - The controller holds the functions:
      - TicTacToeController() // initilises the model and view
      - controlModel() // prompts player for next move through views function



**MVC parts**

-- the parts 
