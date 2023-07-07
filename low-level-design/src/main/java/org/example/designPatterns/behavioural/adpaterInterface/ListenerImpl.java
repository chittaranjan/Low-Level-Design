package org.example.designPatterns.behavioural.adpaterInterface;

/**
 * This implementation of the SomeListener interface
 * has to implement all the methods of the interface
 * even though it is not interested in all the events.
 */
public class ListenerImpl implements SomeListener {

    public ListenerImpl() {
        Subject.getInstance().addSomeListener(this);
    }

    public void doSomething(String string) {
        System.out.println(string);
    }

    @Override
    public void onEvent1() {
        doSomething("Divisible by 2");
    }

    @Override
    public void onEvent2() {
        doSomething("Divisible by 3");
    }

    @Override
    public void onEvent3() {
        doSomething("Everything else");
    }
}
