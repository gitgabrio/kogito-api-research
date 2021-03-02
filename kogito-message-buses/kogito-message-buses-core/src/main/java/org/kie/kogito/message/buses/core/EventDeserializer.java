package org.kie.kogito.message.buses.core;

import org.apache.kafka.common.serialization.Deserializer;
import org.kie.kogito.research.application.api.Event;

import java.io.*;

public class EventDeserializer implements Deserializer<Event> {
    @Override
    public Event deserialize(String s, byte[] bytes) {
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        try (var ois = new ObjectInputStream(bis)) {
            return (Event) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
