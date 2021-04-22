package org.kie.kogito.research.processes.api;

import org.kie.kogito.research.application.api.Addressable;
import org.kie.kogito.research.application.api.AddressableContainer;
import org.kie.kogito.research.application.api.Evaluable;

public interface ProcessInstance extends Addressable, Evaluable<ProcessInstance> {

    AddressableContainer<TaskInstance> tasks();

}
