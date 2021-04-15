package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Context;
import org.kie.kogito.research.application.api.Event;
import org.kie.kogito.research.application.api.Unit;
import org.kie.kogito.research.application.api.UnitInstanceId;
import org.kie.kogito.research.processes.api.Policies;
import org.kie.kogito.research.processes.api.TaskInstance;

public class HumanTaskInstance implements TaskInstance {
    @Override
    public UnitInstanceId id() {
        return null;
    }

    @Override
    public Unit unit() {
        return null;
    }

    @Override
    public <T extends Context> T context(Class<T> cls) {
        return null;
    }

    @Override
    public void start() {

    }

    @Override
    public void complete() {

    }

    @Override
    public void save(Context ctx, Policies user) {

    }

    @Override
    public void complete(Context ctx, Policies policies) {

    }

    @Override
    public void send(Event event) {

    }

    @Override
    public void transition(Context ctx, String phase, Policies policies) {

    }

    @Override
    public void abort(String phase, Policies policy) {

    }

    @Override
    public <T extends TaskInstance> T as(Class<T> cls) {
        return cls.cast(this);
    }

    public HumanTaskCommentContainer comments() {
        return new HumanTaskCommentContainer();
    }

    public HumanTaskAttachmentContainer attachments() {
        return new HumanTaskAttachmentContainer();
    }

}
