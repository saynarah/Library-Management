package com.br.book.service;

import com.br.book.dto.request.CreateBookRequestDTO;
import com.br.book.dto.response.BookResponseDTO;
import com.br.book.entity.Book;
import com.br.book.repository.BookRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookResponseDTO createBook(CreateBookRequestDTO createBookRequestDTO) {
        Book newBook = new Book(createBookRequestDTO.getTitle(), createBookRequestDTO.getAuthor(), createBookRequestDTO.getIsbn(), createBookRequestDTO.getPublication_year(),createBookRequestDTO.getAvailable_copies());
        Book bookObj = bookRepository.save(newBook);
        return new BookResponseDTO(bookObj.getId(),bookObj.getTitle(),bookObj.getAuthor(), bookObj.getIsbn(), bookObj.getPublication_year(), bookObj.getAvailable_copies() );

    }

    public List<BookResponseDTO> getAllBooks() {
        List<Book> books = bookRepository.findAll();
        return books.stream()
                .map(book -> new BookResponseDTO(book.getId(),book.getTitle(),book.getAuthor(),book.getIsbn(),book.getPublication_year(),book.getAvailable_copies()))
                .collect(Collectors.toList());

    }
}
