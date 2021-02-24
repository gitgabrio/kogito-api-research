package org.kie.kogito.research.integration.tests.impl;

import io.quarkus.kafka.client.serialization.ObjectMapperDeserializer;
import org.kie.kogito.research.application.api.Event;
import org.kie.kogito.research.processes.core.impl.SimpleProcessEvent;

public class JacksonEventDeserializer extends ObjectMapperDeserializer<SimpleProcessEvent> {
    public JacksonEventDeserializer(){
        // pass the class to the parent.
        super(SimpleProcessEvent.class);
    }
}
