package edu.utexas.tacc.tapis.notifications.api.resources;

import edu.utexas.tacc.tapis.sharedapi.providers.ObjectMapperContextResolver;
import edu.utexas.tacc.tapis.sharedapi.providers.TapisExceptionMapper;
import edu.utexas.tacc.tapis.sharedapi.providers.ValidationExceptionMapper;
import org.glassfish.jersey.jackson.JacksonFeature;
import org.glassfish.jersey.media.multipart.MultiPartFeature;
import org.glassfish.jersey.server.ResourceConfig;

public class BaseResourceConfig extends ResourceConfig {

    public BaseResourceConfig() {
        super();
        // Need that for some reason for multipart forms/ uploads
        register(MultiPartFeature.class);
        // Serialization
        register(JacksonFeature.class);
        // Custom Timestamp/Instant serialization
        register(ObjectMapperContextResolver.class);
        // ExceptionMappers, need both because ValidationMapper is a custom Jersey thing and
        // can't be implemented in a generic mapper
        register(TapisExceptionMapper.class);
        register(ValidationExceptionMapper.class);

    }
}