package ru.itis.homework2;


import ru.itis.homework2.components.TestComponent1;
import ru.itis.homework2.components.TestComponent2;
import ru.itis.homework2.tests.Test;

/*
 * 1. Сканирование структуры программы
 *  1.1 ищем компоненты @Component -> Map<Name, Type>
 *  1.2 ищем поля @Inject -> Map<Class, Map<Name, Type>>
 *
 * 2. Инициализация полей @Inject
 *
 * 3. Запуск основного класса приложения
 */


public class AnnotationScaner {

    public static void main(String[] args) {
        Contex c = new Contex(AnnotationScaner.class);

        Test test = c.get(Test.class);

        test.print();
        test.hi("camilo");
        TestComponent2 A = c.get(TestComponent2.class);
        TestComponent1 B = test.testComponent1;
        System.out.println(A + " is"
                + (A.equals(B) ? " " : " NOT ")
                + "equal to " + B
        );

    }
}

