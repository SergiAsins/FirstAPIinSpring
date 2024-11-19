package org.factoriaf5.first_api.books;

import java.util.*;

public class InMemoryBookRepository implements BookRepository {

    private final static List<Book> booksDB = new ArrayList<>();

    public InMemoryBookRepository() {
        booksDB.add(new Book("A111", "BlackLifeMatters", "John Joe"));
        booksDB.add(new Book("B222", "FreeWorld", "Hello World"));
    }

    @Override
    public List<Book> findAll() {
        return Collections.unmodifiableList(booksDB);
    }

    @Override
    public Optional<Book> findByIsbn(String isbn) {
        for (Book book : booksDB) {
            if (book.getISBN().equals(isbn)) return Optional.of(book);
        }
        return Optional.empty();
    }

    @Override
    public void save(Book book) {
        booksDB.add(book);
    }

    @Override
    public void deleteByIsbn(String isbn) {
        booksDB.removeIf(book -> book.getISBN().equals(isbn));
    }
}