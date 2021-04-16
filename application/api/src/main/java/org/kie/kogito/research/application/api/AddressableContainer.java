package org.kie.kogito.research.application.api;

public interface AddressableContainer<T extends Addressable> extends Addressable {
    T get(RelativeId id);
}
