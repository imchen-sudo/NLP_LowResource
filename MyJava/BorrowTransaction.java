import java.util.Date;

public class BorrowTransaction extends Transaction {
   /*    ● Create two classes BorrowTransaction and ReturnTransaction that inherit from
    the abstract Transaction class.
            ○ BorrowTransaction: Handles borrowing logic.
○ ReturnTransaction: Handles returning logic.
*/

    public BorrowTransaction(int transaction_Id, Date date, Book book, Member member) {
        super(transaction_Id, date, book, member);
    }

    @Override
    public void execute() {
        if (book.getIsAvailable()) { //check if the book is available
            member.borrow_book(book);
            System.out.println("Book '" + book.getTitle() +"' was successfully borrowed by member: " + member.getName());
        } else {
            System.out.println("Sorry, this book can't be borrowed for now as it is borrowed by someone else.");
        }

    }




}
