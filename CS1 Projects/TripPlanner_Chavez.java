// ﻿import java.io.File;
// import java.util.Scanner;
import java.io.File;
import java.util.Scanner;
public class TripPlanner_Chavez {

    public static void main(String args[]) throws Exception {


        //Declare Scanners and File Reader
        File ufile = new File("user.txt");
        Scanner sc = new Scanner(ufile);
        Scanner input = new Scanner(System.in);
        Scanner scnr = new Scanner(System.in);

        //Store each line of user.txt in an array
        String[] fileLine = new String[5];
        int l = 0;
        while (sc.hasNextLine()) {
            String text = sc.nextLine();
            fileLine[l] = text;
            l++;
        }

        //Declare variables outside in order for them to remain otside of the loops
        String checkout = "Yes";
        int userInput = 0;
        double f = 0.0;
        String currentLocation = "El Paso";
        String destination = "El Paso";;
        int accuMiles = 0;
        int travelPoints = 0;
        double cost = f * accuMiles;
        String continentTxt = "";
        boolean choice = false;

        /*
        --------------------------------------------------------------------------------
                                Start of User Credentials
        --------------------------------------------------------------------------------
        */

        //Ask user to input user credentials
        System.out.println("");
        System.out.println("Welcome to Trip Planner!");
        System.out.println("Please enter correct credentials to log in.");
        System.out.print("\t Username: ");
        String username = input.nextLine();
        System.out.print("\t Password: ");
        String password = input.nextLine();

        //Create a for loop that will give user a total of 3 tries to input user credentials
        for (int i = 0; i < 2; i++) {
            System.out.println("");
            if (username.equals(fileLine[1]) && password.equals(fileLine[2])) {
                break;
            } else {
                System.out.println("Welcome to Trip Planner!");
                System.out.println("Sorry, you have entered invalid credentials. Try again.");
                System.out.print("\t Username: ");
                username = input.nextLine();
                System.out.print("\t Password: ");
                password = input.nextLine();
            }
        }
        if (!(username.equals(fileLine[1]) && password.equals(fileLine[2]))) {
            System.out.println("");
            System.out.print("Sorry, you are temporarily blocked from the platform. ");
            System.out.println("Please try again in a couple of hours.");
            System.exit(0);
        }

        /*
        --------------------------------------------------------------------------------
                                  //Start of Continent Choice
        --------------------------------------------------------------------------------
        */

        System.out.println("Welcome " + fileLine[0] + "!");
        System.out.println("PLease answer the following question to determine which " +
            "continent best fits to your vacation plans.");
        System.out.println("When are you planning to travel? Please enter the day and the full month.");
        System.out.print("\t Day: ");
        int day = scnr.nextInt();
        System.out.print("\t Month: ");
        String month = input.nextLine();
        System.out.println("");

        //Store each month string into a designated integer for convenience when setting conditions
        int numMonth = 0;
        if (month.equalsIgnoreCase("January")) {
            numMonth = 1;
        }
        if (month.equalsIgnoreCase("February")) {
            numMonth = 2;
        }
        if (month.equalsIgnoreCase("March")) {
            numMonth = 3;
        }
        if (month.equalsIgnoreCase("April")) {
            numMonth = 4;
        }
        if (month.equalsIgnoreCase("May")) {
            numMonth = 5;
        }
        if (month.equalsIgnoreCase("June")) {
            numMonth = 6;
        }
        if (month.equalsIgnoreCase("July")) {
            numMonth = 7;
        }
        if (month.equalsIgnoreCase("August")) {
            numMonth = 8;
        }
        if (month.equalsIgnoreCase("September")) {
            numMonth = 9;
        }
        if (month.equalsIgnoreCase("October")) {
            numMonth = 10;
        }
        if (month.equalsIgnoreCase("November")) {
            numMonth = 11;
        }
        if (month.equalsIgnoreCase("December")) {
            numMonth = 12;
        }

        //Set conditions that will determine which continents are best to travel to on selected dates
        String continent = "";
        if (numMonth >= 1 && numMonth <= 7) {
            System.out.println("Welcome " + fileLine[0] + "!");
            System.out.println("Based on your data selection, North America and Asia " +
                "are the continents you should choose to travel to");
            System.out.print("Enter your choice of continent: ");
            continent = input.nextLine();
        }else {
            System.out.println("Welcome " + fileLine[0] + "!");
            System.out.println("Based on your data selection, South America and Europe " +
                "are the continents you should choose to travel to");
            System.out.print("Enter your choice of continent: ");
            continent = input.nextLine();
        }

        /*
        --------------------------------------------------------------------------------
                                    Start of City Choice
        --------------------------------------------------------------------------------
        */

        //Assign the appropriate .txt file and f quantity with the the appropriate continent
        switch (continent) {
            case ("Asia"):
                continentTxt = "Asia.txt";
                f = 0.15;
                break;
            case ("North America"):
                continentTxt = "NA.txt";
                f = 0.26;
                break;
            case ("Europe"):
                continentTxt = "Europe.txt";
                f = 0.23;
                break;
            case ("South America"):
                continentTxt = "SA.txt";
                f = 0.21;
                break;
            case ("asia"):
                continentTxt = "Asia.txt";
                f = 0.15;
                break;
            case ("north america"):
                continentTxt = "NA.txt";
                f = 0.26;
                break;
            case ("europe"):
                continentTxt = "Europe.txt";
                f = 0.23;
                break;
            case ("south america"):
                continentTxt = "SA.txt";
                f = 0.21;
                break;
        }

        //Store each line of the chosen continent .txt file into an array
        String[] fileInfo = new String[7];
        ufile = new File(continentTxt);
        sc = new Scanner(ufile);
        int k = 0;
        while (sc.hasNextLine()) {
            String text = sc.nextLine();
            fileInfo[k] = text;
            k++;
        }

        //Create a menu for the user that keeps track of user's plan
        System.out.println("");
        System.out.println("Great! You chose " + continent + " to travel on " + month + " " + day + ".");
        System.out.println("Here is a menu to keep track of your plan.");

        System.out.println("\nPlan " + continent);
        System.out.println("Current Location: " + currentLocation);
        System.out.println("Destination: City X");
        System.out.println("The cost is calculated by [" + f + " * " + accuMiles + "]");
        System.out.println("Cost: [$" + cost + "]");
        System.out.println("Miles accumulated: [" + accuMiles + "]");
        System.out.println("Travel Points: [" + travelPoints + "]");
        System.out.println("");

        System.out.println("Below are the best cities to visit for this season.");
        System.out.println("Select the city you want to go to:");
        System.out.println("");

        /*
        --------------------------------------------------------------------------------
                                              Asia
        --------------------------------------------------------------------------------
        */

        //Make array of cities corresponding to appropriate continent
        if (continent.equalsIgnoreCase("Asia")) {
            String[] cities = {
                "New Delhi",
                "Hong Kong",
                "Tokyo",
            };
            int[] milesEP = {
                Integer.parseInt(fileInfo[4]),
                Integer.parseInt(fileInfo[5]),
                Integer.parseInt(fileInfo[6]),
            };

            //Outer loop will print updated information
            for (int index = 0; index < 5; index++) {

                //Inner loop will print cities.
                for (int n = 0; n < cities.length; n++) {
                    System.out.println((n + 1) + ". " + cities[n] + " " + milesEP[n]);
                }

                System.out.println("4. Return to El Paso");
                System.out.println("5. Check out");

                System.out.println("\nPick an option that is available.");
                userInput = scnr.nextInt();
                System.out.println("-------------------------------------------------");

                //userInput options:
                if (userInput == 1) {
                    if (destination.equalsIgnoreCase("El Paso")) {
                        currentLocation = destination;
                        destination = cities[userInput - 1];
                        accuMiles += Integer.parseInt(fileInfo[4]);
                        cost = f * accuMiles;
                        travelPoints = ((accuMiles / 1500) * 75);
                    } else if (destination.equalsIgnoreCase("Hong Kong")) {
                        currentLocation = destination;
                        destination = cities[userInput - 1];
                        accuMiles += Integer.parseInt(fileInfo[2]);
                        cost = f * accuMiles;
                        travelPoints = ((accuMiles / 1500) * 75);
                    } else if (destination.equalsIgnoreCase("Tokyo")) {
                        currentLocation = destination;
                        destination = cities[userInput - 1];
                        accuMiles += Integer.parseInt(fileInfo[1]);
                        cost = f * accuMiles;
                        travelPoints = ((accuMiles / 1500) * 75);
                    }
                }

                if (userInput == 2) {
                    if (destination.equalsIgnoreCase("El Paso")) {
                        currentLocation = destination;
                        destination = cities[userInput - 1];
                        accuMiles += Integer.parseInt(fileInfo[5]);
                        cost = f * accuMiles;
                        travelPoints = ((accuMiles / 1500) * 75);
                    } else if (destination.equalsIgnoreCase("New Delhi")) {
                        currentLocation = destination;
                        destination = cities[userInput - 1];
                        accuMiles += Integer.parseInt(fileInfo[2]);
                        cost = f * accuMiles;
                        travelPoints = ((accuMiles / 1500) * 75);
                    } else if (destination.equalsIgnoreCase("Tokyo")) {
                        currentLocation = destination;
                        destination = cities[userInput - 1];
                        accuMiles += Integer.parseInt(fileInfo[3]);
                        cost = f * accuMiles;
                        travelPoints = ((accuMiles / 1500) * 75);
                    }
                }

                if (userInput == 3) {
                    if (destination.equalsIgnoreCase("El Paso")) {
                        currentLocation = destination;
                        destination = cities[userInput - 1];
                        accuMiles += Integer.parseInt(fileInfo[6]);
                        cost = f * accuMiles;
                        travelPoints = ((accuMiles / 1500) * 75);
                    } else if (destination.equalsIgnoreCase("New Delhi")) {
                        currentLocation = destination;
                        destination = cities[userInput - 1];
                        accuMiles += Integer.parseInt(fileInfo[1]);
                        cost = f * accuMiles;
                        travelPoints = ((accuMiles / 1500) * 75);
                    } else if (destination.equalsIgnoreCase("Hong Kong")) {
                        currentLocation = destination;
                        destination = cities[userInput - 1];
                        accuMiles += Integer.parseInt(fileInfo[3]);
                        cost = f * accuMiles;
                        travelPoints = ((accuMiles / 1500) * 75);
                    }
                }

                if (userInput == 4) {
                    break;
                }

                if (userInput == 5) {
                    choice = true;
                    break;
                }

                //This is to clear an option once user has already selected it
                cities[userInput - 1] = "";
                milesEP[userInput - 1] = 0;

                //This is the menu in the outer for loop that will continue printing
                System.out.println("\nPlan " + continent);
                System.out.println("Current Location: " + currentLocation);
                System.out.println("Destination: " + destination);
                System.out.println("The cost is calculated by " + f + " * " + accuMiles);
                System.out.println("Cost: $" + cost);
                System.out.println("Miles accumulated: " + accuMiles);
                System.out.println("Travel Points: " + travelPoints);
                System.out.println("");
            }

            //If user picks option of going back to El Paso
            if (userInput == 4) {
                if (destination.equalsIgnoreCase("New Delhi")) {
                    currentLocation = destination;
                    destination = "El Paso";
                    accuMiles += Integer.parseInt(fileInfo[4]);
                    cost = f * accuMiles;
                    travelPoints = (((accuMiles / 1500) * 75) + travelPoints);
                } else if (destination.equalsIgnoreCase("Hong Kong")) {
                    currentLocation = destination;
                    destination = "El Paso";
                    accuMiles += Integer.parseInt(fileInfo[5]);
                    cost = f * accuMiles;
                    travelPoints = (((accuMiles / 1500) * 75) + travelPoints);
                } else if (destination.equalsIgnoreCase("Tokyo")) {
                    currentLocation = destination;
                    destination = "El Paso";
                    accuMiles += Integer.parseInt(fileInfo[6]);
                    cost = f * accuMiles;
                    travelPoints = (((accuMiles / 1500) * 75) + travelPoints);
                }

                //Print menu one last time
                System.out.println("\nPlan " + continent);
                System.out.println("Current Location: " + currentLocation);
                System.out.println("Destination: " + destination);
                System.out.println("The cost is calculated by [" + f + " * " + accuMiles + "]");
                System.out.println("Cost: $[" + cost + "]");
                System.out.println("Miles accumulated: [" + accuMiles + "]");
                System.out.println("Travel Points: [" + travelPoints + "]");
                System.out.println("");

                System.out.println("-------------------------------------------------");

                System.out.println("");
                System.out.println(fileLine[0] + ", You have decided to return back to El Paso.");
                System.out.println("Would you like to checkout? \nPlease input \"Yes\"/\"No\"");
                checkout = input.nextLine();
                System.out.println("");

                if (checkout.equalsIgnoreCase("Yes")) {
                    choice = true;
                }

                if (checkout.equalsIgnoreCase("No")) {
                    choice = false;

                }
            }
        }

        /*
        --------------------------------------------------------------------------------
                                      North America
        --------------------------------------------------------------------------------
        */

        //Make array of cities corresponding to appropriate continent
        if (continent.equalsIgnoreCase("North America")) {
            String[] cities = {
                "NY",
                "Los Angeles",
                "Vancouver",
            };
            int[] milesEP = {
                Integer.parseInt(fileInfo[4]),
                Integer.parseInt(fileInfo[5]),
                Integer.parseInt(fileInfo[6]),
            };

            //Outer loop will print updated information
            for (int index = 0; index < 5; index++) {

                //Inner loop will print cities.
                for (int n = 0; n < cities.length; n++) {
                    System.out.println((n + 1) + ". " + cities[n] + " " + milesEP[n]);
                }

                System.out.println("4. Return to El Paso");
                System.out.println("5. Check out");

                System.out.println("\nPick an option that is available.");
                userInput = scnr.nextInt();
                System.out.println("-------------------------------------------------");

                //UserInput options:
                if (userInput == 1) {
                    if (destination.equalsIgnoreCase("El Paso")) {
                        currentLocation = destination;
                        destination = cities[userInput - 1];
                        accuMiles += Integer.parseInt(fileInfo[4]);
                        cost = f * accuMiles;
                        travelPoints = ((accuMiles / 1500) * 75);
                    } else if (destination.equalsIgnoreCase("Los Angeles")) {
                        currentLocation = destination;
                        destination = cities[userInput - 1];
                        accuMiles += Integer.parseInt(fileInfo[3]);
                        cost = f * accuMiles;
                        travelPoints = ((accuMiles / 1500) * 75);
                    } else if (destination.equalsIgnoreCase("Vancouver")) {
                        currentLocation = destination;
                        destination = cities[userInput - 1];
                        accuMiles += Integer.parseInt(fileInfo[1]);
                        cost = f * accuMiles;
                        travelPoints = ((accuMiles / 1500) * 75);
                    }
                }

                if (userInput == 2) {
                    if (destination.equalsIgnoreCase("El Paso")) {
                        currentLocation = destination;
                        destination = cities[userInput - 1];
                        accuMiles += Integer.parseInt(fileInfo[5]);
                        cost = f * accuMiles;
                        travelPoints = ((accuMiles / 1500) * 75);
                    } else if (destination.equalsIgnoreCase("NY")) {
                        currentLocation = destination;
                        destination = cities[userInput - 1];
                        accuMiles += Integer.parseInt(fileInfo[3]);
                        cost = f * accuMiles;
                        travelPoints = ((accuMiles / 1500) * 75);
                    } else if (destination.equalsIgnoreCase("Vancouver")) {
                        currentLocation = destination;
                        destination = cities[userInput - 1];
                        accuMiles += Integer.parseInt(fileInfo[2]);
                        cost = f * accuMiles;
                        travelPoints = ((accuMiles / 1500) * 75);
                    }
                }

                if (userInput == 3) {
                    if (destination.equalsIgnoreCase("El Paso")) {
                        currentLocation = destination;
                        destination = cities[userInput - 1];
                        accuMiles += Integer.parseInt(fileInfo[6]);
                        cost = f * accuMiles;
                        travelPoints = ((accuMiles / 1500) * 75);
                    } else if (destination.equalsIgnoreCase("NY")) {
                        currentLocation = destination;
                        destination = cities[userInput - 1];
                        accuMiles += Integer.parseInt(fileInfo[1]);
                        cost = f * accuMiles;
                        travelPoints = ((accuMiles / 1500) * 75);
                    } else if (destination.equalsIgnoreCase("Los Angeles")) {
                        currentLocation = destination;
                        destination = cities[userInput - 1];
                        accuMiles += Integer.parseInt(fileInfo[2]);
                        cost = f * accuMiles;
                        travelPoints = ((accuMiles / 1500) * 75);
                    }
                }

                if (userInput == 4) {
                    break;
                }

                if (userInput == 5) {
                    choice = true;
                    break;
                }

                //This is to clear an option once user has already selected it
                cities[userInput - 1] = "";
                milesEP[userInput - 1] = 0;

                //This is the menu in the outer for loop that will continue printing
                System.out.println("\nPlan " + continent);
                System.out.println("Current Location: " + currentLocation);
                System.out.println("Destination: " + destination);
                System.out.println("The cost is calculated by " + f + " * " + accuMiles);
                System.out.println("Cost: $" + cost);
                System.out.println("Miles accumulated: " + accuMiles);
                System.out.println("Travel Points: " + travelPoints);
                System.out.println("");
            }

            //If use picks option of going back to El Paso
            if (userInput == 4) {
                if (destination.equalsIgnoreCase("NY")) {
                    currentLocation = destination;
                    destination = "El Paso";
                    accuMiles += Integer.parseInt(fileInfo[4]);
                    cost = f * accuMiles;
                    travelPoints = (((accuMiles / 1500) * 75) + travelPoints);
                } else if (destination.equalsIgnoreCase("Los Angeles")) {
                    currentLocation = destination;
                    destination = "El Paso";
                    accuMiles += Integer.parseInt(fileInfo[5]);
                    cost = f * accuMiles;
                    travelPoints = (((accuMiles / 1500) * 75) + travelPoints);
                } else if (destination.equalsIgnoreCase("Vancouver")) {
                    currentLocation = destination;
                    destination = "El Paso";
                    accuMiles += Integer.parseInt(fileInfo[6]);
                    cost = f * accuMiles;
                    travelPoints = (((accuMiles / 1500) * 75) + travelPoints);
                }

                //Print menu one last time
                System.out.println("\nPlan " + continent);
                System.out.println("Current Location: " + currentLocation);
                System.out.println("Destination: " + destination);
                System.out.println("The cost is calculated by [" + f + " * " + accuMiles + "]");
                System.out.println("Cost: $[" + cost + "]");
                System.out.println("Miles accumulated: [" + accuMiles + "]");
                System.out.println("Travel Points: [" + travelPoints + "]");
                System.out.println("");

                System.out.println("-------------------------------------------------");

                System.out.println("");
                System.out.println(fileLine[0] + ", You have decided to return back to El Paso.");
                System.out.println("Would you like to checkout? \nPlease input \"Yes\"/\"No\"");
                checkout = input.nextLine();
                System.out.println("");

                if (checkout.equalsIgnoreCase("Yes")) {
                    choice = true;
                }

                if (checkout.equalsIgnoreCase("No")) {
                    choice = false;

                }
            }
        }

        /*
        --------------------------------------------------------------------------------
                                              Europe
        --------------------------------------------------------------------------------
        */

        //Make array of cities corresponding to appropriate continent
        if (continent.equalsIgnoreCase("Europe")) {
            String[] cities = {
                "Madrid",
                "Rome",
                "Amsterdam",
            };
            int[] milesEP = {
                Integer.parseInt(fileInfo[4]),
                Integer.parseInt(fileInfo[5]),
                Integer.parseInt(fileInfo[6]),
            };

            //Outer loop will print updated information
            for (int index = 0; index < 5; index++) {

                //Inner loop will print cities.
                for (int n = 0; n < cities.length; n++) {
                    System.out.println((n + 1) + ". " + cities[n] + " " + milesEP[n]);
                }

                System.out.println("4. Return to El Paso");
                System.out.println("5. Check out");

                System.out.println("\nPick an option that is available.");
                userInput = scnr.nextInt();
                System.out.println("-------------------------------------------------");

                //UserInput options:
                if (userInput == 1) {
                    if (destination.equalsIgnoreCase("El Paso")) {
                        currentLocation = destination;
                        destination = cities[userInput - 1];
                        accuMiles += Integer.parseInt(fileInfo[4]);
                        cost = f * accuMiles;
                        travelPoints = ((accuMiles / 1500) * 75);
                    } else if (destination.equalsIgnoreCase("Rome")) {
                        currentLocation = destination;
                        destination = cities[userInput - 1];
                        accuMiles += Integer.parseInt(fileInfo[1]);
                        cost = f * accuMiles;
                        travelPoints = ((accuMiles / 1500) * 75);
                    } else if (destination.equalsIgnoreCase("Amsterdam")) {
                        currentLocation = destination;
                        destination = cities[userInput - 1];
                        accuMiles += Integer.parseInt(fileInfo[3]);
                        cost = f * accuMiles;
                        travelPoints = ((accuMiles / 1500) * 75);
                    }
                }

                if (userInput == 2) {
                    if (destination.equalsIgnoreCase("El Paso")) {
                        currentLocation = destination;
                        destination = cities[userInput - 1];
                        accuMiles += Integer.parseInt(fileInfo[5]);
                        cost = f * accuMiles;
                        travelPoints = ((accuMiles / 1500) * 75);
                    } else if (destination.equalsIgnoreCase("Madrid")) {
                        currentLocation = destination;
                        destination = cities[userInput - 1];
                        accuMiles += Integer.parseInt(fileInfo[1]);
                        cost = f * accuMiles;
                        travelPoints = ((accuMiles / 1500) * 75);
                    } else if (destination.equalsIgnoreCase("Amsterdam")) {
                        currentLocation = destination;
                        destination = cities[userInput - 1];
                        accuMiles += Integer.parseInt(fileInfo[2]);
                        cost = f * accuMiles;
                        travelPoints = ((accuMiles / 1500) * 75);
                    }
                }

                if (userInput == 3) {
                    if (destination.equalsIgnoreCase("El Paso")) {
                        currentLocation = destination;
                        destination = cities[userInput - 1];
                        accuMiles += Integer.parseInt(fileInfo[6]);
                        cost = f * accuMiles;
                        travelPoints = ((accuMiles / 1500) * 75);
                    } else if (destination.equalsIgnoreCase("Madrid")) {
                        currentLocation = destination;
                        destination = cities[userInput - 1];
                        accuMiles += Integer.parseInt(fileInfo[3]);
                        cost = f * accuMiles;
                        travelPoints = ((accuMiles / 1500) * 75);
                    } else if (destination.equalsIgnoreCase("Rome")) {
                        currentLocation = destination;
                        destination = cities[userInput - 1];
                        accuMiles += Integer.parseInt(fileInfo[2]);
                        cost = f * accuMiles;
                        travelPoints = ((accuMiles / 1500) * 75);
                    }
                }

                if (userInput == 4) {
                    break;
                }

                if (userInput == 5) {
                    choice = true;
                    break;
                }

                //This is to clear an option once user has already selected it
                cities[userInput - 1] = "";
                milesEP[userInput - 1] = 0;

                //This is the menu in the outer for loop that will continue printing
                System.out.println("\nPlan " + continent);
                System.out.println("Current Location: " + currentLocation);
                System.out.println("Destination: " + destination);
                System.out.println("The cost is calculated by " + f + " * " + accuMiles);
                System.out.println("Cost: $" + cost);
                System.out.println("Miles accumulated: " + accuMiles);
                System.out.println("Travel Points: " + travelPoints);
                System.out.println("");
            }

            //If use picks option of going back to El Paso
            if (userInput == 4) {
                if (destination.equalsIgnoreCase("Madrid")) {
                    currentLocation = destination;
                    destination = "El Paso";
                    accuMiles += Integer.parseInt(fileInfo[4]);
                    cost = f * accuMiles;
                    travelPoints = (((accuMiles / 1500) * 75) + travelPoints);
                } else if (destination.equalsIgnoreCase("Rome")) {
                    currentLocation = destination;
                    destination = "El Paso";
                    accuMiles += Integer.parseInt(fileInfo[5]);
                    cost = f * accuMiles;
                    travelPoints = (((accuMiles / 1500) * 75) + travelPoints);
                } else if (destination.equalsIgnoreCase("Amsterdam")) {
                    currentLocation = destination;
                    destination = "El Paso";
                    accuMiles += Integer.parseInt(fileInfo[6]);
                    cost = f * accuMiles;
                    travelPoints = (((accuMiles / 1500) * 75) + travelPoints);
                }

                //Print menu one last time
                System.out.println("\nPlan " + continent);
                System.out.println("Current Location: " + currentLocation);
                System.out.println("Destination: " + destination);
                System.out.println("The cost is calculated by [" + f + " * " + accuMiles + "]");
                System.out.println("Cost: $[" + cost + "]");
                System.out.println("Miles accumulated: [" + accuMiles + "]");
                System.out.println("Travel Points: [" + travelPoints + "]");
                System.out.println("");

                System.out.println("-------------------------------------------------");

                System.out.println("");
                System.out.println(fileLine[0] + ", You have decided to return back to El Paso.");
                System.out.println("Would you like to checkout? \nPlease input \"Yes\"/\"No\"");
                checkout = input.nextLine();
                System.out.println("");

                if (checkout.equalsIgnoreCase("Yes")) {
                    choice = true;
                }

                if (checkout.equalsIgnoreCase("No")) {
                    choice = false;

                }
            }
        }

        /*
        --------------------------------------------------------------------------------
                                          South America
        --------------------------------------------------------------------------------
        */

        //Make array of cities corresponding to appropriate continent
        if (continent.equalsIgnoreCase("South America")) {
            String[] cities = {
                "Rio",
                "Bogota",
                "Buenos Aires",
            };
            int[] milesEP = {
                Integer.parseInt(fileInfo[4]),
                Integer.parseInt(fileInfo[5]),
                Integer.parseInt(fileInfo[6]),
            };

            //Outer loop will print updated information
            for (int index = 0; index < 5; index++) {

                //Inner loop will print cities.
                for (int n = 0; n < cities.length; n++) {
                    System.out.println((n + 1) + ". " + cities[n] + " " + milesEP[n]);
                }

                System.out.println("4. Return to El Paso");
                System.out.println("5. Check out");

                System.out.println("\nPick an option that is available.");
                userInput = scnr.nextInt();
                System.out.println("-------------------------------------------------");

                //UserInput options:
                if (userInput == 1) {
                    if (destination.equalsIgnoreCase("El Paso")) {
                        currentLocation = destination;
                        destination = cities[userInput - 1];
                        accuMiles += Integer.parseInt(fileInfo[4]);
                        cost = f * accuMiles;
                        travelPoints = ((accuMiles / 1500) * 75);
                    } else if (destination.equalsIgnoreCase("Bogota")) {
                        currentLocation = destination;
                        destination = cities[userInput - 1];
                        accuMiles += Integer.parseInt(fileInfo[1]);
                        cost = f * accuMiles;
                        travelPoints = ((accuMiles / 1500) * 75);
                    } else if (destination.equalsIgnoreCase("Buenos Aires")) {
                        currentLocation = destination;
                        destination = cities[userInput - 1];
                        accuMiles += Integer.parseInt(fileInfo[2]);
                        cost = f * accuMiles;
                        travelPoints = ((accuMiles / 1500) * 75);
                    }
                }

                if (userInput == 2) {
                    if (destination.equalsIgnoreCase("El Paso")) {
                        currentLocation = destination;
                        destination = cities[userInput - 1];
                        accuMiles += Integer.parseInt(fileInfo[5]);
                        cost = f * accuMiles;
                        travelPoints = ((accuMiles / 1500) * 75);
                    } else if (destination.equalsIgnoreCase("Rio")) {
                        currentLocation = destination;
                        destination = cities[userInput - 1];
                        accuMiles += Integer.parseInt(fileInfo[1]);
                        cost = f * accuMiles;
                        travelPoints = ((accuMiles / 1500) * 75);
                    } else if (destination.equalsIgnoreCase("Buenos Aires")) {
                        currentLocation = destination;
                        destination = cities[userInput - 1];
                        accuMiles += Integer.parseInt(fileInfo[3]);
                        cost = f * accuMiles;
                        travelPoints = ((accuMiles / 1500) * 75);
                    }
                }

                if (userInput == 3) {
                    if (destination.equalsIgnoreCase("El Paso")) {
                        currentLocation = destination;
                        destination = cities[userInput - 1];
                        accuMiles += Integer.parseInt(fileInfo[6]);
                        cost = f * accuMiles;
                        travelPoints = ((accuMiles / 1500) * 75);
                    } else if (destination.equalsIgnoreCase("Rio")) {
                        currentLocation = destination;
                        destination = cities[userInput - 1];
                        accuMiles += Integer.parseInt(fileInfo[2]);
                        cost = f * accuMiles;
                        travelPoints = ((accuMiles / 1500) * 75);
                    } else if (destination.equalsIgnoreCase("Bogota")) {
                        currentLocation = destination;
                        destination = cities[userInput - 1];
                        accuMiles += Integer.parseInt(fileInfo[3]);
                        cost = f * accuMiles;
                        travelPoints = ((accuMiles / 1500) * 75);
                    }
                }

                if (userInput == 4) {
                    break;
                }

                if (userInput == 5) {
                    choice = true;
                    break;
                }

                //This is to clear an option once user has already selected it
                cities[userInput - 1] = "";
                milesEP[userInput - 1] = 0;

                //This is the menu in the outer for loop that will continue printing
                System.out.println("\nPlan " + continent);
                System.out.println("Current Location: " + currentLocation);
                System.out.println("Destination: " + destination);
                System.out.println("The cost is calculated by " + f + " * " + accuMiles);
                System.out.println("Cost: $" + cost);
                System.out.println("Miles accumulated: " + accuMiles);
                System.out.println("Travel Points: " + travelPoints);
                System.out.println("");
            }

            //If use picks option of going back to El Paso
            if (userInput == 4) {
                if (destination.equalsIgnoreCase("Rio")) {
                    currentLocation = destination;
                    destination = "El Paso";
                    accuMiles += Integer.parseInt(fileInfo[4]);
                    cost = f * accuMiles;
                    travelPoints = (((accuMiles / 1500) * 75) + travelPoints);
                } else if (destination.equalsIgnoreCase("Bogota")) {
                    currentLocation = destination;
                    destination = "El Paso";
                    accuMiles += Integer.parseInt(fileInfo[5]);
                    cost = f * accuMiles;
                    travelPoints = (((accuMiles / 1500) * 75) + travelPoints);
                } else if (destination.equalsIgnoreCase("Buenos Aires")) {
                    currentLocation = destination;
                    destination = "El Paso";
                    accuMiles += Integer.parseInt(fileInfo[6]);
                    cost = f * accuMiles;
                    travelPoints = (((accuMiles / 1500) * 75) + travelPoints);
                }

                //Print menu one last time
                System.out.println("\nPlan " + continent);
                System.out.println("Current Location: " + currentLocation);
                System.out.println("Destination: " + destination);
                System.out.println("The cost is calculated by [" + f + " * " + accuMiles + "]");
                System.out.println("Cost: $[" + cost + "]");
                System.out.println("Miles accumulated: [" + accuMiles + "]");
                System.out.println("Travel Points: [" + travelPoints + "]");
                System.out.println("");

                System.out.println("-------------------------------------------------");

                System.out.println("");
                System.out.println(fileLine[0] + ", You have decided to return back to El Paso.");
                System.out.println("Would you like to checkout? \nPlease input \"Yes\"/\"No\"");
                checkout = input.nextLine();
                System.out.println("");

                if (checkout.equalsIgnoreCase("Yes")) {
                    choice = true;
                }

                if (checkout.equalsIgnoreCase("No")) {
                    choice = false;

                }
            }
        }

        /*
        --------------------------------------------------------------------------------
                                           Checkout
        --------------------------------------------------------------------------------
        */

        //Declare all variables used
        double discount15 = ((15.00 / 100.00) * cost);
        double discount40 = ((40.00 / 100.00) * cost);
        double discountCost15 = (cost - discount15);
        double discountCost40 = (cost - discount40);
        String redeem = "";
        int remTravelPoints15 = (travelPoints - 500);
        int remTravelPoints40 = (travelPoints - 900);

        if (choice == false) {
            System.out.println("Thank you for using Trip Planner!");
            System.out.println("Come back soon!");
            System.exit(0);
        }

        if (choice == true) {
            if ((travelPoints >= 500) && (travelPoints < 900)) {
                System.out.println("");
                System.out.println(fileLine[0] + "! You have accumulated enough travel points to earn a 15% discount from your total!");
                System.out.println("If you decide to use this, you would be saving: $" + discount15 + "!");
                System.out.println("Would you like to redeem? Please input \"Yes\"/\"No\"");
                redeem = input.nextLine();

                if (redeem.equalsIgnoreCase("Yes")) {
                    System.out.println("");
                    System.out.println("Congratulations on using your 15% discount!");
                    System.out.println("Final cost of trip: " + discountCost15);
                    System.out.println("Remaining travel points: " + remTravelPoints15);
                    System.out.println("Have a safe trip " + fileLine[0] + "!");
                    System.out.println("Thank you for choosing Trip Planner!");
                    System.exit(0);
                }
            } else if (travelPoints >= 900) {
                System.out.println("Hey! You have accumulated enough travel points to earn you a 15% OR 40% discount from your total!");
                System.out.println("If you use your 15% discount you will save $" + discount15 + " and you can save all extra travel points for next time!");
                System.out.println("If you use your 40% discount you will save $" + discount40 + " but have fewer travel points remaining.");
                System.out.println("Would you like to use one of these discounts? Please input \"Yes\"/\"No\"");
                redeem = input.nextLine();

                if (redeem.equalsIgnoreCase("Yes")) {
                    System.out.println("");
                    System.out.println("Awesome! Which discount would you like to use? Please input \"15\"/\"40\"");
                    int whichDiscount = scnr.nextInt();
                    if (whichDiscount == 15) {
                        System.out.println("");
                        System.out.println("Congratulations! You are using your 15% discount!");
                        System.out.println("Final cost of trip: " + discountCost15);
                        System.out.println("Remaining travel points: " + remTravelPoints15);
                        System.out.println("");
                        System.out.println("Have a safe trip " + fileLine[0] + "!");
                        System.out.println("Thank you for choosing Trip Planner!");
                        System.exit(0);
                    } else if (whichDiscount == 40) {
                        System.out.println("");
                        System.out.println("Congratulations! You are using your 40% discount!");
                        System.out.println("Final cost of trip: " + discountCost40);
                        System.out.println("Remaining travel points: " + remTravelPoints40);
                        System.out.println("Have a safe trip " + fileLine[0] + "!");
                        System.out.println("Thank you for choosing Trip Planner!");
                        System.exit(0);
                    }
                }
                if (redeem.equalsIgnoreCase("No")) {
                    System.out.println("");
                    System.out.println("Final cost of trip: " + cost);
                    System.out.println("Travel points: " + travelPoints);
                    System.out.println("Have a safe trip " + fileLine[0] + "!");
                    System.out.println("Thank you for choosing Trip Planner!");
                    System.exit(0);
                }
            } else {
                System.out.println("");
                System.out.println("Awesome! You are now checking out.");
                System.out.println("Final cost of trip: " + cost);
                System.out.println("Travel points: " + travelPoints);
                System.out.println("Have a safe trip " + fileLine[0] + "!");
                System.out.println("Thank you for choosing Trip Planner!");
                System.exit(0);
            }
        }

    }
}
