package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Context;
import org.kie.kogito.research.application.api.Event;
import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.core.AbstractUnitInstance;
import org.kie.kogito.research.processes.api.HumanTaskAttachmentContainer;
import org.kie.kogito.research.processes.api.HumanTaskCommentContainer;
import org.kie.kogito.research.processes.api.Task;
import org.kie.kogito.research.processes.api.TaskInstance;

public class HumanTaskInstance extends AbstractUnitInstance<Task> implements TaskInstance {

    public HumanTaskInstance(Id parentId) {
        super(parentId);
        register(HumanTaskCommentContainer.class, new HumanTaskCommentContainerImpl(id()));
        register(HumanTaskAttachmentContainer.class, new HumanTaskAttachmentContainerImpl(id()));
    }

    @Override
    public void save(Context ctx) {
        System.out.println("SAVE: " + id());
    }

    @Override
    public void complete(Context ctx) {
        System.out.println("COMPLETE: " + id());

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
    public void transition(Context ctx, String phase) {
        System.out.println("TRANSITION: " + id());

    }

    @Override
    public void abort(String phase) {
        System.out.println("ABORT: " + id());

    }

    public HumanTaskCommentContainer comments() {
        return get(HumanTaskCommentContainer.class);
    }

    public HumanTaskAttachmentContainer attachments() {
        return get(HumanTaskAttachmentContainer.class);
    }

}
