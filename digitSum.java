public class digitSum {
    public static void main(String [] args)
    {
       sum(555);
    }

    public static void sum(int x)
    {
        int newNum;
        int sum = 0;
        sum += x % 10;
        while (x > 0)
        {
            newNum = x/10;
            sum += newNum % 10;
        }

        System.out.println(sum);
    } 
    
}

//enter a number into the parameter
//create the integer entered as a primitive as an object
//find the length of the intiger
//create a for loop which will iterate the same umber of times as the length of the intiger
//create an int varibale with the updated value of the sum
//for each itteration of the for loop the variabel will update with the new value of that value

