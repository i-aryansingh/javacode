class Solution {
    public ArrayList<Integer> spirallyTraverse(int[][] mat) {
        // code here
          ArrayList<Integer> res=new ArrayList<>();
        int n=mat.length;
        int m=mat[0].length;
        int top=0,bottom=n-1,left=0,right=m-1;
             while(top<=bottom && left<=right){
            for(int i=left;i<=right;i++){
                res.add(mat[top][i]);
            }
            top++;
               for(int i=top;i<=bottom;i++){
                res.add(mat[i][right]);
            }
            right--;
                 if(top<=bottom){
                for(int i=right;i>=left;i--){
                    res.add(mat[bottom][i]);
                }
                bottom--;
            }
            if(left<=right){
                for(int i=bottom;i>=top;i--){
                    res.add(mat[i][left]);
                }
                left++;
            }
        }
        return res;
    }
}