package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Context;
import org.kie.kogito.research.application.api.Event;
import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.api.UnitInstanceId;
import org.kie.kogito.research.application.core.UriUnitId;
import org.kie.kogito.research.processes.api.Task;
import org.kie.kogito.research.processes.api.TaskInstance;

import java.util.UUID;

public class HumanTaskInstance implements TaskInstance {
    private final UriUnitId id;

    public HumanTaskInstance(Id parentId) {
        this.id = new UriUnitId(parentId, UUID.randomUUID().toString());
    }

    @Override
    public UnitInstanceId id() {
        return id;
    }

    @Override
    public Task unit() {
        return null;
    }

    @Override
    public void save(Context ctx) {
        System.out.println("SAVE: "+id());
    }

    @Override
    public void complete(Context ctx) {
        System.out.println("COMPLETE: "+id());

    }

    @Override
    public <T extends Context> T context(Class<T> cls) {
        return null;
    }

    @Override
    public void send(Event event) {
        System.out.printf("SEND: %s --> %s\n", id(), event);

    }

    @Override
    public void start() {
        System.out.printf("START: %s\n", id());

    }

    @Override
    public void complete() {
        System.out.printf("COMPLETE: %s\n", id());

    }




    @Override
    public void transition(Context ctx, String phase) {
        System.out.println("TRANSITION: "+id());

    }

    @Override
    public void abort(String phase) {
        System.out.println("ABORT: "+id());

    }

    @Override
    public <T extends TaskInstance> T as(Class<T> cls) {
        return cls.cast(this);
    }

    public HumanTaskCommentContainer comments() {
        return new HumanTaskCommentContainer(id());
    }

    public HumanTaskAttachmentContainer attachments() {
        return new HumanTaskAttachmentContainer(id());
    }

}
