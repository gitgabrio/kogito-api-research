package org.kie.kogito.research.application.api.v2;

import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.api.v2.address.Catalog;
import org.kie.kogito.research.application.api.v2.address.RelativeUriId;
import org.kie.kogito.research.application.api.v2.address.UriId;

public class Application {
    Id id = UriId.of(null, RelativeUriId.of("app"));
    public <T> Catalog<T> forCatalog(Type<T> cls) {
        return new Catalog<>(id, cls);
    }

    public Id id() {
        return id;
    }
}
