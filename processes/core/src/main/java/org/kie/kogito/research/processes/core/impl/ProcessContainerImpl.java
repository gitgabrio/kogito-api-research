package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.*;
import org.kie.kogito.research.application.api.impl.AbstractUnitContainer;
import org.kie.kogito.research.application.api.impl.LambdaMessageBus;
import org.kie.kogito.research.application.api.impl.SimpleId;
import org.kie.kogito.research.processes.api.Process;
import org.kie.kogito.research.processes.api.ProcessContainer;
import org.kie.kogito.research.processes.api.ProcessEvent;
import org.kie.kogito.research.processes.api.ProcessId;
import org.kie.kogito.research.processes.api.messages.ProcessMessages;

import java.util.Collection;

public class ProcessContainerImpl extends AbstractUnitContainer<Process> implements ProcessContainer {
    private final MessageBus<ProcessEvent> messageBus;
    private Id id = new SimpleId();

    public ProcessContainerImpl(Application application, MessageBus<? extends Event> messageBus) {
        super(application);
        this.messageBus = (MessageBus<ProcessEvent>) messageBus;
        this.messageBus.subscribe(this::receive);
    }

    public ProcessContainerImpl(Application application) {
        super(application);
        this.messageBus = new LambdaMessageBus<>(this::send);
    }

    public void register(Collection<? extends Process> processes) {
        for (Process p : processes) {
            super.register(p);
        }
    }

    @Override
    public Process get(UnitId unitId) {
        if (! (unitId instanceof ProcessId)) {
            return null;
        }
        return super.get(unitId);
    }

    private void receive(ProcessEvent event) {
        event.payload().as(ProcessMessages.CreateInstance.class).ifPresent(createInstance -> {
            Process process = get(createInstance.processId());
            if (process == null) {
                messageBus.send(new SimpleProcessEvent(this.id, event.senderId(),
                        ProcessMessages.NoSuchProcess.of(createInstance.requestId(), createInstance.processId())));
            }
        });
    }
}
