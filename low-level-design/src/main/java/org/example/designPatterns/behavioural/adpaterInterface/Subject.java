package org.example.designPatterns.behavioural.adpaterInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Subject {

    private List<SomeListener> listeners;

    private static Subject INSTANCE = new Subject();

    public static Subject getInstance() {
        return INSTANCE;
    }

    private Subject() {
        listeners = new ArrayList<>();
    }
    public void addSomeListener(SomeListener listener) {
        listeners.add(listener);
    }

    public void removeSomeListener(SomeListener listener) {
        listeners.remove(listener);
    }

    public void startProcessing() {
        while (true) {
            //Generate Random Integer
            Random random = new Random();
            int randomInteger = random.nextInt(100);
            if (randomInteger % 2 == 0) {
                listeners.forEach(SomeListener::onEvent1);
            } else if (randomInteger % 3 == 0) {
                listeners.forEach(SomeListener::onEvent2);
            } else {
                listeners.forEach(SomeListener::onEvent3);
            }
        }
    }
}
