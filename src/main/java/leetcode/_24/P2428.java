package leetcode._24;

public class P2428 {
    public int maxSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int result = -1;
        for (int i=1;i<n-1;++i)
            for (int j=1;j<m-1;++j)
                result = Math.max(result, getHourglassSum(grid,i,j));
        return result;
    }

    private int getHourglassSum(int[][] grid, int x, int y) {
        return grid[x-1][y-1]
            + grid[x-1][y]
            + grid[x-1][y+1]
            + grid[x][y]
            + grid[x+1][y-1]
            + grid[x+1][y]
            + grid[x+1][y+1];
    }
}
