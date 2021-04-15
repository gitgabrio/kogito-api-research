package org.kie.kogito.research.processes.api;

import org.kie.kogito.research.application.api.Context;
import org.kie.kogito.research.application.api.Event;
import org.kie.kogito.research.application.api.UnitInstance;

public interface TaskInstance extends UnitInstance {
    Task unit();

    void save(Context ctx, Policies user);

    void complete(Context ctx, Policies policies);

    void send(Event event);

    void transition(Context ctx, String phase, Policies policies);

    void abort(String phase, Policies policy);

    <T extends TaskInstance> T as(Class<T> cls);
}
