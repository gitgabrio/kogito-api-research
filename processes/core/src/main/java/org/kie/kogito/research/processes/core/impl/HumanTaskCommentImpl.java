package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.core.UriUnitId;
import org.kie.kogito.research.processes.api.HumanTaskComment;

public class HumanTaskCommentImpl implements HumanTaskComment {
    private final UriUnitId id;
    private final String info;

    public HumanTaskCommentImpl(Id parentId, String id, String info) {
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
