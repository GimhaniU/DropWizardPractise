package com.gimhani;

import com.gimhani.health.TemplateHealthCheck;
import com.gimhani.resources.HelloWorldResource;
import com.gimhani.resources.ProductInfoResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;

public class SimpleProjectApplication extends Application<SimpleProjectConfiguration> {

    public static void main(final String[] args) throws Exception {
        new SimpleProjectApplication().run(args);
    }

    @Override
    public String getName() {
        return "SimpleProject";
    }

    @Override
    public void initialize(final Bootstrap<SimpleProjectConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final SimpleProjectConfiguration configuration,
                    final Environment environment) {
        final HelloWorldResource resource = new HelloWorldResource(
                configuration.getTemplate(),
                configuration.getDefaultName()
        );
        environment.jersey().register(resource);

        final ProductInfoResource presource = new ProductInfoResource(
                configuration.getProductId(),
                configuration.getProductName(),
                configuration.getTags(),
                configuration.getLocation(),
                configuration.getMax_price()
        );
        environment.jersey().register(presource);

        final TemplateHealthCheck healthCheck =
                new TemplateHealthCheck(configuration.getTemplate());
        environment.healthChecks().register("template", healthCheck);


    }

}
