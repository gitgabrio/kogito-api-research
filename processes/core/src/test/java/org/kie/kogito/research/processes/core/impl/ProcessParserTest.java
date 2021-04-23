package org.kie.kogito.research.processes.core.impl;

import org.junit.jupiter.api.Test;
import org.kie.kogito.research.application.api.Addressable;
import org.kie.kogito.research.application.api.Application;
import org.kie.kogito.research.application.core.ApplicationImpl;
import org.kie.kogito.research.application.core.RelativeUriId;
import org.kie.kogito.research.application.core.UriId;
import org.kie.kogito.research.processes.api.ProcessContainer;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProcessParserTest {
    Application application = new ApplicationImpl();
    ProcessParserImpl processParser = new ProcessParserImpl(application.get(ProcessContainer.class));


    @Test
    void testProcess() {
        var id = UriId.parse("kogito://kogito-app/processes/my-process");
        var addressable = processParser.parse(id);

        assertEquals(
                application.get(ProcessContainer.class).get(RelativeUriId.of("my-process")).id(),
                addressable.id());
    }


    @Test
    void testProcessInstance() {
        var id = UriId.parse("kogito://kogito-app/processes/my-process/instances/1234567");
        var addressable = processParser.parse(id);

        assertEquals(
                application.get(ProcessContainer.class)
                        .get(RelativeUriId.of("my-process"))
                        .instances()
                        .get(RelativeUriId.of("1234567"))
                        .id(),
                addressable.id());
    }
}
