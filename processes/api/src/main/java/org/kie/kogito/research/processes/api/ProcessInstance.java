package org.kie.kogito.research.processes.api;

import org.kie.kogito.research.application.api.Addressable;
import org.kie.kogito.research.application.api.AddressableContainer;

public interface ProcessInstance extends Addressable {

    AddressableContainer<TaskInstance> tasks();

}
