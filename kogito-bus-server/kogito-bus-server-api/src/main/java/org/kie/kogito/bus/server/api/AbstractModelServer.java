/*
 * Copyright 2021 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.kie.kogito.bus.server.api;


import org.kie.kogito.research.application.api.events.Event;
import org.kie.kogito.research.application.api.MessageBus;
import org.kie.kogito.research.application.api.events.ModelEvent;
import org.kie.kogito.research.application.api.ids.ModelId;
import org.kie.kogito.research.application.api.messages.ModelMessage;
import org.kie.logito.models.api.ModelExecutor;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

/**
 * Abstract <b>ModelServer</b> class to hold all required methods by concrete implementations.
 * It has to be completely CDI-agnostic
 */
public abstract class AbstractModelServer<T extends ModelId, E extends ModelMessage<T>,  K extends ModelExecutor<T>, U extends ModelEvent<T, E>> {

    private static final Logger LOGGER = Logger.getLogger(AbstractModelServer.class.getName());

    protected MessageBus<T, E, U> messageBus;

    private List<K> modelExecutors;

    /**
     * Constructor to bind the concrete instance to the actual
     * <code>MessageBus</code> and <code>List&lt;ModelExecutor&gt;</code>,
     * that are different depending on the environment.
     * Must be called on the environment-specific CDI-annotated method
     * @param messageBus
     * @param modelExecutors
     */
    protected AbstractModelServer(MessageBus<T, E, U> messageBus, List<K> modelExecutors) {
        this.messageBus = messageBus;
        this.modelExecutors = modelExecutors;
        this.messageBus.subscribe(this::manageEvent);
    }

    protected void manageEvent(final U toManage) {
       if (modelExecutors == null || modelExecutors.isEmpty()) {
           sendReply(getNoExecutorReply(toManage));
       }
        Optional<K> modelExecutor = modelExecutors
                .stream()
                .filter(executor -> toManage.getExecutorId().equals(executor.getId()))
                .findFirst();
       if (modelExecutor.isPresent()) {
           receive(modelExecutor.get(), toManage);
       } else {
           sendReply(getNoMatchingExecutorReply(toManage));
       }
    }

    protected void sendReply(final U toSend) {
        messageBus.send(toSend);
    }

    /**
     * Concrete implementation must provide a method that forward the request to actual <code>ModelExecutor</code>
     * binding it to the underlined <code>MessageBus</code>
     * @param toReceive
     */
    public abstract void receive(final K modelExecutor, final U toReceive);


    /**
     * Concrete implementation must provide a reply when no executors have been registered,
     * that is an <b>unexpected</b> status.
     * This delegation is used due to maintain <b>Generic</b> contract.
     * @return
     */
    protected abstract U getNoExecutorReply(U event);

    /**
     * Concrete implementation must provide a reply when no <b>matching </b>executor have been registered,
     * that is an <b>expected</b> status.
     * This delegation is used due to maintain <b>Generic</b> contract.
     * @return
     */
    protected abstract U getNoMatchingExecutorReply(U event);


}
