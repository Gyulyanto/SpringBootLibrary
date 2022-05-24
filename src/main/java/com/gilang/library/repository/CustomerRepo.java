package com.gilang.library.repository;

import com.gilang.library.entity.Customer;
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
public interface CustomerRepo extends JpaRepository<Customer,String>, JpaSpecificationExecutor {
    @Query(value = "select '*' from mst_customer",nativeQuery = true)
    Page<Customer> findAll(Pageable pageable);
    @Query(value = "select '*' from mst_customer",nativeQuery = true)
    Page<Customer> findAll(Specification customerSpecification, Pageable pageable);
    @Query(value = "select '*' from mst_customer where firstName=? lastName=? ",nativeQuery = true)
    public List<Customer> findCustomerByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(@Param("firstName") String firstName, @Param("lastName")String lastName);
}
