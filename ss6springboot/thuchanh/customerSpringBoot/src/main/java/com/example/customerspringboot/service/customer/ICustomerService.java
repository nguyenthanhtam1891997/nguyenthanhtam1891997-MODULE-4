package com.example.customerspringboot.service.customer;

import com.example.customerspringboot.model.Customer;
import com.example.customerspringboot.model.Province;
import com.example.customerspringboot.service.IGeneralService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface ICustomerService extends IGeneralService<Customer> {
    Iterable<Customer> findAllByProvince(Province province);
    Page<Customer> findAllByFirstNameContaining(String firstName, Pageable pageable);

}
