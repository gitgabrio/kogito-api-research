package org.kie.kogito.research.processes.api;

import org.kie.kogito.research.application.api.Addressable;

public interface HumanTaskAttachment extends Addressable {
    void update(HumanTaskAttachmentData humanTaskAttachment);

    void delete();
}
