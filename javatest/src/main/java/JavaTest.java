import builder_pattern.NyPizza;
import builder_pattern.Pizza;
import interfaces.DefaultStaticInterface;
import interfaces.StaticInterface;
import maps.WeakHashMapTest;
import objects.Point;

import java.util.EnumSet;
import java.util.WeakHashMap;

public class JavaTest {
    public static void main(String[] args) {
//        StaticInterface.singleGreeting();
//
//        DefaultStaticInterface defaultStaticInterface = new DefaultStaticInterface();
//        defaultStaticInterface.greeting();

        /*
        자원 해제 테스트
         */
//        WeakHashMapTest weakHashMapTest = new WeakHashMapTest();
//        weakHashMapTest.testWithHashMap();
//        weakHashMapTest.testWithWeakHashMap();

        /*
        빌더 테스트
         */
//        NyPizza pizza = new NyPizza.Builder(NyPizza.Size.SMALL)
//                .addToppoing(Pizza.Topping.HAM).build();

        Point pointA = new Point(1, 2);
        Point pointB = new Point(1, 2);

        boolean equals = pointA.equals(pointB);
        System.out.println(equals);
    }
}
