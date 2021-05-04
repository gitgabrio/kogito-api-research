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

import org.kie.kogito.research.application.api.KogitoService;
import org.kie.kogito.research.decisions.core.services.DecisionService;
import qnd.Application;

import java.util.HashMap;

public class ApplicationTest {

    public static void main(String[] args) {
        Application application = new Application();
        KogitoService kogitoService = application.get(DecisionService.class);
        Object result =  kogitoService
                .get(24) // this is the second step
                .get(null) // this is the last step
                .getResult(new HashMap<>());
        System.out.println(result);
    }
}
