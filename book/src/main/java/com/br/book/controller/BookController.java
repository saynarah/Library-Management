package com.br.book.controller;

import com.br.book.dto.request.CreateBookRequestDTO;
import com.br.book.dto.response.BookResponseDTO;
import com.br.book.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping
    public ResponseEntity<List<BookResponseDTO>> getAllBooks() {
        List<BookResponseDTO> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }

    @PostMapping
    public ResponseEntity<BookResponseDTO> createBook(@RequestBody CreateBookRequestDTO CreateBookRequestDTO) {
        BookResponseDTO bookResponseDTO = bookService.createBook(CreateBookRequestDTO);
        return ResponseEntity.ok(bookResponseDTO);

    }



}
