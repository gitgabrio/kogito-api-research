package org.kie.kogito.research.processes.core.service.impl;

import org.kie.kogito.research.application.api.Context;
import org.kie.kogito.research.processes.core.impl.SignalEvent;

public class TaskInstanceDecorator {
    public void send(SignalEvent signalEvent) {

    }


    public <T extends Context> T context(Class<T> model) {
        return null;
    }


    public <T extends Context> T complete(T model) {
        return null;
    }

    public <T extends Context> T save(T model) {
        return null;
    }

    public <T extends Context> T transition(T model, String s) {
        return null;
    }
    public <T extends Context> T abort(String s) {
        return null;
    }
}
