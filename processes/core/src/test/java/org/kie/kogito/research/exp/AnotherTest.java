package org.kie.kogito.research.exp;

import org.junit.jupiter.api.Test;

class App {
    <T> Type<T> get(Class<T> cls) {
        return new Type<>(cls);
    }
}

class Pair<U> {
    private final String id;

    public Pair(String id) {
        this.id = id;
    }

    <T> Type<T> get(Type<T> cls) {
        return cls;
    }

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
                .get(ProcType.get().instances())
                .get("instance-id")
                .get(Task.instances())
                .get("myTask")
                .resolve()
                .start();

        app.get(Proc.class)
                .get("process-id")
                .get(ProcType.get().instances())
                .get("instance-id")
                .get(Task.instances())
                .get("myTask")
                .resolve()
                .start();


    }
}



class ProcType implements TypeProvider<Proc, ProcInst> {
    public static ProcType get() {
        return new ProcType();
    }

    public Type<Proc> type() {
        return new Type<>(Proc.class);
    }
    public Type<ProcInst> instances() {
        return new Type<>(ProcInst.class);
    }
};

interface TypeProvider<T,U> {
    Type<T> type();
    Type<U> instances();
}

interface Proc {}

interface ProcInst {
    void start();
};

interface Inst<T> {
    Type<T> get(String s);
}

interface Task {
    static Type<TaskInst> instances() { return new Type<>(TaskInst.class); }
}

interface TaskInst {
    void start();
}
