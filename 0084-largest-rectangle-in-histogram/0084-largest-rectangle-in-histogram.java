public class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<Integer> stack = new Stack<>();  // stores indices of increasing bars
        int maxArea = 0;
        int len = heights.length;

        // Go through all bars including an extra 0 at the end
        for (int i = 0; i <= len; i++) {
            int currentHeight = (i == len) ? 0 : heights[i];  // Add dummy 0 at the end

            // If current bar is smaller than the one on top of stack
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];  // Bar to calculate area for

                // how far can this bar extend  meaning width?
                int width;
                if (stack.isEmpty()) {
                    width = i;  // bar spans from 0 to i-1
                } else {
                    width = i - stack.peek() - 1;  // span between current and previous smaller bar
                }

                int area = height * width;  // Calculate area
                maxArea = Math.max(maxArea, area);  // Update max area
            }

            stack.push(i);  // Push current index to stack
        }

        return maxArea;
    }
}
