package org.kie.kogito.research.integration.tests.server;


import io.quarkus.runtime.Startup;
import org.jboss.logging.Logger;

import javax.annotation.PostConstruct;
import javax.inject.Inject;

@Startup
public class ServerMain  {

    private static final Logger LOGGER = Logger.getLogger(ServerMain.class);

    @Inject
    ProcessSmallryeMessageBus messageBus;


    @Inject
    ProcessImpl processImpl;

    @PostConstruct
    public void startup() {
        ProcessServerMain processServerMain = new ProcessServerMain(/*(MessageBus) messageBus, Arrays.asList(processImpl)*/);
        LOGGER.info("SERVER STARTED");
    }

}
