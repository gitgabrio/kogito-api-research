package org.kie.kogito.research.processes.core.service.impl;

import org.kie.kogito.research.application.api.Context;
import org.kie.kogito.research.processes.api.Task;
import org.kie.kogito.research.processes.api.TaskInstance;
import org.kie.kogito.research.processes.core.impl.SignalEvent;

public class TaskServiceImpl {
    public void send(TaskInstance task, SignalEvent signalEvent) {

    }

    public <T extends Context> T context(TaskInstance task, Class<T> model) {
        return null;
    }

    public <T extends Context> T complete(TaskInstance task, T model) {
        return null;
    }

    public <T extends Context> T save(TaskInstance task, T model) {
        return null;
    }

    public <T extends Context> T transition(TaskInstance task, T model, String s) {
        return null;
    }

    public <T extends Context> T abort(TaskInstance task, String s) {
        return null;
    }
}
