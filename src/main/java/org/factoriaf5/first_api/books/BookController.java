package org.factoriaf5.first_api.books;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/books")
public class BookController {

    private  final static  List<Book> booksDB = new ArrayList<>();


    @GetMapping
    public List<Book> getAllBooks(){

    }
}
