import java.util.Date;

public class Main {
/*
    Design a Library Management System using object-oriented programming principles in
    Java. The system should manage Books, Members, Librarians, and Transactions such
    as borrowing and returning books. You need to model the system with appropriate classes
    and implement functionality using OOP concepts.
    */

    public static void main(String[] args) {
        Librarian librarian=new Librarian(1,"imchen");
        Member member=new Member(1,"aien");
        Book book1=new Book(101,"2000","Cambridge university press");
        Book book2=new Book(102,"O level computer science","Cambridge university press");

        librarian.addBook(book1);
        librarian.addBook(book2);

        Transaction borrowTransaction=new BorrowTransaction(1,new Date(),book1,member);
        borrowTransaction.execute();

        Transaction returnTransaction=new ReturnTransaction(2,new Date(),book1,member);
        returnTransaction.execute();

    }
}