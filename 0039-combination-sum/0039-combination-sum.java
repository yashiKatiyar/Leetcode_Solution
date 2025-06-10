import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        helper(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    public static void helper(int[] candidates, int target, int i, List<Integer> currList, List<List<Integer>> result) {
        if (target == 0) {
            result.add(new ArrayList<>(currList));
            return;
        }

        if (i >= candidates.length || target < 0) {
            return;
        }

        // Include current element
        currList.add(candidates[i]);
        helper(candidates, target - candidates[i], i, currList, result); // Continue with the same index
        currList.remove(currList.size() - 1); // Backtrack

        // Exclude current element and move to next index
        helper(candidates, target, i + 1, currList, result);
    }
}