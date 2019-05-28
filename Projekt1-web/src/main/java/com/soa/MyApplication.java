package com.soa;


import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.HashSet;
import java.util.Set;

@ApplicationPath("/")
public class MyApplication extends Application {
    @Override
    public Set<Class<?>> getClasses() {
        HashSet h = new HashSet<Class<?>>();
        h.add(Test.class);
        h.add(UserEndpoint.class);
        h.add(JWTTokenNeededFilter.class);
        h.add(SimpleKeyGenerator.class);
        return h;
    }

}
