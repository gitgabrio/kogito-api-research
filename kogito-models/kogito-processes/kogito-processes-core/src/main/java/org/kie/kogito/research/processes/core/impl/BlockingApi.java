package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Event;
import org.kie.kogito.research.application.api.MessageBus;
import org.kie.kogito.research.application.core.impl.BroadcastProcessorMessageBus;
import org.kie.kogito.research.processes.api.ProcessId;
import org.kie.kogito.research.processes.api.ProcessInstanceId;
import org.kie.kogito.research.processes.api.messages.ProcessMessages;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class BlockingApi {
    AssertBus assertBus;
    private CompletableFuture<ProcessMessages.InstanceCompleted> completed;

    public BlockingApi(MessageBus<Event> messageBus) {
        this.assertBus = new AssertBus(messageBus);
    }

    public ProxyProcessInstance createInstance(ProcessId processId) throws ExecutionException, InterruptedException, TimeoutException {
        // create instance via message passing
        var createInstance = ProcessMessages.CreateInstance.of(processId);
        var response =
                assertBus.send(createInstance)
                        .expect()
                        .get(5, TimeUnit.SECONDS);

        Optional<ProcessMessages.InstanceCreated> instanceCreated = response.as(ProcessMessages.InstanceCreated.class);
        if (instanceCreated.isPresent()) {
            ProcessMessages.InstanceCreated created = instanceCreated.get();
            return new ProxyProcessInstance(created.processId(), created.processInstanceId(), assertBus);
        } else {
            Optional<ProcessMessages.NoSuchProcess> nsp = response.as(ProcessMessages.NoSuchProcess.class);
            if (nsp.isPresent()) {
                throw new NoSuchProcessIdException(nsp.get().processId());
            } else {
                throw new IllegalArgumentException();
            }
        }

    }


    public static class ProxyProcessInstance {
        private final ProcessId processId;
        private final ProcessInstanceId processInstanceId;
        private final AssertBus assertBus;

        public ProxyProcessInstance(ProcessId processId, ProcessInstanceId processInstanceId, AssertBus assertBus) {
            this.processId = processId;
            this.processInstanceId = processInstanceId;
            this.assertBus = assertBus;
        }

        public void start() throws ExecutionException, InterruptedException, TimeoutException {
            var startInstance =
                    ProcessMessages.StartInstance.of(processId, processInstanceId);


            var instanceStarted = assertBus
                    .send(startInstance)
                    .expect(ProcessMessages.InstanceStarted.class)
                    .get(1, TimeUnit.SECONDS);
        }


        public void awaitTermination() throws ExecutionException, InterruptedException, TimeoutException {
            assertBus.expect(ProcessMessages.InstanceCompleted.class, instanceCompleted -> processInstanceId.equals(instanceCompleted.processInstanceId())).get(1, TimeUnit.SECONDS);
        }
    }
}
