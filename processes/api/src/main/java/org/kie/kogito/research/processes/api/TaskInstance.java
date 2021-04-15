package org.kie.kogito.research.processes.api;

import org.kie.kogito.research.application.api.Context;
import org.kie.kogito.research.application.api.Event;
import org.kie.kogito.research.application.api.UnitInstance;

public interface TaskInstance extends UnitInstance {
    Task unit();

    void save(Context ctx);

    void complete(Context ctx);

    void send(Event event);

    void transition(Context ctx, String phase);

    void abort(String phase);

    <T extends TaskInstance> T as(Class<T> cls);
}
