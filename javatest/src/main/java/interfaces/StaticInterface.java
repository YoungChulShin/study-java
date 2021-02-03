package interfaces;

public interface StaticInterface {

    void greeting();

    static void singleGreeting() {
        System.out.println("Hi my self");
    }
}
