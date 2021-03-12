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

import org.kie.kogito.research.application.api.ids.ModelId;
import org.kie.kogito.research.application.api.ids.ModelInstanceId;
import org.kie.kogito.research.application.api.ids.RequestId;
import org.kie.kogito.research.application.api.messages.InstanceMessage;
import org.kie.kogito.research.application.api.messages.Response;

public class ModelInstanceStartedEvent<T extends ModelId, E extends ModelInstanceId, U extends InstanceMessage<T, E>> extends AbstractModelInstanceEvent<T, E, U> implements Response {

    private final RequestId requestId;

    protected ModelInstanceStartedEvent(RequestId requestId, T modelId, E modelInstanceId, U payload) {
        super(modelId, modelInstanceId, payload);
        this.requestId = requestId;
    }

    @Override
    public RequestId requestId() {
        return requestId;
    }
}
