package org.kie.kogito.research.application.core;

import org.kie.kogito.research.application.api.Addressable;
import org.kie.kogito.research.application.api.AddressableFactory;
import org.kie.kogito.research.application.api.Id;

public abstract class AbstractAddressableFactory<I extends Addressable, C>
        extends AbstractAddressableContainer<I>
        implements AddressableFactory<I, C> {

    public AbstractAddressableFactory(Id parentId, String name) {
        super(parentId, name);
    }

    @Override
    public final I create(C ctx) {
        return register(create0(ctx));
    }

    public abstract I create0(C ctx);

}
