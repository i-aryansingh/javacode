class Solution {
    public int countLessEqual(int[] arr, int x) {
        // code here
       
        int n = arr.length;
        int pivot = findPivot(arr);
        
        int count = 0;
        
        count += upperBound(arr, 0, pivot - 1, x);
        count += upperBound(arr, pivot, n - 1, x);
        
        return count;
    }
    
    private int findPivot(int[] arr) {
        int low = 0, high = arr.length - 1;
        
        while (low < high) {
            int mid = (low + high) / 2;
            
            if (arr[mid] > arr[high])
                low = mid + 1;
            else
                high = mid;
        }
        return low;
    }
    
    private int upperBound(int[] arr, int l, int r, int x) {
        
        int left = l;
        int ans = -1;
        
        while (l <= r) {
            int mid = (l + r) / 2;
            
            if (arr[mid] <= x) {
                ans = mid;
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        
        if (ans == -1) return 0;
        return ans - left + 1;
    }
}