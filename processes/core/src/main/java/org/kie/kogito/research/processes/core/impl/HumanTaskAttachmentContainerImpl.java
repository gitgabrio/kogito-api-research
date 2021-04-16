package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.core.AbstractAddressableContainer;
import org.kie.kogito.research.processes.api.HumanTaskAttachment;
import org.kie.kogito.research.processes.api.HumanTaskAttachmentContainer;

public class HumanTaskAttachmentContainerImpl extends AbstractAddressableContainer<HumanTaskAttachment> implements HumanTaskAttachmentContainer {

    public HumanTaskAttachmentContainerImpl(Id id) {
        super(id, "attachments");
    }

    public void create() {
        System.out.println("CREATE: " + this.id());
    }

    public void update(HumanTaskAttachment attachment) {
        System.out.println("UPDATE: " + attachment.id());
    }

    public void delete(Id id) {
        System.out.println("DELETE: " + id);
    }

}
