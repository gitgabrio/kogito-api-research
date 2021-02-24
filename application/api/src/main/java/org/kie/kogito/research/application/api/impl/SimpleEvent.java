package org.kie.kogito.research.application.api.impl;

import org.kie.kogito.research.application.api.Event;
import org.kie.kogito.research.application.api.Id;

import java.io.Serializable;

public class SimpleEvent implements Event {

    private final Id senderId;
    private final Id targetId;
    private final Serializable payload;

    public static SimpleEvent of(Id senderId, Id targetId, Serializable payload) {
        return new SimpleEvent(senderId, targetId, payload);
    }

    protected SimpleEvent(Id senderId, Id targetId, Serializable payload) {
        this.senderId = senderId;
        this.targetId = targetId;
        this.payload = payload;
    }

    @Override
    public Id senderId() {
        return senderId;
    }

    @Override
    public Id targetId() {
        return targetId;
    }

    public Serializable payload() {
        return payload;
    }

    @Override
    public String toString() {
        return "SimpleEvent{" +
                "senderId=" + senderId +
                ", targetId=" + targetId +
                ", payload=" + payload +
                '}';
    }
}
