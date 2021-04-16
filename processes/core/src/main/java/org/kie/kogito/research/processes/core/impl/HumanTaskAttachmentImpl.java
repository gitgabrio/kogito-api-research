package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.processes.api.HumanTaskAttachment;

public class HumanTaskAttachmentImpl implements HumanTaskAttachment {
    private final Id id;
    private final String info;

    public HumanTaskAttachmentImpl(Id id, String info) {
        this.id = id;
        this.info = info;
    }

    public Id id() {
        return id;
    }

    public String info() {
        return info;
    }
}
