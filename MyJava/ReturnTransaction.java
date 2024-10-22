import java.util.Date;

public class ReturnTransaction extends Transaction {
    /*    ● Create two classes BorrowTransaction and ReturnTransaction that inherit from
    the abstract Transaction class.
            ○ BorrowTransaction: Handles borrowing logic.
○ ReturnTransaction: Handles returning logic.
*/

    public ReturnTransaction(int transaction_Id, Date date, Book book, Member member) {
        super(transaction_Id, date, book, member);
    }

    @Override
    public void execute() {
        if (!book.getIsAvailable()) {
            member.return_book(book);
            System.out.println("Book '" + book.getTitle() + "' is now returned by member: " + member.getName());
        } else {
            System.out.println("Sorry, the book can't be returned as it is not currently borrowed.");
        }
    }
}
