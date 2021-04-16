package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.*;
import org.kie.kogito.research.application.core.AbstractUnitInstance;
import org.kie.kogito.research.application.core.UriUnitId;
import org.kie.kogito.research.processes.api.Task;
import org.kie.kogito.research.processes.api.TaskInstance;

import java.util.UUID;

public class HumanTaskInstance extends AbstractUnitInstance<Task> implements TaskInstance  {

    public HumanTaskInstance(Id parentId) {
        super(parentId, null, null);
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
    public void abort() {

    }

    @Override
    public <T extends Context> T update(T ctx) {
        return null;
    }


    @Override
    public void transition(Context ctx, String phase) {
        System.out.println("TRANSITION: "+id());

    }

    @Override
    public void abort(String phase) {
        System.out.println("ABORT: "+id());

    }

    public HumanTaskCommentContainer comments() {
        return new HumanTaskCommentContainer(id());
    }

    public HumanTaskAttachmentContainer attachments() {
        return new HumanTaskAttachmentContainer(id());
    }

}
