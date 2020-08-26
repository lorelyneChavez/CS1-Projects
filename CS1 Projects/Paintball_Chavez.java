import java.io.*;
import java.lang.Math;
import java.util.Random;

/**
 * <h1>Paintball</h1>
 *The Paintball program implememts an application where you monitor a soldier, Mark, in the field and order
  it to eliminate the target that is closest to him.
 *<p>
 *<b>Note:</b> *The Paintball program implememts the use of methods, 2D arrays, and recursion.
 *@author Lorelyne Chavez
 *@version 1.0
 *@since 2020-04-08
 */

public class Paintball_Chavez {


    /*
    --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                                             main METHOD
    --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    */

    /**
    * This is the main method which makes use of all Paintball methods.
    *@param args unused.
    @return nothing.
    */
    public static void main(String args[]) {
        //Declaring the size of the grid and the symbols inside the cells
        int rows = 10;
        int columns = 10;
        char symbol = '-';

        char[][] grid = createGrid(rows, columns, symbol);
        grid = modifyGrid(grid);

        System.out.println("\n" + "--------------GRID--------------" + "\n");
        displayGrid(grid);

        //Calls the method to get the coordinates for 'S'
        int[] S = getCoordinates(grid, 'S');
        //Calls the method to get the coordinates for 'T'
        int[] T2 = getCoordinates(grid, 'T');
        //Calls the method with recursion to search for the second T coordinates.
        int[] T = recurse(grid, 0, 0, 'T');

        System.out.print("\nSoldier points: ");
        //Calls method to print soldier coordinates
        printCoordinates(S);
        System.out.print("\nTarget points: ");
        //Calls method to print soldier coordinates
        printCoordinates(T);
        printCoordinates(T2);
        System.out.println();

        System.out.print("\n" + "PARK! ELIMINATE TARGET LOCATED IN THESE COORDINATES: ");
        //This method prints the coordinates of target that needs to be eliminated, distance, and bullet travel time.
        int[] target = chooseTarget(S, T, T2);
        System.out.println();

        grid = eliminateTarget(grid, target);
        System.out.println("\nModified Grid:");
        System.out.println();
        displayGrid(grid);

    } //END OF MAIN


    /*
    --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                                           createGrid METHOD
    --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    */

    /**
     *This method will receive as input total number of rows and total number of columns and a character representing
      the symbol ‘-‘. Then, it will create a rows by columns 2D array and initialize the array with hyphens (-). This
      method then returns the 2D character array.
     *@param rows This is the first parameter to createGrid method.
     *@param columns This is the first parameter to createGrid method.
     *@param symbol This is the third parameter to createGrid method.
     *@return char[][] This returns the 2D array which is the grid of the program.
     */
    public static char[][] createGrid(int rows, int columns, char symbol) {
        char[][] grid = new char[rows][columns];
        // This for loop will loop through all rows
        for (rows = 0; rows < grid.length; rows++) {
            // This for loop will loop through each column of that row
            for (columns = 0; columns < grid[rows].length; columns++) {
                grid[rows][columns] = symbol;
            }
        }
        return grid;
    }

    /*
    --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                                             displayGrid METHOD
    --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    */

    /**
     *This method will accept a 2D array of characters and display the contents of the array in a suitable format.
     *@param grid 2-D array of charcters.
     *@return nothing.
     */

    public static void displayGrid(char grid[][]) {
        //Print grid refernce numbers for user
        System.out.printf("%-3s", "");
        for (int i = 0; i < grid[0].length; i++) {
            System.out.printf("%-3d", i);
        }
        System.out.println();
        for (int i = 0; i < grid.length; i++) {
            System.out.printf("%-3d", i);
            for (int j = 0; j < grid[0].length; j++) {
                System.out.printf("%-3c", grid[i][j]);
            }
            System.out.println();
        }
    }


    /*
    --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                                               modifyGrid METHOD
    --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    */

    /**
    *This method will first randomly choose 3 points (make sure there are no duplicates) or
     coordinates in the form of (x,y) from the grid and replace any one with ‘S’ and the
     rest two with ‘T’. This method then returns the modified grid.
    *@param grid An array of characters.
    *@return char a modified grid (2D array of characters).
    */

    public static char[][] modifyGrid(char grid[][]) {

        //Create a random object
        Random rand = new Random();

        //Generate random coordinates for the soldier
        //Coordinates range from 0-9
        int soldier_x = rand.nextInt(10);
        int soldier_y = rand.nextInt(10);

        //Generate random coordinates for the first target
        //Coordinates range from 0-9
        int target1_x = rand.nextInt(10);
        int target1_y = rand.nextInt(10);

        //Generate random coordinates for the second target
        //Coordinates range from 0-9
        int target2_x = rand.nextInt(10);
        int target2_y = rand.nextInt(10);

        //Created a for loop to prevent duplicates
        for (int i = 0; i < grid.length; i++) {
            if ((soldier_x == target1_x) && (soldier_y == target1_y) || (soldier_x == target2_x) && (soldier_y == target2_y)) {
                soldier_x = rand.nextInt(10);
                soldier_y = rand.nextInt(10);
            }
            if ((target1_x == target2_x) && (target1_y == target2_y)) {
                target2_x = rand.nextInt(10);
                target2_y = rand.nextInt(10);
            }
        }

        //Save soldier coordinates in variable S
        grid[soldier_x][soldier_y] = 'S';
        //Save first target's coordinates in variable T
        grid[target1_x][target1_y] = 'T';
        //Save second target's coordinates in variable T
        grid[target2_x][target2_y] = 'T';

        return grid;
    }

