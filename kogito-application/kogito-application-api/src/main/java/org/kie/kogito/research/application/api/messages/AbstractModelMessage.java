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
package org.kie.kogito.research.application.api.messages;

import org.kie.kogito.research.application.api.ids.ModelId;
import org.kie.kogito.research.application.api.ids.RequestId;

import java.util.Optional;

public abstract class AbstractModelMessage<T extends ModelId> implements ModelMessage<T> {

    private RequestId requestId;
    private T modelId;

    protected AbstractModelMessage(RequestId requestId, T modelId) {
        this.requestId = requestId;
        this.modelId = modelId;
    }

    protected AbstractModelMessage() {
    }

    @Override
    public RequestId requestId() {
        return requestId;
    }

    @Override
    public T modelId() {
        return modelId;
    }

    @Override
    public <K extends ModelMessage<T>> Optional<K> as(Class<K> type) {
        return type.isInstance(this) ? Optional.of((K) this) : Optional.empty();
    }
}
