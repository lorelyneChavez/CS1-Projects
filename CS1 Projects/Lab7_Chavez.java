import java.util.Scanner;
public class Lab7_Chavez {
  public static void main(String args[]) {
  Scanner scnr = new Scanner(System.in);

  System.out.println("\nWelcome to Set Calculator. Choose one of the following methods.");
  System.out.println("1. Power");
  System.out.println("2. Factorial");
  System.out.println("3. Combination");
  System.out.println("4. Permutation");
  String methodChoice = "";
  System.out.print("Method choice: " );
  methodChoice = scnr.nextLine();

  int n = 0;
  int m = 0;
  int r = 0;
  if(methodChoice.equals("1") || methodChoice.equalsIgnoreCase("power")){
      System.out.println("\nAwesome! You have chosen the Power Method.");
      System.out.print("Please input the base number: ");
      n = scnr.nextInt();
      System.out.print("Please input the power number: ");
      m = scnr.nextInt();
      System.out.println("Answer: " + power(n, m));
    }
    if(methodChoice.equals("2") || methodChoice.equalsIgnoreCase("factorial")){
      System.out.println("\nAwesome! You have chosen the Factorial Method.");
      System.out.print("Please input a number for the method: ");
      n = scnr.nextInt();
      System.out.println("\nAnswer: " + factorial(n));
    }
    if(methodChoice.equals("3") || methodChoice.equalsIgnoreCase("combination")){
      System.out.println("\nAwesome! You have chosen the Combination Method.");
      System.out.print("Please input the first number: ");
      n = scnr.nextInt();
      System.out.print("Please input the second number: ");
      r = scnr.nextInt();
      System.out.println("\nAnswer: " + combination(n, r));
    }
    if(methodChoice.equals("4") || methodChoice.equalsIgnoreCase("permutation")){
      System.out.println("\nAwesome! You have chosen the Permutation Method.");
      System.out.print("Please input the first number: ");
      n = scnr.nextInt();
      System.out.print("Please input the second number: ");
      r = scnr.nextInt();
      System.out.println("\nAnswer: " + permutation(n, r));
    }

  }

  public static int power (int n, int m) {
    if (m == 0){
      return 1;
    }else{
      return n * power(n, m - 1);
    }
  }

  public static int factorial (int n) {
    if (n == 1)
        return 1;
      return n * factorial(n-1);
  }

  public static int combination (int n, int r) {
    if (n == 1)
      return 1;
    return factorial(n)/(factorial(r)*factorial(n-r));
  }

  public static int permutation (int n, int r) {
    if (n == 1)
      return 1;
    return (factorial(n)/factorial(n-r));
  }
}
