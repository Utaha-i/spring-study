package com.utaha.mapper.impl;

import com.utaha.mapper.CustomerMapper;
import com.utaha.pojo.Customer;
import org.mybatis.spring.SqlSessionTemplate;

import java.util.List;

public class CustomerMapperImpl implements CustomerMapper {

    //我们原理操作都使用sqlSession来执行，在现在都使用sqlSessionTemplate
    private SqlSessionTemplate sqlSessionTemplate;

    public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
        this.sqlSessionTemplate = sqlSessionTemplate;
    }

    @Override
    public List<Customer> selectCustomer() {
        CustomerMapper mapper = sqlSessionTemplate.getMapper(CustomerMapper.class);
        return mapper.selectCustomer();
    }
}
