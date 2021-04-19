package org.kie.kogito.research.application.api;

/**
 * A container of Containers of Addressable objects
 */
public interface AddressableContainerContainer extends Addressable {
    <U extends Addressable, C extends AddressableContainer<U>> C get(Class<U> cls);
}
