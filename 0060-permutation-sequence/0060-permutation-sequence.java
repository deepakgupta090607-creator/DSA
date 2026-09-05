class Solution {
    public String getPermutation(int n, int k) {

        // Store numbers 1 to n
        List<Integer> numbers = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        // Factorials
        int[] fact = new int[n + 1];
        fact[0] = 1;

        for (int i = 1; i <= n; i++) {
            fact[i] = fact[i - 1] * i;
        }

        // Convert k to 0-based index
        k--;

        StringBuilder ans = new StringBuilder();

        for (int i = n; i >= 1; i--) {

            // Size of each block
            int blockSize = fact[i - 1];

            // Find which block k belongs to
            int index = k / blockSize;

            // Select the number
            ans.append(numbers.get(index));

            // Remove selected number
            numbers.remove(index);

            // Move inside the selected block
            k = k % blockSize;
        }

        return ans.toString();
    }
}