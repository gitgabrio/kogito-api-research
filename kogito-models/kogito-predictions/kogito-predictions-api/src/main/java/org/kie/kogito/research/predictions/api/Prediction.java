package org.kie.kogito.research.predictions.api;

import org.kie.kogito.research.application.api.Model;
import org.kie.kogito.research.predictions.api.ids.PredictionId;

public interface Prediction extends Model<PredictionId, PredictionMessage, PredictionEvent> {

    @Override
    PredictionId id();
}
