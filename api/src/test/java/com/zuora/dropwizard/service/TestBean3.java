package com.zuora.dropwizard.service;

import com.zuora.dropwizard.service.api.Bean;
import com.zuora.dropwizard.service.api.Bean.Builder;
import com.zuora.dropwizard.service.api.Bean3;

public class TestBean3 extends AbstractTestBean
{

    @Override
    protected Builder<? extends Bean> getBuilder()
    {
        return Bean3.builder();
    }
}
