import java.util.Scanner;

public class MethodActivity8 {
  public static void main (String args[]){
  Scanner scnr = new Scanner(System.in);

    System.out.print("Please input a string: ");
    String userInput = scnr.nextLine();
    System.out.println("\nThe number of words in the string: " + wordCount(userInput));
  }

  public static int wordCount (String n) {
    if (n.isEmpty()) {
      return 0;
    }
    String [] words = n.split("\\s+");
    return words.length;
  }
}
