package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.core.AbstractAddressableContainer;

public class HumanTaskAttachmentContainer extends AbstractAddressableContainer<HumanTaskAttachment> {

    public HumanTaskAttachmentContainer(Id id) {
        super(id, "attachments");
    }

    public void create() {
        System.out.println("CREATE: " + this.id());
    }
    public void update(HumanTaskAttachment attachment) {
        System.out.println("CREATE: " + attachment.id());

    }
    public void delete(Id id) {
        System.out.println("CREATE: "  +id);

    }

}
