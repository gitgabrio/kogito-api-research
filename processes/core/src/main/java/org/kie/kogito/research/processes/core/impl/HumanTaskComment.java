package org.kie.kogito.research.processes.core.impl;

public class HumanTaskComment {
    private final String id;
    private final String info;

    public HumanTaskComment(String id, String info) {
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
