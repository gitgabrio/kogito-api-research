package org.kie.kogito.research.processes.core.impl;

import org.junit.jupiter.api.Test;
import org.kie.kogito.research.application.api.Context;
import org.kie.kogito.research.application.api.RelativeId;
import org.kie.kogito.research.application.api.v2.Application;
import org.kie.kogito.research.application.core.RelativeUriId;
import org.kie.kogito.research.application.core.UriId;
import org.kie.kogito.research.processes.api.Process;
import org.kie.kogito.research.processes.api.TaskInstance;
import org.kie.kogito.research.processes.api.v2.Processes;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class ProcessApiTestV2 {

    class Person implements Context {
    }

    class OutputModel implements Context {
    }

    @Test
    void pathBuilder() {
        RelativeId processId = RelativeUriId.of("my-process-id");
        RelativeId instanceId = RelativeUriId.of("fake-instance-id");
        RelativeId taskInstanceId = RelativeUriId.of("fake-task-instance-id");
        var application = new Application();

        application.forCatalog(Processes.type)
                .get(processId)
                .forCatalog(Processes.instances)
                .get(instanceId)
                .forCatalog(Processes.tasks)
                .get(taskInstanceId)
                .resolve();

        application.forCatalog(Processes.type)
                .get(processId)
                .forCatalog(Processes.instances)
                .get(instanceId)
                .forCatalog(Processes.tasks)
                .get()
                .resolve();

        application.forCatalog(Processes.type)
                .get(processId)
                .forCatalog(Processes.instances)
                .get(instanceId)
                .factoryOf(Processes.tasks)
                .get()
                .resolve()
                .create(new Person());


        ///   / processes / my.process / instances / 9483784279384732 / tasks / 888888888
        ///   / tasks    / my-task / instances /  888888888


        ///   / tasks    / my-task / instances /  888888888



        ///   abort [ / processes      /  my.process / instances / 8437483743982
        ///             Process           @Named        ProcessInstance    @Named ... ?


    }


}
