package org.kie.kogito.research.application.core;

import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.api.UnitId;
import org.kie.kogito.research.application.api.UnitInstanceId;

import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.util.Objects;

public class UriUnitId implements Id, UnitId, UnitInstanceId {
    private final Id parent;
    private final String current;

    public UriUnitId(Id parent, String current) {
        this.parent = parent;
        this.current = current;
    }

    public UriUnitId append(String segment) {
        return new UriUnitId(this, segment);
    }

    @Override
    public String toString() {
        return ( parent == null ? "kogito:/" : parent.toString() ) +
                '/' + URLEncoder.encode(current, StandardCharsets.UTF_8);
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Id &&
                Objects.equals(o.toString(), this.toString());
    }

}
