package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.core.impl.AssertBus;
import org.kie.kogito.research.processes.api.ProcessEvent;
import org.kie.kogito.research.processes.api.ProcessMessage;
import org.kie.kogito.research.processes.api.ProcessMessageBus;
import org.kie.kogito.research.processes.api.ids.ProcessId;

public class ProcessAssertBus extends AssertBus<ProcessId, ProcessMessage, ProcessEvent> {


    public ProcessAssertBus(ProcessMessageBus messageBus) {
        super(messageBus);
    }

    public ExpectResponse send(ProcessMessage message) {
        messageBus.send(new SimpleProcessEvent(self, null, message));
        return new ExpectResponse(message);
    }

}
