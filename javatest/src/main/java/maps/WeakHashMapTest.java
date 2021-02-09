package maps;

import java.util.HashMap;
import java.util.WeakHashMap;

public class WeakHashMapTest {

    public void testWithHashMap() {
        HashMap<Integer, String> testMap = new HashMap<Integer, String>();

        Integer key1 = 10;
        Integer key2 = 100;

        testMap.put(key1, "test 1");
        testMap.put(key2, "test 2");

        key1 = null;

        System.gc();

        testMap.entrySet().stream().forEach(i -> System.out.println("Hashmap :" + i));
    }

    public void testWithWeakHashMap() {

        WeakHashMap<Integer, String> testMap2 = new WeakHashMap<>();

        Integer key1 = 300;
        Integer key2 = 200;

        testMap2.put(key1, "test 1");
        testMap2.put(key2, "test 2");

        key1 = null;

        System.gc();

        testMap2.entrySet().stream().forEach(i -> System.out.println(i));

//        WeakHashMap<Integer, String> map = new WeakHashMap<>();
//
//        Integer key1 = 1000;
//        Integer key2 = 2000;
//
//        map.put(key1, "test a");
//        map.put(key2, "test b");
//
//        key1 = null;
//
//        System.gc();  //강제 Garbage Collection
//
//        map.entrySet().stream().forEach(el -> System.out.println("map" + el));

    }
}
