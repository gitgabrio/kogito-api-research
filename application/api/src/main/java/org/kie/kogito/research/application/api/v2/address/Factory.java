package org.kie.kogito.research.application.api.v2.address;

import org.kie.kogito.research.application.api.*;
import org.kie.kogito.research.application.api.v2.Type;

public class Factory<T> {

    private final Id id;

    public Factory(Id parentId, Type<T> cls) {
        this.id = new UriId(parentId, RelativeUriId.of(cls.name()));
    }

    public Leaf<T> create() {
        return new Leaf<>();
    }

    public Leaf<AddressableFactory<Addressable, Context>> get() {
        return null;
    }
}
