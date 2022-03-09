package ru.itis.homework2.components;
import ru.itis.homework2.annotations.Component;

@Component(name="test1")
public class TestComponent1 {
     public String getComponentInfo() {
        return "Hello from TestComponent";
    }
}
