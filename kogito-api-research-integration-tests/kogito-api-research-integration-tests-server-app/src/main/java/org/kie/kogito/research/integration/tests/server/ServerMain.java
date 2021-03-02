package org.kie.kogito.research.integration.tests.server;


import io.quarkus.runtime.Startup;
import org.jboss.logging.Logger;
import org.kie.kogito.research.application.api.MessageBus;
import org.kie.kogito.research.processes.core.impl.ProcessImpl;
import org.kie.kogito.research.processes.core.impl.SimpleProcessId;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Startup
public class ServerMain {

    private static final Logger LOGGER = Logger.getLogger(ServerMain.class);

    @Inject
    MessageBus messageBus;

    @Inject
    SimpleProcessId unitID;

    @PostConstruct
    public void startup() {
        var processId = SimpleProcessId.fromString("my.process");
        var process = new ProcessImpl(null, unitID, messageBus);
        LOGGER.info("SERVER STARTED");
    }

}
