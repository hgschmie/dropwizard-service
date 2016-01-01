package com.zuora.dropwizard.service;

import com.zuora.dropwizard.service.api.Bean;
import com.zuora.dropwizard.service.api.Bean.Builder;
import com.zuora.dropwizard.service.api.Bean2;

public class TestBean2 extends AbstractTestBean
{

    @Override
    protected Builder<? extends Bean> getBuilder()
    {
        return Bean2.builder();
    }
}
