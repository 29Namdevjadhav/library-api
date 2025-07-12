package com.example.library.service;

import com.example.library.model.Book;
import com.example.library.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    private final BookRepository repository;

    public BookService(BookRepository repository) {
        this.repository = repository;
    }

    public Book addBook(Book book) {
        return repository.save(book);
    }

    public List<Book> getAllBooks() {
        return repository.findAll();
    }

    public Book getBookById(Integer id) {
        return repository.findById(id).orElse(null);
    }

    public boolean deleteBook(Integer id) {
        if (repository.existsById(id)) {
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    public boolean updateAvailability(Integer id, Boolean available) {
        return repository.findById(id).map(book -> {
            book.setAvailable(available);
            repository.save(book);
            return true;
        }).orElse(false);
    }
}