package org.kie.kogito.research.processes.api;

import org.kie.kogito.research.application.api.AddressableContainer;
import org.kie.kogito.research.application.api.Id;

public interface HumanTaskAttachmentContainer extends AddressableContainer<HumanTaskAttachment> {
    void create();

    void update(HumanTaskAttachment humanTaskAttachment);

    void delete(Id id);
}
