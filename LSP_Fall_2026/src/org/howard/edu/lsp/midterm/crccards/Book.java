package org.howard.edu.lsp.midterm.crccards;

/**
 * Represents a book in the library lending system.
 * Maintains the book's details and its current availability status.
 * 
 * @author Malik John
 */
public class Book {
    private String isbn;
    private String title;
    private String author;
    private boolean available;

    /**
     * Constructs a new Book. New books are available by default.
     *
     * @param isbn   the ISBN of the book
     * @param title  the title of the book
     * @param author the author of the book
     */
    public Book(String isbn, String title, String author) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.available = true; // New books start available
    }

    /**
     * Gets the ISBN of the book.
     *
     * @return the book's ISBN
     */
    public String getIsbn() {
        return isbn;
    }

    /**
     * Gets the title of the book.
     *
     * @return the book's title
     */
    public String getTitle() {
        return title;
    }

    /**
     * Gets the author of the book.
     *
     * @return the book's author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * Checks if the book is currently available to be borrowed.
     *
     * @return true if the book is available, false if it is borrowed
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Marks the book as borrowed, making it unavailable.
     *
     * @throws IllegalStateException if the book is already borrowed
     */
    public void borrowBook() {
        if (!available) {
            throw new IllegalStateException("Book is already borrowed.");
        }
        this.available = false;
    }

    /**
     * Marks the book as returned, making it available again.
     *
     * @throws IllegalStateException if the book is already available
     */
    public void returnBook() {
        if (available) {
            throw new IllegalStateException("Book is already available.");
        }
        this.available = true;
    }

    /**
     * Returns a string representation of the book, including its status.
     * Format: "ISBN Title by Author [STATUS]"
     * Example: "B101 Effective Java by Joshua Bloch [AVAILABLE]"
     *
     * @return the formatted string representation of the book
     */
    @Override
    public String toString() {
        String status = available ? "[AVAILABLE]" : "[BORROWED]";
        return isbn + " " + title + " by " + author + " " + status;
    }
}
