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
package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.ids.Id;
import org.kie.kogito.research.application.api.impl.SimpleEvent;
import org.kie.kogito.research.processes.api.ProcessEvent;
import org.kie.kogito.research.processes.api.ProcessMessage;
import org.kie.kogito.research.processes.api.ids.ProcessId;

public class SimpleProcessEvent extends SimpleEvent implements ProcessEvent {

    protected SimpleProcessEvent() {}

    public SimpleProcessEvent(Id senderId, Id targetId, ProcessMessage payload) {
        super(senderId, targetId, payload);
    }

    @Override
    public ProcessMessage payload() {
        return (ProcessMessage) super.payload();
    }

    @Override
    public Id getExecutorId() {
        return null;
    }


    @Override
    public ProcessId getModelId() {
        return payload().modelId();
    }
}
