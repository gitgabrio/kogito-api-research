package org.kie.kogito.research.processes.api;

import org.kie.kogito.research.application.api.Addressable;
import org.kie.kogito.research.application.api.AddressableContainer;
import org.kie.kogito.research.application.api.Evaluable;
import org.kie.kogito.research.application.api.Unit;
import org.kie.kogito.research.processes.api.tasks.TaskInstance;

public interface ProcessInstance extends Addressable, Unit, Evaluable<ProcessInstance> {

    AddressableContainer<TaskInstance> tasks();

}
