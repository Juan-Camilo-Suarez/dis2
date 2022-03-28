package ru.itis.components;

import ru.itis.annotations.Inject;

public class TestClass {
    @Inject
    public TestComponent testComponent;

    public void print() {
        System.out.println(testComponent.getComponentInfo());
    }
}
