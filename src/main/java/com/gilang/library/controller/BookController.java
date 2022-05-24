package com.gilang.library.controller;

import com.gilang.library.dto.BookSearchDto;
import com.gilang.library.entity.Book;
import com.gilang.library.services.BookServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class BookController {
    @Autowired
    BookServices  bookServices;
    @GetMapping("/book")
    public List<Book> getAll() {
        return bookServices.getAll();
    }
@GetMapping("/book/getid")
    public Optional<Book> getById(@RequestParam String id) {
        return bookServices.getById(id);
    }
@PostMapping("/book/save")
    public Book saveBook(@RequestBody Book book) {
        return bookServices.saveBook(book);
    }
@PutMapping("/book/update")
    public Book updateBook(@RequestBody Book book) {
        return bookServices.updateBook(book);
    }
@DeleteMapping("/book/delete")
    public void deleteBook(@RequestParam String id) {
        bookServices.deleteBook(id);
    }
@GetMapping("/book/pagination")
    public Page<Book> getAllCustomerPerPage(@RequestBody BookSearchDto bookSearchDto,
                                            @RequestParam(name = "page",defaultValue = "0") Integer page,
                                            @RequestParam(name = "size",defaultValue = "10") Integer sizePerPage,
                                            @RequestParam(name = "sorted", defaultValue = "id") String sorted,
                                            @RequestParam (name = "direction",defaultValue = "asc")String direction){

        //sort dari direction ambil dari string,sorted
        Sort sort = Sort.by(Sort.Direction.fromString(direction), sorted);

        Pageable pageable = PageRequest.of(page,sizePerPage, sort);
        System.out.println("page = "+page+" size = "+sizePerPage);
        return bookServices.getAllBookPerPage(pageable,bookSearchDto);
    }
@GetMapping("/book/search")
    public List<Book> getCustomerByBookNameAndAuthor(@Param("bookName") String bookName,@Param("author") String author) {
        return bookServices.getCustomerByBookNameAndAuthor(bookName, author);
    }
}
