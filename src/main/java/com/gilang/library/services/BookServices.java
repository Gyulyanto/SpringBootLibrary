package com.gilang.library.services;

import com.gilang.library.dto.BookSearchDto;

import com.gilang.library.entity.Book;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface BookServices {
    public List<Book> getAll();
    public Optional<Book> getById(String  id);

    public Book saveBook(Book book);
    public Book updateBook(Book book);
    public void deleteBook(String id);
    public Page<Book> getAllBookPerPage(Pageable pageable, BookSearchDto bookSearchDto);
    public List<Book> getCustomerByBookNameAndAuthor(String bookName,String author);
}
