package org.kie.kogito.message.buses.core;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import org.apache.kafka.common.serialization.Serializer;
import org.kie.kogito.research.application.api.Context;
import org.kie.kogito.research.application.api.Event;
import org.kie.kogito.research.application.api.Id;

import java.io.Serializable;

public class JacksonEventSerializer implements Serializer<Event> {

    private static final ObjectMapper mapper;

    static {
        mapper = new ObjectMapper();
        PolymorphicTypeValidator ptv = BasicPolymorphicTypeValidator.builder()
                .allowIfBaseType(Serializable.class)
                .allowIfBaseType(Id.class)
                .allowIfBaseType(Event.class)
//                .allowIfBaseType(ProcessMessages.Message.class)
                .allowIfBaseType(Context.class)
                .build();
        mapper.activateDefaultTyping(ptv);

        mapper.registerSubtypes(Event.class);

        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
//        mapper.registerSubtypes(SimpleProcessContext.class);
//        mapper.registerSubtypes(ProcessMessages.Message.class);
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

    }

    @Override
    public byte[] serialize(String s, Event event) {
        try {
            return mapper.writerFor(Event.class).writeValueAsBytes(event);
        } catch (JsonProcessingException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
