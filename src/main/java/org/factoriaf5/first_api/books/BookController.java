package org.factoriaf5.first_api.books;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/books")
public class BookController {

    private final InMemoryBookRepository bookRepository;

    public BookController() {
        this.bookRepository = new InMemoryBookRepository();
    }

    @GetMapping
    public List<Book> getAllBooks() {
        return this.bookRepository.findAll();
    }

    @GetMapping("/{isbn}")
    public ResponseEntity<Book> getBookByIsbn(@PathVariable String isbn) {
        Optional<Book> optionalBook = bookRepository.findByIsbn(isbn);

        if (optionalBook.isPresent()) {
            return new ResponseEntity<>(optionalBook.get(), HttpStatus.OK); // 200 OK
        }

        return new ResponseEntity<>(HttpStatus.NOT_FOUND); // 404 Not Found
    }

    @PostMapping
    public Book createBook(@RequestBody Book book) {

        // Check that the ISBN does not already exist; if it does, return (bad_request)

        bookRepository.save(book);
        return book; // OK (200) or Created (201)
    }

    @DeleteMapping("/{isbn}")
    public void deleteBookByIsbn(@PathVariable String isbn) {
        // If the ISBN does not exist, return a 404
        // If the book is deleted, return OK
        bookRepository.deleteByIsbn(isbn);
    }

    // Update -> modify a book by its ISBN (PUT)
}
