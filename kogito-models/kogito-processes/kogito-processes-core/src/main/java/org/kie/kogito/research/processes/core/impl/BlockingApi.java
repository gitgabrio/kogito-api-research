package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.processes.api.ProcessInstanceMessageBus;

public class BlockingApi {
    ProcessInstanceMessageBus assertBus;
//    private CompletableFuture<ProcessInstanceCompletedMessage> completed;
//
//    public BlockingApi(ProcessInstanceMessageBus messageBus) {
//        this.assertBus = messageBus;
//    }
//
////    public ProxyProcessInstance createInstance(ProcessId processId) throws ExecutionException, InterruptedException, TimeoutException {
////        // create instance via message passing
////        var createInstance = ProcessCreateInstance.of(processId);
////        var response =
////                assertBus.send(createInstance)
////                        .expect()
////                        .get(5, TimeUnit.SECONDS);
////
////        Optional<ProcessInstanceCreated> instanceCreated = response.as(ProcessInstanceCreated.class);
////        if (instanceCreated.isPresent()) {
////            ProcessInstanceCreated created = instanceCreated.get();
////            return new ProxyProcessInstance(created.modelId(), created.modelInstanceId(), assertBus);
////        } else {
////            Optional<NoSuchProcess> nsp = response.as(NoSuchProcess.class);
////            if (nsp.isPresent()) {
////                throw new NoSuchProcessIdException(nsp.get().modelId());
////            } else {
////                throw new IllegalArgumentException();
////            }
////        }
////
////    }
//
//
//    public static class ProxyProcessInstance {
//        private final ProcessId processId;
//        private final ProcessInstanceId processInstanceId;
//        private final ProcessAssertBus assertBus;
//
//        public ProxyProcessInstance(ProcessId processId, ProcessInstanceId processInstanceId, ProcessAssertBus assertBus) {
//            this.processId = processId;
//            this.processInstanceId = processInstanceId;
//            this.assertBus = assertBus;
//        }
//
//        public void start() throws ExecutionException, InterruptedException, TimeoutException {
//            var startInstance =
//                    ProcessStartInstanceMessage.of(processId, processInstanceId);
//
//
//            var instanceStarted = assertBus
//                    .send(startInstance)
//                    .expect(ProcessInstanceStartedMessage.class)
//                    .get(1, TimeUnit.SECONDS);
//        }
//
//
//        public void awaitTermination() throws ExecutionException, InterruptedException, TimeoutException {
//            assertBus.expect(ProcessInstanceCompletedMessage.class, instanceCompleted -> processInstanceId.equals(instanceCompleted.modelInstanceId())).get(1, TimeUnit.SECONDS);
//        }
//    }
}
