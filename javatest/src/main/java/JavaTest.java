import interfaces.DefaultStaticInterface;
import interfaces.StaticInterface;
import maps.WeakHashMapTest;

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
        WeakHashMapTest weakHashMapTest = new WeakHashMapTest();
        weakHashMapTest.testWithHashMap();
        weakHashMapTest.testWithWeakHashMap();
    }
}
