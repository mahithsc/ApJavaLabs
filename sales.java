import java.util.Scanner;

public class sales 
{
    
    public static void main(String [] args)
    {
        Scanner sc = new Scanner (System.in);
        int [] intSales = new int[5];
        int [] idNum = new int[5];

        for(int i =0; i<5; i++)
        {
            System.out.print("Please print out the the sales numbers for employee # " + (i+1)+ ": ");
            intSales[i] = sc.nextInt();
        }

        System.out.println(" ");
        System.out.println(" ");

        for(int z =0; z<5; z++)
        {
            System.out.print("Please print out the the id numbers for employee #" + (z+1)+ ": ");
            idNum[z] = sc.nextInt();
        }

        System.out.println(" ");

        System.out.println("Slaes: ");

        int average = 0;
        for(int x = 0; x<5; x++)
        {
            System.out.println("Employee # " + idNum[x] + "-----> " + intSales[x]);
            average += intSales[x];
        }

        System.out.println("Sum of the sales = " + average);

        average /= 5;

        //Average statement
        System.out.println("Avergae: " + average);

        //Maximum statement
        String maxStatement = Max(intSales, idNum);
        System.out.println(maxStatement);

        //Minimum Statement
        String minStatement = Min(intSales, idNum);
        System.out.println(minStatement);

        //exceeding statement
        exceedAmmount(intSales, idNum);


    }

    public static String Max(int [] intSales, int [] idNum)
    {
        int max = 0;
        int employee = 0;
        

        for(int i = 0; i<5; i++)
        {
            if (intSales[i] > max)
            {
                max = intSales[i];
                employee = i + 1;
            }
        }
        
        String maxStatement = "Salesperson " + employee + " had the highest sale with $" + max;

        return maxStatement;
    }

    public static String Min(int [] intSales, int [] idNum)
    {
        int min = 0;
        int employee = 0;
        

        for(int i =0; i<5; i++)
        {
            if (intSales[i] < min);
            {
                min = intSales[i];
                employee = i + 1;
            }
        }
        
        String minStatement = "Salesperson " + employee + " had the lowest sale with $" + min;

        return minStatement;
    }

    public static void exceedAmmount(int [] intSales, int [] idNum )
    {
        Scanner sc = new Scanner(System.in);

        System.out.print("Please choose a price: ");
        int choice = sc.nextInt();
        int numEmployees = 0;

        for(int i =0; i<5; i++)
        {
            if(intSales[i]>choice)
            {
                System.out.println("Employee #" + idNum[i] + "----> " + intSales[i]);
                numEmployees++;
            }
        }

        System.out.println("The number of employees who exceeded this is " + numEmployees);
    }

}

/*
Create a class called Sales.java – which contains a Java program that prompts for and reads in the sales for each of 5 salespeople in a company. It then prints out the id and amount of sales for each salesperson and the total sales., then compile and run the program to see how it works.  

1.	Compute and print the average sale. (You can compute this directly from the total; no loop is necessary.) 
2.	Find and print the maximum sale. Print both the id of the salesperson with the max sale and the amount of the sale, e.g., "Salesperson 3 had the highest sale with $4500." Note that you don't need another loop for this; you can do it in the same loop where the values are read and the sum is computed. 
3.	Do the same for the minimum sale. 
4.	After the list, sum, average, max and min have been printed, ask the user to enter a value. Then print the id of each salesperson who exceeded that amount, and the amount of their sales. Also print the total number of salespeople whose sales exceeded the value entered.
*/