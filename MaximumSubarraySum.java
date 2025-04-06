public class MaximumSubarraySum {

    public static void main(String[] args) {

        int array[] = {1, 2, 7, -4, 3, 2, -10, 9, 1};
        int sum = 0;
        long max = 0;

        for(int i=0;i<array.length;i++){
            sum = sum + array[i];
            if(max < sum)
                max = sum;
            if(0>sum)
                sum = 0;
        }

        System.out.println(max);
    }
}
