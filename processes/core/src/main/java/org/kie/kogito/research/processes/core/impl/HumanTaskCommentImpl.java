package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.api.RelativeId;
import org.kie.kogito.research.application.core.UriId;
import org.kie.kogito.research.processes.api.HumanTaskComment;
import org.kie.kogito.research.processes.api.HumanTaskCommentData;

public class HumanTaskCommentImpl implements HumanTaskComment {
    private final Id id;
    private final HumanTaskCommentData data;

    public HumanTaskCommentImpl(Id parent, RelativeId id, HumanTaskCommentData data) {
        this.id = UriId.of(parent, id);
        this.data = data;
    }

    public Id id() {
        return id;
    }

    public HumanTaskCommentData data() {
        return data;
    }


    public void update(HumanTaskCommentData comment) {
        System.out.printf("UPDATE: %s -- %s\n", id(), comment);
    }

    public void delete() {
        System.out.println("DELETE: " + this.id());
    }


}
