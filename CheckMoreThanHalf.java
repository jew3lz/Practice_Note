/**
 * Created by JEWELZ on 28/7/15.
 */
public class CheckMoreThanHalf {

    boolean g_InvalidInput = false;

    public static void main(String[] args) {
        CheckMoreThanHalf checkMoreThanHalf = new CheckMoreThanHalf();
        System.out.println(checkMoreThanHalf.MoreThanHalfNum_Solution(new int[]{1, 2, 3, 2, 2, 2, 5, 4, 2}));
    }

    public int MoreThanHalfNum_Solution(int[] array) {
        if (array == null || array.length < 1) {
            g_InvalidInput = true;
            return 0;
        }
        int middle = array.length / 2;
        int start = 0;
        int end = array.length - 1;
        int resIndex = partition(array, start, end);
        while (resIndex != middle) {
            if (resIndex > middle)
                resIndex = partition(array, start, resIndex - 1);
            else
                resIndex = partition(array, resIndex + 1, end);
        }
        if (!checkMoreThanHalf(array, array[resIndex])) {
            g_InvalidInput = true;
            return 0;
        }
        return array[resIndex];
    }

    public int MoreThanHalfNum_Solution2(int[] array) {
        if (array == null || array.length < 1) {
            g_InvalidInput = true;
            return 0;
        }
        int res = array[0];
        int times = 1;
        for (int i = 1; i < array.length; i++) {
            if (times == 0) {
                res = array[i];
            } else if (array[i] == res)
                times++;
            else
                times--;
        }
        if (!checkMoreThanHalf(array, res)) {
            g_InvalidInput = true;
            return 0;
        }
        return res;
    }

    private int partition(int[] arr, int start, int end) {
        int pivotKey = arr[start];
        while (start < end) {
            while (start < end && arr[end] >= pivotKey)
                end--;
            arr[start] = arr[end];
            while (start < end && arr[start] <= pivotKey)
                start++;
            arr[end] = arr[start];
        }

        arr[start] = pivotKey;//一趟快排完成后start位为空,填补上
        return start;//返回中轴位置
    }

    private boolean checkMoreThanHalf(int[] arr, int num) {
        int times = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == num)
                times++;
        }
        return times > arr.length / 2;
    }
}
