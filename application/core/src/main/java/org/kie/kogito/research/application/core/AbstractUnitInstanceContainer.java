package org.kie.kogito.research.application.core;

import org.kie.kogito.research.application.api.*;

public abstract class AbstractUnitInstanceContainer<I extends Instance<?>>
        extends AbstractAddressableFactory<I, Context>
        implements AddressableContainerFactory<I> {

    public AbstractUnitInstanceContainer(Id parentId, String name) {
        super(parentId, name);
    }

}
