class Solution {
    public boolean has132Pattern(int[] arr) {
        // code here
        int n = arr.length;
        Stack<Integer> stack = new Stack<>();
        int third = Integer.MIN_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            if (arr[i] < third) {
                return true;
            }
            while (!stack.isEmpty() && arr[i] > stack.peek()) {
                third = stack.pop();
            }
            stack.push(arr[i]);
        }
        return false;
    }
}