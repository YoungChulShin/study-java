package study.java.version.java14;

public class SwitchEx {

  public static void main(String[] args) {
    //=============================================
    // Switch 표현식
    //=============================================
    Nationality my = Nationality.KOREA;

    // java 8
    String greeting;
    switch (my) {
      case KOREA:
        greeting = "안녕하세요";
        break;
      case USA:
        greeting = "헬로";
        break;
      default:
        greeting = "잘 모르겠네요";
        break;
    }
    System.out.println(greeting);

    // java 14
    String greeting2 = switch (my) {
      case KOREA -> "안녕하세요";
      case USA -> "헬로";
      default -> {
        yield "잘 모르겠네요";
      }
    };
    System.out.println(greeting2);
  }

  public enum Nationality {
    KOREA,
    JAPAN,
    USA,
    CHINA
  }
}
