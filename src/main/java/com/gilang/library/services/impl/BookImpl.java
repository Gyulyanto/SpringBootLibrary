package com.gilang.library.services.impl;

import com.gilang.library.dto.BookSearchDto;
import com.gilang.library.entity.Book;
import com.gilang.library.repository.BookRepo;
import com.gilang.library.services.BookServices;
import com.gilang.library.specification.BookSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class BookImpl implements BookServices {
    @Autowired
    BookRepo bookRepo;

    @Override
    public List<Book> getAll() {
        List<Book> books=bookRepo.findAll();
        return books;
    }

    @Override
    public Optional<Book> getById(String id) {
        return bookRepo.findById(id);
    }

    @Override
    public Book saveBook(Book book) {
        bookRepo.save(book);
        return book;
    }

    @Override
    public Book updateBook(Book book) {
        bookRepo.save(book);
        return book;
    }

    @Override
    public void deleteBook(String id) {
    bookRepo.deleteById(id);
    }

    @Override
    public Page<Book> getAllBookPerPage(Pageable pageable, BookSearchDto bookSearchDto) {
        Specification<Book> customerSpecification = BookSpecification.getSpecification(bookSearchDto);
        return bookRepo.findAll(customerSpecification,pageable);
    }

    @Override
    public List<Book> getCustomerByBookNameAndAuthor(String bookName, String author) {
        return bookRepo.findBookByBookNameContainingIgnoreCaseAndAuthorContainingIgnoreCase(bookName,author);
    }
}
