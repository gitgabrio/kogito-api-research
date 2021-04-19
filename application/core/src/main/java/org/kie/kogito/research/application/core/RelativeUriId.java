package org.kie.kogito.research.application.core;

import org.kie.kogito.research.application.api.RelativeId;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
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
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RelativeUriId that = (RelativeUriId) o;
        return Objects.equals(segment, that.segment);
    }

    @Override
    public int hashCode() {
        return Objects.hash(segment);
    }

    @Override
    public String toString() {
        return URLEncoder.encode(segment, StandardCharsets.UTF_8);
    }
}
