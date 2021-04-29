package org.kie.kogito.research.processes.core.tasks.impl;

import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.api.RelativeId;
import org.kie.kogito.research.application.core.AbstractAddressableContainer;
import org.kie.kogito.research.processes.api.tasks.HumanTaskComment;
import org.kie.kogito.research.processes.api.tasks.HumanTaskCommentContainer;

public class HumanTaskCommentContainerImpl extends AbstractAddressableContainer<HumanTaskComment> implements HumanTaskCommentContainer {

    public HumanTaskCommentContainerImpl(Id id) {
        super(id);
    }

    @Override
    public HumanTaskComment get(RelativeId id) {
        return new HumanTaskCommentImpl(id().append(id));
    }

}
