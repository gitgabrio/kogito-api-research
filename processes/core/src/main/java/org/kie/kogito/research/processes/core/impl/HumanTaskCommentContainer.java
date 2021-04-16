package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.core.AbstractAddressableContainer;

public class HumanTaskCommentContainer extends AbstractAddressableContainer<HumanTaskComment> {

    public HumanTaskCommentContainer(Id id) {
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
