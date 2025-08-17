package leetcodeproblems.divideandconquer;

import java.util.Arrays;

/**
 *
 * The core idea of Merge Sort is to recursively split the array in half until each sub-array contains only one element.
 * A single-element array is, by definition, sorted. Then, it merges these sorted sub-arrays back together in a way that maintains the sorted order.
 * This process repeats until the entire array is sorted.
 *
 * Breakdown of the Code
 * mergeSort(int arr[], int l, int r)
 * This is the main recursive function.
 *
 * It takes the array arr[] along with the starting index l and the ending index r.
 *
 * The base case of the recursion is if (l < r). This condition checks if the sub-array has more than one element.
 * If l is not less than r, it means the sub-array has either one element or is empty, so it's already sorted and the recursion stops.
 *
 * It finds the middle index m of the sub-array. The formula l + (r - l) / 2 is used to prevent potential integer overflow issues that might occur with (l + r) / 2 for very large arrays.
 *
 * It then makes two recursive calls:
 *
 * mergeSort(arr, l, m): Sorts the first half of the sub-array.
 *
 * mergeSort(arr, m + 1, r): Sorts the second half of the sub-array.
 *
 * Finally, after the two halves are sorted, it calls the merge() function to combine them.
 *
 * merge(int arr[], int l, int m, int r)
 * This function is the "conquer" part of the algorithm. It merges two sorted sub-arrays into a single, sorted array.
 *
 * The first sub-array is from arr[l] to arr[m].
 *
 * The second sub-array is from arr[m + 1] to arr[r].
 *
 * It first calculates the sizes of the two sub-arrays (n1 and n2).
 *
 * It creates two temporary arrays, L[] and R[], and copies the elements from the two sub-arrays into them.
 *
 * Using a while loop, it compares the elements of L[] and R[] one by one. The smaller element is placed into the correct position in the main array arr[].
 * This continues until one of the temporary arrays is exhausted.
 *
 * After the main while loop, there might be remaining elements in either L[] or R[]. The two final while loops handle this by copying any leftover elements into arr[].
 *
 * main(String args[])
 * This is the entry point of the program.
 *
 * It initializes an unsorted integer array arr = {38, 27, 43, 10}.
 *
 * It calls mergeSort() with the array and its starting and ending indices (0 and arr.length - 1).
 *
 * After mergeSort completes, the array will be sorted.
 *
 * It then iterates through the sorted array and prints the elements to the console.
 * */
public class MergeSortExample {
    public static void main(String[] args) {

        int [] array = new int[]{38, 27, 43, 10};
        int arrayLength = array.length;
        merge(array,0,arrayLength-1);

        Arrays.stream(array).forEach(System.out::println);
    }
    public static void merge(int[] array, int left, int right){
        if(left < right){

            // Find the middle point
            int mid = left + (right - left)/2;

            merge(array,left,mid);
            merge(array,mid+1,right);

            mergeSort(array,left,right,mid);
        }
    }
    public static void mergeSort(int[] array,int left,int right,int mid){

        int i = 0, j = 0, k = left;

        int leftArraySize = mid - left + 1;
        int rightArraySize = right - mid;

        int [] leftSubArray = new int[leftArraySize];
        int [] rightSubArray = new int[rightArraySize];

        for(int index = 0;index<leftArraySize;index++) leftSubArray[index] = array[left + index];
        for(int secondIndex = 0;secondIndex<rightArraySize;secondIndex++) rightSubArray[secondIndex] = array[mid + 1 +secondIndex];

        while((i < leftArraySize) && (j < rightArraySize)){
            if(leftSubArray[i] <= rightSubArray[j]){
                array[k] = leftSubArray[i];
                i++;
            }else{
                array[k] = rightSubArray[j];
                j++;
            }
            k++;
        }

        while(i < leftArraySize){
            array[k] = leftSubArray[i];
            i++;
            k++;
        }

        while(j < rightArraySize){
            array[k] = rightSubArray[j];
            j++;
            k++;
        }
    }
}
