
/*==============================================================================================
== Name        : main.java
== Author      : Dave Gray
== Version     : v1
== Description : Simple Java Program that creates a method for counting Up 0-20 and another
                 method to count down 20 - 0.  Each method is run in a seperate thread. The 2nd
                 thread does not start until the 1st has completed it task.
================================================================================================
*/
class Main {

    // Create Count Up Method //
    public static void countUp() {
        System.out.println("Counting Up: ");
        for (int i = 0; i <= 20; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    // Create Count Down Method //
    public static void countDown() {
        System.out.println("Counting Down: ");
        for (int i = 20; i >= 0; i--) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
    /* Create Main for calling methods in 2 different threads. Thread2 runs After Thread1
    completes. */
    public static void main(String[] args) throws InterruptedException {
        Thread thread1 = new Thread(() -> countUp());
        thread1.start();
        thread1.join();

        System.out.println();

        Thread thread2 = new Thread(() -> countDown());
        thread2.start();
        thread2.join();

    }
}
