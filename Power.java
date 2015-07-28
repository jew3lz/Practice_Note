/**
 * Created by JEWELZ on 12/7/15.
 */
public class Power {
    boolean isInvalied = false;

    double Power(double base, int exponent) {
        boolean isInvalied = false;
        if (equal(base, 0.0) && exponent < 0) {
            isInvalied = true;
            return 0.0;
        }
        double result = 0.0;
        if (equal(exponent, 0.0))
            return 1.0;
        if (exponent < 0) {
            result = PowerWithExponent(1 / base, -exponent);
        } else {
            result = PowerWithExponent(base, exponent);
        }
        if (isInvalied)
            System.out.println("非法输入");
        return result;

    }

    public double PowerWithExponent(double base, int exponent) {
        double result = 1.0;
        for (int i = 1; i <= exponent; i++) {
            result = result * base;
        }
        return result;
    }

    public boolean equal(double num1, double num2) {
        if ((num1 - num2 > -0.0000001) && (num1 - num2 < 0.0000001)) {
            return true;
        } else {
            return false;
        }
    }
}
