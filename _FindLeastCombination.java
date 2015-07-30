import java.util.Arrays;

/**
 * Created by JEWELZ on 30/7/15.
 */
public class _FindLeastCombination {

    String leastNum = "";

    public static void main(String[] args) {
        System.out.println(new _FindLeastCombination().PrintMinNumber1(new int[]{3, 32, 321}));
    }

    public String PrintMinNumber1(int[] numbers) {
        if (numbers == null || numbers.length <= 0)
            return "";
        int[] strNumbers = numbers.clone();
        printMinNumber(strNumbers, 0, strNumbers.length - 1);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strNumbers.length; i++) {
            sb.append(strNumbers[i]);
        }
        return String.valueOf(sb);
    }

    public void printMinNumber(int[] arr, int start, int end) {
        if (start < end) {
            int main_number = arr[end];
            int small_cur = start;
            for (int j = start; j < end; j++) {
                if (compare1(String.valueOf(arr[j]), String.valueOf(main_number))) {
                    int temp = arr[j];
                    arr[j] = arr[small_cur];
                    arr[small_cur] = temp;
                    small_cur++;
                }
            }
            arr[end] = arr[small_cur];
            arr[small_cur] = main_number;
            printMinNumber(arr, 0, small_cur - 1);
            printMinNumber(arr, small_cur + 1, end);

        }
    }

    private boolean compare1(String m, String n) {
        String left = m + n;
        String right = n + m;
        boolean res = false;
        for (int i = 0; i < left.length(); i++) {
            if (left.charAt(i) < right.charAt(i))
                return true;
            else if (left.charAt(i) > right.charAt(i))
                return false;
        }
        return res;
    }

    public String PrintMinNumber(int[] numbers) {
        if (numbers == null || numbers.length < 1)
            return null;
        permutation(numbers, 0);
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < leastNum.length(); i++) {
            if (leastNum.charAt(i) != '[' && leastNum.charAt(i) != ']' && leastNum.charAt(i) != ',' && leastNum.charAt(i) != ' ')
                sb.append(leastNum.charAt(i));
        }
        leastNum = sb.toString();
        return leastNum;
    }

    void permutation(int[] numbers, int begin) {
        if (numbers == null || begin < 0 || begin > numbers.length)
            return;
        if (begin == numbers.length - 1) {
            if (leastNum == "" || compare(leastNum, Arrays.toString(numbers)))
                leastNum = Arrays.toString(numbers);
        } else {
            for (int pCh = begin; pCh < numbers.length; pCh++) {
                int temp = numbers[pCh];
                numbers[pCh] = numbers[begin];
                numbers[begin] = temp;

                permutation(numbers, begin + 1);

                temp = numbers[pCh];
                numbers[pCh] = numbers[begin];
                numbers[begin] = temp;
            }
        }
    }

    private boolean compare(String m, String n) {
        for (int i = 0; i < m.length(); i++) {
            if (m.charAt(i) > n.charAt(i))
                return true;
            else if (m.charAt(i) < n.charAt(i))
                return false;
        }

        return false;
    }
}
