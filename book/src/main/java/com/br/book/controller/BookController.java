package com.br.book.controller;

import com.br.book.dto.request.CreateBookRequestDTO;
import com.br.book.dto.response.BookResponseDTO;
import com.br.book.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/allBooks")
    public ResponseEntity<List<BookResponseDTO>> getAllBooks() {
        List<BookResponseDTO> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @PostMapping("/newBook")
    public ResponseEntity<BookResponseDTO> createBook(@RequestBody CreateBookRequestDTO CreateBookRequestDTO) {
        BookResponseDTO bookResponseDTO = bookService.createBook(CreateBookRequestDTO);
        return ResponseEntity.ok(bookResponseDTO);

    }

    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDTO> getBookById(@PathVariable UUID id) {
        BookResponseDTO bookResponseDTO = bookService.getBookById(id);
        return ResponseEntity.ok(bookResponseDTO);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteBookById(@PathVariable UUID id) {
        bookService.deleteBook(id);
        return ResponseEntity.ok("Livro com ID: " + id + " deletado com sucesso!");

    }

    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDTO> updateBook(@PathVariable UUID id, @RequestBody CreateBookRequestDTO CreateBookRequestDTO) {
        BookResponseDTO bookResponseDTO = bookService.updateBook(id,CreateBookRequestDTO);
        return ResponseEntity.ok(bookResponseDTO);
    }


}
