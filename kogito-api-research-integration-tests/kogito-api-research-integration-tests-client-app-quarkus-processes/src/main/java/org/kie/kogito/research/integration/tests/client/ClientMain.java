package org.kie.kogito.research.integration.tests.client;


import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;

import javax.inject.Inject;
import java.util.Objects;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@QuarkusMain
public class ClientMain implements QuarkusApplication {

    @Inject
    ProcessSmallryeMessageBus messageBus;


    public int run(String... args) {
        try {
            nonBlockingApi();
            // blockingApi(); // uncomment your pick
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private void nonBlockingApi() throws InterruptedException, ExecutionException, TimeoutException {
//        // a test utility that wraps the bus to await responses
//        var messages = messageBus;
//
//
//        var processId = SimpleProcessId.fromString("ProcessImplId");
//
//        // create instance via message passing
//        var createInstanceMessage = ProcessCreateInstanceMessage.of(processId);
//        var createInstanceEvent = new SimpleProcessEvent(processId, processId, createInstanceMessage);
//        var instanceCreated =
//                messages.send(createInstanceEvent);
////                        .expect(ProcessInstanceCreatedMessage.class)
////                        .get(25, SECONDS);
//
//        assertEquals(createInstanceMessage.requestId(), instanceCreated.requestId());
//        assertEquals(processId, instanceCreated.modelId());
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
//        assertEquals(processId, instanceStarted.modelId());
//        assertEquals(processInstanceId, instanceStarted.processInstanceId());
//
//        var instanceCompleted =
//                messages.expect(ProcessMessages.InstanceCompleted.class).get();
//
//        assertEquals(processId, instanceCompleted.modelId());
//        assertEquals(processInstanceId, instanceCompleted.processInstanceId());
    }

    private void blockingApi() throws ExecutionException, InterruptedException, TimeoutException {
//        var api = new BlockingApi(messageBus);
//        var instance = api.createInstance(SimpleProcessId.fromString("my.process"));
//        instance.start();
//        instance.awaitTermination();
    }


    private void assertEquals(Object a, Object b) {
        if (!Objects.equals(a, b)) {
            throw new AssertionError("Not equal: " + a + " vs. " + b);
        }
    }

}
