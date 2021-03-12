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
import org.kie.kogito.research.application.api.ids.ModelInstanceId;
import org.kie.kogito.research.application.api.ids.RequestId;

public abstract class AbstractInstanceMessage<T extends ModelId, E extends ModelInstanceId> extends AbstractModelMessage<T> implements InstanceMessage<T, E> {

    private E modelInstanceId;

    protected AbstractInstanceMessage(RequestId requestId, T modelId, E modelInstanceId) {
        super(requestId, modelId);
        this.modelInstanceId = modelInstanceId;
    }

    protected AbstractInstanceMessage() {
    }

    @Override
    public E modelInstanceId() {
        return modelInstanceId;
    }

}
