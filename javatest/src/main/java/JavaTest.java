import interfaces.DefaultStaticInterface;
import interfaces.StaticInterface;

import java.util.EnumSet;

public class JavaTest {
    public static void main(String[] args) {
        StaticInterface.singleGreeting();

        DefaultStaticInterface defaultStaticInterface = new DefaultStaticInterface();
        defaultStaticInterface.greeting();
    }
}
