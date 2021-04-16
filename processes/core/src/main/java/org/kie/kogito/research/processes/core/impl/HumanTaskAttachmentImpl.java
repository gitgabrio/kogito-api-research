package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.processes.api.HumanTaskAttachment;
import org.kie.kogito.research.processes.api.HumanTaskAttachmentData;

public class HumanTaskAttachmentImpl implements HumanTaskAttachment {
    private final Id id;
    private final HumanTaskAttachmentData info;

    public HumanTaskAttachmentImpl(Id id, HumanTaskAttachmentData info) {
        this.id = id;
        this.info = info;
    }

    public Id id() {
        return id;
    }

    public HumanTaskAttachmentData data() {
        return info;
    }

    public void update(HumanTaskAttachmentData humanTaskAttachment) {
        System.out.printf("UPDATE: %s -- %s\n", id(), humanTaskAttachment);
    }

    public void delete() {
        System.out.println("DELETE: " + this.id());
    }

}
