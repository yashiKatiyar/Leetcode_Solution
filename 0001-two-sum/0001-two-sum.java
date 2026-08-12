class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> newMap = new HashMap<>();
        int n = nums.length;
        for(int i=0;i<n;i++){
            newMap.put(nums[i],i);
        }
        for(int i=0 ;i<n ; i++){
            int complement = target -nums[i];
            if(newMap.containsKey(complement)&& newMap.get(complement)!=i){
                return new int[]{i,newMap.get(complement)};
            }

        }
        return null;
    }
}