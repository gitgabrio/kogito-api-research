package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.*;
import org.kie.kogito.research.application.core.AbstractApplication;
import org.kie.kogito.research.application.core.RelativeUriId;
import org.kie.kogito.research.application.core.UriId;
import org.kie.kogito.research.processes.api.Process;
import org.kie.kogito.research.processes.api.ProcessInstance;
import org.kie.kogito.research.processes.api.Task;
import org.kie.kogito.research.processes.api.TaskInstance;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class TestPathApp extends AbstractApplication {

    {
        register(Process.class, new ProcessPathContainer(this.id()));
    }


}

class ProcessPathContainer extends PathContainer<Process> {
    public ProcessPathContainer(Id id) {
        super(id, RelativeUriId.of("processes"));
    }
    @Override public Process get(RelativeId id) {
        return new PathProcess(this.id().append(id));
    }
}


class PathProcess extends PathUnit<Process, ProcessInstance> implements Process {
    public PathProcess(Id id) {
        super(id);
    }
    @Override public AddressableContainerFactory<ProcessInstance> instances() {
        return new PathProcessInstanceContainer(id());
    }
}


class PathProcessInstanceContainer extends PathInstanceContainer<ProcessInstance> {

    public PathProcessInstanceContainer(Id parentId) {
        super(parentId, "instances");
    }

    @Override
    public ProcessInstance get(RelativeId unitId) {
        return new PathProcessInstance(id().append(unitId));
    }

    @Override
    public ProcessInstance create(Context ctx) {
        throw new UnsupportedOperationException("CREATE");
    }
}

class PathProcessInstance extends PathInstance<Process> implements ProcessInstance {

    public PathProcessInstance(Id id) {
        super(id);
        register(TaskInstance.class, new PathTaskInstanceContainer(id));
    }

    public <T extends Context> T context(Class<T> cls) {
        return null; //cls.cast(context); // should remap if they don't match!
    }

    @Override
    public <T extends Context> T variables(Class<T> cls) {
        throw new UnsupportedOperationException("VARIABLES");
    }

    @Override
    public AddressableContainerFactory<TaskInstance> tasks() {
        throw new UnsupportedOperationException("TASKS");
    }

    @Override
    public void start() {
        throw new UnsupportedOperationException("START");

    }

    @Override
    public void abort() {
        throw new UnsupportedOperationException("ABORT");

    }

    @Override
    public <T extends Context> T update(T context) {
        throw new UnsupportedOperationException("UPDATE");
    }

    @Override
    public void send(Event signalEvent) {
        throw new UnsupportedOperationException("SEND");

    }
}


class PathTaskInstanceContainer extends PathInstanceContainer<TaskInstance> {

    public PathTaskInstanceContainer(Id parentId) {
        super(parentId, "tasks");
    }

    @Override
    public TaskInstance get(RelativeId id) {
        return new PathTaskInstance(id().append(id));
    }

    @Override
    public TaskInstance create(Context ctx) {
        throw new UnsupportedOperationException("CREATE");
    }
}

class PathTaskInstance extends PathInstance<Task> implements TaskInstance{

    public PathTaskInstance(Id id) {
        super(id);
    }

    @Override
    public void save(Context ctx) {

    }

    @Override
    public void complete(Context ctx) {

    }

    @Override
    public void send(Event event) {

    }

    @Override
    public void transition(Context ctx, String phase) {

    }

    @Override
    public void abort(String phase) {
        throw new UnsupportedOperationException("ABORT");
    }
}




abstract class PathInstance<T extends Unit<T>> implements Instance<T> {

    private final Id id;
    private final Map<Class<?>, AddressableContainer<?>> containers;

    public PathInstance(Id id) {
        this.id = id;
        this.containers = new HashMap<>();
    }

    @Override
    public Id id() {
        return id;
    }

    public <T extends Context> T context(Class<T> cls) {
        return null; //cls.cast(context); // should remap if they don't match!
    }

    protected final <U extends Addressable, C extends AddressableContainer<U>> void register(Class<U> cls, C ctr) {
        containers.put(cls, ctr);
    }

    public <U extends Addressable, C extends AddressableContainer<U>> C get(Class<U> cls) {
        AddressableContainer<?> ctr = containers.get(cls);
        if (ctr == null) throw new NoSuchElementException(cls.getCanonicalName());
        return (C) ctr;
    }

}

abstract class PathInstanceContainer<T extends Addressable> implements AddressableContainerFactory<T> {
    private final Id id;

    public PathInstanceContainer(Id parentId, String name) {
        this.id = new UriId(parentId, name);
    }

    @Override
    public Id id() {
        return id;
    }

}

abstract class PathContainer<T extends Unit<T>> implements AddressableContainer<T> {

    private final Id id;
    private final RelativeUriId relativeId;

    public PathContainer(Id id, RelativeUriId relativeId) {

        this.id = id;
        this.relativeId = relativeId;
    }

    @Override
    public Id id() {
        return id;
    }

}


abstract class PathUnit<T extends Unit<T>, I extends Instance<T>> implements Unit<T> {
    private final Id id;
    public PathUnit(Id id) {
        this.id = id;
    }
    @Override public Id id() {
        return id;
    }
}

