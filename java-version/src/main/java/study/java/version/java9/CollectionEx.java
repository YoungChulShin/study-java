package study.java.version.java9;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Dictionary;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectionEx {

  public static void main(String[] args) {
    //=============================================
    // Collection 생성
    //=============================================
    // java 8
    List<Integer> listInteger1 = new ArrayList<>();
    listInteger1.add(1);
    listInteger1.add(2);
    listInteger1.add(3);

    List<Integer> listInteger2 = new ArrayList<>() {{
        add(1);
        add(2);
        add(3);
      }};

    List<Integer> listInteger3 = Stream.of(1, 2, 3).collect(Collectors.toList());

    List<Integer> listInteger4 = Arrays.asList(1, 2, 3, 4, 5);

    // java9
    List<Integer> listInteger5 = List.of(1, 2, 3);

  }
}
