package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Addressable;
import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.core.UriUnitId;

public class HumanTaskComment implements Addressable {
    private final UriUnitId id;
    private final String info;

    public HumanTaskComment(Id parentId, String id, String info) {
        this.id = new UriUnitId(parentId, id);
        this.info = info;
    }

    public Id id() {
        return id;
    }

    public String info() {
        return info;
    }
}
