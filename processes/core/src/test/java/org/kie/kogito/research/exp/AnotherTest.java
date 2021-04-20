package org.kie.kogito.research.exp;

import org.junit.jupiter.api.Test;

class App {
    <T> Type<T> get(Class<T> cls) { return new Type<>(cls); }
}

class Pair<U> {
    private final String id;

    public Pair(String id) {
        this.id = id;
    }

    <T> Type<T> get(Class<T> cls) { return new Type<>(cls); };
    U resolve() {
        throw new UnsupportedOperationException();
    }
}

class Type<T> {
    private final Class<T> cls;

    public Type(Class<T> cls) {
        this.cls = cls;
    }

    Pair<T> get(String id) {
        return new Pair<>(id);
    }
}

public class AnotherTest {

    @Test
    public void scratch() {
        App app = new App();
        app.get(Proc.class)
                .get("process-id")
                .get(ProcInst.class)
                .get("instance-id")
                .get(TaskInst.class)
                .get("myTask")
                .resolve()
                .start();

        app.get(Proc.class)
                .get("process-id")
                .get(ProcInst.class)
                .get("instance-id")
                .get(TaskInst.class)
                .get("myTask")
                .resolve()
                .start();

    }
}

interface Proc {
};

interface ProcInst {
    void start();
};

interface TaskInst {
    void start();
}