    /*
    --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                                               getCoordinates METHOD
    --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    */

    /**
     *This method will recieve the modified grid array as input and search for the symbol S or T.
     *Then it will return an array containing coordinates of the point in the grid containing the symbol.
     *@param grid The grid (2-D array)
     *@param symbol The symbol S or T depending on the condition.
     *@return A 1-D integer array containing coordinates of S or T.
     */
    public static int[] getCoordinates(char grid[][], char symbol) {
        //Create an integer array of size 2 for the coordinates
        int[] coordinates = new int[2];
        if (symbol == 'S' || symbol == 'T') {
            //Create a nested loop to go through each element in the 2-D array
            for (int i = 0; i < grid.length; i++) {
                for (int j = 0; j < grid[i].length; j++) {
                    if (grid[i][j] == symbol) {
                        //Once a symbol is found save their corresponding coordinates
                        coordinates[0] = i;
                        coordinates[1] = j;
                    }
                }
            }
        }
        return coordinates;
    }

    /*
    --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                                                 getDistance METHOD
    --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    */

    /**
     *This method will calculate the distance (using the Euclidean Formula) from your soldier to a target.
     *@param S An integer array.
     *@param T An integer array.
     *@return double Calculated distance
     */

    public static double getDistance(int S[], int T[]) {
        int P_x1 = S[0];
        int P_y1 = S[1];
        int Q_x2 = T[0];
        int Q_y2 = T[1];
        double distance = Math.sqrt((Q_x2 - P_x1) * (Q_x2 - P_x1) + (Q_y2 - P_y1) * (Q_y2 - P_y1));

        return distance;
    }

    /*
    --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                                                 chooseTarget METHOD
    --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    */

    /**
    *This method calls getDistance(S,T) and compares the distances and will store the final target (with
     minimum distance from soldier) coordinates and the final shortest target distance from the soldier in
     a 1D integer array. Also, it will display the final targetcoordinates to the terminal/console in the form (x,y).
    *@param S Coordinates for 'S' in the grid.
    *@param T Coordinates for first 'T' in the grid.
    *@param T2 Coordinates for second 'T' in the grid.
    *@return 1-D integer array with the coordinates the 'T' that needs to be eliminated.
    */
    public static int[] chooseTarget(int S[], int T[], int T2[]) {

        double target1distance = getDistance(S, T);
        double target2distance = getDistance(S, T2);
        double distance = 0.0;
        double fps = 2421;
        double travelTime = 0.0;

        if (target1distance < target2distance) {
            //Round to 2 decimal places
            distance = Math.round(target1distance * 100.0) / 100.0;
            System.out.println("(" + T[0] + ", " + T[1] + ")" + " ");
            System.out.println("Distance from soldier to Target is " + distance + " m");
            travelTime = distance / fps;
            //Round to 4 decimal places
            System.out.printf("\nBullet arrived to target in %.5f seconds.\n", travelTime);
            return T;
        } else {
            //Round to 2 decimal places
            distance = Math.round(target2distance * 100.0) / 100.0;
            System.out.println("(" + T2[0] + ", " + T2[1] + ")" + " ");
            System.out.println("Distance from soldier to Target is " + distance + " m");
            travelTime = distance / fps;
            //Round to 4 decimal places
            System.out.printf("\nBullet arrived to target in %.5f seconds.\n", travelTime);
            return T2;
        }

    }

    /*
    --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                                                 eliminateTarget METHOD
    --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    */

    /**
     *This method receives as input the modified grid (the 2D array with ‘S’ and ‘T’ marked), the attributes of
      the closest target (coordinates in the first two indices and distance in the third index, respectively) and
      marks an ‘X’ (replaces ‘T’) in that location given by the coordinatesin the grid. Then, it returns the final
      updated grid (2D array).
     *@param grid 2-D array representing the modified grid with S and T's.
     *@param target Coordinates of closest target.
     *@return char 2-D array with the 'X' printed in place of the T that got eliminated.
     */
    public static char[][] eliminateTarget(char grid[][], int target[]) {

        grid[target[0]][target[1]] = 'X';
        return grid;
    }
    /*
    --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                                                 printCoordinates METHOD
    --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    */

    /**
     *This method will take an array of integers as a parameter, containing coordinates of any point and print its contents.
     *@param coordinates A 1-D integer array.
     *@return Nothing.
     */

    public static void printCoordinates(int coordinates[]) {
        System.out.println("(" + coordinates[0] + ", " + coordinates[1] + ")");
    }

    /*
    --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
                                     recurse METHOD
    --------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------
    */

    //Recursion Extra Credit
    /**
     *This method will recursively search for the input symbol
     (either ‘S’ or ‘T’) and return those coordinates 
     *@param grid a 2D array of characters.
     *@param rows This is the size of the 2D array.
     *@param columns This is the size of the 2D array.
     *@param symbol This is the symbol that is being searched depending on the condition.
     *@return int This returns an array of integers with the index of the coordinates.
     */
    public static int[] recurse(char grid[][], int rows, int columns, char symbol) {

        int[] points = new int[2];
        if (grid[rows][columns] == symbol) {
            points[0] = rows;
            points[1] = columns;
            return points;
        }
        if (rows < (grid.length - 1) || columns < (grid[rows].length - 1)) {
            columns = columns + 1;
            if (columns > grid[rows].length - 1) {
                columns = 0;
                rows = rows + 1;
            }
        }
        return recurse(grid, rows, columns, symbol);
    }


}
