package leetcodeproblems.arrayproblems;

public class MinimumSizeSubarraySum {
    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7,new int[]{2,3,1,2,4,3}));
    }
    public static int minSubArrayLen(int target, int[] nums) {

        int result = 0;
        int array[] = new int[82];

        for(int i = 0;i<nums.length;i++){
            System.out.println(" arrays: "+array[nums[i]]+" nums: "+nums[i]);

            if(array[nums[i]] > 0){
                result = Math.max(result,array[nums[i]] + nums[i]);
            }
            array[nums[i]] = Math.max(array[nums[i]],nums[i]);
        }
        System.out.println(result);


        return 0;
    }
}
