package leetcode._24;

public class P2435 {
    private final int mode = 1_000_000_000 + 7;

    public int numberOfPaths(int[][] grid, int target) {
        int n = grid.length;
        int m = grid[0].length;
        int [][][] f = new int[n][m][target];
        f[0][0][grid[0][0]%target] = 1;
        for (int i=0;i<n;++i)
            for (int j=0;j<m;++j) {
                if (i == 0 && j == 0) continue;
                for (int k = 0; k < target; ++k) {
                    int prev = ((k-grid[i][j]) % target + target) % target; // this is to handle k-grid[i][j] < 0
                    if (i>0) f[i][j][k] += f[i-1][j][prev];
                    if (j>0) f[i][j][k] += f[i][j-1][prev];
                    f[i][j][k] %= mode;
                }
            }

        return f[n-1][m-1][0];
    }
}
