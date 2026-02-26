class Solution {
    public int maxPeople(int[] arr) {
       // code here
         int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                left[i] = i;
            } else {
                left[i] = i - stack.peek() - 1;
            }
            stack.push(i);
        }
        stack.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                right[i] = n - i - 1;
            } else {
                right[i] = stack.peek() - i - 1;
            }
            stack.push(i);
        }
        int max = 0;
        for (int i = 0; i < n; i++) {
            max = Math.max(max, left[i] + right[i] + 1);
        }
        return max;
    }
}