package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.core.impl.BroadcastProcessorMessageBus;
import org.kie.kogito.research.processes.api.ProcessId;
import org.kie.kogito.research.processes.api.ProcessInstanceId;
import org.kie.kogito.research.processes.api.messages.ProcessMessages;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class BlockingRequestResponse {
    RequestResponse requestResponse;
    private CompletableFuture<ProcessMessages.InstanceCompleted> completed;

    BlockingRequestResponse(BroadcastProcessorMessageBus messageBus) {
        this.requestResponse = new RequestResponse(messageBus);
    }

    ProcessInstanceId createInstance(ProcessId processId) throws ExecutionException, InterruptedException, TimeoutException {
        // create instance via message passing
        var createInstance = ProcessMessages.CreateInstance.of(processId);
        var instanceCreated =
                requestResponse.send(createInstance)
                        .expect(ProcessMessages.InstanceCreated.class)
                        .get(5, TimeUnit.SECONDS);
        return instanceCreated.processInstanceId();
    }

    void startInstance(ProcessId processId, ProcessInstanceId processInstanceId) throws ExecutionException, InterruptedException, TimeoutException {
        var startInstance =
                ProcessMessages.StartInstance.of(processId, processInstanceId);


        var instanceStarted = requestResponse
                .send(startInstance)
                .expect(ProcessMessages.InstanceStarted.class)
                .get(1, TimeUnit.SECONDS);
    }

    void awaitTermination() throws ExecutionException, InterruptedException, TimeoutException {
        requestResponse.expect(ProcessMessages.InstanceCompleted.class).get(1, TimeUnit.SECONDS);

    }

}
