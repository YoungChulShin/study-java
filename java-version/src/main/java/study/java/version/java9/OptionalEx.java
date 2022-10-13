package study.java.version.java9;

import java.util.Optional;

public class OptionalEx {

  public static void main(String[] args) {
    //=============================================
    // ifPresentOrElse
    //=============================================
    // java8
    Optional<String> message = Optional.empty();
    if (message.isPresent()) {
      System.out.println(message.get());
    } else {
      System.out.println("empty");
    }

    // java9
    message.ifPresentOrElse(System.out::println, () -> System.out.println("empty"));

  }
}
