package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.core.UriUnitId;

public class HumanTaskAttachmentContainer {
    private final Id id;

    public HumanTaskAttachmentContainer(Id id) {
        this.id = new UriUnitId(id, "attachments");
    }

    public void create() {
        System.out.println("CREATE: " + this.id);
    }
    public void update(HumanTaskAttachment attachment) {
        System.out.println("CREATE: " + id + "/" + attachment.id());

    }
    public void delete(String id) {
        System.out.println("CREATE: " + this.id + "/" +id);

    }

    public HumanTaskAttachment get(String id) {
        return null;
    }

}
