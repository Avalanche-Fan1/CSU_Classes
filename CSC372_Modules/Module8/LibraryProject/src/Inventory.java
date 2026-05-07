import java.util.ArrayList;

public class Inventory {
    private ArrayList<Book> availableBooks;
    private ArrayList<Book> borrowedBooks;

    public Inventory () {
        availableBooks = new ArrayList<Book>();
        borrowedBooks = new ArrayList<Book>();
    }

    public void addBook(int bookID, String bookTitle, String bookAuthor, String bookISBN, int bookPages) {
        Book newBook = new Book(bookID, bookTitle, bookAuthor, bookISBN, bookPages);
        availableBooks.add(newBook);
        System.out.println("Book added to the library.");
    }

    public void searchByTitle (String userSearch) {

        boolean found = false;
        userSearch = userSearch.toLowerCase();

        if (availableBooks.isEmpty()) {
            System.out.println("There are no available books in the library.");
        }
        else {
            for (Book book : availableBooks) {
                if (book.getBookTitle().toLowerCase().contains(userSearch)) {
                    book.printBookInfo();
                    found = true;
                }
            }
            if (!found) {
                System.out.println("No matching book found.");
            }
        }
    }

    public void printAll() {
        if (availableBooks.isEmpty()) {
            System.out.println("There are no available books in the library.");
        }
        else {

            for (Book book : availableBooks) {
                book.printBookInfo();
            }
        }
    }

    public void borrowBook(int bookID) {

        boolean found = false;
        for (int i = 0; i < availableBooks.size(); i++ ) {
            Book book = availableBooks.get(i);
            if (bookID == book.getBookID()) {
                System.out.println("Book successfully borrowed.");
                borrowedBooks.add(book);
                availableBooks.remove(i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book not found or already borrowed.");
        }
    }
    public void returnBook(int bookID) {

        boolean found = false;
        for (int i = 0; i < borrowedBooks.size(); i++ ) {
            Book book = borrowedBooks.get(i);
            if (bookID == book.getBookID()) {
                System.out.println("Book successfully returned.");
                availableBooks.add(book);
                borrowedBooks.remove(i);
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Book not found or not already borrowed.");
        }
    }
}
