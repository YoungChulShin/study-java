package compares;

public class CaseInsensitiveString implements Comparable<CaseInsensitiveString> {
    String s;

    @Override
    public int compareTo(CaseInsensitiveString o) {
        return String.CASE_INSENSITIVE_ORDER.compare(s, o.s);
    }
}
