import builder_pattern.NyPizza;
import builder_pattern.Pizza;
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

<<<<<<< HEAD
        /*
        자원 해제 테스트
         */
        WeakHashMapTest weakHashMapTest = new WeakHashMapTest();
        weakHashMapTest.testWithHashMap();
        weakHashMapTest.testWithWeakHashMap();
=======
        NyPizza pizza = new NyPizza.Builder(NyPizza.Size.SMALL)
                .addToppoing(Pizza.Topping.HAM).build();
>>>>>>> 73b65ba16cb570194608eb9bf848982a7a0691a9
    }
}
