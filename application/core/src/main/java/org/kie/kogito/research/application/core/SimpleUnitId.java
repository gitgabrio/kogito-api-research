package org.kie.kogito.research.application.core;

import org.kie.kogito.research.application.api.UnitId;

import java.util.Objects;

public class SimpleUnitId implements UnitId {
    private final String value;

    public static SimpleUnitId fromString(String id) {
        return new SimpleUnitId(id);
    }

    private SimpleUnitId(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimpleUnitId that = (SimpleUnitId) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }

    @Override
    public String toString() {
        return "SimpleProcessId{" +
                "'" + value + '\'' +
                '}';
    }
}
