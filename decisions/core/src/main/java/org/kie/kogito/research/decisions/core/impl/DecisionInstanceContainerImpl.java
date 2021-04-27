package org.kie.kogito.research.decisions.core.impl;

import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.core.AbstractAddressableContainer;
import org.kie.kogito.research.decisions.api.DecisionInstance;
import org.kie.kogito.research.decisions.api.DecisionInstanceContainer;

public class DecisionInstanceContainerImpl extends AbstractAddressableContainer<DecisionInstance> implements DecisionInstanceContainer {

    public DecisionInstanceContainerImpl(Id id) {
        super(id);
    }

    @Override
    protected DecisionInstance create(Id id) {
        return new DecisionInstanceImpl(id);
    }
}
