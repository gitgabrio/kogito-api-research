package org.kie.kogito.research.processes.api;

import org.kie.kogito.research.application.api.Addressable;

public interface HumanTaskComment extends Addressable {
    void update(HumanTaskCommentData humanTaskCommentData);

    void delete();
}
