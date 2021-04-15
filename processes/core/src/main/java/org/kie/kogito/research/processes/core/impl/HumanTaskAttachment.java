package org.kie.kogito.research.processes.core.impl;

public class HumanTaskAttachment {
    private final String id;
    private final String info;

    public HumanTaskAttachment(String id, String info) {
        this.id = id;
        this.info = info;
    }

    public String id() {
        return id;
    }

    public String info() {
        return info;
    }
}
