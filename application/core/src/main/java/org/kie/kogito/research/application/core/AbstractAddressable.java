package org.kie.kogito.research.application.core;

import org.kie.kogito.research.application.api.Addressable;
import org.kie.kogito.research.application.api.Id;

public abstract class AbstractAddressable implements Addressable {
    private final Id id;

    public AbstractAddressable(Id id) {
        this.id = id;
    }

    @Override
    public Id id() {
        return id;
    }

}
