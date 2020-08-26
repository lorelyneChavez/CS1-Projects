import java.util.Scanner;

public class Lab9_BookList_Chavez {
  public static void main(String args[]) {

   Scanner input = new Scanner(System.in);

    //Object for Book 1
    Book book1 = new Book("In Search of Lost Time");
    //Set values for missing attributes for Book 1
    book1.setAuthor("Marcel Proust");
    book1.setyearPublished(1931);
    book1.setAvailable(true);

    //Object for Book 2
    Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
    //Set values for missing attributes for Book 2
    book2.setAvailable(false);

    //Object for Book 3
    Book book3 = new Book("Harry Potter and the Chamber of Secrets", "R.K. Rowling", 1998, true);

    //Link Book objects and initialize head node
    Book head = book1;
    book1.next = book2;
    book2.next = book3;

    //Menu Options
    System.out.println("\nWelcome to the National Public Library!");
    System.out.println("What do you want to do?");
    System.out.println("1. Show all books in the list with all of their information.");
    System.out.println("2. Add a book to the end of the list and print the updated list.");
    System.out.println("3. Remove a book from the end of the list and print the updated list.");
    System.out.print("Option Number: ");
    int option = input.nextInt();

    //Conditions according to user input
    if (option == 1) {
      //Printing head will print the entire linked list
      print(head);
      }

    else if (option == 2) {
      add(head, head);
      print(head);
      }
    else if (option == 3) {
      head = remove(head);
      print(head);
        }

    System.out.println("\nThank you for choosing the National Public Library! \nHave a nice day!");

    }
    public static void print(Book current) {
      for ( ; current != null; current = current.next) {
        System.out.println("\tTitle: \"" + current.title + "\"");
        System.out.println("\tAuthor: " + current.author);
        System.out.println("\tYear Published: " + current.yearPublished);
        System.out.println("\tAvailable: " + current.getAvailable());

        System.out.println();
        }
    }

    public static void add(Book current, Book temp) {
     while (current.next != null) {
       current = current.next;
        }

     //New Book
     Book newBook = new Book("The Perks of Being a Wallflower", "Stephen Chbosky", 1999, true);


        current.next = newBook;
        for ( ; temp != null; temp = temp.next) {}

    }
    public static Book remove(Book head) {


        Book previousBook = null;
        for ( Book temp = head ; temp.next != null; temp = temp.next) {
            previousBook = temp;
        }

        previousBook.next = null;
        for (Book temp = head ; temp != null; temp = temp.next) {}

        return head;

    }





}
