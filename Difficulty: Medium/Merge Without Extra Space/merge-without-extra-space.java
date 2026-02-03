class Solution {
    private int nextGap(int gap) {
        if (gap <= 1) return 0;
        return (gap / 2) + (gap % 2);
    }
    public void mergeArrays(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int gap = nextGap(n + m);
        while (gap > 0) {
            int i = 0;
            while (i + gap < n) {
                if (a[i] > a[i + gap]) {
                    int temp = a[i];
                    a[i] = a[i + gap];
                    a[i + gap] = temp;
                }
                i++;
            }
            int j = gap > n ? gap - n : 0;
            i = i < n ? i : n;
            while (i < n && j < m) {
                if (a[i] > b[j]) {
                    int temp = a[i];
                    a[i] = b[j];
                    b[j] = temp;
                }
                i++;
                j++;
            }
            if (j < m) {
                j = 0;
                while (j + gap < m) {
                    if (b[j] > b[j + gap]) {
                        int temp = b[j];
                        b[j] = b[j + gap];
                        b[j + gap] = temp;
                    }
                    j++;
                }
            }
            gap = nextGap(gap);
        }
    }
}
