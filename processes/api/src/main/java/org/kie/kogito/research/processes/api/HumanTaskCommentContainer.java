package org.kie.kogito.research.processes.api;

import org.kie.kogito.research.application.api.AddressableContainer;
import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.api.RelativeId;

public interface HumanTaskCommentContainer extends AddressableContainer<HumanTaskComment> {
    void create();

    void update(RelativeId id, HumanTaskCommentData commentData);

    void delete(RelativeId id);
}
