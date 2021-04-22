package org.kie.kogito.research.processes.core.services.impl;

import org.kie.kogito.research.application.api.Context;
import org.kie.kogito.research.processes.api.tasks.TaskInstance;
import org.kie.kogito.research.processes.core.impl.SignalEvent;

public class TaskInstanceDecorator {
    private final TaskServiceImpl taskService;
    private final TaskInstance task;

    public TaskInstanceDecorator(TaskServiceImpl taskService, TaskInstance task) {
        this.taskService = taskService;
        this.task = task;
    }

    public void send(SignalEvent signalEvent) {
        taskService.send(task, signalEvent);
    }

    public <T extends Context> T context(Class<T> model) {
        return taskService.context(task, model);
    }

    public <T extends Context> T complete(T model) {
        return taskService.complete(task, model);
    }

    public <T extends Context> T save(T model) {
        return taskService.save(task, model);
    }

    public <T extends Context> T transition(T model, String s) {
        return taskService.transition(task, model, s);
    }

    public <T extends Context> T abort(String s) {
        return taskService.abort(task, s);
    }
}
