package compares;

import java.util.Comparator;

public class PhoneNumber implements Comparable<PhoneNumber> {

    private int areaCode;
    private int prefix;
    private int lineNum;

    private static final Comparator<PhoneNumber> COMPARATOR =
            Comparator.comparingInt((PhoneNumber x) -> x.areaCode)
                    .thenComparingInt(x -> x.lineNum)
                    .thenComparingInt(x -> x.prefix);

    @Override
    public int compareTo(PhoneNumber o) {
        return COMPARATOR.compare(this, o);
    }
}
