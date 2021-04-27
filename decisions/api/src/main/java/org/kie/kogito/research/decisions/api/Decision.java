package org.kie.kogito.research.decisions.api;

import org.kie.kogito.research.application.api.Addressable;
import org.kie.kogito.research.application.api.Evaluable;
import org.kie.kogito.research.application.api.Unit;

public interface Decision extends Unit, Addressable, Evaluable<Decision> {
    DecisionInstanceContainer instances();
}
