package com.br.book.dto.response;

import java.util.UUID;

public class BookResponseDTO {

    private UUID id;
    private String title;
    private String author;
    private String isbn;
    private int publication_year;
    private int available_copies;

    public BookResponseDTO(UUID id, String title, String author, String isbn, int publication_year, int available_copies) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.publication_year = publication_year;
        this.available_copies = available_copies;
    }

    public UUID getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getIsbn() {
        return isbn;
    }

    public int getPublication_year() {
        return publication_year;
    }

    public int getAvailable_copies() {
        return available_copies;
    }
}
