package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Addressable;
import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.api.RelativeId;
import org.kie.kogito.research.application.core.RelativeUriId;
import org.kie.kogito.research.processes.api.Process;
import org.kie.kogito.research.processes.api.ProcessContainer;
import org.kie.kogito.research.processes.api.ProcessInstance;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ProcessParserImpl {

    ProcessContainer processContainer;

    public ProcessParserImpl(ProcessContainer processContainer) {
        this.processContainer = processContainer;
    }


    Addressable parse(Id id) {
        ArrayList<RelativeId> segments = new ArrayList<>();
        while (id != null) {
            if (id.segment().toString().equals("kogito-app")) {
                id = id.parent();
                continue;
            }
            segments.add(id.segment());
            id = id.parent();
        }

        Collections.reverse(segments);
        return processes(segments);
    }

    Addressable processes(List<RelativeId> rest) {
        var fragment = rest.remove(0);
        if (fragment.equals(processContainer.id().segment())) {
            return instanceId(processContainer.get(rest.remove(0)), rest);
        }
        throw new IllegalArgumentException("expected '/processes', found: " + fragment);
    }

    Addressable instanceId(Process process, List<RelativeId> rest) {
        if (rest.isEmpty()) return process;
        else if (rest.remove(0).equals(process.instances().id().segment())) {
            return nested(process.instances().get(rest.remove(0)), rest);
        } else {
            throw new IllegalArgumentException("expected /processes/<id>/instances/<id>, found: " + rest);
        }
    }

    private Addressable nested(ProcessInstance processInstance, List<RelativeId> rest) {
        if (!rest.isEmpty()) {
            throw new UnsupportedOperationException("cannot parse further: " + rest);
        }
        return processInstance;
    }


}
