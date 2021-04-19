package org.kie.kogito.research.application.api;

public interface Instance<T extends Unit<T>> extends Addressable, AddressableContainerContainer {
    <C extends Context> C context(Class<C> cls);
}
