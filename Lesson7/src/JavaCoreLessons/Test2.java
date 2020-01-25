package JavaCoreLessons;

public class Test2 {
    @BeforeSuite
    public static void before(){
        System.out.println("Подготовка...");
    }

    @Test
    public static void method1(){
        System.out.println("Метод 1");
    }

    @Test
    public static void method2(){
        System.out.println("Метод 2");
    }

    @Test(priority = 2)
    public static void method3(){
        System.out.println("Метод 3");
    }

    @AfterSuite
    public static void after(){
        System.out.println("Завершение.");
    }

    @Test
    public static void method4() {
        System.out.println("Метод 4");
    }

    @AfterSuite
    public static void end() {
        System.out.println("Окончание.");
    }
}
