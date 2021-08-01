// Game of Life trial 1
// Rules :
// 1. A cell will die if it has 0 to 1 neighbours (UnderPopulation).
// 2. A cell will live only if it has 2 to 3 neighbours.
// 3. A cell will die if it has more than three neighbours (Overpopulation).
// 4. A cell will regenerate if it has exactly 3 neighbours (Reproduction).


package com.GOF;



public class Main {

    public static void main(String[] args)
    {
        Game game = new Game();
        game.start();
    }

}
class Game
{
    void start()
    {
        BoardCreation boardCreation= new BoardCreation();
        GameFlow gameFlow = new GameFlow();

        int initial_chance = 3;

        // Create Board
        boardCreation.init();
        boardCreation.ruleDisplay();

        // Begin with initial chance
        //boardCreation = gameFlow.stageOne(boardCreation,initial_chance);
        gameFlow.beginGame(boardCreation,initial_chance);

        boardCreation.displayPoints();

    }
}
