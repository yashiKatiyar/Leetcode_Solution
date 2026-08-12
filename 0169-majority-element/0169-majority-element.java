class Solution {
    public int majorityElement(int[] nums) {
        int n = nums.length;
        Map<Integer, Integer> freq = new HashMap<>();

        for(int i=0; i<n; i++){
            freq.put(nums[i], freq.getOrDefault(nums[i],0)+1);
        }
        n=n/2;
        for(Map.Entry<Integer,Integer> entry: freq.entrySet()){
            if(entry.getValue()>n){
                return entry.getKey();
            }
        }
        return 0;
    }
}