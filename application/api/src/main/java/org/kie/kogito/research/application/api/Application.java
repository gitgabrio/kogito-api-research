package org.kie.kogito.research.application.api;

public interface Application {
    <U extends AddressableContainer<?>> U get(Class<U> cls);

}
