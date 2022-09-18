package study.java.multithread.sender;

import java.time.LocalDateTime;

public class DataSender {

  public static void sendData1() {
    long threadId = Thread.currentThread().getId();
    String threadName = Thread.currentThread().getName();
    long startTime = System.currentTimeMillis();

    System.out.println("[" + LocalDateTime.now() + "] 데이터 1 전송 시작 - " + threadId + ", " + threadName);
    waitLock(5000L);
    System.out.println("[" + LocalDateTime.now() + "] 데이터 1 전송 완료 - " + threadId + ", " + threadName);
    System.out.println("[" + LocalDateTime.now() + "] 데이터 1 전송 시간 - " + (System.currentTimeMillis() - startTime));
  }

  public static String sendData1WithReturn() {
    long threadId = Thread.currentThread().getId();
    String threadName = Thread.currentThread().getName();
    long startTime = System.currentTimeMillis();

    System.out.println("[" + LocalDateTime.now() + "] 데이터 1 전송 시작 - " + threadId + ", " + threadName);
    waitLock(5000L);
    System.out.println("[" + LocalDateTime.now() + "] 데이터 1 전송 완료 - " + threadId + ", " + threadName);
    System.out.println("[" + LocalDateTime.now() + "] 데이터 1 전송 시간 - " + (System.currentTimeMillis() - startTime));

    return "data1";
  }

  public static void sendData2() {
    long threadId = Thread.currentThread().getId();
    String threadName = Thread.currentThread().getName();
    long startTime = System.currentTimeMillis();

    System.out.println("[" + LocalDateTime.now() + "] 데이터 2 전송 시작 - " + threadId + ", " + threadName);
    waitLock(3000L);
    System.out.println("[" + LocalDateTime.now() + "] 데이터 2 전송 완료 - " + threadId + ", " + threadName);
    System.out.println("[" + LocalDateTime.now() + "] 데이터 2 전송 시간 - " + (System.currentTimeMillis() - startTime));
  }

  public static String sendData2WithReturn() {
    long threadId = Thread.currentThread().getId();
    String threadName = Thread.currentThread().getName();
    long startTime = System.currentTimeMillis();

    System.out.println("[" + LocalDateTime.now() + "] 데이터 2 전송 시작 - " + threadId + ", " + threadName);
    waitLock(3000L);
    System.out.println("[" + LocalDateTime.now() + "] 데이터 2 전송 완료 - " + threadId + ", " + threadName);
    System.out.println("[" + LocalDateTime.now() + "] 데이터 2 전송 시간 - " + (System.currentTimeMillis() - startTime));

    return "data2";
  }

  private static void waitLock(long millis) {
    try {
      Thread.sleep(millis);
    } catch (InterruptedException e) {
      throw new RuntimeException(e);
    }
  }

}
