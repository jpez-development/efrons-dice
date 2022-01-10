package matches;

import java.util.Random;

/**
 * This class handles the rolling logic and probability of the dice
 */
public class DiceRoller {
    /**
     * Random number generator
     */
    private final Random rand;

    /**
     * Constructor instantiates rng
     */
    public DiceRoller() {
        rand = new Random();
    }

    /**
     * This method handles the actual rolling logic
     * @param die the assignation of the die that is to be rolled
     * @return the number that was rolled, or 99 as an error code
     */
    public int roll(char die) {
        switch (die) {
            case 'a':
                return switch (thirdsRoll()) {
                    case THIRD -> 0;
                    case TWOTHIRDS -> 4;
                };

            case 'b':
                return 3;

            case 'c':
                return switch (thirdsRoll()) {
                    case THIRD -> 6;
                    case TWOTHIRDS -> 2;
                };

            case 'd':
                switch (rand.nextInt(2)+1) {
                    case 1:
                        return 5;
                    case 2:
                        return 1;
                }

            default:
                System.out.println("Incorrect Input");
                return 99;

        }

    }

    /**
     * This method allows a die to be rolled that has a 2-thirds probability of landing on 1 number and a 1-third probability of rolling another
     * @return an enum that represents which one of the 2 numbers was rolled
     */
    private Fraction thirdsRoll() {
        int roll = rand.nextInt(3)+1;
        if (roll == 1 || roll == 2) {
            return Fraction.TWOTHIRDS;
        }else {
            return Fraction.THIRD;
        }
    }

    /**
     * An enum containing definitions of relevant fractions for this project
     */
    enum Fraction {
        THIRD,
        TWOTHIRDS
    }
}
