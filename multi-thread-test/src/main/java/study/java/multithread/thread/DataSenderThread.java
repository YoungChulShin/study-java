package study.java.multithread.thread;

import study.java.multithread.sender.DataSender;

public class DataSenderThread extends Thread {

  private final int sendSequence;

  public DataSenderThread(int sendSequence) {
    this.sendSequence = sendSequence;
  }

  @Override
  public void run() {
    if (sendSequence == 1) {
      DataSender.sendData1();
    } else {
      DataSender.sendData2();
    }
  }
}
