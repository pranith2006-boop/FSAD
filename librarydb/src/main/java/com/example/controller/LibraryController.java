package com.example.controller;

import com.example.model.Book;
import com.example.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/library")
public class LibraryController {

    @Autowired
    private LibraryService service;

    // Add one book
    @PostMapping("/add")
    public Book addBook(@RequestBody Book book) {
        return service.addBook(book);
    }

    // Add many books
    @PostMapping("/addAll")
    public List<Book> addAll(@RequestBody List<Book> books) {
        return service.addAllBooks(books);
    }

    // Get all books
    @GetMapping("/all")
    public List<Book> getAll() {
        return service.getAllBooks();
    }

    // Get book by id
    @GetMapping("/{id}")
    public Book getById(@PathVariable Integer id) {
        return service.getBookById(id);
    }

    // Update book
    @PutMapping("/update/{id}")
    public Book update(@PathVariable Integer id,
                       @RequestBody Book book) {
        return service.updateBook(id, book);
    }

    // Delete book
    @DeleteMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        return service.deleteBook(id);
    }
}
