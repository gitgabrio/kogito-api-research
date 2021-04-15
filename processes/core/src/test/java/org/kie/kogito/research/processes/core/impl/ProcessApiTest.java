package org.kie.kogito.research.processes.core.impl;

import org.junit.jupiter.api.Test;
import org.kie.kogito.research.application.api.Context;
import org.kie.kogito.research.application.core.SimpleUnitId;
import org.kie.kogito.research.application.core.SimpleUnitInstanceId;
import org.kie.kogito.research.processes.api.*;

import java.util.List;

public class ProcessApiTest {

    class Person implements Context {}
    class OutputModel implements Context {}

    @Test
    void test() {
        var processId = SimpleUnitId.fromString("my-process-id");
        var instanceId = SimpleUnitInstanceId.fromString("some-instance-id");

        ProcessContainer processContainer =
                new ProcessContainerImpl(null);
        var taskInstanceId = SimpleUnitInstanceId.fromString("task-def");

        // createProcessInstance
        {
            processContainer
                    .get(processId)
                    .instances()
                    .create(new Person())
                    .start();
        }

        // getProcessInstanceOutput + findById
        OutputModel variables = processContainer.get(processId)
                .instances()
                .get(instanceId)
                .variables(OutputModel.class);

        // delete
        {
            var processInstance = processContainer.get(processId)
                    .instances()
                    .get(instanceId);
            processInstance.abort();
            Person result = processInstance.variables(Person.class);// how to let these stick around?
        }

        // update
        {
            var processInstance = processContainer.get(processId)
                    .instances()
                    .get(instanceId);
            var updated = processInstance
                    .update(new Person(/* ... */));

            OutputModel outputModel = processInstance.context(OutputModel.class);
        }

        // signalProcessInstance
        processContainer.get(processId)
                .instances()
                .get(instanceId)
                .send(new SignalEvent());

        // get tasks
        processContainer.get(processId)
                .instances()
                .get(instanceId)
                .tasks();

        // signalTasks
        processContainer.get(processId)
                .instances()
                .get(instanceId)
                .tasks()
                .get(taskInstanceId)
                .send(new SignalEvent());

        // getTaskByName
        processContainer.get(processId)
                .instances()
                .get(instanceId)
                .tasks()
                .get(taskInstanceId); // note: should be taskId !

        // completeTask
        {
            // policies
            processContainer.get(processId)
                    .instances()
                    .get(instanceId)
                    .tasks()
                    .get(taskInstanceId)// note: should be taskId !
                    .complete(new OutputModel());
        }


        // saveTask
        {
            // policies
            processContainer.get(processId)
                    .instances()
                    .get(instanceId)
                    .tasks()
                    .get(taskInstanceId)// note: should be taskId !
                    .save(new OutputModel());
        }

        // taskTransition
        {
            // policies
            processContainer.get(processId)
                    .instances()
                    .get(instanceId)
                    .tasks()
                    .get(taskInstanceId)// note: should be taskId !
                    .transition(
                            new OutputModel(),
                            "some-phase");
        }

        // getTask
        OutputModel output = processContainer.get(processId)
                .instances()
                .get(instanceId)
                .tasks()
                .get(taskInstanceId)// note: should be taskId !
                .context(OutputModel.class);

        // abortTask
        {
            // policies
            processContainer.get(processId)
                    .instances()
                    .get(instanceId)
                    .tasks()
                    .get(taskInstanceId)// note: should be taskId !
                    .abort("some-phase");
        }

        // -------------- comments --------------


        // add comment
        processContainer.get(processId)
                .instances()
                .get(instanceId)
                .tasks()
                .get(taskInstanceId)
                .as(HumanTaskInstance.class)
                .comments()
                .create();

        // update comment
        processContainer.get(processId)
                .instances()
                .get(instanceId)
                .tasks()
                .get(taskInstanceId)
                .as(HumanTaskInstance.class)
                .comments()
                .update(new HumanTaskComment("id", "info..."));

        // delete comment
        processContainer.get(processId)
                .instances()
                .get(instanceId)
                .tasks()
                .get(taskInstanceId)
                .as(HumanTaskInstance.class)
                .comments()
                .delete("some-id");

        // getComment
        processContainer.get(processId)
                .instances()
                .get(instanceId)
                .tasks()
                .get(taskInstanceId)
                .as(HumanTaskInstance.class)
                .comments()
                .get("some-id");

        // getComments
        processContainer.get(processId)
                .instances()
                .get(instanceId)
                .tasks()
                .get(taskInstanceId)
                .as(HumanTaskInstance.class)
                .comments();


        // -------------- attachments --------------


        // add
        processContainer.get(processId)
                .instances()
                .get(instanceId)
                .tasks()
                .get(taskInstanceId)
                .as(HumanTaskInstance.class)
                .attachments()
                .create();

        // update attachment
        processContainer.get(processId)
                .instances()
                .get(instanceId)
                .tasks()
                .get(taskInstanceId)
                .as(HumanTaskInstance.class)
                .attachments()
                .update(new HumanTaskAttachment("id", "info..."));

        // delete attachment
        processContainer.get(processId)
                .instances()
                .get(instanceId)
                .tasks()
                .get(taskInstanceId)
                .as(HumanTaskInstance.class)
                .comments()
                .delete("some-id");

        // getAttachment
        processContainer.get(processId)
                .instances()
                .get(instanceId)
                .tasks()
                .get(taskInstanceId)
                .as(HumanTaskInstance.class)
                .comments()
                .get("some-id");

        // getAttachments
        processContainer.get(processId)
                .instances()
                .get(instanceId)
                .tasks()
                .get(taskInstanceId)
                .as(HumanTaskInstance.class)
                .attachments();


        // get schema and phases
        processContainer.get(processId)
                .instances()
                .get(instanceId)
                .tasks()
                .get(taskInstanceId)
                .unit();  // asJsonSchema() ??



    }

}
