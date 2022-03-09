package ru.itis.homework2.tests;

import ru.itis.homework2.PathScan;
import ru.itis.homework2.annotations.Inject;
import ru.itis.homework2.components.TestComponent1;
import ru.itis.homework2.components.TestComponent2;

import java.util.List;

public class Test{
        @Inject
        public TestComponent1 testComponent1;
        @Inject
        public TestComponent2 testComponent2;

        public void print() {
            System.out.println(testComponent1.getComponentInfo());
        }

        public void hi(String user) {
            testComponent2.driver(user);
        }


}
