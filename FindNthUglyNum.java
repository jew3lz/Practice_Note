/**
 * Created by JEWELZ on 30/7/15.
 */
public class FindNthUglyNum {
    public int GetUglyNumber_Solution(int n) {
        if (n == 0)
            return 0;
        int[] uglyNumArr = new int[n];
        uglyNumArr[0] = 1;
        int index = 0;
        int index_2 = 0;
        int index_3 = 0;
        int index_5 = 0;
        while (index < n - 1) {
            int min = Min(uglyNumArr[index_2] * 2, uglyNumArr[index_3] * 3, uglyNumArr[index_5] * 5);
            index++;
            uglyNumArr[index] = min;
            if (uglyNumArr[index_2] * 2 == min)
                index_2++;
            if (uglyNumArr[index_3] * 3 == min)
                index_3++;
            if (uglyNumArr[index_5] * 5 == min)
                index_5++;
        }
        return uglyNumArr[n - 1];
    }

    private int Min(int a, int b, int c) {
        return Min(Min(a, b), c);
    }

    private int Min(int a, int b) {
        return a < b ? a : b;
    }
}
