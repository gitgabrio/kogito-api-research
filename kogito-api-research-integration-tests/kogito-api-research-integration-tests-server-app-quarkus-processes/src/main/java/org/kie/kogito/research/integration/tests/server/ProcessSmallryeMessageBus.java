package org.kie.kogito.research.integration.tests.server;

import org.kie.kogito.research.integration.tests.impl.SmallryeProcessorMessageBus;
import org.kie.kogito.research.processes.api.ProcessEvent;
import org.kie.kogito.research.processes.api.ProcessMessage;
import org.kie.kogito.research.processes.api.ProcessMessageBus;
import org.kie.kogito.research.processes.api.ids.ProcessId;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ProcessSmallryeMessageBus extends SmallryeProcessorMessageBus<ProcessId, ProcessMessage, ProcessEvent> implements ProcessMessageBus {
}