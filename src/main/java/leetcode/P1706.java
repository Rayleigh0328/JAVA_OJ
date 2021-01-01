package leetcode;

public class P1706 {
    private int n,m;
    int [][] g;

    public int[] findBall(int[][] grid) {
        g = grid;
        n = g.length;
        m = g[0].length;

        int result [] = new int [m];
        for (int i=0;i<m;++i) {
            result[i] = solve(0,i);
        }
        return result;
    }

    private int solve(int x, int y) {
        if (x == n) return y;
        if (!inBoard(x,y)) return -1;


        if (getValue(x, y+g[x][y]) == g[x][y]) {
            return solve(x+1, y+g[x][y]);
        }
        else {
            return -1;
        }
    }

    private boolean inBoard(int x, int y){
        if (x < 0 || x >= n) return false;
        if (y < 0 || y >= m) return false;
        return true;
    }

    private int getValue(int x, int y){
        if (!inBoard(x,y)) return 0;
        return g[x][y];
    }
}
