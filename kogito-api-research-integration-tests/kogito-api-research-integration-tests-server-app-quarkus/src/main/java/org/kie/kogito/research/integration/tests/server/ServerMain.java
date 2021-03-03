package org.kie.kogito.research.integration.tests.server;


import io.quarkus.runtime.Startup;
import org.jboss.logging.Logger;
import org.kie.kogito.research.application.api.MessageBus;
import org.kie.kogito.research.integration.tests.impl.SmallryeProcessorMessageBus;
import org.kie.kogito.research.processes.core.impl.ProcessServerMain;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Arrays;

@Startup
public class ServerMain  {

    private static final Logger LOGGER = Logger.getLogger(ServerMain.class);

    @Inject
    SmallryeProcessorMessageBus messageBus;


    @Inject
    ProcessImpl processImpl;

    @PostConstruct
    public void startup() {
        ProcessServerMain processServerMain = new ProcessServerMain((MessageBus) messageBus, Arrays.asList(processImpl));
        LOGGER.info("SERVER STARTED");
    }

}
