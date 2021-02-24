package org.kie.kogito.research.integration.tests.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.quarkus.jackson.ObjectMapperCustomizer;
import org.kie.kogito.research.processes.core.impl.SimpleProcessEvent;

import javax.inject.Singleton;

@Singleton
public class RegisterCustomModuleCustomizer implements ObjectMapperCustomizer {

    public void customize(ObjectMapper mapper) {
        mapper.registerSubtypes(SimpleProcessEvent.class);
    }
}
