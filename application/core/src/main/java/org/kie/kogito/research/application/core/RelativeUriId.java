package org.kie.kogito.research.application.core;

import org.kie.kogito.research.application.api.RelativeId;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

public class RelativeUriId implements RelativeId {
    public static RelativeUriId of(String segment) {
        return new RelativeUriId(segment);
    }
    public static RelativeUriId random() {
        return new RelativeUriId(UUID.randomUUID().toString());
    }

    private final String segment;

    public RelativeUriId(String segment) {
        this.segment = segment;
    }

    @Override
    public String toString() {
        return URLEncoder.encode(segment, StandardCharsets.UTF_8);
    }
}
