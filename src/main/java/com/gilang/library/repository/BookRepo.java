package com.gilang.library.repository;

import com.gilang.library.entity.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface BookRepo extends JpaRepository<Book,String>, JpaSpecificationExecutor {
    @Query(value = "select'*'from mst_book ",nativeQuery = true)
    Page<Book> findAll(Pageable pageable);
    @Query(value = "Select'*'from mst_book",nativeQuery = true)
    Page<Book> findAll(Specification customerSpecification, Pageable pageable);
    @Query(value = "select '*' from mst_book where book_id =?",nativeQuery = true)
    public List<Book> findBookByBookNameContainingIgnoreCaseAndAuthorContainingIgnoreCase(@Param("bookName") String bookName, @Param("author")String author);

}
