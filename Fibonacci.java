/**
 * Created by JEWELZ on 7/7/15.
 */
public class Fibonacci {
    public int JumpFloor(int target) {
        if (target <= 1)
            return target;
        long preOne = 0;
        long preTwo = 1;
        long res = 0;

        for (int i = 0; i < target; i++) {
            res = preOne + preTwo;

            preOne = preTwo;
            preTwo = res;
        }
        return (int) res;
    }

    public int JumpFloorII(int target) {
        if (target <= 1)
            return target;
        int result = 1;
        for (int i = 0; i < target - 1; i++) {
            result *= 2;
        }
        return result;
    }
}
