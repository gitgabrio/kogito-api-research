package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.core.AbstractAddressableContainer;
import org.kie.kogito.research.processes.api.HumanTaskComment;
import org.kie.kogito.research.processes.api.HumanTaskCommentContainer;

public class HumanTaskCommentContainerImpl extends AbstractAddressableContainer<HumanTaskComment> implements HumanTaskCommentContainer {

    public HumanTaskCommentContainerImpl(Id id) {
        super(id, "comments");
    }

    public void create() {
        System.out.println("CREATE: " + id());
    }

    public void update(HumanTaskComment comment) {
        System.out.printf("UPDATE: %s -- %s\n", id(), comment);
    }

    public void delete(Id id) {
        System.out.println("DELETE: " + id);
    }

}
