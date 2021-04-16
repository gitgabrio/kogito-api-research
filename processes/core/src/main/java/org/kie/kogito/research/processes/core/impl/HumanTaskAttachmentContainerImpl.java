package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.api.RelativeId;
import org.kie.kogito.research.application.core.AbstractAddressableFactory;
import org.kie.kogito.research.application.core.RelativeUriId;
import org.kie.kogito.research.processes.api.HumanTaskAttachment;
import org.kie.kogito.research.processes.api.HumanTaskAttachmentContainer;
import org.kie.kogito.research.processes.api.HumanTaskAttachmentData;

public class HumanTaskAttachmentContainerImpl extends AbstractAddressableFactory<HumanTaskAttachment, HumanTaskAttachmentData> implements HumanTaskAttachmentContainer {

    public HumanTaskAttachmentContainerImpl(Id id) {
        super(id, "attachments");
    }

    public HumanTaskAttachment create0(HumanTaskAttachmentData attachmentData) {
        var id = id().append(RelativeUriId.random());
        System.out.printf("CREATE: %s -- %s\n", id, attachmentData);
        return new HumanTaskAttachmentImpl(id, attachmentData);
    }

    @Override
    public HumanTaskAttachment get(RelativeId unitId) {
        return create0(new HumanTaskAttachmentDataImpl("MOCK " + unitId));
    }
}
