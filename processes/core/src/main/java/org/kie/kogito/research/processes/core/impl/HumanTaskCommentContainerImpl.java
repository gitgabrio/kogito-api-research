package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.api.RelativeId;
import org.kie.kogito.research.application.core.AbstractAddressableContainer;
import org.kie.kogito.research.processes.api.HumanTaskComment;
import org.kie.kogito.research.processes.api.HumanTaskCommentContainer;
import org.kie.kogito.research.processes.api.HumanTaskCommentData;

public class HumanTaskCommentContainerImpl extends AbstractAddressableContainer<HumanTaskComment> implements HumanTaskCommentContainer {

    public HumanTaskCommentContainerImpl(Id id) {
        super(id, "comments");
    }

    public void create() {
        System.out.println("CREATE: " + id());
    }

    public void update(RelativeId id, HumanTaskCommentData comment) {
        System.out.printf("UPDATE: %s -- %s\n", id().append(id), comment);
    }

    public void delete(RelativeId id) {
        System.out.println("DELETE: " + this.id().append(id));
    }

}
