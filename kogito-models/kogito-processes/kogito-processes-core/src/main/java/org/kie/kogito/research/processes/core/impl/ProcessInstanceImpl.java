package org.kie.kogito.research.processes.core.impl;

public class ProcessInstanceImpl /*extends AbstractUnitInstance implements ProcessInstance*/ {
//    private final ExecutionModel executionModel;
//    private final Id senderId;
//
//    public ProcessInstanceImpl(RequestId requestId, Id senderId, ProcessInstanceId id, ProcessImpl unit, Context context) {
//        super(id, unit, context);
//        messageBus().subscribe(this::receive);
//        messageBus().send(new SimpleProcessEvent(this.id(), senderId,
//                ProcessMessages.InstanceCreated.of(requestId, unit.id(), id)));
//
//        this.senderId = senderId;
//
//        if (context instanceof ExecutionModel) {
//            this.executionModel = (ExecutionModel) context;
//        } else {
//            this.executionModel = null;
//        }
//
//    }
//
//    @Override
//    public ProcessInstanceId id() {
//        return (ProcessInstanceId) super.id();
//    }
//
//    @Override
//    public Process unit() {
//        return (Process) super.unit();
//    }
//
//    @Override
//    public MessageBus<ProcessEvent> messageBus() {
//        return (MessageBus<ProcessEvent>) unit().messageBus();
//    }
//
//    protected void receive(Event event) {
//        if (executionModel != null) executionModel.onEvent(event);
//
//        // internal handling logic
//        if (event instanceof ProcessEvent) {
//            ProcessEvent pEvent = (ProcessEvent) event;
//            pEvent.payload().as(ProcessMessages.StartInstance.class)
//                    .ifPresent(e -> {
//                        messageBus().send(new SimpleProcessEvent(this.id(), pEvent.senderId(),
//                                ProcessMessages.InstanceStarted.of(e.requestId(), unit().id(), id())));
//                        messageBus().send(new SimpleProcessEvent(this.id(), this.id(),
//                                InternalProcessMessages.CompleteProcessInstance.of(new SimpleRequestId(), unit().id(), id())));
//                    });
//            pEvent.payload().as(InternalProcessMessages.CompleteProcessInstance.class)
//                    .filter(e -> e.processInstanceId().equals(this.id()))
//                    .ifPresent(e ->
//                            messageBus().send(new SimpleProcessEvent(this.id(), senderId,
//                                    ProcessMessages.InstanceCompleted.of(new SimpleRequestId(), unit().id(), id()))));
//        }
//    }
//
//    public void run() {}

}
