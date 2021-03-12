package org.kie.kogito.research.processes.api;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import com.fasterxml.jackson.annotation.JsonTypeName;
import org.kie.kogito.research.application.api.Context;

import java.io.Serializable;

@JsonTypeName("SimpleProcessContext")
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME)
public class SimpleProcessContext implements Context, Serializable {
}
