import java.beans.Statement;
import java.util.Scanner;

public class Bagels 
{
    public static void main(String [] args)
    {
        final int NUM_DIGITS = 4;
        //this generates the number
        int[] randNumber = new int[NUM_DIGITS];
        for (int i =0; i<randNumber.length; i++)
        {
            randNumber[i] = (int)(Math.random()*9)+1;
        }
        
        introduction();
        int guesse = oneTurn();
        oneGame(guesse, randNumber, NUM_DIGITS);

    }//end main

    public static void introduction()
    {
        System.out.println("Welcome to AP CS Bagels!");
        System.out.println("Im thinking of a 4 digit number");
        System.out.println("Each digit is between 1 and 9.");
        System.out.println("Try to guess my number, and I'll say fermi");
        System.out.println("for each digit you get right, and pica");
        System.out.println("for each correct digit in the wrong place.");
        //standard intro following the format
    }//end intro

    public static int oneTurn()
    {
        int guesse;
        Scanner sc = new Scanner(System.in);
        System.out.print("Your guess? ");
        guesse = sc.nextInt();

        return guesse;
    }//end oneTurn

    public static String checkAnswers(int guesse, int[] randNumber, int NUM_DIGITS)
    {
        boolean [] fermiBool = new boolean[NUM_DIGITS]; //if the digit is already occupied for fermi, its true
        String statement = "";
        int [] userGuesse = new int[NUM_DIGITS];
        int index = userGuesse.length - 1;
        boolean [] userGuesseBool = new boolean[NUM_DIGITS];
        while(guesse>0)//assigning the players guesse to an array as single digits
        {
            userGuesse[index] = guesse%10;
            guesse/=10;
            index--;
        }

        for(int i =0; i<userGuesse.length; i++)//this sequnce is to text for fermi
        {
            if(randNumber[i]==userGuesse[i])
            {
                statement += " fermi";
                fermiBool[i] = true;
            }

            else
            {
                fermiBool[i] = false;
            }
        }//sequence for fermi ends

        for(int i = 0; i<randNumber.length; i++) //sequence for pica
        {
            for(int z = 0; z<userGuesse.length; z++)
            {
                if(i == z|| fermiBool[i]==true||userGuesseBool[z]==true)
                {
                }//if both indexes are the same || one index occupied, do nothing

                else if (randNumber[i] == userGuesse[z])
                {
                    statement += " pica";
                    userGuesseBool[z] = true;
                }

            }
        }//pica sequence ends

        if(statement.equals(""))
        {
            statement = "bagels";
        }//bagels sequencs

        if(randNumber[1]==userGuesse[1]&&randNumber[2]==userGuesse[2]&&randNumber[3]==userGuesse[3]&&randNumber[0]==userGuesse[0])
        {
            statement= "You got it right in";
        }
        return statement;
    }//end check answer

    public static void oneGame(int guesse, int[] randNumber, int NUM_DIGITS)
    {
        int counter = 0;
        oneTurn();
        String statement = checkAnswers(guesse, randNumber, NUM_DIGITS);
        counter++;
        while(!statement.equals("You got it right in")
        {
            oneTurn();
            statement = checkAnswers(guesse, randNumber, NUM_DIGITS);
            counter++;
        }
        statement = statement + " " + counter + " tries";
        System.out.println(statement);
    }
    
}//end class

/*
Revised Pseudocode:
1. First things first write the intro
2. Generate a number without any zeros
    - create an array that generates number 1-9 included in a for loop
*/