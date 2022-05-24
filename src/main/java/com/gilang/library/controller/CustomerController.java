package com.gilang.library.controller;

import com.gilang.library.dto.CustomerSearchDto;
import com.gilang.library.entity.Customer;
import com.gilang.library.services.CustomerServices;
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
public class CustomerController {
@Autowired
    CustomerServices customerServices;
@GetMapping("/customer")
    public List<Customer> getAll() {
        return customerServices.getAll();
    }



    @GetMapping("/customer/id")
    public Optional<Customer> getById(@RequestParam String id) {
        return customerServices.getById(id);
    }
@PostMapping("/customer/save")
    public Customer saveCustomer(@RequestBody Customer customer) {
        return customerServices.saveCustomer(customer);
    }
@PutMapping("/customer/update")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return customerServices.updateCustomer(customer);
    }
@DeleteMapping("/customer/delete")
    public void deleteCustomer(@RequestParam String id) {
        customerServices.deleteCustomer(id);
    }
@GetMapping("/customer/pagination")
    public Page<Customer> getAllCustomerPerPage(@RequestBody CustomerSearchDto customerSearchDto,
                                                @RequestParam(name = "page",defaultValue = "0") Integer page,
                                                @RequestParam(name = "size",defaultValue = "10") Integer sizePerPage,
                                                @RequestParam(name = "sorted", defaultValue = "id") String sorted,
                                                @RequestParam (name = "direction",defaultValue = "asc")String direction){

    //sort dari direction ambil dari string,sorted
    Sort sort = Sort.by(Sort.Direction.fromString(direction), sorted);

    Pageable pageable = PageRequest.of(page,sizePerPage, sort);
    System.out.println("page = "+page+" size = "+sizePerPage);
    return customerServices.getAllCustomerPerPage(pageable,customerSearchDto);
    }
@GetMapping("/customer/search")
public List<Customer> getCustomerByFirstName(@Param("name") String name, @Param("nameSecond")String nameSecond) {
//        List<Customer> customers = customerService.getCustomerByFirstName(name);
//        return customers;
    return customerServices.getCustomerByFirstName(name,nameSecond);
}

}
