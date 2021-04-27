package org.kie.kogito.research.decisions.core.impl;

import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.core.AbstractAddressable;
import org.kie.kogito.research.application.core.RelativeUriId;
import org.kie.kogito.research.decisions.api.Decision;
import org.kie.kogito.research.decisions.api.DecisionInstanceContainer;

public class DecisionImpl extends AbstractAddressable implements Decision {

    public DecisionImpl(Id id) {
        super(id);
    }

    @Override
    public DecisionInstanceContainer instances() {
        return new DecisionInstanceContainerImpl(id().append(RelativeUriId.of("instances")));
    }
}
