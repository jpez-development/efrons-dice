package matches;

/**
 * This class runs the match iterations to generate a data set
 */
public class Umpire {
    /**
     * The letter of the first die layout
     */
    private final char die1;
    /**
     * The letter of the second die layout
     */
    private final char die2;
    /**
     * The amount of games to be played
     */
    private int gameAmount;
    /**
     * The amount of times the first die has won
     */
    private double winCount1;
    /**
     * The amount the second die has won
     */
    private double winCount2;

    /**
     * The rolling logic for the dice
     */
    private final DiceRoller roller;

    /**
     * This constructor assigns the wanted values to their variable and instantiates a DiceRoller
     * @param Die1 the letter of the first die layout
     * @param Die2 the letter of the second die layout
     * @param GameAmount the amount of games to be played
     */
    public Umpire(char Die1, char Die2, int GameAmount) {
        die1 = Die1;
        die2 = Die2;
        gameAmount = GameAmount;
        roller = new DiceRoller();
    }

    /**
     * This method runs every game needed to be played and outputs the results
     */
    public void startMatch() {
        while (gameAmount > 0) { //loop till all games completed
            int die1Result = roller.roll(die1); //roll the die
            int die2Result = roller.roll(die2); //roll the die

            if (die1Result > die2Result) {
                winCount1 += 1; //add to die1's win count if it won
            }
            else {
                winCount2 += 1; //add to die2's win count if it has won
            }

            gameAmount -= 1; //reduce games by one
        }
        char die1Upper = Character.toUpperCase(die1); //uppercase of die1's letter
        char die2Upper = Character.toUpperCase(die2);//uppercase of die2's letter
        System.out.println("Results from " + die1Upper + " vs " + die2Upper + ":\n" + die1Upper + " won " + winCount1 + "times with a win% of " + (winCount1/(winCount1+winCount2)) + "\n" + die2Upper + " won " + winCount2 + "times with a win% of " + (winCount2/(winCount1+winCount2))); //output results
    }
}
