/**
 * Created by JEWELZ on 30/7/15.
 */
public class _InversePairs {

    public int InversePairsO(int[] array) {
        if (array == null || array.length == 0 || array.length == 1)
            return 0;
        int count = 0;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (i == j)
                    continue;
                if (array[i] > array[j])
                    count++;
            }
        }
        return count;
    }

    public int InversePairs(int[] array) {
        if (array == null || array.length < 1)
            return 0;

        int[] copy = array.clone();

        int count = InversePairsCore(array, copy, 0, array.length - 1);

        return count;
    }

    int InversePairsCore(int[] data, int[] copy, int start, int end) {
        if (start == end) {
            copy[start] = data[start];
            return 0;
        }

        int length = (end - start) / 2;
        int left = InversePairsCore(copy, data, start, start + length);
        int right = InversePairsCore(copy, data, start + length + 1, end);

        //i初始化为前半段最后一个数字的下标
        int i = start + length;
        //j初始化为后半段最后一个数字的下标
        int j = end;
        int indexCopy = end;
        int count = 0;
        while (i >= start && j >= start + length + 1) {
            if (data[i] > data[j]) {
                copy[indexCopy--] = data[i--];
                count += j - start - length;
            } else
                copy[indexCopy--] = data[j--];
        }

        for (; i >= start; --i)
            copy[indexCopy--] = data[i];

        for (; j >= start + length + 1; --j)
            copy[indexCopy--] = data[j];

        return left + right + count;
    }
}
