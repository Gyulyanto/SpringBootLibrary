package com.gilang.library.specification;

import com.gilang.library.dto.CustomerSearchDto;
import com.gilang.library.entity.Customer;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.ArrayList;
import java.util.List;

public class CustomerSpecification {
    public static Specification<Customer> getSpecification(CustomerSearchDto customerSearchDto){
        return new Specification<Customer>() {
            @Override
            public Predicate toPredicate(Root<Customer> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
                List<Predicate>predicates = new ArrayList<>();
                if (!(customerSearchDto.getSearchCustomerFirstName()==null)){
                    Predicate customerFirstNamePredicate =
                            criteriaBuilder.like(criteriaBuilder.lower(root.get("firstName")), "%"+ customerSearchDto.getSearchCustomerFirstName() +"%");predicates.add(customerFirstNamePredicate);
                }
                if (!(customerSearchDto.getSearchCustomerLastName()==null)){
                    Predicate customerLastNamePredicate =
                            criteriaBuilder.like(criteriaBuilder.lower(root.get("lastName")), "%"+ customerSearchDto.getSearchCustomerLastName() +"%");
                    predicates.add(customerLastNamePredicate);
                }
                Predicate[] arrayPredicate = predicates.toArray(new Predicate[predicates.size()]);
                return criteriaBuilder.and(arrayPredicate);
            }
        };
    }
}
