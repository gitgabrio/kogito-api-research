package org.kie.kogito.research.processes.core.tasks.impl;

import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.api.RelativeId;
import org.kie.kogito.research.application.core.AbstractAddressableContainer;
import org.kie.kogito.research.processes.api.tasks.HumanTaskAttachment;
import org.kie.kogito.research.processes.api.tasks.HumanTaskAttachmentContainer;

public class HumanTaskAttachmentContainerImpl extends AbstractAddressableContainer<HumanTaskAttachment> implements HumanTaskAttachmentContainer {

    public HumanTaskAttachmentContainerImpl(Id id) {
        super(id);
    }

    @Override
    public HumanTaskAttachment get(RelativeId unitId) {
        return new HumanTaskAttachmentImpl(id().append(unitId));
    }

}
