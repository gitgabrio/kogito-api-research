package org.kie.kogito.research.integration.tests.impl;

import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.kie.kogito.research.processes.api.messages.ProcessMessages;
import org.kie.kogito.research.processes.core.impl.AssertBus;
import org.kie.kogito.research.processes.core.impl.ProcessImpl;
import org.kie.kogito.research.processes.core.impl.SimpleProcessId;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.utility.DockerImageName;

import javax.inject.Inject;
import java.util.concurrent.ExecutionException;

import static org.junit.jupiter.api.Assertions.assertEquals;

@QuarkusTest
@QuarkusTestResource(KafkaResource.class)
public class ProcessMessagingAPITest {

    @Inject SmallryeProcessorMessageBus messageBus;

    @Test
    public void createInstance() throws InterruptedException, ExecutionException {

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