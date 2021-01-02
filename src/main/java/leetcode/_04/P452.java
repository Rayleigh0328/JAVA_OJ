package leetcode._04;

import java.util.Arrays;
import java.util.Comparator;

public class P452 {

    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) return 0;
        Arrays.sort(points, Comparator.comparingInt(p -> p[1]));
        int cur = points[0][1], result = 1;
        int [] point;
        for (int i=1;i<points.length;++i) {
            point = points[i];
            if (point[0] > cur) {
                ++result;
                cur = point[1];
            }
        }
        return result;
    }

}
