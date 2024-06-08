import java.util.ArrayList;
import java.util.List;

class Author {
    private String name;
    private String biography;

    public Author(String name,String biography) {
        this.name=name;
        this.biography=biography;
    }

    public String getName() {
        return name;
    }

    public String getBiography() {
        return biography;
    }
}

class Book {
    private String title;
    private Author author;
    private int publicationYear;

    public Book(String title, Author author, int publicationYear) {
        this.title=title;
        this.author=author;
        this.publicationYear=publicationYear;
    }

    public String getTitle() {
        return title;
    }

    public Author getAuthor() {
        return author;
    }

    public int getPublicationYear() {
        return publicationYear;
    }
}

class Library {
    private List<Book> books;

    Library() {
        this.books=new ArrayList<>();
    }

    void addBook(Book book) {
        books.add(book);
    }

    List<Book> searchAuthor(String authorName) {
        List<Book> foundBooks=new ArrayList<>();
        for (Book book: books) {
            if (book.getAuthor().getName().toLowerCase().contains(authorName.toLowerCase())) {
                foundBooks.add(book);
            }
        }
        return foundBooks;
    }

}

public class Lib_Main {
    public static void main(String[] args) {
        Author author1=new Author("Sudha Murthy","Best known for herphilanthropy and her contribution to literature in Kanada and English.");
        Author author2=new Author("Rick Riordan","Best known for writing the Percy Jackson & the Olympians series.");

        Book book1=new Book("The Seed of Truth",author1,2013);
        Book book2=new Book("The Titan's Curse",author2,2007);

        Library library=new Library();
        library.addBook(book1);
        library.addBook(book2);
        System.out.println("Books written by Sudha Murthy ");
        for (Book book : library.searchAuthor("Sudha Murthy")) {
            System.out.println(book.getTitle());
        }

        
    }
}