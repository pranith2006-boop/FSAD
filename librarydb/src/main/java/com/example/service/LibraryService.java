package com.example.service;

import com.example.model.Book;
import com.example.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryService {

    @Autowired
    private BookRepository repo;

    // Add one book
    public Book addBook(Book book) {
        return repo.save(book);
    }

    // Add many books
    public List<Book> addAllBooks(List<Book> books) {
        return repo.saveAll(books);
    }

    // Get all
    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    // Get by id
    public Book getBookById(Integer id) {
        return repo.findById(id).orElse(null);
    }

    // Update
    public Book updateBook(Integer id, Book newBook) {
        Book oldBook = repo.findById(id).orElse(null);

        if (oldBook != null) {
            oldBook.setTitle(newBook.getTitle());
            oldBook.setAuthor(newBook.getAuthor());
            oldBook.setPrice(newBook.getPrice());
            return repo.save(oldBook);
        }
        return null;
    }

    // Delete
    public String deleteBook(Integer id) {
        repo.deleteById(id);
        return "Book Deleted";
    }
}
