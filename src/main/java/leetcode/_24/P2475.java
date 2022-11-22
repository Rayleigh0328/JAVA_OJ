package leetcode._24;

public class P2475 {


    public int unequalTriplets(int[] a) {
        int result = 0;
        final int n = a.length;
        for (int i=0;i<n;++i)
            for (int j=i+1;j<n;++j)
                for (int k=j+1;k<n;++k) {
                    if (a[i] != a[j] && a[i] != a[k] && a[j] != a[k]) {
                        ++result;
                    }
                }
        return result;
    }



}
