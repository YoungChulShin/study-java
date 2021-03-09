package generics;

import java.util.Arrays;

public class supressWarn {

    Object[] target;
    int size = 5;

    @SuppressWarnings("unchecked")
    public <T> T[] toArray(T[] a) {
        if (a.length < size) {
            return (T[]) Arrays.copyOf(target, size, a.getClass());
        }
        System.arraycopy(target, 0, a, 0, size);
        if (a.length > size) {
            a[size] = null;
        }

        return a;
    }
}
