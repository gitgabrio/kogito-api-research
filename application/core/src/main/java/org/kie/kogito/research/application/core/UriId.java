package org.kie.kogito.research.application.core;

import org.kie.kogito.research.application.api.Id;
import org.kie.kogito.research.application.api.RelativeId;

import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class UriId implements Id {

    public static final String URI_SCHEME = "kogito";

    public static UriId parse(String uri) {
        var u = URI.create(uri);

        String scheme = u.getScheme();
        if (!scheme.equals(URI_SCHEME)) {
            throw new IllegalArgumentException("Unknown scheme " + scheme);
        }

        if (u.getPath().isBlank()) {
            return makeUri(u, Path.of("/"));
        }

        return new UriId(u);
    }

    private static UriId makeUri(URI uri, Path path) {
        if (!path.isAbsolute()) {
            throw new IllegalArgumentException("Path must be absolute");
        }
        try {
            return new UriId(new URI(URI_SCHEME, uri.getRawAuthority(), path.toString(), null, null));
        } catch (URISyntaxException e) {
            throw new IllegalArgumentException(e);
        }
    }


    private final URI uri;
    private final Path path;

    private UriId(URI uri) {
        this.uri = uri;
        this.path = Path.of(uri.getRawPath());
    }

    @Override
    public Id parent() {
        return makeUri(uri, path.getParent());
    }

    public UriId append(RelativeId segment) {
        return makeUri(uri, path.resolve(segment.toString()));
    }

    @Override
    public RelativeId segment() {
        return RelativeUriId.of(path.getFileName().toString());
    }

    @Override
    public List<RelativeId> segments() {
        ArrayList<RelativeId> relativeIds = new ArrayList<>();
        for (Path p : path) {
            relativeIds.add(RelativeUriId.of(p.toString()));
        }
        return relativeIds;
    }

    @Override
    public String toString() {
        return uri.toString();
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Id &&
                Objects.equals(o.toString(), this.toString());
    }

}
