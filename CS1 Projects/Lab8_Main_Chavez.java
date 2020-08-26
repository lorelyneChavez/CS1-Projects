public class Lab8_Main_Chavez {
    public static void main(String args[]) {



      //Object for Book 1
      Book book1 = new Book("In Search of Lost Time");
      //Set values for missing attributes for Book 1
      book1.setAuthor("Marcel Proust");
      book1.setyearPublished(1931);
      book1.setAvailable(true);


      //Object for Book 2
      Book book2 = new Book("The Great Gatsby", "F. Scott Fitzgerald", 1925);
      //Set values for missing attributes for Book 1
      book2.setAvailable(false);

      //Object for Book 3
      Book book3 = new Book("Harry Potter and the Chamber of Secrets", "R.K. Rowling", 1998, true);


      //Printing Book 1
      System.out.println("Book 1:");
      System.out.println("\tTitle: \"" + book1.title + "\"");
      System.out.println("\tAuthor: " + book1.author);
      System.out.println("\tYear Published: " + book1.yearPublished);
      System.out.println("\tAvailable: " + book1.getAvailable());

      //Printing Book 2
      System.out.println("Book 2:");
      System.out.println("\tTitle: \"" + book2.title + "\"");
      System.out.println("\tAuthor: " + book2.author);
      System.out.println("\tYear Published: " + book2.yearPublished);
      System.out.println("\tAvailable: " + book2.getAvailable());

      //Printing Book 3
      System.out.println("Book 3:");
      System.out.println("\tTitle: \"" + book3.title + "\"");
      System.out.println("\tAuthor: " + book3.author);
      System.out.println("\tYear Published: " + book3.yearPublished);
      System.out.println("\tAvailable: " + book3.getAvailable());

    }
}
