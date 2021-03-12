package org.kie.kogito.research.integration.tests.server;

import io.quarkus.runtime.Startup;
import org.jboss.logging.Logger;
import org.kie.kogito.research.application.api.MessageBus;
import org.kie.kogito.research.integration.tests.impl.SmallryeProcessorMessageBus;
import org.kie.kogito.research.predictions.api.PredictionMessageBus;

import javax.annotation.PostConstruct;
import javax.inject.Inject;
import java.util.Arrays;

@Startup
public class ServerMain {

    private static final Logger LOGGER = Logger.getLogger(ServerMain.class);

    @Inject
    PredictionSmallryeMessageBus messageBus;

    @Inject
    PredictionImpl processImpl;

    @PostConstruct
    public void startup() {
        PredictionServerMain predictionServerMain = new PredictionServerMain(messageBus, Arrays.asList(processImpl));
        LOGGER.info("SERVER STARTED " + predictionServerMain );
    }

}
