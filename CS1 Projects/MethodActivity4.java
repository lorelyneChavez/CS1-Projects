import java.util.Scanner;

public class MethodActivity4 {
  public static void main (String args[]){
  Scanner scnr = new Scanner(System.in);

    System.out.println("Please input 3 numbers.");
    int a = scnr.nextInt();
    int b = scnr.nextInt();
    int c = scnr.nextInt();

    small(a,b,c);
    System.out.print("The smallest value is: ");
    System.out.println(small(a,b,c));

  }

  public static int small(int a, int b, int c){
    if(a < b && a < c) {
      return a;
    }
    else if(b < a && b < c) {
      return b;
    }
    else {
      return c;
    }
  }
}
