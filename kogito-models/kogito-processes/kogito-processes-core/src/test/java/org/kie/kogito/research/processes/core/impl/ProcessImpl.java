package org.kie.kogito.research.processes.core.impl;

public class ProcessImpl extends AbstractProcessImpl {

    public ProcessImpl() {
        super("ProcessImplId", new ProcessInstanceFactory("my.process")); // <- "ProcessImplId" to be replaced by code-generation
    }


}
