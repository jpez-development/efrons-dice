import matches.Umpire;


public class Program {
    public static void main(String[] args) {
        char[][] games = {{'a','b'},{'a','c'},{'a','d'},{'b','c'},{'b','d'},{'c','d'}}; //an array of all the different matchings of dice
        for (char[] game: games) { //loops through each matching
            Umpire gamesHost = new Umpire(game[0],game[1],1000000000); // creates umpire object that will run the games to create data
            gamesHost.startMatch(); //starts the matches
        }
    }
}
