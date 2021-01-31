import java.util.*;

public class Bagels2 {

    public static void main (String [] args)
    {
        final int DIGIT_LENGTH = 4;
        
        //instantiates random array
        int[] randNumber = new int[DIGIT_LENGTH];
        
        //creats random array
        for (int i =0; i<randNumber.length; i++)
        {
            randNumber[i] = (int)(Math.random()*9)+1;
        }

        for(int i: randNumber)
        {
            System.out.print(i);
        }

        introduction();
        /*
        int [] userGuesse = oneGame(randNumber, DIGIT_LENGTH);
        
        completeGame(userGuesse, randNumber, DIGIT_LENGTH);
        */
        int counter = 0;

        oneGame(randNumber, DIGIT_LENGTH);
        String statement = oneGameString(randNumber, DIGIT_LENGTH);

        if(statement.equals("fermi fermi fermi fermi "))
        {
            statement = "You got it right in " + counter + "guesses.";
            System.out.println(statement);
        }
    }

    public static void introduction()
    {
        System.out.println("Welcome to AP CS Bagels!");
        System.out.println("Im thinking of a 4 digit number");
        System.out.println("Each digit is between 1 and 9.");
        System.out.println("Try to guess my number, and I'll say fermi");
        System.out.println("for each digit you get right, and pica");
        System.out.println("for each correct digit in the wrong place.");
    }
    
    public static void oneGame(int [] randNumber, int DIGIT_LENGTH)
    {
        //instantiations
        Scanner sc = new Scanner(System.in);
        int [] userGuesse = new int[DIGIT_LENGTH];
        int index = DIGIT_LENGTH - 1;
        //user input
        System.out.print("Your guess?");
        int userGuesseRawNum = sc.nextInt();

        //adding the number to an array

        while(userGuesseRawNum>0)//assigning the players guesse to an array as single digits
        {
            userGuesse[index] = userGuesseRawNum%10;
            userGuesseRawNum/=10;
            index--;
        }

        String statement = checkGuesse(userGuesse, randNumber, DIGIT_LENGTH);
        System.out.println(statement);
    }

    public static String oneGameString(int [] randNumber, int DIGIT_LENGTH)
    {
        //instantiations
        Scanner sc = new Scanner(System.in);
        int [] userGuesse = new int[DIGIT_LENGTH];
        int index = DIGIT_LENGTH - 1;
        //user input
        System.out.print("Your guess?");
        int userGuesseRawNum = sc.nextInt();

        //adding the number to an array

        while(userGuesseRawNum>0)//assigning the players guesse to an array as single digits
        {
            userGuesse[index] = userGuesseRawNum%10;
            userGuesseRawNum/=10;
            index--;
        }

        String statement = checkGuesse(userGuesse, randNumber, DIGIT_LENGTH);
        return statement;
    }

    
    public static String checkGuesse(int [] userGuesse,int [] randNumber,int DIGIT_LENGTH)
    {
        String statement = "";
        boolean[] userBolean = new boolean[DIGIT_LENGTH];
        boolean[] randBoolean = new boolean[DIGIT_LENGTH];

        //this is for fermi
        for(int i = 0; i<DIGIT_LENGTH; i++)
        {
            if(userGuesse[i] == randNumber[i])
            {
                statement+="fermi ";
                randBoolean[i] = true;
                userBolean[i] = true;
            }
        }
        
        for(int i =0; i<DIGIT_LENGTH; i++)//parses through randomNumber
        {

            for(int z = 0; z<DIGIT_LENGTH; z++ )//parses through the guesse
            {
                if(i==z||userBolean[z] == true||randBoolean[i]==true)
                {

                }
                else if(randNumber[i] == userGuesse[z])
                {
                    statement+="pica ";
                    randBoolean[i] = true;
                    userBolean[z] = true;
                }
            }

        }
        if(statement.equals(""))
        {
            statement += "bagels";
        }
        return statement;
    }

    public static void completeGame(int [] userGuesse,int [] randNumber,int DIGIT_LENGTH)
    {
        oneGame(randNumber, DIGIT_LENGTH);
        String statement = checkGuesse(userGuesse, randNumber, DIGIT_LENGTH);
        System.out.println(statement);
    }

}