package leetcode._24;

import lib.common.BitwiseHelper;

public class P2429 {
    public int minimizeXor(int num1, int num2) {
        int count1 = (int) BitwiseHelper.getSetBits(num1);
        int count2 = (int) BitwiseHelper.getSetBits(num2);
        if (count1 >= count2) {
            return getHighBits(num1, count2);
        } else {
            // this is to flip every bit but the sign bit (~num1) & 0x7FFFFFFF
            return num1 + getLowBits(BitwiseHelper.flip(num1), count2 - count1);
        }
    }

    private int getLowBits(int x, int target) {
        int result = 0;
        for (int i=0;i<target && x != 0; ++i) {
            int tmp = (int) BitwiseHelper.lowBit(x);
            result += tmp;
            x -= tmp;
        }
        return result;
    }

    private int getHighBits(int x, int target) {
        int result = 0;
        for (int i=0;i<target && x != 0; ++i) {
            int tmp = (int) BitwiseHelper.highBit(x);
            result += tmp;
            x -= tmp;
        }
        return result;
    }
}
