class Solution {
    public int countSubarrays(int[] arr) {
        // code here
        int n = arr.length;
        int count = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peek() > arr[i]) {
                stack.pop();
            }
            count += stack.size() + 1;
            stack.push(arr[i]);
        }
        return count;   // now returning int
    }
}