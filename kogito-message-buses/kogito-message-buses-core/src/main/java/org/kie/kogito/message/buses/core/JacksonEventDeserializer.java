package org.kie.kogito.message.buses.core;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import org.apache.kafka.common.serialization.Deserializer;
import org.kie.kogito.research.application.api.Context;
import org.kie.kogito.research.application.api.events.Event;
import org.kie.kogito.research.application.api.ids.Id;
//import org.kie.kogito.research.processes.api.SimpleProcessContext;
//import org.kie.kogito.research.processes.api.messages.ProcessMessages;

import java.io.IOException;
import java.io.Serializable;
import java.io.UncheckedIOException;

public class JacksonEventDeserializer implements Deserializer<Event> {

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

    public JacksonEventDeserializer() {
    }

    @Override
    public Event deserialize(String s, byte[] bytes) {
        try {
            return mapper.readerFor(Event.class).readValue(bytes);
        } catch (IOException e) {
            throw new UncheckedIOException(e);
        } catch (RuntimeException e) {
            e.printStackTrace();
            throw e;
        }
    }
}
