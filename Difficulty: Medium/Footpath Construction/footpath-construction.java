//User function Template for Java
class Solution {
    public int[] createFootpath(int n, int m, int a[][], int q, int queries[][]) {
        int[][] tl = new int[n][m];
        int[][] tr = new int[n][m];
        int[][] bl = new int[n][m];
        int[][] br = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                tl[i][j] = a[i][j];
                if (i > 0)
                    tl[i][j] = Math.min(tl[i][j], tl[i - 1][j]);
                if (j > 0)
                    tl[i][j] = Math.min(tl[i][j], tl[i][j - 1]);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = m - 1; j >= 0; j--) {
                tr[i][j] = a[i][j];
                if (i > 0)
                    tr[i][j] = Math.min(tr[i][j], tr[i - 1][j]);
                if (j < m - 1)
                    tr[i][j] = Math.min(tr[i][j], tr[i][j + 1]);
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                bl[i][j] = a[i][j];
                if (i < n - 1)
                    bl[i][j] = Math.min(bl[i][j], bl[i + 1][j]);
                if (j > 0)
                    bl[i][j] = Math.min(bl[i][j], bl[i][j - 1]);
            }
        }
        for (int i = n - 1; i >= 0; i--) {
            for (int j = m - 1; j >= 0; j--) {
                br[i][j] = a[i][j];
                if (i < n - 1)
                    br[i][j] = Math.min(br[i][j], br[i + 1][j]);
                if (j < m - 1)
                    br[i][j] = Math.min(br[i][j], br[i][j + 1]);
            }
        }
        int[] result = new int[q];
        for (int k = 0; k < q; k++) {
            int r = queries[k][0] - 1;
            int c = queries[k][1] - 1;
            int sum = 0;
            if (r > 0 && c > 0)
                sum += tl[r - 1][c - 1];
            if (r > 0 && c < m - 1)
                sum += tr[r - 1][c + 1];
            if (r < n - 1 && c > 0)
                sum += bl[r + 1][c - 1];
            if (r < n - 1 && c < m - 1)
                sum += br[r + 1][c + 1];
            result[k] = sum;
        }
        return result;
    }
}