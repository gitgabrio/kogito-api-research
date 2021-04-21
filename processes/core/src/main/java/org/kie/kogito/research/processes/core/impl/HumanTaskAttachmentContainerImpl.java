package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.core.AbstractAddressableContainer;
import org.kie.kogito.research.processes.api.HumanTaskAttachment;
import org.kie.kogito.research.processes.api.HumanTaskAttachmentContainer;

public class HumanTaskAttachmentContainerImpl extends AbstractAddressableContainer<HumanTaskAttachment> implements HumanTaskAttachmentContainer {

    public HumanTaskAttachmentContainerImpl(Id id) {
        super(id);
    }

    public HumanTaskAttachment create(Id id) {
        return new HumanTaskAttachmentImpl(id);
    }

}
