package com.utaha.mapper.impl;

import com.utaha.mapper.CustomerMapper;
import com.utaha.pojo.Customer;
import org.mybatis.spring.support.SqlSessionDaoSupport;

import java.util.List;

public class CustomerMapperImpl2 extends SqlSessionDaoSupport implements CustomerMapper {

    @Override
    public List<Customer> selectCustomer() {
        return getSqlSessionTemplate().getMapper(CustomerMapper.class).selectCustomer();
    }
}
