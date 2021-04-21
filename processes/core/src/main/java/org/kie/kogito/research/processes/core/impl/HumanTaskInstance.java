package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.core.AbstractAddressable;
import org.kie.kogito.research.application.core.RelativeUriId;
import org.kie.kogito.research.processes.api.HumanTaskAttachmentContainer;
import org.kie.kogito.research.processes.api.HumanTaskCommentContainer;
import org.kie.kogito.research.processes.api.TaskInstance;

public class HumanTaskInstance extends AbstractAddressable implements TaskInstance {

    public HumanTaskInstance(Id id) {
        super(id);
    }

    @Override
    public <I extends TaskInstance> I as(Class<I> cls) {
        return cls.cast(this);
    }

    public HumanTaskCommentContainer comments() {
        return new HumanTaskCommentContainerImpl(id().append(RelativeUriId.of("comments")));
    }

    public HumanTaskAttachmentContainer attachments() {
        return new HumanTaskAttachmentContainerImpl(id().append(RelativeUriId.of("attachments")));
    }

}
