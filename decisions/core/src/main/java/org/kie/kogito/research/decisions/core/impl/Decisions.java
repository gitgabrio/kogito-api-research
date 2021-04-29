package org.kie.kogito.research.decisions.core.impl;

import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.api.RelativeId;
import org.kie.kogito.research.application.core.AbstractAddressable;
import org.kie.kogito.research.application.core.AbstractAddressableContainer;
import org.kie.kogito.research.application.core.RelativeUriId;
import org.kie.kogito.research.decisions.api.Decision;
import org.kie.kogito.research.decisions.api.DecisionContainer;
import org.kie.kogito.research.decisions.api.DecisionInstance;
import org.kie.kogito.research.decisions.api.DecisionInstanceContainer;

// /decisions
class DecisionContainerImpl extends AbstractAddressableContainer<Decision> implements DecisionContainer {
    public DecisionContainerImpl(Id id) {
        super(id);
    }

    @Override
    public Decision get(RelativeId id) {
        return new DecisionImpl(id().append(id));
    }
}

// /decisions/$decision_id/
class DecisionImpl extends AbstractAddressable implements Decision {

    public DecisionImpl(Id id) {
        super(id);
    }

    @Override
    public DecisionInstanceContainer instances() {
        return new DecisionInstanceContainerImpl(id().append(RelativeUriId.of("instances")));
    }
}

// /decisions/$decision_id/instances
class DecisionInstanceContainerImpl extends AbstractAddressableContainer<DecisionInstance> implements DecisionInstanceContainer {

    public DecisionInstanceContainerImpl(Id id) {
        super(id);
    }

    @Override
    public DecisionInstance get(RelativeId id) {
        return new DecisionInstanceImpl(id().append(id));
    }
}

// /decisions/$decision_id/instances/$decision_instance_id
class DecisionInstanceImpl extends AbstractAddressable implements DecisionInstance {

    public DecisionInstanceImpl(Id id) {
        super(id);
    }

}

