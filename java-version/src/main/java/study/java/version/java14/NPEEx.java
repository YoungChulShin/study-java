package study.java.version.java14;

public class NPEEx {

  public static void main(String[] args) {
    //=============================================
    // NullPointerException 표현
    //=============================================
    User user = null;
    System.out.println(user.name);
    // message: Cannot read field "name" because "user" is null
  }

}
