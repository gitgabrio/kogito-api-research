package org.kie.kogito.research.predictions.api;

import org.kie.kogito.research.application.api.ModelContainer;
import org.kie.kogito.research.predictions.api.ids.PredictionId;

public interface PredictionContainer extends ModelContainer<PredictionId, PredictionMessage,  PredictionEvent, Prediction> {
}
