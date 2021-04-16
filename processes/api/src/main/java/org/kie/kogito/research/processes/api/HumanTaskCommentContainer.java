package org.kie.kogito.research.processes.api;

import org.kie.kogito.research.application.api.AddressableContainer;
import org.kie.kogito.research.application.api.Id;

public interface HumanTaskCommentContainer extends AddressableContainer<HumanTaskComment> {
    void create();

    void update(HumanTaskComment humanTaskAttachment);

    void delete(Id id);
}
