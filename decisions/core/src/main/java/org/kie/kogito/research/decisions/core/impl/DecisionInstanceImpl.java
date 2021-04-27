package org.kie.kogito.research.decisions.core.impl;

import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.core.AbstractAddressable;
import org.kie.kogito.research.decisions.api.DecisionInstance;

public class DecisionInstanceImpl extends AbstractAddressable implements DecisionInstance {

    public DecisionInstanceImpl(Id id) {
        super(id);
    }

}
