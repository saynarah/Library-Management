package com.br.book.service;

import com.br.book.dto.request.CreateBookRequestDTO;
import com.br.book.dto.response.BookResponseDTO;
import com.br.book.entity.Book;
import com.br.book.repository.BookRepository;
import exception.BookNotFoundException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class BookService {
    private final BookRepository bookRepository;

    private static final Logger logger = LoggerFactory.getLogger(BookService.class);

    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    public BookResponseDTO createBook(CreateBookRequestDTO createBookRequestDTO) {

        logger.info("Iniciando criação do livro com título: {}", createBookRequestDTO.getTitle());

        Book newBook = new Book(createBookRequestDTO.getTitle(), createBookRequestDTO.getAuthor(), createBookRequestDTO.getIsbn(), createBookRequestDTO.getPublication_year(),createBookRequestDTO.getAvailable_copies());
        Book bookObj = bookRepository.save(newBook);

        logger.info("Livro criado com sucesso com título: {}, Livro ID: {}", bookObj.getTitle(), bookObj.getId());
        return new BookResponseDTO(bookObj.getId(),bookObj.getTitle(),bookObj.getAuthor(), bookObj.getIsbn(), bookObj.getPublication_year(), bookObj.getAvailable_copies() );

    }

    public List<BookResponseDTO> getAllBooks() {
        logger.info("Iniciando o método de busca de livros");

        List<Book> books = bookRepository.findAll();

        logger.info("Finalizando o método de busca de livros");

        return books.stream()
                .map(book -> new BookResponseDTO(book.getId(),book.getTitle(),book.getAuthor(),book.getIsbn(),book.getPublication_year(),book.getAvailable_copies()))
                .collect(Collectors.toList());

    }

    public BookResponseDTO getBookById(UUID id) {

        logger.info("Iniciando a busca por um livro com ID: {}",id);

        Book book = bookRepository.findById(id)
                .orElseThrow(()-> new BookNotFoundException("Livro não encontrado com ID: " + id));

        logger.info("Finalizando a busca por um livro com ID: {}",id);

        return new BookResponseDTO(book.getId(), book.getTitle(), book.getAuthor(), book.getIsbn(), book.getPublication_year(), book.getAvailable_copies());
    }

    public void deleteBook(UUID id) {

        logger.info("Iniciando deleção do livro com ID: {}",id);

        Book book = bookRepository.findById(id)
                .orElseThrow(()-> new BookNotFoundException("Book não encontrado com ID: " + id));

            bookRepository.delete(book);

        logger.info("Finalizando deleção do livro com ID: {}",id);
    }

    public BookResponseDTO updateBook(UUID id, CreateBookRequestDTO bookRequestDTO){

        logger.info("Iniciando atualização do livro com ID: {}",id);

        Book book = bookRepository.findById(id)
                .orElseThrow(()-> new BookNotFoundException("Livro não encontrado com id: " + id));

            book.setTitle(bookRequestDTO.getTitle());
            book.setAuthor(bookRequestDTO.getAuthor());
            book.setIsbn(bookRequestDTO.getIsbn());
            book.setPublication_year(bookRequestDTO.getPublication_year());
            book.setAvailable_copies(bookRequestDTO.getAvailable_copies());

            Book bookUpdated = bookRepository.save(book);

            logger.info("Livro atualizado com sucesso: {}", bookUpdated.getTitle());

            return new BookResponseDTO(bookUpdated.getId(),bookUpdated.getTitle(),bookUpdated.getAuthor(),bookUpdated.getIsbn(), bookUpdated.getPublication_year(), bookUpdated.getAvailable_copies());

    }
}
