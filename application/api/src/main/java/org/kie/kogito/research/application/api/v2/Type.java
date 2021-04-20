package org.kie.kogito.research.application.api.v2;

public class Type<T> {
    private final String name;

    public Type(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }
}