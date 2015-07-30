/**
 * Created by JEWELZ on 30/7/15.
 */
public class NumberOf1Between1andN {
    boolean g_InvalidInput = false;

    public static void main(String[] args) {
        System.out.println(new NumberOf1Between1andN().NumberOf1Between1AndN_Solution(25000));
        System.out.println(1 % 10);
    }

    public int NumberOf1Between1AndN_Solution(int n) {
        if (n < 1) {
            g_InvalidInput = true;
            return 0;
        }
        int times = 0;
        for (int i = 0; i <= n; i++) {
            times += NumberOf1(i);
        }

        return times;
    }

    private int NumberOf1(int n) {
        int number = 0;
        while (n != 0) {
            if (n % 10 == 1)
                number++;
            n /= 10;
        }

        return number;
    }

    public int NumberOf1Between1AndN_Solution2(int n) {
        long count = 0;
        long i = 1;
        long current = 0, after = 0, before = 0;
        while ((n / i) != 0) {
            current = (n / i) % 10;
            before = n / (i * 10);
            after = n - (n / i) * i;

            if (current > 1)
                count = count + (before + 1) * i;
            else if (current == 0)
                count = count + before * i;
            else if (current == 1)
                count = count + before * i + after + 1;

            i = i * 10;
        }
        return Integer.parseInt(String.valueOf(count));
    }
}
