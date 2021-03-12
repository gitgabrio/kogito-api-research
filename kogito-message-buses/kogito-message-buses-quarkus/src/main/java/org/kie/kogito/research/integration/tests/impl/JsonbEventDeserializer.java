package org.kie.kogito.research.integration.tests.impl;

import io.quarkus.kafka.client.serialization.JsonbDeserializer;
import org.kie.kogito.research.processes.core.impl.SimpleProcessInstanceEvent;

public class JsonbEventDeserializer extends JsonbDeserializer<SimpleProcessInstanceEvent> {
    public JsonbEventDeserializer(){
        // pass the class to the parent.
        super(SimpleProcessInstanceEvent.class);
    }
}
