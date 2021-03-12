package org.kie.kogito.research.application.api;

import org.kie.kogito.research.application.api.ids.ModelId;

import java.util.Objects;

public class ClassModelId implements ModelId {
    private final Class<?> cls;

    protected ClassModelId(Class<?> cls) {
        this.cls = cls;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        ClassModelId that = (ClassModelId) o;
        return Objects.equals(cls, that.cls);
    }

    @Override
    public int hashCode() {
        return Objects.hash(cls);
    }

    public static ClassModelId of(Class<?> cls) {
        return new ClassModelId(cls);
    }

}
