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
package org.kie.kogito.research.predictions.core.impl;

import org.kie.kogito.research.application.api.events.ModelExecutedEvent;
import org.kie.kogito.research.application.api.ids.RequestId;
import org.kie.kogito.research.predictions.api.PredictionEvent;
import org.kie.kogito.research.predictions.api.PredictionMessage;
import org.kie.kogito.research.predictions.api.ids.PredictionId;

public class PredictionExecutedEvent extends ModelExecutedEvent<PredictionId, PredictionMessage> implements PredictionEvent {
    public PredictionExecutedEvent(RequestId requestId, PredictionId modelId, PredictionMessage payload) {
        super(requestId, modelId, payload);
    }
}
