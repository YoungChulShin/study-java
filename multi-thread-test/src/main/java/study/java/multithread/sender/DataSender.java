package study.java.multithread.sender;

public class DataSender {

  public static void sendData1() throws InterruptedException {
    long threadId = Thread.currentThread().getId();
    String threadName = Thread.currentThread().getName();
    long startTime = System.currentTimeMillis();

    System.out.println("데이터 1 전송 시작 - " + threadId + ", " + threadName);
    Thread.sleep(5000);
    System.out.println("데이터 1 전송 완료 - " + threadId + ", " + threadName);
    System.out.println("데이터 1 전송 시간 - " + (System.currentTimeMillis() - startTime));
  }

  public static void sendData2() throws InterruptedException {
    long threadId = Thread.currentThread().getId();
    String threadName = Thread.currentThread().getName();
    long startTime = System.currentTimeMillis();

    System.out.println("데이터 2 전송 시작 - " + threadId + ", " + threadName);
    Thread.sleep(3000);
    System.out.println("데이터 2 전송 완료 - " + threadId + ", " + threadName);
    System.out.println("데이터 2 전송 시간 - " + (System.currentTimeMillis() - startTime));
  }

}
