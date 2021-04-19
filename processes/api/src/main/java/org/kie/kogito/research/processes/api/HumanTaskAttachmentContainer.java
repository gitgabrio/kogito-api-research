package org.kie.kogito.research.processes.api;

import org.kie.kogito.research.application.api.AddressableContainer;
import org.kie.kogito.research.application.api.AddressableFactory;

public interface HumanTaskAttachmentContainer
        extends
        AddressableContainer<HumanTaskAttachment>,
        AddressableFactory<HumanTaskAttachment, HumanTaskAttachmentData> {
}
