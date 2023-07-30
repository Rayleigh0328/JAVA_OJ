package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class P5641 {
    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (x,y) -> y[1] - x[1]);
        int result = 0;
        for (int i=0;i<boxTypes.length;++i){
            if (truckSize > boxTypes[i][0]) {
                result += boxTypes[i][0] * boxTypes[i][1];
                truckSize -= boxTypes[i][0];
            }
            else {
                result += truckSize * boxTypes[i][1];
                break;
            }
        }
        return result;
    }
}
