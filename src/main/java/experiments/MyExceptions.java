package experiments;

public class MyExceptions {
    public static void main(String[] args) {
        method1();
        uncheckedException(10, 0);
    }

    public static void method1() {
        try {
            pauseThread();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void pauseThread() throws InterruptedException {
        Thread.sleep(3000);
    }

    public static void uncheckedException(int a, int b) {
        int result = 0;
        try {
            result = a / b;
            System.out.println(result);
        } catch (ArithmeticException e) {
            result = 1;
            System.out.println(result);
        }
    }

}
