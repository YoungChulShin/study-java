package interfaces;

public class DefaultStaticInterface implements StaticInterface {
    @Override
    public void greeting() {
        System.out.println("Hi from default");
    }
}
