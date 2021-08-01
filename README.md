# Game-Of-Life
Based on cellular automation devised by British mathematician John Horton Conway.
It is a zero-player concept but project was aimed to make it into a one-person scoring game in JAVA.

Read about Conway's Game of Life [here](https://en.wikipedia.org/wiki/Conway%27s_Game_of_Life).

## Rules

1. A cell will die if it has 0 to 1 neighbours (UnderPopulation).
2. A cell will live only if it has 2 to 3 neighbours.
3. A cell will die if it has more than three neighbours (Overpopulation).
4. A cell will regenerate if it has exactly 3 neighbours (Reproduction).

## GamePlay

1. The player has to select a cell in the initial set up of the board.
   - All the values are set to zero.(BoardCreation.java)
2. Then the user will need to input the cell number (between 1 to 25).
   - First move will consists of the cell inputs.
   - After this, all the subsequent moves will require one cell input only.
3. Points are supplied to the borad on the basis of cell populaiton at the end of every move.
4. Final score is the sum of all non-zero cells in the board.

## Future Work

1. Implementation of better score calculation.
2. Addition of UI instead of the curent command line interface.
3. Saving player information like username, score using FIle I/O.
   - Create a leaderboard
   
## Possible Extensions

1. Add spring framework for better dependency injection.
2. Develop framework to collect data points which can be used for strategies or analysis.
3. Addition of the second player and update rules accordingly.

###### DATE CREATED : JULY 2020
