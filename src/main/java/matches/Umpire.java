package matches;


public class Umpire {
    private final char die1;
    private final char die2;
    private int gameAmount;
    private double winCount1;
    private double winCount2;

    private final DiceRoller roller;


    public Umpire(char Die1, char Die2, int GameAmount) {
        die1 = Die1;
        die2 = Die2;
        gameAmount = GameAmount;
        roller = new DiceRoller();
    }

    public void startMatch() {
        while (gameAmount > 0) {
            int die1Result = roller.roll(die1);
            int die2Result = roller.roll(die2);

            if (die1Result > die2Result) {
                winCount1 += 1;
            }
            else {
                winCount2 += 1;
            }

            gameAmount -= 1;
        }
        char die1Upper = Character.toUpperCase(die1);
        char die2Upper = Character.toUpperCase(die2);
        System.out.println("Results from " + die1Upper + " vs " + die2Upper + ":\n" + die1Upper + " won " + winCount1 + "times with a win% of " + (winCount1/(winCount1+winCount2)) + "\n" + die2Upper + " won " + winCount2 + "times with a win% of " + (winCount2/(winCount1+winCount2)));
    }
}
