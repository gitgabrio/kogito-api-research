package org.kie.kogito.research.exp;

import org.junit.jupiter.api.Test;

class App {
    <T> Catalog<T> forCatalog(Type<T> cls) {
        return new Catalog<>(cls);
    }
}

class Catalog<U> {
    public Catalog(Type<U> cls) {

    }

    Item<U> lookup(String id) {
        return new Item<>(id);
    }

    public Item<U> lookup() {
        return new Item<>("/");
    }
}

class Leaf<U> {

    public Leaf() {
    }

    U resolve() {
        throw new UnsupportedOperationException();
    }

}

class Item<U> {
    private final String id;

    public Item(String id) {
        this.id = id;
    }

    <T> Catalog<T> forCatalog(Type<T> cls) {
        return new Catalog<>(cls);
    }

    U resolve() {
        throw new UnsupportedOperationException();
    }
}

class Type<T> {
    private final String name;

    public Type(String name) {
        this.name = name;
    }

    public String name() {
        return name;
    }
}

public class AnotherTest {

    @Test
    public void scratch() {
        App app = new App();
        app.forCatalog(Proc.meta.type())
                .lookup("my.process.name")
                .forCatalog(Proc.meta.instances())
                .lookup("some.instance.id")
                .forCatalog(Task.instances())
                .lookup("myTask")
                .resolve()
                .start();

        app.forCatalog(Proc.meta.type())
                .lookup("process-id")
                .forCatalog(Proc.meta.instances())
                .lookup("instance-id")
                .forCatalog(Task.instances())
                .lookup("myTask")
                .resolve()
                .start();


    }
}


class ProcMeta implements TypeProvider<Proc, ProcInst> {
    public static ProcMeta get() {
        return new ProcMeta();
    }

    public Type<Proc> type() {
        return new Type<>("processes");
    }

    public Type<ProcInst> instances() {
        return new Type<>("instances");
    }
};

interface TypeProvider<T, U> {
    Type<T> type();

    Type<U> instances();
}

interface Proc {
    ProcMeta meta = ProcMeta.get();
}

interface ProcInst {
    void start();
};

interface Task {
    static Type<TaskInst> instances() {
        return new Type<>("tasks");
    }
}

interface TaskInst {
    void start();
}
