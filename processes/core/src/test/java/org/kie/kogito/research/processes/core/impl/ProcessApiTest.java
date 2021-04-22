package org.kie.kogito.research.processes.core.impl;

import org.junit.jupiter.api.Test;
import org.kie.kogito.research.application.api.Application;
import org.kie.kogito.research.application.api.Context;
import org.kie.kogito.research.application.api.Instance;
import org.kie.kogito.research.application.api.RelativeId;
import org.kie.kogito.research.application.core.RelativeUriId;
import org.kie.kogito.research.processes.api.ProcessContainer;
import org.kie.kogito.research.processes.core.services.impl.ProcessService;
import org.kie.kogito.research.processes.core.services.impl.UnitService;
import org.kie.kogito.research.processes.core.tasks.impl.HumanTaskInstance;

public class ProcessApiTest {

    class Person implements Context {}

    class OutputModel implements Context {}

    @Test
    void test() {
        RelativeId processId = RelativeUriId.of("my-process-id");

        TestApp app = new TestApp();
        testApplication(app);
    }


    private void testApplication(Application app) {
        RelativeId processId = RelativeUriId.of("my-process-id");
        RelativeId instanceId = RelativeUriId.of("some-instance-id");
        RelativeId taskInstanceId = RelativeUriId.of("some-task");

        var processContainer = app.get(ProcessContainer.class);


        // generic
        {
            Instance instance = processContainer.get(processId)
                    .eval(UnitService.locally())
                    .start(new Person());

        }

        // createProcessInstance
        {
            var processInstance = processContainer
                    .get(processId)
                    .eval(ProcessService.local)
                    .start(new Person());

            var runnableProcess = processContainer
                    .get(processId)
                    .eval(ProcessService.async);
            var processInstance2 = runnableProcess
                    .start(new Person());


//                    .instances();
//                    .create(new Person());
            instanceId = processInstance.id().segment();

        }

        // getProcessInstanceOutput + findById
        OutputModel variables =
                processContainer.get(processId)
                .instances()
                .get(instanceId)
                .eval(ProcessService.localInstance)
                .context(OutputModel.class);

        // delete
        {
            var processInstance = processContainer.get(processId)
                    .instances()
                    .get(instanceId).eval(ProcessService.localInstance);
            processInstance.abort();
            Person result = processInstance.context(Person.class);// how to let these stick around?
        }

        // update
        {
            var processInstance = processContainer.get(processId)
                    .instances()
                    .get(instanceId).eval(ProcessService.localInstance);
            processInstance
                    .update(new Person(/* ... */));

            OutputModel outputModel = processInstance.context(OutputModel.class);
        }

        // signalProcessInstance
        processContainer.get(processId)
                .instances()
                .get(instanceId)
                .eval(ProcessService.localInstance)
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
                .eval(ProcessService.localTask)
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
                    .eval(ProcessService.localTask)
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
                    .eval(ProcessService.localTask)
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
                    .eval(ProcessService.localTask)
                    .transition(
                            new OutputModel(),
                            "some-phase");
        }

        // getTask
        OutputModel output =
                processContainer.get(processId)
                .instances()
                .get(instanceId)
                .tasks()
                .get(taskInstanceId)// note: should be taskId !
                .eval(ProcessService.localTask)
                .context(OutputModel.class);

        // abortTask
        {
            // policies
            processContainer.get(processId)
                    .instances()
                    .get(instanceId)
                    .tasks()
                    .get(taskInstanceId)// note: should be taskId !
                    .eval(ProcessService.localTask)
                    .abort("some-phase");
        }

        // -------------- comments --------------

        var commentContainerId = processContainer.get(processId)
                .instances()
                .get(instanceId)
                .tasks()
                .get(taskInstanceId)
                .as(HumanTaskInstance.class)
                .comments().id();

/*
        // add comment
        var commentId = processContainer.get(processId)
                .instances()
                .get(instanceId)
                .get(TaskInstance.class)
                .get(taskInstanceId)
                .as(HumanTaskInstance.class)
                .comments()
                .create(new HumanTaskCommentDataImpl("hello")).id().segment();

        // update comment
        processContainer.get(processId)
                .instances()
                .get(instanceId)
                .get(TaskInstance.class)
                .get(taskInstanceId)
                .as(HumanTaskInstance.class)
                .comments()
                .get(commentId)
                .update(new HumanTaskCommentDataImpl("info..."));

        // delete comment
        processContainer.get(processId)
                .instances()
                .get(instanceId)
                .get(TaskInstance.class)
                .get(taskInstanceId)
                .as(HumanTaskInstance.class)
                .comments()
                .get(commentId)
                .delete();
*/

        // getComment
        processContainer.get(processId)
                .instances()
                .get(instanceId)
                .tasks()
                .get(taskInstanceId)
                .as(HumanTaskInstance.class)
                .comments()
                .get(RelativeUriId.of("some-comment-id"));

        // getComments
        processContainer.get(processId)
                .instances()
                .get(instanceId)
                .tasks()
                .get(taskInstanceId)
                .as(HumanTaskInstance.class)
                .comments();

        // -------------- attachments --------------

        var attachContainerId =
                processContainer.get(processId)
                        .instances()
                        .get(instanceId)
                        .tasks()
                        .get(taskInstanceId)
                        .as(HumanTaskInstance.class)
                        .attachments().id();
/*

        // add
        processContainer.get(processId)
                .instances()
                .get(instanceId)
                .tasks()
                .get(taskInstanceId)
                .as(HumanTaskInstance.class)
                .attachments()
                .create(new HumanTaskAttachmentDataImpl("..."));

        // update attachment
        processContainer.get(processId)
                .instances()
                .get(instanceId)
                .get(TaskInstance.class)
                .get(taskInstanceId)
                .as(HumanTaskInstance.class)
                .attachments()
                .get(RelativeUriId.of("some-id"))
                .update(new HumanTaskAttachmentDataImpl("info..."));

        // delete attachment
        processContainer.get(processId)
                .instances()
                .get(instanceId)
                .get(TaskInstance.class)
                .get(taskInstanceId)
                .as(HumanTaskInstance.class)
                .attachments()
                .get(RelativeUriId.of("some-id"))
                .delete();

*/

        // getAttachment
        processContainer.get(processId)
                .instances()
                .get(instanceId)
                .tasks()
                .get(taskInstanceId)
                .as(HumanTaskInstance.class)
                .attachments()
                .get(RelativeUriId.of("some-id"));

        // getAttachments
        processContainer.get(processId)
                .instances()
                .get(instanceId)
                .tasks()
                .get(taskInstanceId)
                .as(HumanTaskInstance.class)
                .attachments();

/*
        // get schema and phases
        processContainer.get(processId)
                .instances()
                .get(instanceId)
                .get(TaskInstance.class)
                .get(taskInstanceId);
//                .unit();  // asJsonSchema() ??

*/    }


}
