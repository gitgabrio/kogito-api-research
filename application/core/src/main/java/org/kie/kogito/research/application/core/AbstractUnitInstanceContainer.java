package org.kie.kogito.research.application.core;

import org.kie.kogito.research.application.api.*;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractUnitInstanceContainer<U extends Unit<U>, I extends Instance<U>>
        extends AbstractAddressableContainer<I>
        implements UnitInstanceContainer<U, I> {

    public AbstractUnitInstanceContainer(Id parentId, String name) {
        super(parentId, name);
    }

    @Override
    public I create(Context ctx) {
        return register(create0(ctx));
    }

    public abstract I create0(Context ctx);

}
