package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.Addressable;
import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.api.RelativeId;
import org.kie.kogito.research.processes.api.ProcessContainer;

import java.util.List;

public class ProcessParserImpl {

    ProcessContainer processContainer;

    public ProcessParserImpl(ProcessContainer processContainer) {
        this.processContainer = processContainer;
    }


    Addressable parse(Id id) {
        List<RelativeId> segments = id.segments();
        Addressable addressable = null;
        int index = -1;
        try {
            // /processes
            var processes = segments.get(++index);
            expect(processContainer.id().segment(), processes);
            addressable = processContainer;

            // /processes/$process_id
            var processId = segments.get(++index);
            var process = processContainer.get(processId);
            expect(process.id().segment(), processId);
            addressable = process;

            // /processes/$process_id/instances
            var instances = segments.get(++index);
            var processInstances = process.instances();
            expect(processInstances.id().segment(), instances);
            addressable = processInstances;

            // /processes/$process_id/instances/$process_instance_id
            var processInstanceId = segments.get(++index);
            var processInstance = processInstances.get(processInstanceId);
            expect(processInstance.id().segment(), processInstanceId);
            addressable = processInstance;

            return addressable;

        } catch (IndexOutOfBoundsException e) {
            if (segments.size() == index) {
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