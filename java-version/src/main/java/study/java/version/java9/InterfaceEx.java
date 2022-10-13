package study.java.version.java9;

public interface InterfaceEx {

  default void printHello() {
    printHelloInternal();
  }

  private void printHelloInternal() {
    System.out.println("hello");
  }
}