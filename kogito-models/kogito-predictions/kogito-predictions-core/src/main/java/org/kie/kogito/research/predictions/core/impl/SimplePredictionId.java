package org.kie.kogito.research.predictions.core.impl;

import org.kie.kogito.research.predictions.api.ids.PredictionId;

import javax.enterprise.inject.Default;
import java.util.Objects;

@Default
public class SimplePredictionId implements PredictionId {
    private String value;

    protected SimplePredictionId() {}

    public static SimplePredictionId fromString(String id) {
        return new SimplePredictionId(id);
    }

    private SimplePredictionId(String value) {
        this.value = value;
    }

    public String value() {
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SimplePredictionId that = (SimplePredictionId) o;
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
