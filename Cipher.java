public class Cipher {

    public static void main(String [] args)
    {
        String codeWord = encrypt("Mahith");
        System.out.println(codeWord);

    }

    public static String removeWhitespaceAndConvertToUpper(String word) 
    {
        if(word.substring(0,1).equals(" ") && word.substring(word.length()-1).equals(" "))
        {
            word = word.substring(1, word.length()-1);
        }

        else if(word.substring(0,1).equals(" "))
        { 
            word = word.substring(1);
        }

        else if(word.substring(0,1).equals(" "))
        {
            word = word.substring(0, word.length());
        }

        word = word.toUpperCase();

        return word;
    }

    public static String substitute(String firstWord)
    { 
        
        String[] letters = new String[] {"A", "E", "I", "J", "O", "P", "R", "S", "T", "V", "X", " "};
        String[] chars = new String[] {"@", "=", "!", "?", "*", "#", "&", "$", "+", "^", "%", "_"};
        int z = 0;
        for(int i = 0; i<=11; i++)
        {
            firstWord = firstWord.replaceAll(letters[i], chars[z]);
            z++;
        }
        return firstWord;
        
    }

    public static String swapHalfsForEncrypt(String secondWord)
    {
        int length = secondWord.length();
        String firstPart;
        String secondPart;
        int midpoint = length/2;

        if(length%2 == 0)
        {
            firstPart = secondWord.substring(0,midpoint);
            secondPart = secondWord.substring(midpoint);
            secondWord = secondPart + firstPart;

        }

        else if(length%2 == 1)
        {
            midpoint++;
            firstPart = secondWord.substring(0,midpoint);
            secondPart = secondWord.substring(midpoint);
            secondWord = secondPart + firstPart;
        }

        return secondWord;

    }

    public static String swapFirst2WithLast2(String thirdWord)
    {
        String firstPart = thirdWord.substring(0, 2);
        String lastPart = thirdWord.substring(thirdWord.length()-2);
        String middlePart = thirdWord.substring(2,thirdWord.length()-2);
        thirdWord = lastPart + middlePart + firstPart;

        return thirdWord;
    }

    public static String swapMiddleChars(String fourthWord)
    {
        int length = fourthWord.length();
        int midPoint = length/2;
        String midPart;
        
        if(length%2==0)
        {
            midPoint--;
            midPart = fourthWord.substring(midPoint-1, midPoint+1) + fourthWord.substring(midPoint+1, midPoint+2);
            fourthWord = fourthWord.substring(0, midPoint-1) + midPart + fourthWord.substring(midPoint+2);
        }

        else if(length%2==1)
        {
            midPart = fourthWord.substring(midPoint+1, midPoint+2) + fourthWord.substring(midPoint-1, midPoint+1);
            fourthWord = fourthWord.substring(0, midPoint-1) + midPart + fourthWord.substring(midPoint+3);
        }

        return fourthWord;

    }//encryption methods

    public static String swapHalfsForDecrypt(String thirdWord)
    {

        int len = thirdWord.length();

        if(thirdWord.length() % 2 == 1)
        {
            len /=2;
            thirdWord = thirdWord.substring(len-1) + thirdWord.substring(0,len-1);
        }

        else if(thirdWord.length() % 2 == 0)
        {
            len /=2;
            thirdWord = thirdWord.substring(len) + thirdWord.substring(0,len);
        }
        
        return thirdWord;
    
    }

    public static String substituteDecrypt(String fourthWord)
    {
        String[] letters = new String[] {"A", "E", "I", "J", "O", "P", "R", "S", "T", "V", "X", " "};
        String[] chars = new String[] {"@", "=", "!", "?", "*", "#", "&", "$", "+", "^", "%", "_"};
        int z = 0;
        for(int i = 0; i<=11; i++)
        {
            fourthWord = fourthWord.replaceAll(chars[i], letters[z]);
            z++;
        }
        return fourthWord;
    }



    public static String encrypt(String word)
    {
        String firstWord = removeWhitespaceAndConvertToUpper(word);
        String secondWord = substitute(firstWord);
        String thirdWord = swapHalfsForEncrypt(secondWord);
        String fourthWord = swapFirst2WithLast2(thirdWord);
        String fifthWord = swapMiddleChars(fourthWord);
        return fifthWord;
    } //encryption finished

    public static decrypt(String codeWord)
    {
        String firstWord = removeWhitespaceAndConvertToUpper(codeWord);
        String secondWord = swapMiddleChars(firstWord);
        String thirdWord = swapFirst2WithLast2(secondWord);
        String fourthWord = swapHalfsForDecrypt(thirdWord);
        String fifthWord = substituteDecrypt(fourthWord);
        fifthWord = fifthWord.toLowerCase();
        return fifthWord;
    }
}
