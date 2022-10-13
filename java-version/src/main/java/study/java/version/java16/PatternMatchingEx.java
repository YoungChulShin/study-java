package study.java.version.java16;

public class PatternMatchingEx {

  public static void main(String[] args) {

  }

  //=============================================
  // Pattern Matching for instanceOf
  //=============================================
  // java8
  private void printData(Object data) {
    if (data instanceof String) {
      String stringData = (String) data;
      System.out.println(stringData.substring(1));
    }
  }

  // java16
  private void printData2(Object data) {
    if (data instanceof String stringData) {
      System.out.println(stringData.substring(1));
    }
  }

}
