package org.kie.kogito.research.integration.tests.impl;

import org.apache.kafka.common.serialization.Serializer;
import org.kie.kogito.research.application.api.Event;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class EventSerializer implements Serializer<Event> {
    @Override
    public byte[] serialize(String s, Event event) {
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        try (ObjectOutputStream oos = new ObjectOutputStream(bos)) {
            oos.writeObject(event);
            oos.flush();
            return bos.toByteArray();
        } catch (IOException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
