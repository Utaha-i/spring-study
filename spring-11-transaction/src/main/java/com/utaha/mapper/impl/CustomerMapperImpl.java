package com.utaha.mapper.impl;

import com.utaha.mapper.CustomerMapper;
import com.utaha.pojo.Customer;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.Hashtable;
import java.util.List;

public class CustomerMapperImpl extends SqlSessionDaoSupport implements CustomerMapper {


    @Override
    public List<Customer> selectCustomer() {
        Customer customer01 = new Customer(003, "test01", "asd123");
        addCustomer(customer01);
        deleteCustomer(003);
        return getSqlSessionTemplate().getMapper(CustomerMapper.class).selectCustomer();
    }

    @Override
    public int addCustomer(Customer customer) {
        return getSqlSessionTemplate().getMapper(CustomerMapper.class).addCustomer(customer);
    }

    @Override
    public int deleteCustomer(int id) {
        return getSqlSessionTemplate().getMapper(CustomerMapper.class).deleteCustomer(id);
    }

}
