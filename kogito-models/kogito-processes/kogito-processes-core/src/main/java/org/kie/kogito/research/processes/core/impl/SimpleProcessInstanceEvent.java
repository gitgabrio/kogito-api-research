package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.ids.Id;
import org.kie.kogito.research.application.api.impl.SimpleEvent;
import org.kie.kogito.research.processes.api.ProcessInstanceEvent;
import org.kie.kogito.research.processes.api.ids.ProcessId;
import org.kie.kogito.research.processes.api.ids.ProcessInstanceId;
import org.kie.kogito.research.processes.api.ProcessInstanceMessage;

import java.io.Serializable;

public class SimpleProcessInstanceEvent extends SimpleEvent implements ProcessInstanceEvent {
    protected SimpleProcessInstanceEvent() {}
    public SimpleProcessInstanceEvent(Id senderId, Id targetId, Serializable payload) {
        super(senderId, targetId, payload);
    }

    @Override
    public ProcessInstanceMessage payload() {
        return (ProcessInstanceMessage) super.payload();
    }

    @Override
    public Id getExecutorId() {
        return payload().modelId();
    }

    @Override
    public ProcessId getModelId() {
        return null;
    }

    @Override
    public ProcessInstanceId getModelInstanceId() {
        return null;
    }


}
