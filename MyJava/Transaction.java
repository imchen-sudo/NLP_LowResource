import java.util.Date;

public abstract class Transaction {

/*    ● Transaction (Abstract Class)
○ Attributes: transaction_id, date, book, member
○ Methods: execute() (abstract method)

*/
    protected int transaction_Id;
    protected Date date;
    protected Book book;
    protected Member member;

    public Transaction(int transaction_Id, Date date, Book book, Member member) {
        this.transaction_Id = transaction_Id;
        this.date = date;
        this.book = book;
        this.member = member;
    }

    public abstract void execute();
}
