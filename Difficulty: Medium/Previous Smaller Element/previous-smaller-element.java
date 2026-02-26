class Solution {
    public static ArrayList<Integer> prevSmaller(int[] arr) {
        // code here
         int n = arr.length;
        ArrayList<Integer> result = new ArrayList<>(n);
        ArrayDeque<Integer> stack = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && stack.peekLast() >= arr[i])
                stack.removeLast();
            if (stack.isEmpty())
                result.add(-1);
            else
                result.add(stack.peekLast());
            stack.addLast(arr[i]);
        }
        return result;
    }
}