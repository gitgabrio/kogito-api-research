package org.kie.kogito.research.application.core;

import org.kie.kogito.research.application.api.Addressable;
import org.kie.kogito.research.application.api.AddressableContainer;
import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.api.RelativeId;

public abstract class AbstractAddressableContainer<T extends Addressable> implements AddressableContainer<T> {
    private final Id id;

    public AbstractAddressableContainer(Id id) {
        this.id = id;
    }

    @Override
    public Id id() {
        return id;
    }

    @Override
    public T get(RelativeId unitId) {
        return create(id.append(unitId));
    }

    protected abstract T create(Id id);

}
