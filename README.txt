CS 275 - Lab 3 - Robert Edwards (rde25) & De Yu (dy87)

Instructions to Run
------------------------
Launch emulator or download apk to phone.
Navigate to the TicTacToe app icon and click it.
The play select the position you want to select by pressing it.
X will go first.
Game follows standard tic-tac-toe rules of three in of the same letter in a row to win.
If someone wins a dialog will show announcing the winner, and if there is a tie it will also be shown.
In the dialog box if the user wishes to play another match they can select the rematch option

Implementation & Design
-------------------------
To determine a winner we used a 2D array to represent the tic-tac-toe grid.
If there are 3 of the same characters in a row that are not null than a winner is announced.
To determine a tie we kept a count of how many moves have been made and if a winner has not been reached by the time we count all tiles to be filled there is a tie.
