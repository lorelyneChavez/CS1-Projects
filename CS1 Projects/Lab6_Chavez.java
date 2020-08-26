import java.util.Scanner;

public class Lab6_Chavez {
  public static void main (String[] args) {

  Scanner scnr = new Scanner (System.in);

  //Allow user to declare array length
  System.out.println("Hello user!");
  System.out.print("\t Please enter size of list: ");
  int sizeOfList = scnr.nextInt();

  //Declare 2 arrays of the same length (length chosen by user)
  int[] list1 = new int[sizeOfList];
  int[] list2 = new int[sizeOfList];

  //For loop to allow user to input values for list1
  int numInput1 = 1;
  System.out.println("Please enter values for list 1: ");
  for(int i = 0; i < sizeOfList; i++){
    System.out.print("Value [#" + numInput1 + "]: ");
    list1[i] = scnr.nextInt();
    numInput1++;
  }

  //For loop to allow user to input values for list2
  int numInput2 = 1;
  System.out.println("Please enter values for list 2: ");
  for(int j = 0; j < sizeOfList; j++){
    System.out.print("Value [#" + numInput2 + "]: ");
    list2[j] = scnr.nextInt();
    numInput2++;
  }

  //For loop to find max value in list1
  int max = 0;
  for(int k = 0; k < sizeOfList; k++){
    if(list1[k] > max){
      max = list1[k];
    }
  }
  System.out.println("Analysis: ");
  System.out.println("\t 1) Max value of List 1: " + max);

  //For loop to check if list1 is identical to list2
  boolean identical = false;
  for(int l = 0; l < sizeOfList; l++ ){
    if(list1[l] == list2[l]){
      identical = true;
    }
    else if(list1[l] != list2[l]){
      identical = false;
    }
  }
  System.out.println("\t 2) Identical lists: " + identical);

  //Nested for loop to find the values that both lists have in common
  System.out.print("\t 3) Common numbers: ");
  for(int m = 0; m < sizeOfList; m++){
    for(int n = 0; n < sizeOfList; n++){
      if(list1[m] == list2[n]){
      System.out.print(list1[m] + " ");
      }
    }
  }

  //For loop to find the average of list2
  double sum = 0.0;
  for(int o = 0; o < list2.length; o++){
    sum += list2[o];
  }
  double avgList2 = (double)(sum/sizeOfList);
  System.out.println("\n\t 4) Average value for List 2: " + avgList2);

  }
}
