package lib.common;

public class BitwiseHelper {
    /**
     * Get number of 1s in the binary representation
     * @param x
     * @return count of 1s in the binary representation of x
     */
    public static long getSetBits(long x) {
        int result = 0;
        while (x != 0) {
            ++result;
            x -= lowBit(x);
        }
        return result;
    }

    /**
     * Get the right most 1 in binary representation of x
     *
     * example: lowBit(3) = 1, lowBit(6) = 2
     * @param x
     * @return right most 1
     */
    public static long lowBit(long x) {
        return (x & (-x));
    }

    /**
     * Get the left most 1 in binary representation of x
     *
     * example: highBit(3) = 2, highBit(6) = 4
     * @param x
     * @return
     */
    public static long highBit(long x) {
        // make all right bits 1
        x |= x >> 32;
        x |= x >> 16;
        x |= x >> 8;
        x |= x >> 4;
        x |= x >> 2;
        x |= x >> 1;

        x ^= x >> 1;
        return x;
    }

    /**
     * flip every bit but leave sign bit as 0
     * @param x
     * @return
     */
    public static long flip(long x) {
        return (~x) & 0x7FFF_FFFF_FFFF_FFFFl;
    }

    public static int flip(int x) {
        return (~x) & 0x7FFF_FFFF;
    }
}
