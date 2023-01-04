package leetcode._25;

public class P2520 {


    public int countDigits(int num) {
        String str = String.valueOf(num);
        int tmp;
        int count = 0;
        for (char ch : str.toCharArray()) {
            tmp = ch - '0';
            if (num % tmp == 0) ++count;
        }
        return count;
    }


}
