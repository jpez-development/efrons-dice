package matches;

import java.util.Random;

public class DiceRoller {
    private final Random rand;

    public DiceRoller() {
        rand = new Random();
    }

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

    private Fraction  thirdsRoll() {
        int roll = rand.nextInt(3)+1;
        if (roll == 1 || roll == 2) {
            return Fraction.TWOTHIRDS;
        }else {
            return Fraction.THIRD;
        }
    }

    enum Fraction {
        THIRD,
        TWOTHIRDS
    }
}
