package org.kie.kogito.research.application.api;

class ApplicationTest {
//
//    @Test
//    void test() {
//        Application app = new MyApplication();
//
//        MyModelContainer myUnitContainer = app.get(MyModelContainer.class);
//        MyInstancedModel myContextUnit = myUnitContainer.get(MyInstancedModel.ID);
//        MyModelInstance instance = myContextUnit.createInstance(new MyContext());
//
//        AnotherModelContainer anotherUnitContainer = app.get(AnotherModelContainer.class);
//        AnotherInstancedModel anotherMyContextUnit = anotherUnitContainer.get(ClassModelId.of(AnotherInstancedModel.class));
//        AnotherModelInstance anotherInstance = anotherMyContextUnit.createInstance(new MyContext());
//
//        MyContextWithExecutionModel ctx = new MyContextWithExecutionModel();
//        AnotherModelInstance yetAnotherInstance = app.get(AnotherModelContainer.class)
//                .get(ClassModelId.of(AnotherInstancedModel.class))
//                .createInstance(ctx);
//
//        assertFalse(ctx.gotMessage);
//        app.send(SimpleEvent.of(null, ClassModelId.of(AnotherInstancedModel.class), "Hello Message!"));
//        assertTrue(ctx.gotMessage);
//
//
//    }
//    static class MyContext implements Context {}
//
//    static class MyContextWithExecutionModel implements Context, ExecutionModel {
//
//        public boolean gotMessage = false;
//
//        @Override
//        public void onEvent(Event event) {
//            gotMessage = true;
//        }
//    }
//
//    static class MyApplication extends AbstractApplication {{
//        register(new MyModelContainer(this));
//        register(new AnotherModelContainer(this));
//
//    }}
//
//    static class MyModelContainer extends AbstractModelContainer<SimpleModelId, SimpleModelInstanceId, MyInstancedModel> {
//        MyModelContainer(Application app) {
//            super(app);
//            register(new MyInstancedModel(this));
//        }
//
//    }
//    static class MyInstancedModel extends AbstractInstancedModel<SimpleModelId, SimpleModelInstanceId, AbstractInstanceMessage<SimpleModelId, SimpleModelInstanceId>, MyModelInstance> {
//        public static final SimpleModelId ID = new SimpleModelId();
//        public MyInstancedModel(MyModelContainer container) {
//            super(container, ID);
//        }
//        public MyModelInstance createInstance(Context ctx) {
//            return register(new MyModelInstance(this, ctx));
//        }
//
//    }
//
//    static class MyModelInstance extends AbstractModelInstance<SimpleModelId, SimpleModelInstanceId, AbstractInstanceMessage<SimpleModelId, SimpleModelInstanceId>> {
//        public MyModelInstance(MyInstancedModel myUnit, Context context) {
//            super(new SimpleModelInstanceId(), myUnit, context);
//        }
//
//        @Override
//        public void run() {
//
//        }
//    }
//
//
//    static class AnotherModelContainer extends AbstractModelContainer<ModelId, ModelInstanceId, AnotherInstancedModel> {
//        AnotherModelContainer(Application app) {
//            super(app);
//            register(new AnotherInstancedModel(this));
//        }
//    }
//
//    static class AnotherInstancedModel extends AbstractInstancedModel<ModelId, ModelInstanceId, AbstractInstanceMessage<ModelId, ModelInstanceId>, AnotherModelInstance> {
//        public static final ModelId ID = ClassModelId.of(AnotherInstancedModel.class);
//
//        public AnotherInstancedModel(AnotherModelContainer container) {
//            super(container, ID);
//        }
//        public AnotherModelInstance createInstance(Context ctx) {
//            return register(new AnotherModelInstance(this, ctx));
//        }
//    }
//
//    static class AnotherModelInstance extends AbstractModelInstance<ModelId, ModelInstanceId, AbstractInstanceMessage<ModelId, ModelInstanceId>> {
//        public AnotherModelInstance(AnotherInstancedModel myUnit, Context ctx) {
//            super(new SimpleModelInstanceId(), myUnit, ctx);
//        }
//
//        @Override
//        public void run() {
//
//        }
//    }

}