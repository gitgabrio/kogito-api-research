package org.kie.kogito.research.processes.core.tasks.impl;

import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.core.AbstractAddressableContainer;
import org.kie.kogito.research.processes.api.tasks.HumanTaskAttachment;
import org.kie.kogito.research.processes.api.tasks.HumanTaskAttachmentContainer;

public class HumanTaskAttachmentContainerImpl extends AbstractAddressableContainer<HumanTaskAttachment> implements HumanTaskAttachmentContainer {

    public HumanTaskAttachmentContainerImpl(Id id) {
        super(id);
    }

    public HumanTaskAttachment create(Id id) {
        return new HumanTaskAttachmentImpl(id);
    }

}
