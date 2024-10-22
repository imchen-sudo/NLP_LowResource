import java.util.ArrayList;
import java.util.List;

public class Member {

/*
 ● Member
○ Attributes: member_id, name, borrowed_books (list of borrowed book IDs)
○ Methods: borrow_book(), return_book(), get_borrowed_books()

*/

    private int member_id;
    private String name;
    private List<Integer> borrowedBooks;

    //optional
    private static int memberCount = 0;


    public Member(int member_id, String name) {
        setMemberCount();
        setMember_id(member_id);
        setName(name);
        setBorrowedBooks();
    }


    public int getMember_id() {
        return member_id;
    }

    public void setMember_id(int member_id) {
        if (member_id == 0)
            setMember_id(getMember_id() + 1);
        else
             this.member_id = member_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        if (name.isEmpty() || name.isBlank())
            this.name = "<NEW MEMEBER " + getMemberCount() + ">";
        else
            this.name = name;
    }

    //optional
    public static int getMemberCount() {
        return memberCount;
    }

    //optional
    public static void setMemberCount() {
        memberCount++;
    }

    //optional
    @Override
    public String toString() {
        return "Member Id: " + member_id + ", " + "Name: " + name;
    }

    public List<Integer> getBorrowedBooks() {
        return borrowedBooks;
    }

    private void setBorrowedBooks() {
        borrowedBooks = new ArrayList<>();
    }

    public void borrow_book(Book book) {
        if (book.getIsAvailable()) { //check if the book is available
            book.borrow();
            borrowedBooks.add(book.getBookId());
        }
        else {
            System.out.println("Sorry, the book '" + book.getTitle() + "' is not available to be borrowed.");
        }
    }

    public void return_book(Book book) {
        if (borrowedBooks.contains(book.getBookId()))  { //check if the book is borrowed by this member
            book.return_book();
            borrowedBooks.remove(Integer.valueOf(book.getBookId())); //get the arraylist index of the book
        } else {
            System.out.println("You cannot return this book as it wasn't borrowed by this member.");
        }
    }
}
