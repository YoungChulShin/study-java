package study.java.multithread;

import java.time.LocalDateTime;
import study.java.multithread.sender.DataSender;

public class Application03Runnable {

  public static void main(String[] args) throws InterruptedException {
    long threadId = Thread.currentThread().getId();
    String threadName = Thread.currentThread().getName();
    long startTime = System.currentTimeMillis();

    System.out.println("[" + LocalDateTime.now() + "] 프로그램 시작 - " + threadId + ", " + threadName);

    Thread thread1 = new Thread(DataSender::sendData1);
    thread1.start();
    Thread thread2 = new Thread(DataSender::sendData2);
    thread2.start();

    thread1.join();
    thread2.join();

    System.out.println("[" + LocalDateTime.now() + "] 프로그램 종료 - " + threadId + ", " + threadName);
    System.out.println("[" + LocalDateTime.now() + "] 총 시간 - " + (System.currentTimeMillis() - startTime));
  }

}
