package org.kie.kogito.research.application.api;

public interface EvaluationServiceFactory<T, R> {
    R create(T t);
}
