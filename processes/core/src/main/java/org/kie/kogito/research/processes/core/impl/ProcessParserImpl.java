package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Addressable;
import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.api.RelativeId;
import org.kie.kogito.research.application.core.RelativeUriId;
import org.kie.kogito.research.processes.api.ProcessContainer;

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
        Id root = null;
        while (id != null) {
            if (id.segment().toString().equals("kogito-app")) {
                root = id;
                id = id.parent();
                continue;
            }
            segments.add(id.segment());
            id = id.parent();
        }


        Collections.reverse(segments);
        return processes(root, segments);
    }

    Addressable processes(Id root, List<RelativeId> rest) {
        var fragment = rest.remove(0);
        if (fragment.equals(RelativeUriId.of("processes"))) {
            return processId(root.append(fragment), rest);
        }
        throw new IllegalArgumentException("expected 'processes', found: " + fragment);
    }

    Addressable processId(Id partial, List<RelativeId> rest) {
        var processId = rest.remove(0);
        partial = partial.append(processId);
        if (rest.isEmpty()) {
            return new ProcessImpl(partial);
        } else {
            return instances(partial, rest);
        }
    }

    Addressable instances(Id partial, List<RelativeId> rest) {
        var processId = rest.remove(0);
        partial = partial.append(processId);
        if (rest.isEmpty()) {
            return new ProcessInstanceContainerImpl(partial);
        } else {
            return instanceId(partial, rest);
        }
    }

    Addressable instanceId(Id partial, List<RelativeId> rest) {
        var processId = rest.remove(0);
        partial = partial.append(processId);
        if (rest.isEmpty()) {
            return new ProcessInstanceImpl(partial);
        } else {
            throw new UnsupportedOperationException("Cannot parse rest: " + rest);
        }
    }


}
