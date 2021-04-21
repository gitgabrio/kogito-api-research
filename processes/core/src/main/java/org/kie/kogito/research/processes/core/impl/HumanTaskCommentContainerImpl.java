package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.core.AbstractAddressableContainer;
import org.kie.kogito.research.processes.api.HumanTaskComment;
import org.kie.kogito.research.processes.api.HumanTaskCommentContainer;

public class HumanTaskCommentContainerImpl extends AbstractAddressableContainer<HumanTaskComment> implements HumanTaskCommentContainer {

    public HumanTaskCommentContainerImpl(Id id) {
        super(id);
    }

    @Override
    protected HumanTaskComment create(Id id) {
        return new HumanTaskCommentImpl(id);
    }
}
