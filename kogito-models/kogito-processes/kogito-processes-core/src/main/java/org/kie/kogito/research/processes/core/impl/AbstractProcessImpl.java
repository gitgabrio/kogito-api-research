package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.MessageBus;
import org.kie.kogito.research.application.api.SimpleRequestId;
import org.kie.kogito.research.processes.api.ProcessEvent;
import org.kie.kogito.research.processes.api.ProcessId;
import org.kie.kogito.research.processes.api.ProcessInstanceId;
import org.kie.kogito.research.processes.api.messages.ProcessMessages;
import org.kie.logito.models.api.ModelExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractProcessImpl implements ModelExecutor<ProcessId, ProcessInstanceId> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractProcessImpl.class);

    @Override
    public ProcessId getId() {
        return null;
    }

    @Override
    public ProcessInstanceId getInstanceId() {
        return null;
    }

    protected void receive(MessageBus<ProcessEvent> messageBus, ProcessEvent pEvent) {
        LOGGER.info("receive {} {}", messageBus, pEvent);
        // internal handling logic
        messageBus.subscribe(this::handleConversation);
        pEvent.payload().as(ProcessMessages.CreateInstance.class)
                .ifPresent(e -> {
                    LOGGER.info("receiving ProcessMessages.CreateInstance");
                    LOGGER.info("send ProcessMessages.InstanceCreated");
                    messageBus.send(new SimpleProcessEvent(this.getId(), pEvent.senderId(),
                            ProcessMessages.InstanceCreated.of(e.requestId(), getId(), getInstanceId())));
                     });
        pEvent.payload().as(ProcessMessages.StartInstance.class)
                .ifPresent(e -> {
                    LOGGER.info("receiving ProcessMessages.StartInstance");
                    LOGGER.info("send ProcessMessages.InstanceStarted");
                    messageBus.send(new SimpleProcessEvent(this.getId(), pEvent.senderId(),
                            ProcessMessages.InstanceStarted.of(e.requestId(), getId(), getInstanceId())));
                    LOGGER.info("send InternalProcessMessages.CompleteProcessInstance");
                    messageBus.send(new SimpleProcessEvent(this.getId(), this.getId(),
                            InternalProcessMessages.CompleteProcessInstance.of(new SimpleRequestId(), getId(), getInstanceId())));
                });
        pEvent.payload().as(InternalProcessMessages.CompleteProcessInstance.class)
                .filter(e -> e.processInstanceId().equals(this.getId()))
                .ifPresent(e -> {
                    LOGGER.info("receiving InternalProcessMessages.CompleteProcessInstance");
                    LOGGER.info("send ProcessMessages.InstanceCompleted");
                    messageBus.send(new SimpleProcessEvent(this.getId(), pEvent.senderId(),
                            ProcessMessages.InstanceCompleted.of(new SimpleRequestId(), getId(), getInstanceId())));
                    LOGGER.info("unSubscribe");
                    messageBus.unSubscribe(this::handleConversation);

                });

    }

    protected void handleConversation(ProcessEvent toHandle) {
        // TODO
        LOGGER.info("handleConversation {}", toHandle);

    }


}
