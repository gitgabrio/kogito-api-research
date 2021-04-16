package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.api.RelativeId;
import org.kie.kogito.research.application.core.AbstractAddressableContainer;
import org.kie.kogito.research.processes.api.HumanTaskAttachment;
import org.kie.kogito.research.processes.api.HumanTaskAttachmentContainer;
import org.kie.kogito.research.processes.api.HumanTaskAttachmentData;

public class HumanTaskAttachmentContainerImpl extends AbstractAddressableContainer<HumanTaskAttachment> implements HumanTaskAttachmentContainer {

    public HumanTaskAttachmentContainerImpl(Id id) {
        super(id, "attachments");
    }

    public void create() {
        System.out.println("CREATE: " + this.id());
    }

    public void update(RelativeId id, HumanTaskAttachmentData data) {
        System.out.println("UPDATE: " + id().append(id));
    }

    public void delete(RelativeId id) {
        System.out.println("DELETE: " + this.id().append(id));
    }

}
