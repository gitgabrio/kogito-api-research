package org.kie.kogito.research.decisions.core.impl;

import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.api.RelativeId;
import org.kie.kogito.research.application.core.AbstractAddressableContainer;
import org.kie.kogito.research.decisions.api.DecisionInstance;
import org.kie.kogito.research.decisions.api.DecisionInstanceContainer;

public class DecisionInstanceContainerImpl extends AbstractAddressableContainer<DecisionInstance> implements DecisionInstanceContainer {

    public DecisionInstanceContainerImpl(Id id) {
        super(id);
    }

    @Override
    public DecisionInstance get(RelativeId id) {
        return new DecisionInstanceImpl(id().append(id));
    }
}
