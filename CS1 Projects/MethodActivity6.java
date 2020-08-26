import java.util.Scanner;

public class MethodActivity6 {
  public static void main (String args[]){
  Scanner scnr = new Scanner(System.in);

    System.out.print("Please input a string: ");
    String userInput = scnr.next();

    System.out.print("\nThe middle character in the string is: ");
    System.out.println(middle(userInput));
  }

  public static String middle(String userInput) {
    int position;
    int length;
    if (userInput.length() % 2 == 0) {
      position = userInput.length() / 2 - 1;
      length = 2;
    }
    else {
      position = userInput.length () /2;
      length = 1;
    }
    return userInput.substring(position, position + length);
  }

}
