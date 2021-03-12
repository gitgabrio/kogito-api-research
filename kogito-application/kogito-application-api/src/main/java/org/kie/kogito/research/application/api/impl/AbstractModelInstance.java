package org.kie.kogito.research.application.api.impl;

import org.kie.kogito.research.application.api.Context;
import org.kie.kogito.research.application.api.ExecutionModel;
import org.kie.kogito.research.application.api.Model;
import org.kie.kogito.research.application.api.ModelInstance;
import org.kie.kogito.research.application.api.events.ModelInstanceEvent;
import org.kie.kogito.research.application.api.ids.ModelId;
import org.kie.kogito.research.application.api.ids.ModelInstanceId;
import org.kie.kogito.research.application.api.messages.InstanceMessage;

public abstract class AbstractModelInstance<T extends ModelId, E extends ModelInstanceId, U extends InstanceMessage<T, E>, K extends ModelInstanceEvent<T, E, U>> extends AbstractModel<T, U, K> implements ModelInstance<T, E, U, K> {

    private final E id;
    private final Model<T, U, K> model;
    private final Context context;

    protected AbstractModelInstance(E id, Model<T, U, K> model, Context context) {
        super(model.id());
        this.id = id;
        this.model = model;
        this.context = context;
    }

    @Override
    public E instanceId() {
        return id;
    }

    @Override
    public Model<T, U, K> model() {
        return model;
    }

    @Override
    public Context context() {
        return context;
    }

    @Override
    public void send(K event) {
        if (context instanceof ExecutionModel) {
            ExecutionModel executionModel = (ExecutionModel) this.context;
            if (event.targetId() == null ||
                    event.targetId().equals(this.model.id()) ||
                    event.targetId().equals(this.id())) {
                executionModel.onEvent(event);
            }
        }
    }

}
