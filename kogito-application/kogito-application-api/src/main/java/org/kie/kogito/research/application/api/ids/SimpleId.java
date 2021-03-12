package org.kie.kogito.research.application.api.ids;

import java.util.Objects;
import java.util.UUID;

public class SimpleId implements Id {
    private final UUID uuid = UUID.randomUUID();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleId simpleId = (SimpleId) o;
        return Objects.equals(uuid, simpleId.uuid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid);
    }

    @Override
    public String toString() {
        return "SimpleId(" + uuid + ')';
    }
}
