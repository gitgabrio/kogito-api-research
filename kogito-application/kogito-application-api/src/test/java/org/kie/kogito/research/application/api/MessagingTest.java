package org.kie.kogito.research.application.api;

class MessagingTest {
//
//    @Test
//    public void test() {
////        var app = new MyApplication();
////
////        ContextA ctx1 = new ContextA();
////        var a = app.get(MyModelContainer.class)
////                        .get(MyInstancedModel.ID)
////                        .createInstance(ctx1);
////
////        ContextA ctx2 = new ContextA();
////        var b = app.get(AnotherModelContainer.class)
////                .get(ClassModelId.of(AnotherInstancedModel.class))
////                .createInstance(ctx2);
////
////        ContextB ctx3 = new ContextB();
////        var c = app.get(AnotherModelContainer.class)
////                .get(ClassModelId.of(AnotherInstancedModel.class))
////                .createInstance(ctx3);
////
////        assertNull(ctx1.message);
////        assertNull(ctx2.message);
////        assertFalse(ctx3.gotMessage);
////
////        app.send(SimpleEvent.of(null, ClassModelId.of(AnotherInstancedModel.class), "SPECIAL"));
////
////        assertNull(ctx1.message);
////        assertNull(ctx2.message);
////        assertFalse(ctx3.gotMessage);
////
////        app.run();
////
////        assertNotNull(ctx1.message);
////        System.out.println(ctx1.message);
////        assertEquals("SPECIAL", ctx2.message);
////        assertTrue(ctx3.gotMessage);
//
//
//    }
//    static class ContextA implements Context, ExecutionModel {
//        String message;
//        @Override
//        public void onEvent(Event event) {
//            message = (String) event.payload();
//        }
//    }
//
//    static class ContextB implements Context, ExecutionModel {
//
//        public boolean gotMessage = false;
//
//        @Override
//        public void onEvent(Event event) {
//            gotMessage = true;
//        }
//    }
//
//    static class MyApplication extends AbstractApplication {
////        Deque<Event> deque = new ArrayDeque<>();
////        MyApplication() {
////            register(new MyModelContainer(this));
////            register(new AnotherModelContainer(this));
////        }
////
////        @Override
////        public void send(Event event) {
////            deque.offer(event);
////        }
////
////        public void run() {
////            Event evt = deque.poll();
////            while (evt != null) {
////                super.send(evt);
////                evt = deque.poll();
////            }
////
////        }
//    }
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
//        public void send(Event event) {
//            if (event.targetId().equals(model().id()) && event.payload().equals("SPECIAL")) {
//                model().application().send(
//                        SimpleEvent.of(id(), MyInstancedModel.ID,
//                                       String.format("Message from %s -- %s", id(), model().id())));
//            }
//            super.send(event);
//        }
//
//        @Override
//        public void run() {
//
//        }
//    }

}