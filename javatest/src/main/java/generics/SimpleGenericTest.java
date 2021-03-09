package generics;

import java.util.HashSet;
import java.util.Set;

public class SimpleGenericTest {

    public void simpleTest() {
        Set<String> simpleSet = new HashSet<>();
        simpleSet.add("1");

        Set<?> wildSet = new HashSet<>();
        wildSet.add(null);
    }

    public int numElementInCommon(Set s1, Set s2) {
        int result = 0;
        for (Object o1 : s1) {
            if (s2.contains(o1)) {
                result++;
            }
        }
        return result;
    }

    public int numElementInCommon2(Set<String> s1, Set<String> s2) {
        int result = 0;
        for (String o1 : s1) {
            if (s2.contains(o1)) {
                result++;
            }
        }

        return result;
    }

    public int numElementInCommon3(Set<?> s1, Set<?> s2) {
        int result = 0;
        for (Object o1 : s1) {
            if (s2.contains(o1)) {
                result++;
            }
        }

        return result;
    }
}
