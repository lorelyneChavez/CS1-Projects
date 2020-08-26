import java.util.Scanner;
public class Pyramid {
  public static void main (String args[]) {
  Scanner scnr = new Scanner(System.in);


    System.out.println("Please enter the number of rows.");
    int rows = scnr.nextInt();
    System.out.println("The number of blocks is: " + pyramid(rows));
  }
  public static int pyramid(int n) {
    if (n <= 0)
      return 0;
    return n + pyramid(n-1);
  }
}
