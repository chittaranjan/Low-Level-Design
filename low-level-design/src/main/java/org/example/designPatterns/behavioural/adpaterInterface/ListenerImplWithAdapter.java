package org.example.designPatterns.behavioural.adpaterInterface;

/**
 * With Adapter Interface, this implementation
 * does not have to implement all the methods of the interface.
 */
public class ListenerImplWithAdapter {

    public ListenerImplWithAdapter() {
        Subject.getInstance().addSomeListener(getSomeListenerAdapter());
    }


    public void doSomething(String string) {
        System.out.println(string);
    }


    private SomeListener getSomeListenerAdapter() {
        //Get the Adapter instance
        return new SomeListenerAdapter() {
            @Override
            public void onEvent1() {
                doSomething("Divisible by 2");
            }

            @Override
            public void onEvent2() {
                doSomething("Divisible by 3");
            }
        };
    }

}
