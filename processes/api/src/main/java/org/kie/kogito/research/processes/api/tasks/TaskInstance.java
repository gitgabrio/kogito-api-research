package org.kie.kogito.research.processes.api.tasks;

import org.kie.kogito.research.application.api.Addressable;
import org.kie.kogito.research.application.api.Castable;
import org.kie.kogito.research.application.api.Evaluable;

public interface TaskInstance extends Castable<TaskInstance>, Addressable, Evaluable<TaskInstance> {

}
