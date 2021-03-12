package org.kie.kogito.research.application.api.messages;

import org.kie.kogito.research.application.api.Context;
import org.kie.kogito.research.application.api.ids.ModelId;
import org.kie.kogito.research.application.api.ids.ModelInstanceId;
import org.kie.kogito.research.application.api.ids.RequestId;

import java.util.Optional;

public abstract class InstanceCreateMessage<T extends ModelId, E extends ModelInstanceId> extends AbstractInstanceMessage<T, E> implements Request {
    protected Context context;
    protected RequestId requestId;
    protected T modelId;

    protected InstanceCreateMessage() {
    }

    protected InstanceCreateMessage(T modelId) {
        this.modelId = modelId;
    }

    protected InstanceCreateMessage(T modelId, Context context) {
        this.modelId = modelId;
        this.context = context;
    }

    protected InstanceCreateMessage(RequestId requestId, T modelId) {
        this.requestId = requestId;
        this.modelId = modelId;
    }

    protected InstanceCreateMessage(RequestId requestId, T modelId, Context context) {
        this.requestId = requestId;
        this.modelId = modelId;
        this.context = context;
    }

    public Context context() {
        return context;
    }

    public RequestId requestId() {
        return requestId;
    }

    public T modelId() {
        return modelId;
    }

    @Override
    public <E extends ModelMessage<T>> Optional<E> as(Class<E> type) {
        return type.isInstance(this) ? Optional.of((E) this) : Optional.empty();
    }


}