package org.kie.kogito.research.application.api.messages;

import org.kie.kogito.research.application.api.ids.ModelId;
import org.kie.kogito.research.application.api.ids.ModelInstanceId;
import org.kie.kogito.research.application.api.ids.RequestId;

public abstract class AbstractInstanceCompletedMessage<T extends ModelId, E extends ModelInstanceId> extends AbstractInstanceMessage<T, E> implements Response {
        protected AbstractInstanceCompletedMessage() {
        }

        protected AbstractInstanceCompletedMessage(RequestId requestId, T modelId, E modelInstanceId) {
            super(requestId, modelId, modelInstanceId);
        }
//
//        public InstanceCompleted<T, E> of(RequestId requestId, T modelId, E modelInstanceId) {
//            return new InstanceCompleted(requestId, modelId, modelInstanceId);
//        }
    }