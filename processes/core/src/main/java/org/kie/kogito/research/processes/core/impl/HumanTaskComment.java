package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.core.UriUnitId;

public class HumanTaskComment {
    private final UriUnitId id;
    private final String info;

    public HumanTaskComment(Id parentId, String id, String info) {
        this.id = new UriUnitId( parentId, id);
        this.info = info;
    }

    public String id() {
        return id.toString();
    }

    public String info() {
        return info;
    }
}
