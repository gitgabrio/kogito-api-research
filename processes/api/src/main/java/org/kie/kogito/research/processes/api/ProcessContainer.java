package org.kie.kogito.research.processes.api;

import org.kie.kogito.research.application.api.UnitContainer;
import org.kie.kogito.research.application.api.UnitId;

public interface ProcessContainer extends UnitContainer {

    @Override Process get(UnitId unitId);
}
