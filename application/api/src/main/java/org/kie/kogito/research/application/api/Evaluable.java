package org.kie.kogito.research.application.api;

public interface Evaluable<T> {
    default public <R> R eval(EvaluationServiceFactory<T, R> wrapper) {
        return wrapper.create((T) this);
    }

}
