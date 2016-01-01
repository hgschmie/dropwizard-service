package com.zuora.dropwizard.service;

import com.zuora.dropwizard.service.api.Bean;
import com.zuora.dropwizard.service.api.Bean.Builder;
import com.zuora.dropwizard.service.api.Bean1;

public class TestBean1 extends AbstractTestBean
{

    @Override
    protected Builder<? extends Bean> getBuilder()
    {
        return Bean1.builder();
    }
}
