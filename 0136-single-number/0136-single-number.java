class Solution {
  public int singleNumber(int[] nums) {
    int ans = 0;

    for ( int num : nums)
      ans ^= num;
      //xor of number with itself gives zero and with 0 gives number back
      //a^a=0&&a^0=a

    return ans;
  }
}
