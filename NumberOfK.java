/**
 * Created by JEWELZ on 5/5/15.
 */
public class NumberOfK {
    public static void main(String[] args) {
        System.out.println(new NumberOfK().GetNumberOfK(new int[]{1, 2, 3, 3, 3, 3, 4, 5}, 3));
    }

    public int GetNumberOfK(int[] array, int k) {
        if (array == null || array.length <= 0)
            return 0;
        int number = 0;
        int first = 0;
        int last = 0;
        if (array != null && array.length > 0) {
            first = getFirstK(array, k, 0, array.length - 1);
            last = getLastK(array, k, 0, array.length - 1);
        }

        if (first > -1 && last > -1)
            number = last - first + 1;
        return number;
    }

    public int getFirstK(int arr[], int k, int start, int end) {
        if (start > end)
            return -1;

        int middleIndex = (start + end) / 2;
        int middleData = arr[middleIndex];

        if (middleData == k) {
            if ((middleIndex > 0 && arr[middleIndex - 1] != k) || middleIndex == 0)
                return middleIndex;
            else
                end = middleIndex - 1;
        } else if (middleIndex > k)
            end = middleIndex - 1;
        else
            start = middleIndex + 1;

        return getFirstK(arr, k, start, end);
    }

    public int getLastK(int arr[], int k, int start, int end) {
        if (start > end)
            return -1;
        int middleIndex = (start + end) / 2;
        int middleData = arr[middleIndex];

        if (middleData == k) {
            if ((middleIndex < arr.length - 1 && arr[middleIndex + 1] != k) || middleIndex == arr.length - 1)
                return middleIndex;
            else
                start = middleIndex + 1;
        } else if (middleIndex < k)
            start = middleIndex + 1;
        else
            end = middleIndex - 1;
        return getLastK(arr, k, start, end);
    }
}
