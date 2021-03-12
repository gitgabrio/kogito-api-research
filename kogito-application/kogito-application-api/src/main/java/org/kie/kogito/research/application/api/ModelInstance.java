package org.kie.kogito.research.application.api;

import org.kie.kogito.research.application.api.events.ModelInstanceEvent;
import org.kie.kogito.research.application.api.ids.ModelId;
import org.kie.kogito.research.application.api.ids.ModelInstanceId;
import org.kie.kogito.research.application.api.messages.InstanceMessage;

public interface ModelInstance<T extends ModelId, E extends ModelInstanceId, U extends InstanceMessage<T, E>, I extends ModelInstanceEvent<T, E, U>> extends Model<T, U, I> {

    E instanceId();
    Context context();
    Model<T, U, I> model();
    void run();
}
