package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Application;
import org.kie.kogito.research.application.api.ids.Id;
import org.kie.kogito.research.application.api.ids.SimpleId;
import org.kie.kogito.research.application.api.impl.AbstractModelContainer;
import org.kie.kogito.research.processes.api.Process;
import org.kie.kogito.research.processes.api.*;
import org.kie.kogito.research.processes.api.ids.ProcessId;

import java.util.Collection;

public class ProcessContainerImpl extends AbstractModelContainer<ProcessId, ProcessMessage, ProcessEvent, Process> implements ProcessContainer {

    private ProcessMessageBus messageBus;
    private Id id = new SimpleId();

    public ProcessContainerImpl(ProcessApplication application, ProcessMessageBus messageBus) {
        super(application);
        this.messageBus = messageBus;
        this.messageBus.subscribe(this::receive);
    }

    public ProcessContainerImpl(ProcessApplication application) {
        super(application);
//        this.messageBus = new LambdaMessageBus<>(this::send);
    }

    public void register(Collection<? extends Process> processes) {
        for (Process p : processes) {
            super.register(p);
        }
    }

    private void receive(ProcessEvent event) {
//        event.payload().as(ProcessCreateInstanceMessage.class).ifPresent(createInstance -> {
//            Process process = get(createInstance.modelId());
//            if (process == null) {
//                messageBus.send(new SimpleProcessInstanceEvent(this.id, event.senderId(),
//                        new ProcessNoSuchMessage(createInstance.requestId(), createInstance.modelId())));
//            }
//        });
    }

}
