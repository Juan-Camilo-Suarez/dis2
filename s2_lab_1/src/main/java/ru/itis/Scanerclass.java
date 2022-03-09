package ru.itis;

import ru.itis.annotations.Component;
import ru.itis.annotations.Inject;
import ru.itis.components.TestClass;
import ru.itis.components.TestComponent;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

public class Scanerclass {
    public static String PATH_FOR_SCAN = "ru.itis.classes";

    public static void main(String[] arg) {

        /* Просканируем пакет PATH_FOR_SCAN для поиска классов (включая вложенные пакеты)  */
        System.out.println("STEP 1: scan package " + PATH_FOR_SCAN + ":");

        List<Class<?>> classList = PathScan.find(PATH_FOR_SCAN);
        if (classList != null)
            classList.forEach(c -> System.out.println("\t" + c.getSimpleName()));

        System.out.println("STEP 2: scan class fields:");
        for (Class<?> cl : classList) {
            /* Сканируем поля классов */
            System.out.println("\tFields of class " + cl.getName());

            for (Field field : cl.getDeclaredFields()) {
                System.out.println("\t\t" + field.getName() + " of type " + field.getType().getCanonicalName());
                Type type = field.getGenericType();
                if (type instanceof ParameterizedType) {
                    ParameterizedType pt = (ParameterizedType) type;
                    System.out.println("raw type: " + pt.getRawType());
                    System.out.println("owner type: " + pt.getOwnerType());
                    System.out.println("actual type args:");
                    for (Type t : pt.getActualTypeArguments()) {
                        System.out.println("    " + t);
                    }
                }

            }
        }

        System.out.println("STEP 3: scan class methods:");
        for (Class<?> cl : classList) {
            /* Сканируем методы классов */
            System.out.println("\tFields of class " + cl.getName());
            Method[] methods = cl.getMethods();
            for (Method method : methods) {
                System.out.println("\t\t" + method.getName());
            }


            System.out.println("...");
        }
        System.out.println("STEP 4 Dependecy: ");
        for (Class<?> cl : classList) {
            Field[] fields = cl.getDeclaredFields();
            for (Field field : fields) {
                System.out.println(cl.getSimpleName() + " dependens of -> " + field.getName() + " of type -> " + field.getType());
            }


            System.out.println("...");
        }

    }
}

