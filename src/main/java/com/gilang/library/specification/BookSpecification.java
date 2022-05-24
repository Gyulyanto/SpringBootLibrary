package com.gilang.library.specification;

import com.gilang.library.dto.BookSearchDto;
import com.gilang.library.entity.Book;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class BookSpecification {
    public static Specification<Book> getSpecification(BookSearchDto bookSearchDto){
return new Specification<Book>() {
    @Override
    public Predicate toPredicate(Root<Book> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        List<Predicate>predicates = new ArrayList<>();
        if (!(bookSearchDto.getSearchBookName()==null)){
            Predicate bookBookNamePredicate =
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("bookName")), "%"+ bookSearchDto.getSearchBookName() +"%");
            predicates.add(bookBookNamePredicate);
        }
        if (!(bookSearchDto.getSearchAuthor()==null)){
            Predicate bookAuthorPredicate =
                    criteriaBuilder.like(criteriaBuilder.lower(root.get("author")), "%"+ bookSearchDto.getSearchAuthor() +"%");
            predicates.add(bookAuthorPredicate);
        }
        Predicate[] arrayPredicate = predicates.toArray(new Predicate[predicates.size()]);
        return criteriaBuilder.and(arrayPredicate);
    }
};
    }
}
