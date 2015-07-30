import java.util.Arrays;
import java.util.Random;

/**
 * Created by JEWELZ on 28/7/15.
 */
public class QuickSort {
    public static void main(String[] args) {
        QuickSort qs = new QuickSort();
        int[] arr = new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2};
        Random random = new Random();
//        for (int i = 0; i < 1000; i++) {
//        }
        qs.quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public void quickSort(int[] nums, int start, int end) {
        if (nums == null || nums.length < 1)
            return;
        if (start < end) {
            int middle = Partition(nums, start, end);
            quickSort(nums, start, middle - 1);
            quickSort(nums, middle + 1, end);
        }
    }

    private int Partition(int[] nums, int start, int end) {
        int pivotKey = nums[start];
        while (start < end) {
            while (start < end && nums[end] >= pivotKey)
                end--;
            nums[start] = nums[end];
            while (start < end && nums[start] <= pivotKey)
                start++;
            nums[end] = nums[start];
        }
        nums[start] = pivotKey;
        return start;
    }

}
