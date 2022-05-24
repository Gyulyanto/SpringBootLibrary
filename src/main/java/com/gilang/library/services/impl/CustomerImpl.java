package com.gilang.library.services.impl;

import com.gilang.library.dto.CustomerSearchDto;
import com.gilang.library.entity.Customer;
import com.gilang.library.repository.CustomerRepo;
import com.gilang.library.services.CustomerServices;
import com.gilang.library.specification.CustomerSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerImpl implements CustomerServices {
@Autowired
CustomerRepo customerRepo;

    @Override
    public List<Customer> getAll() {
        List<Customer> customers = customerRepo.findAll();
        return customers;
    }

    @Override
    public Optional<Customer> getById(String id) {
        return customerRepo.findById(id);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        customerRepo.save(customer);
        return customer;

    }

    @Override
    public Customer updateCustomer(Customer customer) {
        customerRepo.save(customer);
        return customer;
    }

    @Override
    public void deleteCustomer(String id) {
customerRepo.deleteById(id);
    }

    @Override
    public Page<Customer> getAllCustomerPerPage(Pageable pageable,CustomerSearchDto customerSearchDto) {
        Specification<Customer> customerSpecification = CustomerSpecification.getSpecification(customerSearchDto);
        return customerRepo.findAll(customerSpecification,pageable);
    }

    @Override
    public List<Customer> getCustomerByFirstName(String firstName, String lastName) {
        return customerRepo.findCustomerByFirstNameContainingIgnoreCaseAndLastNameContainingIgnoreCase(firstName,lastName);
    }
}
