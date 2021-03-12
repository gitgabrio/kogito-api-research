package org.kie.kogito.research.integration.tests.client;


import io.quarkus.runtime.QuarkusApplication;
import io.quarkus.runtime.annotations.QuarkusMain;
import org.kie.kogito.research.application.api.events.Event;
import org.kie.kogito.research.application.api.ids.SimpleRequestId;
import org.kie.kogito.research.predictions.core.impl.PredictionExecuteEvent;
import org.kie.kogito.research.predictions.core.impl.PredictionExecuteMessage;
import org.kie.kogito.research.predictions.core.impl.PredictionExecutedEvent;
import org.kie.kogito.research.predictions.core.impl.SimplePredictionId;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeoutException;

@QuarkusMain
public class ClientMain implements QuarkusApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientMain.class);


    @Inject
    PredictionSmallryeMessageBus messageBus;


    public int run(String... args) {
        try {
            nonBlockingApi();
            // blockingApi(); // uncomment your pick
            return 0;
        } catch (Exception e) {
            e.printStackTrace();
            return -1;
        }
    }

    private void nonBlockingApi() throws InterruptedException, ExecutionException, TimeoutException {
        LOGGER.info("nonBlockingApi");
        var messages = messageBus;
        messageBus.subscribe(this::manageEvent);
        var predictionID = SimplePredictionId.fromString("PredictionId");

        // execute model via message passing
        final SimpleRequestId requestId = new SimpleRequestId();
        var executeMessage = new PredictionExecuteMessage(requestId, predictionID);
        var executeEvent = new PredictionExecuteEvent(requestId, predictionID, executeMessage);
        LOGGER.info("Sending " + executeEvent);
        messages.send(executeEvent);
    }

    private void manageEvent(Event toManage) {
        if (!(toManage instanceof PredictionExecutedEvent)) {
            return;
        }
        LOGGER.info("Managing {}", toManage);
        messageBus.unSubscribe(this::manageEvent);

    }

}
