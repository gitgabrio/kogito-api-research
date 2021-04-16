package org.kie.kogito.research.application.api;

public interface Instance<T extends Unit<T>> extends Addressable {
    Id id();
    <C extends Context> C context(Class<C> cls);

    <U extends Addressable, C extends AddressableContainer<U>> C get(Class<U> cls);

    default <U extends Unit<U>, I extends Instance<U>> I as(Class<I> cls) {
        return cls.cast(this);
    }

}
