package org.kie.kogito.research.application.core;

import org.kie.kogito.research.application.api.UnitInstanceId;

import java.util.Objects;
import java.util.UUID;

public class SimpleUnitInstanceId implements UnitInstanceId {
    private final String value;

    public static SimpleUnitInstanceId create() {
        return new SimpleUnitInstanceId(UUID.randomUUID().toString());
    }

    public static SimpleUnitInstanceId fromString(String id) {
        return new SimpleUnitInstanceId(id);
    }

    private SimpleUnitInstanceId(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleUnitInstanceId that = (SimpleUnitInstanceId) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
