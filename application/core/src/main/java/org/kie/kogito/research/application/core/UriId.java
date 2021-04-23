package org.kie.kogito.research.application.core;

import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.api.RelativeId;

import java.net.URI;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Objects;

public class UriId implements Id {
    public static UriId parse(String uri) {
        var u = URI.create(uri);
        var path = Path.of(u.getPath());

        UriId id = new UriId(null, u.getHost());

        ArrayList<RelativeUriId> segments =  new ArrayList<>();

        while (path.getFileName() != null) {
            var segment = RelativeUriId.of(path.getFileName().toString());
            segments.add(segment);
            path = path.getParent();
        }

        for (int i = segments.size() - 1 ; i >= 0; i--) {
            id = id.append(segments.get(i));
        }

        return id;
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
    public Id parent() {
        return parent;
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
