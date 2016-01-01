package com.zuora.dropwizard.service;

import com.zuora.dropwizard.service.resources.UserResource;
import com.zuora.dropwizard.service.utils.ObjectMapperProvider;
import io.dropwizard.Application;
import io.dropwizard.jackson.Jackson;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ServiceMain extends Application<ServiceConfiguration>
{
    private static final Logger LOG = LoggerFactory.getLogger(ServiceMain.class);

    public static void main(String[] args) throws Exception
    {
        new ServiceMain().run(args);
    }

    @Override
    public String getName()
    {
        return "product-catalog";
    }

    @Override
    public void initialize(Bootstrap<ServiceConfiguration> bootstrap)
    {
        ObjectMapperProvider objectMapperProvider = new ObjectMapperProvider(Jackson.newObjectMapper());
        bootstrap.setObjectMapper(objectMapperProvider.get());
    }

    @Override
    public void run(ServiceConfiguration configuration,
        Environment environment)
    {

        environment.jersey().register(new UserResource());
        LOG.info("Startup complete");
    }
}
