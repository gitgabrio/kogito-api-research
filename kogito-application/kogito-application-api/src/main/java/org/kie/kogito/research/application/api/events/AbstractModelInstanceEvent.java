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
package org.kie.kogito.research.application.api.events;

import org.kie.kogito.research.application.api.ids.Id;
import org.kie.kogito.research.application.api.ids.ModelId;
import org.kie.kogito.research.application.api.ids.ModelInstanceId;
import org.kie.kogito.research.application.api.messages.InstanceMessage;
import org.kie.kogito.research.application.api.messages.ModelMessage;

public abstract class AbstractModelInstanceEvent<T extends ModelId, E extends ModelInstanceId, U extends InstanceMessage<T, E>> implements ModelInstanceEvent<T, E, U> {

    protected final T modelId;
    protected final E modelInstanceId;
    protected final U payload;

    protected AbstractModelInstanceEvent(T modelId, E modelInstanceId, U payload) {
        this.modelId = modelId;
        this.modelInstanceId = modelInstanceId;
        this.payload = payload;
    }

    @Override
    public Id senderId() {
        return null;
    }

    @Override
    public Id targetId() {
        return null;
    }

    @Override
    public Id getExecutorId() {
        return null;
    }

    @Override
    public T getModelId() {
        return modelId;
    }

    @Override
    public E getModelInstanceId() {
        return modelInstanceId;
    }

    @Override
    public U payload() {
        return payload;
    }
}
