class Solution {
    public ArrayList<ArrayList<Integer>> combinationSum(int n, int k) {
        // code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        for (int mask = 0; mask < (1 << 9); mask++) {
            ArrayList<Integer> temp = new ArrayList<>();
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                if ((mask & (1 << i)) != 0) {
                    temp.add(i + 1);
                    sum += (i + 1);
                }
            }
            if (temp.size() == k && sum == n) {
                result.add(temp);
            }
        }
        return result;
    }
}