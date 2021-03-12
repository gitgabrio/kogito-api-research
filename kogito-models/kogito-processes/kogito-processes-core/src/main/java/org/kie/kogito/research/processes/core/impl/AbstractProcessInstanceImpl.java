package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.processes.api.ProcessInstanceEvent;
import org.kie.kogito.research.processes.api.ProcessInstanceMessageBus;
import org.kie.kogito.research.processes.api.ids.ProcessId;
import org.kie.kogito.research.processes.api.ids.ProcessInstanceId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public abstract class AbstractProcessInstanceImpl {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractProcessInstanceImpl.class);
    
    private final ProcessInstanceMessageBus messageBus;
    private final ProcessId processId;


    protected AbstractProcessInstanceImpl(ProcessInstanceMessageBus messageBus, ProcessId processId) {
        this.messageBus = messageBus;
        this.processId = processId;
        this.messageBus.subscribe(this::handleConversation);
    }

    public abstract ProcessInstanceId getInstanceId();

    protected void handleConversation(ProcessInstanceEvent pEvent) {
        LOGGER.info("handleConversation {}", pEvent);
        // internal handling logic
//        pEvent.payload().as(InstanceStartMessage.class)
//                .ifPresent(e -> {
//                    LOGGER.info("receiving ProcessMessages.StartInstance");
//                    LOGGER.info("send ProcessMessages.InstanceStarted");
//                    messageBus.send(new SimpleProcessInstanceEvent(processId, pEvent.senderId(),
//                            ProcessInstanceStartedMessage.of(((InstanceStartMessage)e).requestId(), processId, getInstanceId())));
//                    LOGGER.info("send InternalProcessMessages.CompleteProcessInstance");
//                    messageBus.send(new SimpleProcessInstanceEvent(processId, processId,
//                            CompleteProcessInstance.of(new SimpleRequestId(), processId, getInstanceId())));
//                });
//        pEvent.payload().as(CompleteProcessInstance.class)
//                .filter(e -> e.modelInstanceId().equals(getInstanceId()))
//                .ifPresent(e -> {
//                    LOGGER.info("receiving InternalProcessMessages.CompleteProcessInstance");
//                    LOGGER.info("send ProcessMessages.InstanceCompleted");
//                    messageBus.send(new SimpleProcessInstanceEvent(processId, pEvent.senderId(),
//                            ProcessInstanceCompletedMessage.of(new SimpleRequestId(), processId, getInstanceId())));
//                    LOGGER.info("unSubscribe");
//                    messageBus.unSubscribe(this::handleConversation);
//                });
    }

}
