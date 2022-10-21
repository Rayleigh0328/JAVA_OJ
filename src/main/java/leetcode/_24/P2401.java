package leetcode._24;

 public class P2401 {

     private static final int MAX_SIZE = 32;
     private static final boolean flag [] =  new boolean [MAX_SIZE];

    public int longestNiceSubarray(int[] nums) {
        for (int i=0;i<flag.length;++i) flag[i] = false;
        int L = 0, R = 0, result = 0;
        while (R < nums.length) {
            if (check(nums[R])) {
                include(nums[R]);
                ++R;
            }
            else {
                exclude(nums[L]);
                ++L;
            }
            result = Math.max(result, R-L);
        }
        return result;
    }

    boolean check(int n) {
        for (int i=0;i<MAX_SIZE;++i)
            if ((n & (1<<i)) > 0 && flag[i]) return false;
        return true;
    }

    void include(int n) {
        for (int i=0;i<MAX_SIZE;++i)
            if ((n & (1<<i)) > 0) flag[i] = true;
    }

     void exclude(int n) {
         for (int i=0;i<MAX_SIZE;++i)
             if ((n & (1<<i)) > 0) flag[i] = false;
     }
}
