 package org.kie.kogito.research.processes.core.impl;

import io.vertx.core.Vertx;
import io.vertx.core.buffer.Buffer;
import io.vertx.core.eventbus.EventBus;
import io.vertx.core.eventbus.MessageCodec;
import org.junit.jupiter.api.Test;
import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.api.impl.SimpleId;
import org.kie.kogito.research.application.core.impl.VertxMessageBus;
import org.kie.kogito.research.processes.api.messages.ProcessMessages;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ProcessMessagingAPIVertxTest {

    @Test
    public void createInstance() throws InterruptedException, ExecutionException {
        // set up the system (internal APIs)
        ExecutorService service = Executors.newCachedThreadPool();
        Vertx vertx = Vertx.vertx();
        EventBus eventBus = vertx.eventBus();
        eventBus.registerDefaultCodec(SimpleProcessEvent.class, new IdentityCodec(SimpleProcessEvent.class));
        var messageBus = new VertxMessageBus(eventBus);
        messageBus.subscribe(e -> {
            System.out.println(e.toString());
        });
        var processId = SimpleProcessId.fromString("my.process");
        var process = new ProcessImpl(null, processId, messageBus, service);

        // create instance via message passing
        var createInstance = ProcessMessages.CreateInstance.of(processId);
        var self = new SimpleId();
        messageBus.send(new SimpleProcessEvent(self, null, createInstance));



//        // a test utility that wraps the bus to await responses
//        var messages = new RequestResponse(messageBus);
//
//        // create instance via message passing
//        var createInstance = ProcessMessages.CreateInstance.of(processId);
//        var instanceCreated =
//                messages.send(createInstance)
//                        .expect(ProcessMessages.InstanceCreated.class)
//                        .get();
//
//        assertEquals(createInstance.requestId(), instanceCreated.requestId());
//        assertEquals(processId, instanceCreated.processId());
//
//        // listen for process completion
//        var instanceCompletedListener =
//                messages.expect(ProcessMessages.InstanceCompleted.class);
//
//        var processInstanceId = instanceCreated.processInstanceId();
//
//        // start instance
//        var startInstance =
//                ProcessMessages.StartInstance.of(processId, processInstanceId);
//        var instanceStarted =
//                messages.send(startInstance)
//                        .expect(ProcessMessages.InstanceStarted.class).get();
//
//        assertEquals(startInstance.requestId(), instanceStarted.requestId());
//        assertEquals(processId, instanceStarted.processId());
//        assertEquals(processInstanceId, instanceStarted.processInstanceId());
//
//        var instanceCompleted = instanceCompletedListener.get();
//
//        assertEquals(processId, instanceCompleted.processId());
//        assertEquals(processInstanceId, instanceCompleted.processInstanceId());

    }


}

class IdentityCodec implements MessageCodec {
    private final Class aClass;

    public IdentityCodec(Class aClass) {
        this.aClass = aClass;
    }

    @Override
    public void encodeToWire(Buffer buffer, Object o) {

    }

    @Override
    public Object decodeFromWire(int pos, Buffer buffer) {
        return null;
    }

    @Override
    public Object transform(Object o) {
        return o;
    }

    @Override
    public String name() {
        return aClass.getName() + "Codec";
    }

    @Override
    public byte systemCodecID() {
        return -1;
    }
}
