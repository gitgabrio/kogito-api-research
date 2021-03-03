package org.kie.kogito.research.processes.api.messages;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.kie.kogito.research.application.api.Context;
import org.kie.kogito.research.application.api.SimpleRequestId;
import org.kie.kogito.research.application.api.messages.RequestId;

import org.kie.kogito.research.processes.api.ProcessId;
import org.kie.kogito.research.processes.api.ProcessInstanceId;
import org.kie.kogito.research.processes.api.SimpleProcessContext;

import java.io.Serializable;
import java.util.Optional;

public class ProcessMessages {
    // Requests

    public static class CreateInstance extends ProcessMessage implements Request {
        private Context context;

        public static CreateInstance of(ProcessId processId) {
            return new CreateInstance(new SimpleRequestId(), processId, new SimpleProcessContext());
        }

        public static CreateInstance of(ProcessId processId, Context context) {
            return new CreateInstance(new SimpleRequestId(), processId, context);
        }

        public static CreateInstance of(RequestId requestId, ProcessId processId) {
            return new CreateInstance(requestId, processId, new SimpleProcessContext());
        }

        public static CreateInstance of(RequestId requestId, ProcessId processId, Context context) {
            return new CreateInstance(requestId, processId, context);
        }

        private CreateInstance(RequestId requestId, ProcessId processId, Context context) {
            super(requestId, processId);
            this.context = context;
        }

        protected CreateInstance() {}

        public Context context() {
            return context;
        }
    }

    public static class StartInstance extends ProcessInstanceMessage implements Request {
        public static StartInstance of(ProcessId processId, ProcessInstanceId processInstanceId) {
            return new StartInstance(new SimpleRequestId(), processId, processInstanceId);
        }

        public static StartInstance of(RequestId requestId, ProcessId processId, ProcessInstanceId processInstanceId) {
            return new StartInstance(requestId, processId, processInstanceId);
        }

        protected StartInstance(){}

        private StartInstance(RequestId requestId, ProcessId processId, ProcessInstanceId processInstanceId) {
            super(requestId, processId, processInstanceId);
        }
    }

    // Responses

    public static class NoSuchProcess extends ProcessMessage implements Response {
        public static NoSuchProcess of(RequestId requestId, ProcessId processId) {
            return new NoSuchProcess(requestId, processId);
        }
        protected NoSuchProcess(){}
        public NoSuchProcess(RequestId requestId, ProcessId processId) {
            super(requestId, processId);
        }
    }

    public static class InstanceCreated extends ProcessInstanceMessage implements Response {
        public static InstanceCreated of(RequestId requestId, ProcessId processId, ProcessInstanceId processInstanceId) {
            return new InstanceCreated(requestId, processId, processInstanceId);
        }

        protected InstanceCreated(){}

        private InstanceCreated(RequestId requestId, ProcessId processId, ProcessInstanceId processInstanceId) {
            super(requestId, processId, processInstanceId);
        }
    }

    public static class InstanceStarted extends ProcessInstanceMessage implements Response {
        public static InstanceStarted of(RequestId requestId, ProcessId processId, ProcessInstanceId processInstanceId) {
            return new InstanceStarted(requestId, processId, processInstanceId);
        }

        protected InstanceStarted() {}

        private InstanceStarted(RequestId requestId, ProcessId processId, ProcessInstanceId processInstanceId) {
            super(requestId, processId, processInstanceId);
        }
    }

    public static class InstanceCompleted extends ProcessInstanceMessage implements Response {
        public static InstanceCompleted of(RequestId requestId, ProcessId processId, ProcessInstanceId processInstanceId) {
            return new InstanceCompleted(requestId, processId, processInstanceId);
        }

        protected InstanceCompleted() {}

        private InstanceCompleted(RequestId requestId, ProcessId processId, ProcessInstanceId processInstanceId) {
            super(requestId, processId, processInstanceId);
        }
    }

    public interface Request {
    }

    public interface Response {
    }

    @JsonTypeName("org.kie.kogito.research.processes.api.messages.ProcessMessages$Message")
    @JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
    public interface Message extends Serializable {
        <T extends Message> Optional<T> as(Class<T> type);
        RequestId requestId();
        ProcessId processId();
    }

    public static abstract class ProcessMessage implements Message {
        private RequestId requestId;
        private ProcessId processId;

        protected ProcessMessage(RequestId requestId, ProcessId processId) {
            this.requestId = requestId;
            this.processId = processId;
        }

        protected ProcessMessage() {}

        public RequestId requestId() {
            return requestId;
        }

        public ProcessId processId() {
            return processId;
        }

        @Override
        public <T extends Message> Optional<T> as(Class<T> type) {
            return type.isInstance(this) ? Optional.of((T) this) : Optional.empty();
        }
    }

    public static abstract class ProcessInstanceMessage extends ProcessMessage {
        private ProcessInstanceId processInstanceId;

        protected ProcessInstanceMessage(RequestId requestId, ProcessId processId, ProcessInstanceId processInstanceId) {
            super(requestId, processId);
            this.processInstanceId = processInstanceId;
        }

        ProcessInstanceMessage() {}

        public ProcessInstanceId processInstanceId() {
            return processInstanceId;
        }
    }
}
