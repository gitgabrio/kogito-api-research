package org.kie.kogito.research.processes.core.impl;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.kie.kogito.research.application.core.impl.BroadcastProcessorMessageBus;
import org.kie.kogito.research.processes.api.messages.ProcessMessages;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

import static java.util.Arrays.asList;
import static org.junit.jupiter.api.Assertions.assertEquals;

class ProcessMessagingAPITest {

    @Test
    public void createInstance() throws InterruptedException, ExecutionException {
//        // set up the system (internal APIs)
//        var messageBus = new BroadcastProcessorMessageBus();
//        // a test utility that wraps the bus to await responses
//        var messages = new AssertBus(messageBus);
//
//        var processId = SimpleProcessId.fromString("my.process");
//        var process = new ProcessImpl(/*null, processId, messageBus*/);
//
//        // end of internal API
//
//
//        // create instance via message passing
//        var createInstance = ProcessMessages.CreateInstance.of(processId);
//        var instanceCreated =
//                messages.send(createInstance)
//                        .expect(ProcessMessages.InstanceCreated.class)
//                        .get();
//
//        assertEquals(createInstance.requestId(), instanceCreated.requestId());
//        assertEquals(processId, instanceCreated.processId());
//
//        var processInstanceId = instanceCreated.processInstanceId();
//
//        // start instance
//        var startInstance =
//                ProcessMessages.StartInstance.of(processId, processInstanceId);
//        var instanceStarted =
//                messages.send(startInstance)
//                        .expect(ProcessMessages.InstanceStarted.class).get();
//
//        assertEquals(startInstance.requestId(), instanceStarted.requestId());
//        assertEquals(processId, instanceStarted.processId());
//        assertEquals(processInstanceId, instanceStarted.processInstanceId());
//
//        var instanceCompleted =
//                messages.expect(ProcessMessages.InstanceCompleted.class).get();
//
//        assertEquals(processId, instanceCompleted.processId());
//        assertEquals(processInstanceId, instanceCompleted.processInstanceId());
    }

    @Test
    public void blockingCreateInstance() throws ExecutionException, InterruptedException, TimeoutException {
//        // set up the system (internal APIs)
//        var messageBus = new BroadcastProcessorMessageBus();
//        // a test utility that wraps the bus to await responses
//        var api = new BlockingApi(messageBus);
//        var processId = SimpleProcessId.fromString("my.process");
//        var pctr = new ProcessContainerImpl(null, messageBus);
//        var process = new ProcessImpl(/*pctr, processId, messageBus*/);
//        pctr.register(asList(process));
//
//        // end of internal API
//        var instance = api.createInstance(processId);
//        instance.start();
//        instance.awaitTermination();
//
//        Assertions.assertThrows(NoSuchProcessIdException.class,
//                () -> api.createInstance(SimpleProcessId.fromString("no-such-process")));

    }

}