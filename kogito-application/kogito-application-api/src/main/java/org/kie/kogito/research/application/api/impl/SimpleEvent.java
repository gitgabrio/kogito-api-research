package org.kie.kogito.research.application.api.impl;

import org.kie.kogito.research.application.api.Event;
import org.kie.kogito.research.application.api.Id;

import java.io.Serializable;

public class SimpleEvent implements Event {

    private Id senderId;
    private Id targetId;
    private Serializable payload;

    protected SimpleEvent() {}

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

    @Override
    public Id getExecutorId() {
        return null;
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
