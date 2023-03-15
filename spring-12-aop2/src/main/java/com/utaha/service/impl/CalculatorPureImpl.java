package com.utaha.service.impl;

import com.utaha.aop.AopInter;
import com.utaha.service.Calculator;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
@Slf4j
@Component
public class CalculatorPureImpl implements Calculator {
    
    @Override
    @AopInter(demo = "i think show")
    public int add(int i, int j) {
    
        int result = i + j;
    
        log.debug("方法内部 result = " + result);
    
        return result;
    }
    
    @Override
    public int sub(int i, int j) {
    
        int result = i - j;
    
        log.debug("方法内部 result = " + result);
    
        return result;
    }
    
    @Override
    public int mul(int i, int j) {
    
        int result = i * j;
    
        log.debug("方法内部 result = " + result);
    
        return result;
    }
    
    @Override
    public int div(int i, int j) {
    
        int result = i / j;
    
        log.debug("方法内部 result = " + result);
    
        return result;
    }
}