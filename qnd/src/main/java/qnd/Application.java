/*
 * Copyright 2021 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package qnd;

import org.kie.kogito.research.application.api.KogitoService;
import org.kie.kogito.research.decisions.core.services.DecisionService;
import org.kie.kogito.research.processes.core.services.ProcessService;

public class Application {

    public KogitoService get(Class<? extends KogitoService> clazz) {
        if (clazz.equals(DecisionService.class)) {
            return new DecisionService();
        } else if (clazz.equals(ProcessService.class)) {
            return new ProcessService();
        } else {
            throw new IllegalArgumentException("Unknown class " + clazz.getName());
        }
    }
}
