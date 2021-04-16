package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.processes.api.HumanTaskCommentData;

public class HumanTaskCommentDataImpl implements HumanTaskCommentData {
    private final String data;

    public HumanTaskCommentDataImpl(String data) {
        this.data = data;
    }

    public String data() {
        return data;
    }

}
