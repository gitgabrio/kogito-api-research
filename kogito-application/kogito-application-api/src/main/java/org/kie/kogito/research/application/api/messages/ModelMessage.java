package org.kie.kogito.research.application.api.messages;

import org.kie.kogito.research.application.api.ids.ModelId;
import org.kie.kogito.research.application.api.ids.RequestId;

import java.io.Serializable;
import java.util.Optional;

public interface ModelMessage<T extends ModelId> extends Serializable {

    <E extends ModelMessage<T>> Optional<E> as(Class<E> type);

    RequestId requestId();

    T modelId();
}