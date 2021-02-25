package org.kie.kogito.research.integration.tests.impl;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import io.quarkus.jackson.ObjectMapperCustomizer;
import org.kie.kogito.research.application.api.Event;
import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.processes.api.SimpleProcessContext;
import org.kie.kogito.research.processes.core.impl.SimpleProcessEvent;

import javax.inject.Singleton;

@Singleton
public class RegisterCustomModuleCustomizer implements ObjectMapperCustomizer {

    public void customize(ObjectMapper mapper) {
        PolymorphicTypeValidator ptv = BasicPolymorphicTypeValidator.builder()
                .allowIfBaseType(Id.class)
                .allowIfBaseType(Event.class)
                .build();
        mapper.activateDefaultTyping(ptv);

        mapper.registerSubtypes(Event.class);

        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        mapper.registerSubtypes(SimpleProcessContext.class);
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
    }
}
