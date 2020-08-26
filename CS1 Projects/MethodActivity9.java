import java.util.Scanner;

public class MethodActivity9 {
  public static void main (String args[]){
  Scanner scnr = new Scanner(System.in);

    System.out.print("Please input a string: ");
    String userInput = scnr.nextLine();
    System.out.println("\nNumber of vowels in the string: " + (vowelCount(userInput)));
  }

  public static int vowelCount (String n) {

    int vCount = 0;
    for (int i = 0; i <n.length(); i++) {
      char vowel = n.charAt(i);
      if (vowel == 'a' || vowel == 'A' || vowel == 'e' || vowel == 'E' || vowel == 'i' || vowel == 'I' || vowel == 'o' || vowel == 'O' || vowel == 'u' || vowel == 'U') {
          vCount ++;
        }
      }
    return vCount;
    }
  }
