/*Complete the Function below*/
class Solution {
    public static boolean isPalinArray(int[] arr) {
        // add code here.
         for(int i=0;i<arr.length;i++){
            if(!isPalindrome(arr[i])){
                return false;
            }
        }
        return true;
    }
    private static boolean isPalindrome(int num){
        int original=num,reverse=0;
        while(num>0){
            reverse=reverse*10+(num%10);
            num=num/10;
        }
        return original==reverse;
    }
}