/**
 * Created by JEWELZ on 28/7/15.
 */
public class GreatestSumOfSubArrays {
    boolean g_InvalidInput = false;

    public int FindGreatestSumOfSubArray(int[] array) {
        if (array == null || array.length < 1) {
            g_InvalidInput = true;
            return 0;
        }

        int curSum = 0;
        int greatestSum = 0;
        for (int i = 0; i < array.length; i++) {
            if (curSum <= 0)
                curSum = array[i];
            else
                curSum += array[i];

            if (curSum > greatestSum)
                greatestSum = curSum;
        }

        if (greatestSum == 0) {
            greatestSum = array[0];
            for (int i = 0; i < array.length; i++) {
                if (array[i] > greatestSum)
                    greatestSum = array[i];
            }
        }

        return greatestSum;
    }
}
