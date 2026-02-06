// User function Template for Java

class Solution {
    public int findMinDiff(ArrayList<Integer> arr, int m) {
        // your code here
        if(m==0||arr.size()==0||m>arr.size())return 0;
        Collections.sort(arr);
        int d=Integer.MAX_VALUE;
        for(int i=0;i+m-1<arr.size();i++)
            d=Math.min(d,arr.get(i+m-1)-arr.get(i));
        return d;
    }
}