import java.util.Scanner;

public class Bagels {
    public static void main(String [] args)
    {
        //this generates the number
        int[] randNumber = new int[4];
        for (int i =0; i<randNumber.length; i++)
        {
            randNumber[i] = (int)(Math.random()*9)+1;
        }
        
        introduction();

        int guesse = oneTurn(); 

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

    public static int oneTurn()
    {
        int guesse;
        Scanner sc = new Scanner(System.in);
        System.out.print("Your guess? ");
        guesse = sc.nextInt();

        return guesse;
    }

    public static String checkAnswers(int guesse, int[] randNumber)
    {
        boolean [] fermiBool = new boolean[4];
        String statement = "";
        int [] userGuesse = new int[4];
        int index = userGuesse.length - 1;
        while(guesse>0)//assigning the players guesse to an array as single digits
        {
            userGuesse[index] = guesse%10;
            guesse/=10;
            index--;
        }

        for(int i =0; i<userGuesse.length; i++)
        {
            if(randNumber[i]==userGuesse[i])
            {
                statement += "fermi";
                fermiBool[i] = true;
            }

            else
            {
                fermiBool[i] = false;
            }
        }

        for(int i = 0; i<randNumber.length; i++)
        {
            for(int z = 0; z<userGuesse.length; z++)
            {
                if(i == z)
                {

                }

                else if(fermiBool[i]==true)
                {

                }

                else if (randNumber[i] == userGuesse[z])
                {
                    statement += "pica";
                }

            }
        }
        if(statement.equals(""))
        {
            statement = "bagels";
        }
        return statement;
    }
    
}