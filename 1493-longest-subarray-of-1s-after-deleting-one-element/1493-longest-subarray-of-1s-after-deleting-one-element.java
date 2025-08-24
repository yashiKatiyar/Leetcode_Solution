class Solution {
    public int longestSubarray(int[] nums) {
        int len = nums.length;
        int [] leftLen = new int [len];
        int [] rightLen = new int [len];
        for(int i = 1; i<len ; i++){
            if (nums[i-1] ==1){
                leftLen[i] = leftLen[i-1] + 1;
            }
        }
        for(int i = len-2; i>=0;i--){
            if(nums[i+1]==1){
                rightLen[i]= rightLen[i+1] +1;
            }
        }
        int maxSubArr = 0;
        for(int i=0 ; i<len ;++i){
            maxSubArr = Math.max(maxSubArr, leftLen[i]+rightLen[i]);
        }
        if (maxSubArr ==len){
            maxSubArr--;
        }
        return maxSubArr;
    }
}