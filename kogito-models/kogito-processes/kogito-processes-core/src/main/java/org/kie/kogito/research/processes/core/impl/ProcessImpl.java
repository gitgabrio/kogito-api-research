package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.*;
import org.kie.kogito.research.application.api.impl.AbstractUnit;
import org.kie.kogito.research.application.api.impl.LambdaMessageBus;
import org.kie.kogito.research.application.api.messages.RequestId;
import org.kie.kogito.research.processes.api.Process;
import org.kie.kogito.research.processes.api.ProcessContainer;
import org.kie.kogito.research.processes.api.ProcessEvent;
import org.kie.kogito.research.processes.api.ProcessId;
import org.kie.kogito.research.processes.api.ProcessInstance;
import org.kie.kogito.research.processes.api.messages.ProcessMessages;

import javax.enterprise.inject.Default;

@Default
public class ProcessImpl extends AbstractUnit<ProcessId, ProcessInstance> implements Process {
    private final MessageBus<ProcessEvent> messageBus;

    public ProcessImpl(ProcessContainer container, ProcessId id) {
        super(container, id);
        this.messageBus = new LambdaMessageBus<>(this::send);
    }

    public ProcessImpl(
            ProcessContainerImpl processContainer,
            SimpleProcessId id,
            MessageBus<? extends Event> messageBus) {
        super(processContainer, id);
        this.messageBus = (MessageBus<ProcessEvent>) messageBus;
        messageBus.subscribe(this::receive);
    }

    @Override
    public MessageBus<? extends Event> messageBus() {
        return this.messageBus;
    }

    protected void receive(Event event) {
        // internal handling logic
        if (event instanceof ProcessEvent) {
            ProcessEvent pEvent = (ProcessEvent) event;
            pEvent.payload().as(ProcessMessages.CreateInstance.class).ifPresent(e -> {
                if (this.id().equals(e.processId())) {
                    createInstance0(e.requestId(), event.senderId(), e.context());
                }
            });
        }
    }

    @Override
    public ProcessInstance createInstance(Context ctx) {
        return createInstance0(new SimpleRequestId(), id(), ctx);
    }

    protected ProcessInstance createInstance0(RequestId requestId, Id senderId, Context ctx) {
        var id = SimpleProcessInstanceId.create();
        return register(new ProcessInstanceImpl(requestId, senderId, id,this, ctx));
    }
}
