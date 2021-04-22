package org.kie.kogito.research.processes.core.tasks.impl;

import org.kie.kogito.research.processes.api.tasks.HumanTaskAttachmentData;

public class HumanTaskAttachmentDataImpl implements HumanTaskAttachmentData {
    final String data;

    public HumanTaskAttachmentDataImpl(String data) {
        this.data = data;
    }

    @Override
    public String data() {
        return data;
    }

    @Override
    public String toString() {
        return "HumanTaskAttachmentDataImpl{" +
                "data='" + data + '\'' +
                '}';
    }
}
