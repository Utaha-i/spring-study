package com.utaha.demo05.impl;

import com.utaha.demo05.Calculator;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CalculatorPureImpl implements Calculator {

    @Override
    public int add(int i, int j) {

        int result = i + j;

        log.info("方法内部 result = " + result);

        return result;
    }

    @Override
    public int sub(int i, int j) {

        int result = i - j;

        log.info("方法内部 result = " + result);

        return result;
    }

    @Override
    public int mul(int i, int j) {

        int result = i * j;

        log.info("方法内部 result = " + result);

        return result;
    }

    @Override
    public int div(int i, int j) {

        int result = i / j;

        log.info("方法内部 result = " + result);

        return result;
    }
}
