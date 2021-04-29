package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Addressable;
import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.api.RelativeId;
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
        while (id != null) {
            if (id.segment().toString().equals("kogito-app")) {
                id = id.parent();
                continue;
            }
            segments.add(id.segment());
            id = id.parent();
        }

        Collections.reverse(segments);
        return parse(segments);
    }


    Addressable parse(List<RelativeId> rest) {
        Addressable addressable = null;
        int index = -1;
        try {
            // /processes
            var processes = rest.get(++index);
            expect(processContainer.id().segment(), processes);
            addressable = processContainer;

            // /processes/$process_id
            var processId = rest.get(++index);
            var process = processContainer.get(processId);
            expect(process.id().segment(), processId);
            addressable = process;

            // /processes/$process_id/instances
            var instances = rest.get(++index);
            var processInstances = process.instances();
            expect(processInstances.id().segment(), instances);
            addressable = processInstances;

            // /processes/$process_id/instances/$process_instance_id
            var processInstanceId = rest.get(++index);
            var processInstance = processInstances.get(processInstanceId);
            expect(processInstance.id().segment(), processInstanceId);
            addressable = processInstance;

            return addressable;

        } catch (IndexOutOfBoundsException e) {
            if (rest.size() == index) {
                return addressable;
            } else {
                throw new IllegalArgumentException(e);
            }
        } catch (ParserException e) {
            throw new IllegalArgumentException(e);
        }

    }


    void expect(RelativeId expected, RelativeId given) throws ParserException {
        if (!expected.equals(given)) {
            throw new ParserException(expected, given);
        }
    }


}

class ParserException extends Exception {

    private final RelativeId expected;
    private final RelativeId given;

    public ParserException(RelativeId expected, RelativeId given) {
        super("expected '" + expected + "', given: " + given);
        this.expected = expected;
        this.given = given;
    }
}