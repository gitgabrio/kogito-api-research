package org.kie.kogito.research.processes.core.impl;

import org.junit.jupiter.api.Test;
import org.kie.kogito.research.application.api.Context;
import org.kie.kogito.research.application.core.SimpleUnitId;
import org.kie.kogito.research.application.core.SimpleUnitInstanceId;
import org.kie.kogito.research.processes.api.*;
import org.kie.kogito.research.processes.api.Process;

public class ProcessApiTest {

    class Person implements Context {}

    @Test
    void test() {
        ProcessContainer processContainer = new ProcessContainerImpl(null);
        Process process = processContainer.get(SimpleUnitId.fromString("my-process-id"));
        ProcessInstance processInstance = process.createInstance(Person.class);
        Person processContext = processInstance.context(Person.class);
        TaskInstanceContainer taskContainer = processInstance.get(TaskInstanceContainer.class);
        TaskInstance taskInstance = taskContainer.get(SimpleUnitInstanceId.fromString("task-def"));
        Person taskContext = taskInstance.context(Person.class);


    }

}
