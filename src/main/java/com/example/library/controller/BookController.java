package com.example.library.controller;

import com.example.library.model.Book;
import com.example.library.service.BookService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    public BookController(BookService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<?> addBook(@Valid @RequestBody Book book) {
        return ResponseEntity.ok(service.addBook(book));
    }

    @GetMapping
    public ResponseEntity<List<Book>> getAllBooks() {
        return ResponseEntity.ok(service.getAllBooks());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getBookById(@PathVariable Integer id) {
        Book book = service.getBookById(id);
        return book != null ? ResponseEntity.ok(book) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteBook(@PathVariable Integer id) {
        return service.deleteBook(id)
                ? ResponseEntity.ok("Book deleted")
                : ResponseEntity.status(404).body("Book not found");
    }

    @PatchMapping("/{id}/availability")
    public ResponseEntity<String> updateAvailability(@PathVariable Integer id, @RequestParam boolean available) {
        return service.updateAvailability(id, available)
                ? ResponseEntity.ok("Availability updated")
                : ResponseEntity.status(404).body("Book not found");
    }
}