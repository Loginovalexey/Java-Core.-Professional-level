package JavaCoreLessons;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class TestExecution {
    public static void start(Class argClass) throws InvocationTargetException, IllegalAccessException {

        LinkedList <Integer> sortedPriorities = new LinkedList<Integer>();
        Method[] methods = argClass.getDeclaredMethods();

        System.out.println("Класс: "+argClass.getName());

        boolean beforeExecution = false;
        for (Method m:methods){
            if (m.isAnnotationPresent(BeforeSuite.class)){
                if (beforeExecution){
                    throw new RuntimeException("Аннтоация @BeforeSuite должна быть в единственном экземпляре");
                }
                m.invoke(null);
                beforeExecution = true;
            } else
                if (m.isAnnotationPresent(Test.class)){
                    if (!sortedPriorities.contains(m.getAnnotation(Test.class).priority())){
                        sortedPriorities.add(m.getAnnotation(Test.class).priority());
                    }
                }
        }
        Collections.sort(sortedPriorities);

        for (int i:sortedPriorities
             ) {
            for (Method m:methods){
                if (m.isAnnotationPresent(Test.class)){
                    if (m.getAnnotation(Test.class).priority() == i){
                        System.out.println("Приоритет: " + m.getAnnotation(Test.class).priority());
                        m.invoke(null);
                    }
                }
            }
        }

        boolean afterExecution = false;
        for (Method m:methods){
            if (m.isAnnotationPresent(AfterSuite.class)){
                if (afterExecution){
                    throw new RuntimeException("Аннтоация @AfterSuite должна быть в единственном экземпляре");
                }
                m.invoke(null);
                afterExecution = true;
            }
        }

    }
}
