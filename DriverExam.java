import java.util.Scanner;

public class DriverExam {

    public static void main(String [] args)
    {
        Scanner sc = new Scanner(System.in);
        String[] correctAnswers = {"B", "D", "A", "A", "C", "A", "B", "A", "C", "D", "B","C", "D", "A", "D", "C", "C", "B", "D", "A"};

        //instantiate array for student answers
        String[] studentAnswers = new String[20];

        //input for student answers
        for(int i = 0; i<studentAnswers.length; i++)
        {
            System.out.print("What is your answer for question #" + (i+1) + ": ");
            studentAnswers[i] = sc.nextLine().toUpperCase();
        }

        //correct answer counter
        int correct = totalCorrect(correctAnswers, studentAnswers);

        //incorrect answer counter
        int incorrect = totalIncorrect(correctAnswers, studentAnswers);

        //instantiation the missed question array
        int[] missed = questionMissed(studentAnswers);

        if(passsed(correct, incorrect))
        {
            System.out.println("You Passed");
        }
        else
        {
            System.out.println("You Failed");
        }

        System.out.println("Your score was: " + correct + "/" + (correct+incorrect));

        System.out.println("You missed questions: ");

        System.out.println(missed[0]);
    }

    public static int totalCorrect(String[] correctAnswers, String[] studentAnswers)
    {
        int correctCounter = 0;
        for(int i =0; i<correctAnswers.length; i++)
        {
            if(correctAnswers[i].equals(studentAnswers[i]))
            {
                correctCounter+=1;
            }
        }

        return correctCounter;
    }//end incorrect method

    public static int totalIncorrect(String[] correctAnswers, String[] studentAnswers)
    {
        int incorrectCounter = 0;
        for(int i =0; i<correctAnswers.length; i++)
        {
            if(!correctAnswers[i].equals(studentAnswers[i]))
            {
                incorrectCounter++;
            }
        }
        return incorrectCounter;
    }//end incorrect method

    public static boolean passsed(int correct, int incorrect)
    {
        if(correct>=15)
        {
            return true;
        }

        else
        {
            return false;
        }
    }//end bool method

    public static int[] questionMissed(String[] studentAnswers)
    {
        int missedCounter = 0;
        for(int i =0; i<studentAnswers.length; i++)
        {
            if(studentAnswers[i].equals(" "))
            {
                missedCounter+=1;
            }
        }

        int[] questionsMissed = new int[missedCounter];

        int index = 0;
        for(int i =0; i<studentAnswers.length; i++)
        {
            if(studentAnswers[i].equals(" "))
            {
                questionsMissed[index] = i+1;
                index++;
            }
        }
        return questionsMissed;
    }
    
}
