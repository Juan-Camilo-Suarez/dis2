package ru.itis.homework2.components;

import ru.itis.homework2.annotations.Component;

@Component(name = "test2")
public class TestComponent2 {

    public void driver(String driver) {
        System.out.println("this " + driver + "! from TestComponent2");
    }

}
