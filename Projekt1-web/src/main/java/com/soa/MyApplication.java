package com.soa;


import com.soa.ProtoBuffers.StudentProtocMessageBodyProvider;
import io.swagger.jaxrs.config.BeanConfig;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;


@ApplicationPath("/api")
public class MyApplication extends Application {
    public MyApplication() {
        init();
    }
    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(StudentEndpoint.class);
        h.add(UserEndpoint.class);
        h.add(JWTTokenNeededFilter.class);
        h.add(SimpleKeyGenerator.class);
        h.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        h.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
        h.add(StudentProtocMessageBodyProvider.class);
        return h;
    }


    private void init() {
        BeanConfig beanConfig = new BeanConfig();
        beanConfig.setVersion("1.0.0");
        beanConfig.setSchemes(new String[]{"http"});
        beanConfig.setHost("localhost:8080");
        beanConfig.setBasePath("/Projekt1-web/api");

        beanConfig.setResourcePackage(UserEndpoint.class.getPackage().getName());
        beanConfig.setTitle("Example swagger documentation");
        beanConfig.setDescription("Sample RESTful API built using RESTEasy, Swagger and Swagger UI");
        beanConfig.setScan(true);
    }

}
