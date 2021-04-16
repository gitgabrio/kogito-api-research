package org.kie.kogito.research.processes.core.impl;

import org.junit.jupiter.api.Test;
import org.kie.kogito.research.application.api.Application;
import org.kie.kogito.research.application.api.Context;
import org.kie.kogito.research.application.api.RelativeId;
import org.kie.kogito.research.application.core.RelativeUriId;
import org.kie.kogito.research.application.core.SimpleUnitContainer;
import org.kie.kogito.research.application.core.UriId;
import org.kie.kogito.research.processes.api.Process;

public class ProcessApiTest {

    class Person implements Context {}

    class OutputModel implements Context {}

    @Test
    void test() {
        RelativeId processId = RelativeUriId.of("my-process-id");
        RelativeId instanceId;
        RelativeId taskInstanceId = RelativeUriId.of("some-task");

        Application app = new TestApp();
        var processContainer = app.get(Process.class);

        var pc = (SimpleUnitContainer<Process>) processContainer;
        pc.register(processId, new ProcessImpl(UriId.of(app.id(), processId)));

        // createProcessInstance
        {
            var processInstance = processContainer
                    .get(processId)
                    .instances()
                    .create(new Person());
            instanceId = processInstance.id().segment();

            processInstance.start();
        }

        // getProcessInstanceOutput + findById
        OutputModel variables = processContainer.get(processId)
                .instances()
                .get(instanceId)
                .context(OutputModel.class);

        // delete
        {
            var processInstance = processContainer.get(processId)
                    .instances()
                    .get(instanceId);
            processInstance.abort();
            Person result = processInstance.context(Person.class);// how to let these stick around?
        }

        // update
        {
            var processInstance = processContainer.get(processId)
                    .instances()
                    .get(instanceId);
            processInstance
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
                .get(TaskInstanceContainer.class);

        // signalTasks
        processContainer.get(processId)
                .instances()
                .get(instanceId)
                .get(TaskInstanceContainer.class)
                .get(taskInstanceId)
                .send(new SignalEvent());

        // getTaskByName
        processContainer.get(processId)
                .instances()
                .get(instanceId)
                .get(TaskInstanceContainer.class)
                .get(taskInstanceId); // note: should be taskId !

        // completeTask
        {
            // policies
            processContainer.get(processId)
                    .instances()
                    .get(instanceId)
                    .get(TaskInstanceContainer.class)
                    .get(taskInstanceId)// note: should be taskId !
                    .complete(new OutputModel());
        }


        // saveTask
        {
            // policies
            processContainer.get(processId)
                    .instances()
                    .get(instanceId)
                    .get(TaskInstanceContainer.class)
                    .get(taskInstanceId)// note: should be taskId !
                    .save(new OutputModel());
        }

        // taskTransition
        {
            // policies
            processContainer.get(processId)
                    .instances()
                    .get(instanceId)
                    .get(TaskInstanceContainer.class)
                    .get(taskInstanceId)// note: should be taskId !
                    .transition(
                            new OutputModel(),
                            "some-phase");
        }

        // getTask
        OutputModel output = processContainer.get(processId)
                .instances()
                .get(instanceId)
                .get(TaskInstanceContainer.class)
                .get(taskInstanceId)// note: should be taskId !
                .context(OutputModel.class);

        // abortTask
        {
            // policies
            processContainer.get(processId)
                    .instances()
                    .get(instanceId)
                    .get(TaskInstanceContainer.class)
                    .get(taskInstanceId)// note: should be taskId !
                    .abort("some-phase");
        }

        // -------------- comments --------------

        var commentContainerId = processContainer.get(processId)
                .instances()
                .get(instanceId)
                .get(TaskInstanceContainer.class)
                .get(taskInstanceId)
                .as(HumanTaskInstance.class)
                .comments().id();


        // add comment
        processContainer.get(processId)
                .instances()
                .get(instanceId)
                .get(TaskInstanceContainer.class)
                .get(taskInstanceId)
                .as(HumanTaskInstance.class)
                .comments()
                .create();

        // update comment
        processContainer.get(processId)
                .instances()
                .get(instanceId)
                .get(TaskInstanceContainer.class)
                .get(taskInstanceId)
                .as(HumanTaskInstance.class)
                .comments()
                .update(RelativeUriId.of("some-comment"), new HumanTaskCommentDataImpl("info..."));

        // delete comment
        processContainer.get(processId)
                .instances()
                .get(instanceId)
                .get(TaskInstanceContainer.class)
                .get(taskInstanceId)
                .as(HumanTaskInstance.class)
                .comments()
                .delete(RelativeUriId.of("some-id"));

        // getComment
        processContainer.get(processId)
                .instances()
                .get(instanceId)
                .get(TaskInstanceContainer.class)
                .get(taskInstanceId)
                .as(HumanTaskInstance.class)
                .comments()
                .get(RelativeUriId.of("some-id"));

        // getComments
        processContainer.get(processId)
                .instances()
                .get(instanceId)
                .get(TaskInstanceContainer.class)
                .get(taskInstanceId)
                .as(HumanTaskInstance.class)
                .comments();


        // -------------- attachments --------------

        var attachContainerId =
                processContainer.get(processId)
                        .instances()
                        .get(instanceId)
                        .get(TaskInstanceContainer.class)
                        .get(taskInstanceId)
                        .as(HumanTaskInstance.class)
                        .attachments().id();

        // add
        processContainer.get(processId)
                .instances()
                .get(instanceId)
                .get(TaskInstanceContainer.class)
                .get(taskInstanceId)
                .as(HumanTaskInstance.class)
                .attachments()
                .create();

        // update attachment
        processContainer.get(processId)
                .instances()
                .get(instanceId)
                .get(TaskInstanceContainer.class)
                .get(taskInstanceId)
                .as(HumanTaskInstance.class)
                .attachments()
                .update(RelativeUriId.of("some-id"), new HumanTaskAttachmentDataImpl("info..."));

        // delete attachment
        processContainer.get(processId)
                .instances()
                .get(instanceId)
                .get(TaskInstanceContainer.class)
                .get(taskInstanceId)
                .as(HumanTaskInstance.class)
                .attachments()
                .delete(RelativeUriId.of("some-id"));

        // getAttachment
        processContainer.get(processId)
                .instances()
                .get(instanceId)
                .get(TaskInstanceContainer.class)
                .get(taskInstanceId)
                .as(HumanTaskInstance.class)
                .attachments()
                .get(RelativeUriId.of("some-id"));

        // getAttachments
        processContainer.get(processId)
                .instances()
                .get(instanceId)
                .get(TaskInstanceContainer.class)
                .get(taskInstanceId)
                .as(HumanTaskInstance.class)
                .attachments();


        // get schema and phases
        processContainer.get(processId)
                .instances()
                .get(instanceId)
                .get(TaskInstanceContainer.class)
                .get(taskInstanceId);
//                .unit();  // asJsonSchema() ??


    }

}
