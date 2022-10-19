package lib.string;

public class KMP {

    private String pattern;
    private int [] phi;

    public KMP(String pattern) {
        this(pattern, '$');
    }

    public KMP(String initialPattern, char sentinel) {
        pattern = initialPattern + sentinel;
        phi = new int [pattern.length()];

        phi[0]=-1;
        for (int i=0,j=-1; i<pattern.length()-1; ) {
            if (pattern.charAt(i+1) == pattern.charAt(j+1)) phi[++i] = ++j;
            else if (j == -1) phi[++i] = -1;
            else j = phi[j];
        }
    }

    /**
     * Match pattern against a text string s
     * @param s
     * @return an array t of size |s|
     * t[i] indicates that pattern[0,t[i]] is the longest prefix of pattern that is also a suffix of s[0,i]
     * or -1 is no such prefix exist
     *
     * Note that t[i] == |pattern| - 2 denotes a full match:
     * s[i-|pattern|+2,i] match with pattern[0, |pattern-1|]
     */
    public int [] match(String s) {
        int [] t = new int[s.length()];
        for (int i=-1,j=-1; i<s.length()-1;) {
            if (s.charAt(i+1) == pattern.charAt(j+1)) t[++i] = ++j;
            else if (j == -1) t[++i] = -1;
            else j = phi[j];
        }
        return t;
    }
}
