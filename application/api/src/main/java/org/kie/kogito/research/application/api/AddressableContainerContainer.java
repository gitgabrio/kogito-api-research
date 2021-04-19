package org.kie.kogito.research.application.api;

public interface AddressableContainerContainer {
    <U extends Addressable, C extends AddressableContainer<U>> C get(Class<U> cls);
}
