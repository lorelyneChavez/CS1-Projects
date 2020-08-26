public class Book {

    String title;
    String author;
    int yearPublished;
    private boolean available;
    Book next;

    //Setter method for author
    void setAuthor(String author) {
        this.author = author;
    }
    //Setter method for yearPublished
    void setyearPublished(int yearPublished) {
        this.yearPublished = yearPublished;
    }
    //Getter method for available
    boolean getAvailable() {
        return this.available;
    }
    //Setter method for the available
    void setAvailable(boolean available) {
        this.available = available;
    }

    //Constructor 1
    Book(String title) {
        this.title = title;
    }
    //Constructor 2
    Book(String title, String author, int yearPublished) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
    }
    //Constructor 3
    Book(String title, String author, int yearPublished, boolean available) {
        this.title = title;
        this.author = author;
        this.yearPublished = yearPublished;
        this.available = available;
    }


}
