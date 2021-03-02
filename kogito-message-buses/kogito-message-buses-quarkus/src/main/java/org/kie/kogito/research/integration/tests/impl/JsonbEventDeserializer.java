package org.kie.kogito.research.integration.tests.impl;

import io.quarkus.kafka.client.serialization.JsonbDeserializer;
import org.kie.kogito.research.processes.core.impl.SimpleProcessEvent;

public class JsonbEventDeserializer extends JsonbDeserializer<SimpleProcessEvent> {
    public JsonbEventDeserializer(){
        // pass the class to the parent.
        super(SimpleProcessEvent.class);
    }
}
