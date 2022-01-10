import matches.Umpire;


public class Program {
    public static void main(String[] args) {
        char[][] games = {{'a','b'},{'a','c'},{'a','d'},{'b','c'},{'b','d'},{'c','d'}};
        for (char[] game: games) {
            Umpire gamesHost = new Umpire(game[0],game[1],1000000000);
            gamesHost.startMatch();
        }
    }
}
