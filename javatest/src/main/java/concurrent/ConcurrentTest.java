package concurrent;

import java.io.Console;
import java.time.LocalDateTime;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ConcurrentTest {

  public static void main(String[] args) {
    printCurrentThread();

    // Thread childThread = threadTest();

    ExecutorService executorService = Executors.newFixedThreadPool(4);
    ExecutorTest("hi", executorService);
    ExecutorTest("hello", executorService);
    ExecutorTest("world", executorService);
    ExecutorTest("test", executorService);
    executorService.shutdown();


    System.out.println("Hello Main : " + LocalDateTime.now());
  }

  private static Thread threadTest() {
    Thread thread = new Thread(() -> {
      printCurrentThread();
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println("Hello Thread : " + LocalDateTime.now());
    });
    thread.start();

    return thread;
  }

  private static void ExecutorTest(String message, ExecutorService executorService) {
    executorService.execute(() -> {
      printCurrentThread();
      try {
        Thread.sleep(3000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(message + " Thread : " + LocalDateTime.now());
    });
  }

  private static void printCurrentThread() {
    System.out.println("Current Thread: " + Thread.currentThread().getName());
  }
}
