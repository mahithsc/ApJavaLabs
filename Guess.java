import java.util.*;

public class Guess {

    public static final int MAX = 1000;

    public static void main(String [] args)
    {

        Scanner sc = new Scanner(System.in);
        
        int numGames = 0;
        int totalGuess = 0;
        String playAgain = "y";
        int bestGame = 0;

        introduction();


        while(playAgain.equals("y"))
        {
            System.out.println(" ");
            int numGuess = playGame(sc);
            System.out.print("Do you want to play again (y/n)? ");
            playAgain = sc.next();
            numGames++;
            totalGuess += numGuess;

            if(bestGame < numGuess)
            {
                bestGame = numGuess;
            }

        }

        report(numGames, totalGuess, bestGame);



        

    }

    public static void introduction() // gives an introduction of the game
    {
        System.out.println("Welcome to game guesse");
        System.out.println("Choose a number to begin");
        System.out.println("Then choose y or n at end");




    }


    public static int playGame(Scanner sc) // method starts one game
    {

        int playerGuess;
        int randNum = (int)(Math.random()*MAX)+1;
        System.out.println(randNum);
        int numGuess = 0;

        System.out.println("Im thinking of a number between 1 and 100");
        System.out.print("Your guess: ");
        playerGuess = sc.nextInt();

        while (playerGuess != randNum)
        {
            if(playerGuess > randNum)
            {
                numGuess++;

                System.out.println("Too high!");
                System.out.println("Your guess: ");
                playerGuess = sc.nextInt();
            }
            else if(playerGuess < randNum)
            {
                numGuess++;

                System.out.println("Too low!");
                System.out.println("Your guess: ");
                playerGuess = sc.nextInt();
            }
        }

        numGuess++;

        System.out.println("You got in " + numGuess + " guesses");

        return numGuess;
    }
        
    
            
        

    public static void report(int numGames, int totalGuess, int bestGame) //this method reports the stats to the player
    {
        System.out.println(" ");
        System.out.println("Overall results: ");
        System.out.println("\t total Games: " + numGames);
        System.out.println("\t total Guesses: " + totalGuess);
        System.out.println("\t guesses/game " + ((double)totalGuess/numGames));
        System.out.println("\t best game: " + bestGame);
    }
}
