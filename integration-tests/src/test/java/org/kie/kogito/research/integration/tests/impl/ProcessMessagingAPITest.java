package org.kie.kogito.research.integration.tests.impl;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.jsontype.BasicPolymorphicTypeValidator;
import com.fasterxml.jackson.databind.jsontype.NamedType;
import com.fasterxml.jackson.databind.jsontype.PolymorphicTypeValidator;
import io.quarkus.test.common.QuarkusTestResource;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.ClassRule;
import org.junit.jupiter.api.Test;
import org.kie.kogito.research.application.api.Context;
import org.kie.kogito.research.application.api.Event;
import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.api.impl.SimpleId;
import org.kie.kogito.research.application.api.messages.RequestId;
import org.kie.kogito.research.processes.api.SimpleProcessContext;
import org.kie.kogito.research.processes.api.messages.ProcessMessages;
import org.kie.kogito.research.processes.core.impl.*;
import org.testcontainers.containers.KafkaContainer;
import org.testcontainers.utility.DockerImageName;

import javax.inject.Inject;
import java.io.Serializable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@QuarkusTest
//@QuarkusTestResource(KafkaResource.class)
public class ProcessMessagingAPITest {

    @Inject
    SmallryeProcessorMessageBus messageBus;


    @Test
    public void serializer() throws JsonProcessingException {

        var mapper = new ObjectMapper();
        PolymorphicTypeValidator ptv = BasicPolymorphicTypeValidator.builder()
                .allowIfBaseType(Serializable.class)
                .allowIfBaseType(Id.class)
                .allowIfBaseType(Event.class)
                .allowIfBaseType(ProcessMessages.Message.class)
                .allowIfBaseType(Context.class)
                .build();
        mapper.activateDefaultTyping(ptv);

        mapper.registerSubtypes(Event.class);

        mapper.setVisibility(PropertyAccessor.FIELD, JsonAutoDetect.Visibility.ANY);
        mapper.registerSubtypes(SimpleProcessContext.class);
        mapper.registerSubtypes(ProcessMessages.Message.class);
        mapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);

        String s = mapper.writerFor(Event.class).writeValueAsString(
                new SimpleProcessEvent(SimpleProcessId.fromString("some-proc"), null,
                ProcessMessages.CreateInstance.of(SimpleProcessId.fromString("blah"))));

        System.out.println(s);

        SimpleProcessEvent o = mapper.readerFor(Event.class).readValue(s);

        System.out.println(o);

        Object r = mapper.readerFor(Event.class).readValue("[\"org.kie.kogito.research.processes.core.impl.SimpleProcessEvent\",{\"senderId\":[\"org.kie.kogito.research.application.api.impl.SimpleId\",{\"uuid\":\"bbe77724-65cf-4ad2-b58c-3a128a3dc5b9\"}],\"targetId\":null,\"payload\":[\"org.kie.kogito.research.processes.api.messages.ProcessMessages$CreateInstance\",{\"requestId\":[\"org.kie.kogito.research.application.api.SimpleRequestId\",{\"uuid\":\"f80b6bf2-679d-46a2-ae03-1a281ba91b55\"}],\"processId\":[\"org.kie.kogito.research.processes.core.impl.SimpleProcessId\",{\"value\":\"my.process\"}],\"context\":[\"org.kie.kogito.research.processes.api.SimpleProcessContext\",{}]}]}]");

        System.out.println(r);

    }

    @Test
    public void createInstance() throws InterruptedException, ExecutionException, TimeoutException {

        // a test utility that wraps the bus to await responses
        var messages = new AssertBus(messageBus);


        var processId = SimpleProcessId.fromString("my.process");
        var process = new ProcessImpl(null, processId, messageBus);

        // end of internal API


        // create instance via message passing
        var createInstance = ProcessMessages.CreateInstance.of(processId);
        var instanceCreated =
                messages.send(createInstance)
                        .expect(ProcessMessages.InstanceCreated.class)
                        .get(25, SECONDS);

        assertEquals(createInstance.requestId(), instanceCreated.requestId());
        assertEquals(processId, instanceCreated.processId());

        var processInstanceId = instanceCreated.processInstanceId();

        // start instance
        var startInstance =
                ProcessMessages.StartInstance.of(processId, processInstanceId);
        var instanceStarted =
                messages.send(startInstance)
                        .expect(ProcessMessages.InstanceStarted.class).get();

        assertEquals(startInstance.requestId(), instanceStarted.requestId());
        assertEquals(processId, instanceStarted.processId());
        assertEquals(processInstanceId, instanceStarted.processInstanceId());

        var instanceCompleted =
                messages.expect(ProcessMessages.InstanceCompleted.class).get();

        assertEquals(processId, instanceCompleted.processId());
        assertEquals(processInstanceId, instanceCompleted.processInstanceId());
    }


}