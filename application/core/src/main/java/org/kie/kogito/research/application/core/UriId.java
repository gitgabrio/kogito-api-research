package org.kie.kogito.research.application.core;

import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.api.RelativeId;

import java.net.URI;
import java.nio.file.Path;
import java.util.Objects;

public class UriId implements Id {
    public static UriId parse(String uri) {
        var u = URI.create(uri);
        var path = Path.of(u);
        var segment = RelativeUriId.of(path.getFileName().toString());
        if (path.getParent() == null) {
            return new UriId(null, segment);
        } else {
            return of(parse(path.getParent().toString()), segment);
        }
    }

    public static UriId of(Id parent, RelativeId current) {
        return new UriId(parent, current);
    }

    private final Id parent;
    private final RelativeId segment;

    public UriId(Id parent, String segment) {
        this(parent, RelativeUriId.of(segment));
    }

    public UriId(Id parent, RelativeId segment) {
        this.parent = parent;
        this.segment = segment;
    }

    @Override
    public RelativeId segment() {
        return segment;
    }

    public UriId append(RelativeId segment) {
        return new UriId(this, segment);
    }

    @Override
    public String toString() {
        return (parent == null ? "kogito:/" : parent.toString()) +
                '/' + segment.toString();
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Id &&
                Objects.equals(o.toString(), this.toString());
    }

}
