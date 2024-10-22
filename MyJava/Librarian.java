import java.util.ArrayList;
import java.util.List;

public class Librarian {

/*    ● Librarian
○ Attributes: librarian_id, name
○ Methods: add_book(), remove_book(), search_book()
*/

    private int librarian_id;
    private String name;
    private List<Integer> booksList;

    //optional
    private static int librarianCount = 0;

    public Librarian(int librarian_id, String name) {
        setLibrarianCount();
        setBooksList();
        setLibrarian_id(librarian_id);
        setName(name);
    }

    public int getLibrarian_id() {
        return librarian_id;
    }

    public void setLibrarian_id(int librarian_id) {
        if (librarian_id == 0)
            this.librarian_id = getLibrarianCount();
        else
            this.librarian_id = librarian_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isBlank() || name.isEmpty())
            this.name = "<NO NAME " + getLibrarianCount() + ">";
        else
            this.name = name;
    }

    public static int getLibrarianCount() {
        return librarianCount;
    }

    public static void setLibrarianCount() {
        librarianCount++;
    }

    public List<Integer> getBooksList() {
        return booksList;
    }

    private void setBooksList() {
        booksList = new ArrayList<>();
    }

    //optional
    @Override
    public String toString() {
        return "Librarian id: " + getLibrarian_id() + ", " + "Name: " + getName();
    }

    public void addBook(Book book) {
        //check if the book is already added
        if(booksList.contains(book.getBookId()))
            System.out.println("You can't add this book. The book is already in the list");
        else {
            booksList.add(book.getBookId());
            System.out.println(book.getTitle() + " book as successfully added.");
        }
    }

    public void removeBook(Book book) {
        if (booksList.contains(Integer.valueOf(book.getBookId()))) {//check if the book is in the list
            booksList.remove(Integer.valueOf(book.getBookId()));
            System.out.println(book.getTitle() + " book was successfully removed");
        }
        else
            System.out.println("You cannot removed the book as it is not in the list.");
    }

    public void searchBook(String title, List<Book> books) {
        for (Book theBook : books) {
            if (theBook.getTitle().toUpperCase().equals(title)) {
                theBook.displayDetails();
                return;
            }
        }
        System.out.println("Book not found.");
    }



}
