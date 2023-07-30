package lib.string.suffix_array;

import java.util.List;

public class SuffixArray {

    // EOS is the character padded at the end of the original string
    private static final int EOS = -1;

    private int [] a;
    private int [] sa;
    private int [] rank;
    private int [] height;

    public SuffixArray(List<Integer> list, SuffixArrayConstructor saConstructor) {
        a = new int[list.size() + 1];
        for (int i=0;i<list.size();++i) a[i] = list.get(i);
        a[list.size()] = -1;

        rank = saConstructor.buildRank(a);
        sa = saConstructor.buildSaFromRank(rank);
        buildHeight();
    }

    public SuffixArray(String st, SuffixArrayConstructor saConstructor){
        a = new int[st.length() + 1];
        for (int i=0; i<st.length();++i) a[i] = st.charAt(i);
        a[st.length()] = -1;

        rank = saConstructor.buildRank(a);
        sa = saConstructor.buildSaFromRank(rank);
        buildHeight();
    }

    private void buildHeight(){
        int currentHeight = 0;
        height = new int [sa.length];
        height[0] = 0;
        for (int i=0;i<sa.length-1; ++i){
            int prevIndex = sa[rank[i] - 1];
            while (a[i + currentHeight] == a[prevIndex + currentHeight]) ++currentHeight;
            height[rank[i]] = currentHeight;
            currentHeight = Math.max(0, currentHeight - 1);
        }
    }

    public int[] getA() {
        return a;
    }

    public int[] getSa() {
        return sa;
    }

    public int[] getRank() {
        return rank;
    }

    public int[] getHeight() {
        return height;
    }

}

