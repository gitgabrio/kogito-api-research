package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Addressable;
import org.kie.kogito.research.application.api.Id;

public class HumanTaskAttachment implements Addressable {
    private final Id id;
    private final String info;

    public HumanTaskAttachment(Id id, String info) {
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
