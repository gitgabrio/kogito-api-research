package org.kie.kogito.research.decisions.core.impl;

import org.kie.kogito.research.application.api.Addressable;
import org.kie.kogito.research.application.api.AddressableContainer;
import org.kie.kogito.research.application.api.AddressableContainerFactory;
import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.core.RelativeUriId;
import org.kie.kogito.research.decisions.api.DecisionContainer;

public class DecisionContainerFactoryImpl implements AddressableContainerFactory {
    @Override
    public AddressableContainer<? extends Addressable> create(Id id) {
        return new DecisionContainerImpl(id.append(RelativeUriId.of("decisions")));
    }

    @Override
    public Class<? extends AddressableContainer<? extends Addressable>> type() {
        return DecisionContainer.class;
    }
}
