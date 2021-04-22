package org.kie.kogito.research.processes.core.tasks.impl;

import org.kie.kogito.research.processes.api.tasks.HumanTaskCommentData;

public class HumanTaskCommentDataImpl implements HumanTaskCommentData {
    private final String data;

    public HumanTaskCommentDataImpl(String data) {
        this.data = data;
    }

    public String data() {
        return data;
    }

    @Override
    public String toString() {
        return "HumanTaskCommentDataImpl{" +
                "data='" + data + '\'' +
                '}';
    }
}
