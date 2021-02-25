package org.kie.kogito.research.integration.tests.client;


import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.kie.kogito.research.integration.tests.impl.SmallryeProcessorMessageBus;
import org.kie.kogito.research.processes.api.messages.ProcessMessages;
import org.kie.kogito.research.processes.core.impl.AssertBus;
import org.kie.kogito.research.processes.core.impl.ProcessImpl;
import org.kie.kogito.research.processes.core.impl.SimpleProcessId;

import javax.inject.Inject;
import java.util.Objects;

import static java.util.concurrent.TimeUnit.SECONDS;

@QuarkusMain
public class ClientMain implements QuarkusApplication {

    @Inject
    SmallryeProcessorMessageBus messageBus;


    public int run(String... args) {
        try {

            // a test utility that wraps the bus to await responses
            var messages = new AssertBus(messageBus);


            var processId = SimpleProcessId.fromString("my.process");

            // end of internal API


            // create instance via message passing
            var createInstance = ProcessMessages.CreateInstance.of(processId);
            var instanceCreated =
                    messages.send(createInstance)
                            .expect(ProcessMessages.InstanceCreated.class)
                            .get(25, SECONDS);

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

            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private void assertEquals(Object a, Object b) {
        if (!Objects.equals(a, b)) {
            throw new AssertionError("Not equal: " + a + " vs. " + b);
        }
    }

}
