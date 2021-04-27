package org.kie.kogito.research.decisions.core;

import org.kie.kogito.research.application.api.RelativeId;

import java.util.Objects;

public class DecisionId implements RelativeId {

    public static DecisionId of(String namespace, String name) {
        return new DecisionId(namespace, name);
    }

    private final String namespace;
    private final String name;

    private DecisionId(String namespace, String name) {
        this.namespace = namespace;
        this.name = name;
    }

    public String namespace() {
        return namespace;
    }

    public String name() {
        return name;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof RelativeId && o.toString().equals(this.toString());
    }

    @Override
    public int hashCode() {
        return Objects.hash(namespace, name);
    }

    @Override
    public String toString() {
        return String.format("%s#%s", namespace, name);
    }
}
