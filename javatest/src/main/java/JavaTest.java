import builder_pattern.NyPizza;
import builder_pattern.Pizza;
import interfaces.DefaultStaticInterface;
import interfaces.StaticInterface;

import java.util.EnumSet;

public class JavaTest {
    public static void main(String[] args) {
//        StaticInterface.singleGreeting();
//
//        DefaultStaticInterface defaultStaticInterface = new DefaultStaticInterface();
//        defaultStaticInterface.greeting();

        NyPizza pizza = new NyPizza.Builder(NyPizza.Size.SMALL)
                .addToppoing(Pizza.Topping.HAM).build();
    }
}
