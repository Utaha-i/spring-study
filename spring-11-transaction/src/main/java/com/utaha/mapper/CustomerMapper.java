package com.utaha.mapper;

import com.utaha.pojo.Customer;

import java.util.List;

public interface CustomerMapper {
    List<Customer> selectCustomer();

    int addCustomer(Customer customer);

    int deleteCustomer(int id);
}
