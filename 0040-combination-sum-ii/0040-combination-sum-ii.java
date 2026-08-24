import java.util.*;

class Solution {

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new ArrayList<>();

        Arrays.sort(candidates);

        backtrack(candidates, target, 0, new ArrayList<>(), result);

        return result;
    }

    private void backtrack(int[] candidates, int target, int start,
                           List<Integer> current,
                           List<List<Integer>> result) {

        // Target achieved
        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = start; i < candidates.length; i++) {

            // Skip duplicate combinations
            if (i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // If current number is greater than target,
            // no further numbers can be used
            if (candidates[i] > target) {
                break;
            }

            // Choose current number
            current.add(candidates[i]);

            // i + 1 means each element can be used only once
            backtrack(
                candidates,
                target - candidates[i],
                i + 1,
                current,
                result
            );

            // Remove current number (backtracking)
            current.remove(current.size() - 1);
        }
    }
}