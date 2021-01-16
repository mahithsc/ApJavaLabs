import java.util.Scanner;
public class ProcessName{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Type your full name: ");
        
        //your code goes here
        String firstLastname = sc.nextLine();
        int position = firstLastname.indexOf(" ");
        //System.out.println(position);
        String name = firstLastname.substring(position + 1) + ", " + firstLastname.substring(0, 1) + ".";
        System.out.println(name);
    }
}

//take in user input for the name
//usee .indexOf to find the space in the name
//add 1 to the intiger and store the rest of the string in a variale, this is the last name
//take the first index value of the string and store it in varible, this is the initial of the first name
//store the two varibales in the correct format in the variables names
//print out names

