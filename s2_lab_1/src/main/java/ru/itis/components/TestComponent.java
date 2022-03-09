package ru.itis.components;

import ru.itis.annotations.Component;

@Component(name="test")
public class TestComponent {
    public String getComponentInfo() {
        return "Hello from TestComponent!";
    }
}
