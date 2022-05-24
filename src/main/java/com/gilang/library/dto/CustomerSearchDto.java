package com.gilang.library.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
@AllArgsConstructor
@Getter@Setter
public class CustomerSearchDto {
    private String searchCustomerFirstName;
    private String searchCustomerLastName;
    private Date searchCustomerBirthDate;
}
