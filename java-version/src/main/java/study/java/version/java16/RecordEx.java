package study.java.version.java16;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class RecordEx {

  public static void main(String[] args) {

    //=============================================
    // Pattern Matching for instanceOf
    //=============================================
    // Java 14 (Preview), Java16 (Official)
    // constructor
    Point2 point = new Point2(1, 2);
    // getter
    point.x();
    point.y();
    // toString()
    System.out.println(point); // Point2[x=1, y=2]
    // equals
    Point2 point2 = new Point2(1, 2);
    if (point.equals(point2)) { // true
      System.out.println("equal!");
    }
    // hashCode
    Set<Point2> pointSet = new HashSet<>();
    pointSet.add(point);
    pointSet.add(point2);
    System.out.println(pointSet.size());  // 1

    // record test
    var sampleRequest = new SampleRequest(1L, "myname", 20);
    sampleRequest.printName();
  }
}
