package study.java.version.java11;

import java.util.stream.Stream;
import org.apache.commons.lang3.StringUtils;

public class StringEx {

  public static void main(String[] args) {
    //=============================================
    // String 헬퍼 메서드 추가 - 공백체크
    //=============================================
    // java 8 공백 체크
    String greeting = " ";

    if (greeting.trim().isEmpty()) {
      System.out.println("blank");
    }

    // java 8 + Apache Commons Lang library
    if (StringUtils.isBlank(greeting)) {
      System.out.println("blank");
    }

    // java 11
    if (greeting.isBlank()) {
      System.out.println("blank");
    }

    //=============================================
    // String 헬퍼 메서드 추가 - lines
    //=============================================
    String mixedAlphabet = "aaaa\rbbbb\ncccc";
    Stream<String> lines = mixedAlphabet.lines();
    lines.forEach(System.out::println);
    // aaaa
    // bbbb
    // cccc
  }

}
