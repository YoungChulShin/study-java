package study.gc;

import java.util.ArrayList;
import java.util.List;

public class GCMaker {

    public static void main(String[] args) throws InterruptedException {
        GCMaker gcMaker = new GCMaker();
        for (int loop = 0; loop < 120; loop++) {
            gcMaker.makeObject();
            Thread.sleep(1000);
            System.out.println(".");
        }
    }

    private void makeObject() {
        Integer[] intArr = new Integer[1024000];
        List<Integer> list = new ArrayList<>(1024000);
        for (int loop = 0; loop < 1024; loop++) {
            intArr[loop] = loop;
            list.add(loop);
        }
    }
}
