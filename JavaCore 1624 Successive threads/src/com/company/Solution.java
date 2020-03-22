package com.company;

/*

1624 Sequential threads
1. Understand what the program does.
2. Make the program first output the result of the thread, and when the thread finishes - continue the main method.
3. Example output:
inside MyThread 0
inside MyThread 1
...
inside MyThread 9
inside main 0
inside main 1
...
inside main 9

Requirements:
1. The main method should call the start method on the thread t.
2. The main method should call the join method on the thread t.
3. The program should first output 10 lines beginning with "inside MyThread".
4. At the end, the program should output 10 lines beginning with "inside main".
5. In total, the program should output 20 lines.


 */


public class Solution {
    public static MyThread t = new MyThread();
    static String message = "inside main ";

    public static void main(String a[]) throws Exception {
        t.start();
        t.join();
        for (int i = 0; i < 10; i++) {
            System.out.println(message + i);
            sleep();
        }
    }

    public static void sleep() {
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
        }
    }

    static class MyThread extends Thread {
        String message = "inside MyThread ";

        public void run() {
            for (int i = 0; i < 10; i++) {
                System.out.println(message + i);
                Solution.sleep();
            }
        }
    }
}


