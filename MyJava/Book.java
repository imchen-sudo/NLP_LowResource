public class Book {

/*    Book
○ Attributes: book_id, title, author, availability
○ Methods: borrow(), return_book(), display_details()
*/

    //instance variables
    private int bookId;
    private String title;
    private String author;
    private boolean isAvailable;

    //optional
    private static int bookCount = 0;

    //constructor
    public Book(int bookId, String title, String author) {
        setBookCount();
        setTitle(title);
        setAuthor(author);
        setIsAvailable(true);
        setBookId(bookId);
    }

    //optional
    public static int getBookCount() {
        return bookCount;
    }

    //optional
    private static void setBookCount() {
       bookCount++;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        if (bookId == 0)
            this.bookId = getBookCount();
        else
            this.bookId = bookId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title.isBlank() || title.isEmpty())
            this.title = "<NO TITLE " + getBookCount() + ">";
        else
            this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        if (author.isBlank() || author.isEmpty())
            author = "<NO AUTHOR " + getBookCount()+">";
        this.author = author;
    }

    public boolean getIsAvailable() {
        return isAvailable;
    }

    private void setIsAvailable(boolean available) {
        isAvailable = available;
    }


    public void displayDetails() {
        System.out.println("\nBook Id: " + getBookId() +
                "\nTitle: " + getTitle() +
                "\nAuthor: " + getAuthor() +
                "\nAvailability: " + getIsAvailable());

    }


    //optional
    @Override
    public String toString() {
        return "Book Id: " + getBookId() + ", Title: " + getTitle() +
                ", Author: " + getAuthor() + ", Availability: " + getIsAvailable();
    }


    public void borrow() {
        if (getIsAvailable()) { //proper encapsulation
            setIsAvailable(false);
            System.out.println("Book borrowed: " + getTitle());
        }
        else
            System.out.println("Book is not available.");
    }

    public void return_book() {
        if (getIsAvailable() == false)
            setIsAvailable(true);
        else {
            System.out.println("You can't return a book that was not borrowed.");
        }

    }
}
