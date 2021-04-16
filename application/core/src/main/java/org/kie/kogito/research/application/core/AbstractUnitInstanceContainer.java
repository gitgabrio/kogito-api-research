package org.kie.kogito.research.application.core;

import org.kie.kogito.research.application.api.*;

import java.util.HashMap;
import java.util.Map;

public abstract class AbstractUnitInstanceContainer<I extends Instance<?>>
        extends AbstractAddressableFactory<I, Context>
        implements UnitInstanceContainer<I> {

    public AbstractUnitInstanceContainer(Id parentId, String name) {
        super(parentId, name);
    }

}
