public class Book {
    private int bookID;
    private String bookTitle;
    private String bookAuthor;
    private String bookISBN;
    private int bookPages;

    public Book () {
        bookID = -1;
        bookTitle = "NoName";
        bookAuthor = "NoName";
        bookISBN = "NoNumber";
        bookPages = -1;
    }
    public Book (int bookID, String bookTitle, String bookAuthor, String bookISBN, int bookPages) {
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.bookAuthor = bookAuthor;
        this.bookISBN = bookISBN;
        this.bookPages = bookPages;
    }

    //Getters for Books //
    public int getBookID(){
        return bookID;
    }

    public String getBookTitle(){
        return bookTitle;
    }

    public String getBookAuthor(){
        return bookAuthor;
    }

    public String getBookISBN(){
        return bookISBN;
    }

    public int getBookPages(){
        return bookPages;
    }

    //Setters for Books //
    public void setBookID(int bookID){
        this.bookID = bookID;
    }

    public void setBookTitle(String bookTitle){
        this.bookTitle = bookTitle;
    }

    public void setBookAuthor(String bookAuthor){
        this.bookAuthor = bookAuthor;
    }

    public void setBookISBN(String bookISBN){
        this.bookISBN = bookISBN;
    }

    public void setBookPages(int bookPages){
        this.bookPages = bookPages;
    }

    // Print Book information //
    public void printBookInfo(){
        System.out.println("ID: " + bookID);
        System.out.println("Title: " + bookTitle);
        System.out.println("Author: " + bookAuthor);
        System.out.println("ISBN: " + bookISBN);
        System.out.println("Pages: " + bookPages);

    }

}


