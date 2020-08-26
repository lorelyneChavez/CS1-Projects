import java.util.Scanner;

public class MethodActivity7 {
  public static void main (String args[]){
  Scanner scnr = new Scanner(System.in);

    System.out.print("Please input an integer: ");
    int userInput = scnr.nextInt();
    System.out.println("\nThe sum is: " + sum(userInput));
  }

  public static int sum(int n) {
    int answer = 0;

    while(n >= 1) {
      answer += n % 10;
      n /=10;
    }
    return answer;
  }
}
