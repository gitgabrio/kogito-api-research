package org.kie.kogito.research.integration.tests.impl;

import io.smallrye.reactive.messaging.connectors.InMemoryConnector;
import io.smallrye.reactive.messaging.connectors.InMemorySink;
import io.smallrye.reactive.messaging.connectors.InMemorySource;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.kie.kogito.research.processes.api.messages.ProcessMessages;
import org.kie.kogito.research.processes.core.impl.AssertBus;
import org.kie.kogito.research.processes.core.impl.ProcessImpl;
import org.kie.kogito.research.processes.core.impl.SimpleProcessId;

import javax.enterprise.inject.se.SeContainerInitializer;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProcessMessagingAPITest {


//    @BeforeAll
//    public static void switchMyChannels() {
//        InMemoryConnector.switchIncomingChannelsToInMemory("source");
//        InMemoryConnector.switchOutgoingChannelsToInMemory("sink");
//    }
//
//    // 2. Don't forget to reset the channel after the tests:
//    @AfterAll
//    public static void revertMyChannels() {
//        InMemoryConnector.clear();
//    }



//    @Test
    public void createInstance0() throws InterruptedException, ExecutionException {
        var container = SeContainerInitializer.newInstance()
                .initialize();
        InMemoryConnector connector = container.select(InMemoryConnector.class).get();
        // 4. Retrieves the in-memory source to send message
        InMemorySource<Integer> source = connector.source("source");
        // 5. Retrieves the in-memory sink to check what is received
        InMemorySink<Integer> sink = connector.sink("sink");

        // 6. Send fake messages:
        source.send(1);
        source.send(2);
        source.send(3);

        // 7. Check you have receives the expected messages
        assertEquals(3, sink.received().size());

    }

    @Test
    public void createInstance() throws InterruptedException, ExecutionException {
        System.out.println("TEST");
        var container = SeContainerInitializer.newInstance()
                .initialize();
        // set up the system (internal APIs)
        SmallryeProcessorMessageBus messageBus = container.select(SmallryeProcessorMessageBus.class).get();

//        var messageBus = new BroadcastProcessorMessageBus();
        // a test utility that wraps the bus to await responses
        var messages = new AssertBus(messageBus);


        var processId = SimpleProcessId.fromString("my.process");
        var process = new ProcessImpl(null, processId, messageBus);

        // end of internal API


        // create instance via message passing
        var createInstance = ProcessMessages.CreateInstance.of(processId);
        var instanceCreated =
                messages.send(createInstance)
                        .expect(ProcessMessages.InstanceCreated.class)
                        .get();

        assertEquals(createInstance.requestId(), instanceCreated.requestId());
        assertEquals(processId, instanceCreated.processId());

        var processInstanceId = instanceCreated.processInstanceId();

        // start instance
        var startInstance =
                ProcessMessages.StartInstance.of(processId, processInstanceId);
        var instanceStarted =
                messages.send(startInstance)
                        .expect(ProcessMessages.InstanceStarted.class).get();

        assertEquals(startInstance.requestId(), instanceStarted.requestId());
        assertEquals(processId, instanceStarted.processId());
        assertEquals(processInstanceId, instanceStarted.processInstanceId());

        var instanceCompleted =
                messages.expect(ProcessMessages.InstanceCompleted.class).get();

        assertEquals(processId, instanceCompleted.processId());
        assertEquals(processInstanceId, instanceCompleted.processInstanceId());
    }


}