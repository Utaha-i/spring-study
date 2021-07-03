package com.utaha.mapper;

import com.utaha.pojo.Customer;

import java.util.List;

public interface CustomerMapper {
    public List<Customer> selectCustomer();

    public int addCustomer(Customer customer);

    public int deleteCustomer(int id);
}
