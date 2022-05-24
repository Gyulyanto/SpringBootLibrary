package com.gilang.library.services;

import com.gilang.library.dto.CustomerSearchDto;
import com.gilang.library.entity.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface CustomerServices {

    public List<Customer> getAll();
    public Optional<Customer> getById(String  id);

    public Customer saveCustomer(Customer customer);
    public Customer updateCustomer(Customer customer);
    public void deleteCustomer(String id);
    public Page<Customer> getAllCustomerPerPage(Pageable pageable, CustomerSearchDto customerSearchDto);
    public List<Customer> getCustomerByFirstName(String firstName,String lastName);
}
