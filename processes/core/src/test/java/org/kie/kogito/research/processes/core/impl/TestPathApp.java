package org.kie.kogito.research.processes.core.impl;

import org.kie.kogito.research.application.api.*;
import org.kie.kogito.research.application.core.AbstractApplication;
import org.kie.kogito.research.application.core.RelativeUriId;
import org.kie.kogito.research.application.core.UriId;
import org.kie.kogito.research.processes.api.Process;
import org.kie.kogito.research.processes.api.ProcessInstance;
import org.kie.kogito.research.processes.api.TaskInstance;

import java.util.HashMap;
import java.util.Map;

public class TestPathApp extends AbstractApplication {

    {
        register(Process.class, new PathProcessContainer(this.id(),  RelativeUriId.of("processes")));
    }


}

class PathProcess implements Process {

    private final Id id;

    public PathProcess(Id id) {
        this.id = id;
    }

    @Override
    public Id id() {
        return id;
    }

    @Override
    public AddressableContainerFactory<ProcessInstance> instances() {
        return new PathProcessInstanceContainer(id, "instances");
    }


}

class PathProcessContainer implements AddressableContainer<Process> {

    private final Id id;
    private final RelativeUriId processes;

    public PathProcessContainer(Id id, RelativeUriId processes) {

        this.id = id;
        this.processes = processes;
    }

    @Override
    public Id id() {
        return id;
    }

    @Override
    public Process get(RelativeId id) {
        return new PathProcess(this.id.append(id));
    }
}

class PathProcessInstanceContainer implements AddressableContainerFactory<ProcessInstance> {
    private final Id id;

    public PathProcessInstanceContainer(Id parentId, String name) {
        this.id = new UriId(parentId, name);
    }

    @Override
    public Id id() {
        return id;
    }

    @Override
    public ProcessInstance get(RelativeId unitId) {
        return new PathProcessInstance(id.append(unitId));
    }

    @Override
    public ProcessInstance create(Context ctx) {
        throw new UnsupportedOperationException("CREATE");
    }
}



class PathProcessInstance implements ProcessInstance {

    private final Id id;
    private final Map<Class<?>, AddressableContainer<?>> containers;

    public PathProcessInstance(Id id) {
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
        return (C) containers.get(cls);
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
