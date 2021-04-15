package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.core.UriUnitId;

public class HumanTaskCommentContainer {
    private final Id id;

    public HumanTaskCommentContainer(Id id) {
        this.id = new UriUnitId(id, "comments");
    }

    public void create() {
        System.out.println("CREATE: " + id);
    }

    public void update(HumanTaskComment comment) {
        System.out.printf("UPDATE: %s -- %s\n", id, comment);
    }

    public void delete(String id) {
        System.out.println("DELETE: " + this.get(id).id());
    }

    public HumanTaskComment get(String id) {
        return new HumanTaskComment(this.id, id, "default");
    }

}
