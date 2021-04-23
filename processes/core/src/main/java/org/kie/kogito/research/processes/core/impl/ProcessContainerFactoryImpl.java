package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Addressable;
import org.kie.kogito.research.application.api.AddressableContainer;
import org.kie.kogito.research.application.api.AddressableContainerFactory;
import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.core.RelativeUriId;
import org.kie.kogito.research.processes.api.ProcessContainer;

public class ProcessContainerFactoryImpl implements AddressableContainerFactory {
    @Override
    public AddressableContainer<? extends Addressable> create(Id id) {
        return new ProcessContainerImpl(id.append(RelativeUriId.of("processes")));
    }

    @Override
    public Class<? extends AddressableContainer<? extends Addressable>> type() {
        return ProcessContainer.class;
    }
}
