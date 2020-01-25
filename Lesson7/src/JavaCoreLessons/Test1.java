package JavaCoreLessons;

public class Test1 {

    @BeforeSuite
    public static void before(){
        System.out.println("Подготовка");
    }

    @Test
    public static void method1(){
        System.out.println("Метод 1");
    }

    @Test(priority = 8)
    public static void method2(){
        System.out.println("Метод 2");
    }

    @Test(priority = 9)
    public static void method3(){
        System.out.println("Метод 3");
    }

    @Test
    public static void method4(){
        System.out.println("Метод 4");
    }

    @AfterSuite
    public static void after(){
        System.out.println("Завершение");
    }

}
