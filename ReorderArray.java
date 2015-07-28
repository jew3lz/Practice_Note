/**
 * Created by JEWELZ on 12/7/15.
 */
public class ReorderArray {
    public void reOrderArray(int[] array) {
        if (array == null || array.length < 1)
            return;
        int p1 = 0;
        int p2 = array.length - 1;
        while (p1 < p2) {
            while (p1 < p2 && !isEven(array[p1]))
                p1++;
            while (p1 < p2 && isEven(array[p2]))
                p2--;
            if (p1 < p2) {
                int temp = array[p1];
                array[p1] = array[p2];
                array[p2] = temp;
            }
        }
    }


    public boolean isEven(int num) {
        return num % 2 == 0;
    }

    public void reOrderArrayInSort(int[] array) {
        if (array == null || array.length == 0)
            return;
        int tmp = 0;
        for (int i = 0, j = 0; i < array.length && j < array.length; i++) {
            if (array[i] % 2 != 0) {
                tmp = array[i];
                for (int k = i; k > j; k--) {
                    array[k] = array[k - 1];
                }
                array[j] = tmp;
                j++;
            }
        }


    }
}
