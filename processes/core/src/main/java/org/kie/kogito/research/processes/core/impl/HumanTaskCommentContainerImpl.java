package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.api.RelativeId;
import org.kie.kogito.research.application.core.AbstractAddressableFactory;
import org.kie.kogito.research.application.core.RelativeUriId;
import org.kie.kogito.research.processes.api.HumanTaskComment;
import org.kie.kogito.research.processes.api.HumanTaskCommentContainer;
import org.kie.kogito.research.processes.api.HumanTaskCommentData;

public class HumanTaskCommentContainerImpl extends AbstractAddressableFactory<HumanTaskComment, HumanTaskCommentData> implements HumanTaskCommentContainer {

    public HumanTaskCommentContainerImpl(Id id) {
        super(id, "comments");
    }

    @Override
    public HumanTaskComment create0(HumanTaskCommentData ctx) {
        var id = id().append(RelativeUriId.random());
        System.out.printf("CREATE: %s -- %s\n", id, ctx);
        return new HumanTaskCommentImpl(id(), RelativeUriId.random(), ctx);
    }

    @Override
    public HumanTaskComment get(RelativeId unitId) {
        return create0(new HumanTaskCommentDataImpl("MOCK " + unitId));
    }
}
