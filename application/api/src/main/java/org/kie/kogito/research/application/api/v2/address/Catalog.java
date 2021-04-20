package org.kie.kogito.research.application.api.v2.address;

import org.kie.kogito.research.application.api.Addressable;
import org.kie.kogito.research.application.api.AddressableFactory;
import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.api.RelativeId;
import org.kie.kogito.research.application.api.v2.Type;

public class Catalog<T> {

    private final Id id;

    public Catalog(Id parentId, Type<T> cls) {
        this.id = new UriId(parentId, RelativeUriId.of(cls.name()));
    }

    public Item<T> get(RelativeId id) {
        return new Item<>(this.id, id);
    }

    public Leaf<T> get() {
        return new Leaf<>();
    }

    public Leaf<T> resolve() {
        return get();
    }
}
