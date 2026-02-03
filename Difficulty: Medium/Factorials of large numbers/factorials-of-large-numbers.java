// User function Template for Java

class Solution {
    public static ArrayList<Integer> factorial(int n) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        result.add(1); // 0! and 1! = 1
        for (int i = 2; i <= n; i++) {
            int carry = 0;
            for (int j = 0; j < result.size(); j++) {
                int prod = result.get(j) * i + carry;
                result.set(j, prod % 10);
                carry = prod / 10;
            }
            while (carry > 0) {
                result.add(carry % 10);
                carry /= 10;
            }
        }
        int left = 0, right = result.size() - 1;
        while (left < right) {
            int temp = result.get(left);
            result.set(left, result.get(right));
            result.set(right, temp);
            left++;
            right--;
        }
        return result;
    }
}
