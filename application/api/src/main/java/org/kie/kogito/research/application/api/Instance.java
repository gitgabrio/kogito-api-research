package org.kie.kogito.research.application.api;

public interface Instance<T extends Unit> {
    Id id();
    T unit();
    <C extends Context> C context(Class<C> cls);

    <U extends Unit, C extends UnitInstanceContainer<U>> C get(Class<C> cls);

    void start();
    void complete();

    void abort();

    <T extends Context> T update(T ctx);

    void send(Event event);


    default <U extends Unit, I extends Instance<U>> I as(Class<I> cls) {
        return cls.cast(this);
    }

}
