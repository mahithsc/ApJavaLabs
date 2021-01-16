import java.util.Scanner;
public class LabOps {
    Scanner sc = new Scanner(System.in)
    {
        public static void main(String[]args)
        {
            System.out.print("Enter the String: ");
            String myString = sc.nextLine();
            
            for(int i = 0; i<myString.length; i++)
            {
                String x = first(myString);
                System.out.println(x + ",");
                myString = butFirst(myString);

            }
        }

        public static String first(String s)
        {
        return s.substring(0, 1); 
          
        }

        public static String butFirst(String s)
        {
            return s.substring(1);

        }
    }

    
}
