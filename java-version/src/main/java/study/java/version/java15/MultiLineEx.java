package study.java.version.java15;

public class MultiLineEx {

  public static void main(String[] args) {
    //=============================================
    // Multiline
    //=============================================
    // java8
    String greeting = "안녕하세요.\n"
        + "만나서 반갑습니다";
    System.out.println(greeting);

    // java15
    String greeting2 = """
        안녕하세요.
        만나서 반갑습니다""";
    System.out.println(greeting2);

    if (greeting.equals(greeting2)) {
      System.out.println("일치합니다");
    }

    String greeting3 = """
        안녕하세요. \
        만나서 반갑습니다""";
    System.out.println(greeting3);  // 안녕하세요. 만나서 반갑습니다
  }

}
