package org.kie.kogito.research.processes.api;

import org.kie.kogito.research.application.api.Context;
import org.kie.kogito.research.application.api.Event;
import org.kie.kogito.research.application.api.Instance;

public interface TaskInstance extends Instance<Task> {

    void save(Context ctx);

    void complete(Context ctx);

    void send(Event event);

    void transition(Context ctx, String phase);

    void abort(String phase);

}
