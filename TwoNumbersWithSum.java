import java.util.ArrayList;

/**
 * Created by JEWELZ on 5/5/15.
 */
public class TwoNumbersWithSum {
    public static void main(String[] args) {
        System.out.println(new TwoNumbersWithSum().FindNumbersWithSum(new int[]{1,2,4,7,11,15},15));
    }

    public ArrayList<Integer> FindNumbersWithSum(int[] array, int sum) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (array == null || array.length < 2)
            return res;

        int ahead = array.length - 1;
        int behind = 0;

        while (ahead > behind) {
            long curSum = array[ahead] + array[behind];

            if (curSum == sum) {
                res.add(array[behind]);
                res.add(array[ahead]);
                break;
            } else if (curSum > sum)
                ahead--;
            else
                behind++;
        }
        return res;
    }
}
