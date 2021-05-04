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
package org.kie.kogito.research.decisions.core.services;

import org.kie.kogito.research.application.api.KogitoService;
import org.kie.kogito.research.application.api.PathStep;

import java.util.Arrays;

public class DecisionService implements KogitoService {

    PathStep rootStep;

    @Override
    public String getPath() {
        return "decisions";
    }

    /**
     * Select a specific DMN
     * @param id
     * @return
     */
    @Override
    public PathStep get(Object id) {
        return rootStep.get(id);

    }

    public DecisionService() {
        rootStep = new PathStep(this::evaluateRoot,
                o -> "Decision",
                this::getSecondStep);
    }

    private PathStep getSecondStep (Object id) {
        return new PathStep(this::evaluateSecondStep,
                o -> "boh-decision",
                this::getLastStep);
    }

    /**
     * Actually evaluate the last step
     * @param id
     * @return
     */
    private PathStep getLastStep(Object id) {
        return new PathStep(this::evaluateLastStep,
        o -> "evaluate",
        null);
    }

    /**
     * Represent the evaluation of current path (e.g. the list of all possible DMNs)
     * @param toIgnore
     * @return
     */
    private Object evaluateRoot(Object toIgnore) {
        return Arrays.asList(1, 2, 3, 4, 5);
    }

    /**
     * Represent the evaluation of current path (e.g. the list of all possible decisions inside a DMN)
     * @param id
     * @return
     */
    private String evaluateSecondStep(Object id) {
        return "Select decision where decisionid = " + id;
    }

    /**
     * Represent the evaluation of current path (e.g. the result of a DMN execution)
     * @param input
     * @return
     */
    private Object evaluateLastStep(Object input) {
        return "Result based on input " + input.toString();
    }

}
