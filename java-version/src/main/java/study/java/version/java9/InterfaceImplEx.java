package study.java.version.java9;

public class InterfaceImplEx {

  public static void main(String[] args) {
    InterfaceEx interfaceEx = new MyInterface();
    interfaceEx.printHello();
  }

  private static class MyInterface implements InterfaceEx {

  }
}
