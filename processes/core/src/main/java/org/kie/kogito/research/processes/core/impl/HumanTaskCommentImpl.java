package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.api.RelativeId;
import org.kie.kogito.research.application.core.UriId;
import org.kie.kogito.research.processes.api.HumanTaskComment;
import org.kie.kogito.research.processes.api.HumanTaskCommentData;

public class HumanTaskCommentImpl implements HumanTaskComment {
    private final Id id;
    private final HumanTaskCommentDataImpl data;

    public HumanTaskCommentImpl(Id parent, RelativeId id, String data) {
        this.id = UriId.of(parent, id);
        this.data = new HumanTaskCommentDataImpl(data);
    }

    public Id id() {
        return id;
    }

    public HumanTaskCommentData data() {
        return data;
    }
}
