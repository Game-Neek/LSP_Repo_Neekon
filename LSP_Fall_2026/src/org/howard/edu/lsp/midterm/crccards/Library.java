package org.howard.edu.lsp.midterm.crccards;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

/**
 * Represents a library that maintains a collection of books.
 * Responsible for adding books, locating them, and coordinating the borrowing
 * and returning processes while enforcing a library-wide borrowing limit.
 * 
 * @author [Your Name Here]
 */
public class Library {
    private List<Book> books;
    
    // Constant for the maximum number of borrowed books allowed
    private static final int MAX_BORROWED_BOOKS = 3;

    /**
     * Constructs an empty Library.
     */
    public Library() {
        this.books = new ArrayList<>();
    }

    /**
     * Adds a new book to the library.
     *
     * @param book the Book to be added
     * @throws IllegalArgumentException if a book with the same ISBN already exists in the library
     */
    public void addBook(Book book) {
        if (findBook(book.getIsbn()) != null) {
            throw new IllegalArgumentException("A book with ISBN " + book.getIsbn() + " already exists in the library.");
        }
        books.add(book);
    }

    /**
     * Finds and returns a book by its ISBN.
     *
     * @param isbn the ISBN to search for
     * @return the Book instance if found, or null if it does not exist in the library
     */
    public Book findBook(String isbn) {
        for (Book book : books) {
            if (book.getIsbn().equals(isbn)) {
                return book;
            }
        }
        return null;
    }

    /**
     * Borrows a book from the library by its ISBN.
     * Enforces a library-wide limit on the total number of borrowed books.
     *
     * @param isbn the ISBN of the book to borrow
     * @throws IllegalArgumentException if the ISBN is not found in the library
     * @throws IllegalStateException    if the library limit of 3 borrowed books is reached,
     *                                  or if the book is already borrowed
     */
    public void borrowBook(String isbn) {
        Book book = findBook(isbn);
        if (book == null) {
            throw new IllegalArgumentException("Book with ISBN " + isbn + " not found in the library.");
        }
        
        // We must check the borrowing limit before attempting to borrow the specific book
        // to ensure the state remains unchanged if the operation fails.
        if (book.isAvailable() && getBorrowedBookCount() >= MAX_BORROWED_BOOKS) {
            throw new IllegalStateException("Borrowing limit reached. Cannot borrow more than " + MAX_BORROWED_BOOKS + " books.");
        }
        
        // Delegate the state change to the Book
        book.borrowBook();
    }

    /**
     * Returns a previously borrowed book to the library by its ISBN.
     *
     * @param isbn the ISBN of the book to return
     * @throws IllegalArgumentException if the ISBN is not found in the library
     * @throws IllegalStateException    if the book is already available
     */
    public void returnBook(String isbn) {
        Book book = findBook(isbn);
        if (book == null) {
            throw new IllegalArgumentException("Book with ISBN " + isbn + " not found in the library.");
        }
        
        // Delegate the state change to the Book
        book.returnBook();
    }

    /**
     * Retrieves a list of all currently available books.
     *
     * @return a List of available Books. Returns an empty List if no books are available.
     */
    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }
        return availableBooks;
    }

    /**
     * Retrieves a list of books by a specific author.
     *
     * @param author the exact author name to match (case-sensitive)
     * @return a List of matching Books. Returns an empty List if no matches are found.
     */
    public List<Book> getBooksByAuthor(String author) {
        List<Book> matchingBooks = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equals(author)) {
                matchingBooks.add(book);
            }
        }
        return matchingBooks;
    }

    /**
     * Retrieves all books in the library sorted by their ISBN in ascending lexicographical order.
     * This method does not modify the library's internal state.
     *
     * @return a new, sorted List of all Books. Returns an empty List if the library is empty.
     */
    public List<Book> getBooksSortedByIsbn() {
        // Create a shallow copy of the books list to avoid altering internal ordering
        List<Book> sortedBooks = new ArrayList<>(books);
        
        // Sort the list based on the string value of the ISBN
        sortedBooks.sort(Comparator.comparing(Book::getIsbn));
        
        return sortedBooks;
    }

    /**
     * Calculates the current number of books that are borrowed.
     *
     * @return the number of unavailable (borrowed) books
     */
    public int getBorrowedBookCount() {
        int count = 0;
        for (Book book : books) {
            if (!book.isAvailable()) {
                count++;
            }
        }
        return count;
    }
}