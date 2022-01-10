import matches.Umpire;

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicInteger;


public class Program {
    public static void main(String[] args) {
        Scanner inputs = new Scanner(System.in);
        System.out.println("Enter the amount of rounds for each match: ");
        AtomicInteger input = new AtomicInteger();
        try {
            input.set(inputs.nextInt());
        }catch (InputMismatchException e) {
            System.out.println("There was an incorrect input, we will use the default number of 10,000 rounds");
            input.set(10000);
        }
        char[][] games = {{'a','b'},{'a','c'},{'a','d'},{'b','c'},{'b','d'},{'c','d'}}; //an array of all the different matchings of dice
        for (char[] game: games) { //loops through each matching
            Umpire gamesHost = new Umpire(game[0],game[1], input.get()); // creates umpire object that will run the games to create data
            gamesHost.startMatch(); //starts the matches
        }
    }
}
