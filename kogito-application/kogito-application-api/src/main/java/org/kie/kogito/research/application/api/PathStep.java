package org.kie.kogito.research.application.api;

import java.util.function.Function;
import java.util.function.UnaryOperator;

public class PathStep {

        private final UnaryOperator<Object> evaluateFunction;
        private final Function<Object, String> pathFunction;
        private final Function<Object, PathStep> nextStepFunction;

        public PathStep(UnaryOperator<Object> evaluateFunction,
                        Function<Object, String> pathFunction,
                        Function<Object, PathStep> nextStepFunction) {
            this.evaluateFunction = evaluateFunction;
            this.pathFunction = pathFunction;
            this.nextStepFunction = nextStepFunction;
        }

        /**
         * Returns the second step, eventually based on id
         * @param id
         * @return
         */
        public PathStep get(Object id) {
            if (nextStepFunction == null) {
                throw new IllegalArgumentException("This is the leaf");
            }
            return nextStepFunction.apply(id);
        }

        public String getPath(Object id) {
            return pathFunction.apply(id);
        }

        public Object getResult(Object input) {
            return evaluateFunction.apply(input);
        }

    }