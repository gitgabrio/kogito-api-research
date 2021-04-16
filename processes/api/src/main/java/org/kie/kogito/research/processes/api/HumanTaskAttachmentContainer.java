package org.kie.kogito.research.processes.api;

import org.kie.kogito.research.application.api.AddressableContainer;
import org.kie.kogito.research.application.api.RelativeId;

public interface HumanTaskAttachmentContainer extends AddressableContainer<HumanTaskAttachment> {
    void create();

    void update(RelativeId id, HumanTaskAttachmentData humanTaskAttachment);

    void delete(RelativeId id);
}
