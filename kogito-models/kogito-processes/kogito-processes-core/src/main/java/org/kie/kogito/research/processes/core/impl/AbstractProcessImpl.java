package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.processes.api.ProcessEvent;
import org.kie.kogito.research.processes.api.ProcessMessageBus;
import org.kie.kogito.research.processes.api.ids.ProcessId;
import org.kie.kogito.research.processes.api.ids.ProcessInstanceId;
import org.kie.logito.models.api.ModelExecutor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractProcessImpl implements ModelExecutor<ProcessId> {

    private static final Logger LOGGER = LoggerFactory.getLogger(AbstractProcessImpl.class);

    private final AbstractProcessInstanceFactory processInstanceFactory;
    private final ProcessId processId;
    private final Map<ProcessInstanceId, AbstractProcessInstanceImpl> processInstancesMap = new HashMap<>();

    protected AbstractProcessImpl(String processId, AbstractProcessInstanceFactory processInstanceFactory) {
        this.processInstanceFactory = processInstanceFactory;
        this.processId = SimpleProcessId.fromString(processId);
    }

    @Override
    public ProcessId getId() {
        return processId;
    }


    protected void receive(ProcessMessageBus messageBus, ProcessEvent pEvent) {
        LOGGER.info("receive {} {}", messageBus, pEvent);
        // internal handling logic
        messageBus.subscribe(this::handleConversation);
//        pEvent.payload().as(ProcessCreateInstanceMessage.class)
//                .ifPresent(e -> {
//                    LOGGER.info("receiving ProcessMessages.CreateInstance");
//                    LOGGER.info("Creating AbstractProcessInstanceImpl");
//                    AbstractProcessInstanceImpl processInstanceImpl = processInstanceFactory.getProcessInstanceImpl(messageBus);
//                    processInstancesMap.put(processInstanceImpl.getInstanceId(), processInstanceImpl);
//                    LOGGER.info("AbstractProcessInstanceImpl created {}", processInstanceImpl);
//                    LOGGER.info("send ProcessMessages.InstanceCreated");
//                    messageBus.send(new SimpleProcessEvent(this.getId(), pEvent.senderId(),
//                            ProcessInstanceCreatedMessage.of(e.requestId(), getId(), processInstanceImpl.getInstanceId())));
//                     });
    }

    protected void handleConversation(ProcessEvent pEvent) {
        LOGGER.info("handleConversation {}", pEvent);
        pEvent.payload().as(CompleteProcessInstance.class)
                .filter(e -> processInstancesMap.containsKey(e.modelInstanceId()))
                .ifPresent(e -> {
                    LOGGER.info("processMessages.InstanceCompleted {}", e.modelInstanceId());
                    AbstractProcessInstanceImpl processInstanceImpl = processInstancesMap.remove(e.modelInstanceId());
                    LOGGER.info("Deleting {}", processInstanceImpl);
                    processInstanceImpl = null;
                });
    }


}
