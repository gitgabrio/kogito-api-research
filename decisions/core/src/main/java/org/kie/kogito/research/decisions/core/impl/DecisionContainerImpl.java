package org.kie.kogito.research.decisions.core.impl;

import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.core.AbstractAddressableContainer;
import org.kie.kogito.research.decisions.api.Decision;
import org.kie.kogito.research.decisions.api.DecisionContainer;

public class DecisionContainerImpl extends AbstractAddressableContainer<Decision> implements DecisionContainer {
    public DecisionContainerImpl(Id id) {
        super(id);
    }

    @Override
    protected Decision create(Id id) {
        return new DecisionImpl(id);
    }
}
