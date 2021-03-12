package org.kie.kogito.research.integration.tests.server;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ProcessServerMain/* extends AbstractModelServer<AbstractProcessImpl, ProcessEvent> */{

    private static final Logger LOGGER = LoggerFactory.getLogger(ProcessServerMain.class);
/*
    public ProcessServerMain(MessageBus<ProcessEvent> messageBus, List<AbstractProcessImpl> modelExecutors) {
        super(messageBus, modelExecutors);
        LOGGER.info("ProcessServerMain constructor invoked with {} {}", messageBus, modelExecutors);
    }

    @Override
    protected void receive(AbstractProcessImpl modelExecutor, ProcessEvent toReceive) {
        LOGGER.info("receive {} {}", modelExecutor, toReceive);
        modelExecutor.receive(messageBus, toReceive);
    }

    @Override
    protected SimpleProcessEvent getNoExecutorReply(ProcessEvent event) {
        LOGGER.info("getNoExecutorReply {}", event);
        return new SimpleProcessEvent(event.senderId(), event.targetId(), "WARN!!!!! No Process executors registered!!!");
    }

    @Override
    protected SimpleProcessEvent getNoMatchingExecutorReply(ProcessEvent event) {
        LOGGER.info("getNoMatchingExecutorReply {}", event);
        return new SimpleProcessEvent(event.senderId(), event.targetId(), "No matching Process executor found");
    }*/
}
