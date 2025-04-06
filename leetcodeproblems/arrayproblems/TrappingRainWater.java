package leetcodeproblems.arrayproblems;

public class TrappingRainWater {
    public static void main(String[] args) {
        System.out.println(trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
    /**
     * @Leetcode
     * @Hard
     * @Important
     * @42. Trapping Rain Water
     * @https://leetcode.com/problems/trapping-rain-water/description/?envType=problem-list-v2&envId=array
     *
     * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it can trap after raining.
     *
     * Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * Output: 6
     * Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
     * Example 2:
     *
     * Input: height = [4,2,0,3,2,5]
     * Output: 9
     * */
    public static int trap(int[] height) {

        int leftIndex = 0;
        int rightIndex = height.length-1;
        int leftMax = height[leftIndex];
        int rightMax = height[rightIndex];
        int maxArea = 0;
        while (leftIndex < rightIndex){
            if(leftMax < rightMax){
                maxArea += leftMax - height[leftIndex];
                leftIndex++;
                leftMax = Math.max(leftMax,height[leftIndex]);
            }else{
                maxArea += rightMax - height[rightIndex];
                rightIndex--;
                rightMax = Math.max(rightMax,height[rightIndex]);
            }
        }
        return maxArea;
    }
}
