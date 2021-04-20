package org.kie.kogito.research.application.api.v2.address;

import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.api.RelativeId;
import org.kie.kogito.research.application.api.v2.BuildableType;
import org.kie.kogito.research.application.api.v2.Type;

public class Item<T> {
    private final Id id;

    public Item(Id parentId, RelativeId id) {
        this.id = new UriId(parentId, id);
    }

    public <T> Catalog<T> forCatalog(Type<T> cls) {
        return new Catalog<>(this.id, cls);
    }

    public <T> Factory<T> factoryOf(BuildableType<T> cls) {
        return new Factory<>(this.id, cls);
    }


    public T resolve() {
        throw new UnsupportedOperationException();
    }
}