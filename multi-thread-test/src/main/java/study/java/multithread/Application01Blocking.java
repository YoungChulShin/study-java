package study.java.multithread;

import study.java.multithread.sender.DataSender;

public class Application01Blocking {

  public static void main(String[] args) throws InterruptedException {
    long threadId = Thread.currentThread().getId();
    String threadName = Thread.currentThread().getName();
    long startTime = System.currentTimeMillis();

    System.out.println("프로그램 시작 - " + threadId + ", " + threadName);

    DataSender.sendData1();
    DataSender.sendData2();

    System.out.println("프로그램 종료 - " + threadId + ", " + threadName);
    System.out.println("총 시간 - " + (System.currentTimeMillis() - startTime));

  }
}
