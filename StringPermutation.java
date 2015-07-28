/**
 * Created by JEWELZ on 6/5/15.
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。例如输入字符串abc,
 * 则打印出由字符a,b,c所能排列出来的所有字符串abc,acb,bac,bca,cab和cba。
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class StringPermutation {
    ArrayList<String> res = new ArrayList<>();
    static ArrayList<String> res0 = new ArrayList<>();

    public static void main(String[] args) {
//        new StringPermutation().Permutation(new int[]{1,2,3,1,2,3,2,2}, 0);
//        System.out.println(res0);
        System.out.println(new StringPermutation().Permutation("alibaba"));
//        System.out.println(new StringPermutation().Check(new int[]{1, 2, 3, 2, 3, 2, 1, 2}));
//        System.out.println(new StringPermutation().Check(new int[]{1, 2, 3, 2, 2, 3, 2, 1}));
//        System.out.println(new StringPermutation().Check(new int[]{1, 2, 2, 3, 3, 2, 2, 1}));
//        System.out.println(new StringPermutation().Check(new int[]{3, 2, 1, 2, 1, 2, 3, 2}));
//        System.out.println(new StringPermutation().Check(new int[]{2, 2, 2, 2, 3, 1, 1, 3}));
//        System.out.println(new StringPermutation().Check(new int[]{3, 2, 1, 2, 2, 1, 2, 3}));
//        System.out.println(new StringPermutation().Check(new int[]{1, 2, 3, 2, 3, 2, 1, 2}));
//        System.out.println(new StringPermutation().Check(new int[]{2, 2, 3, 1, 2, 2, 1, 3}));
//        System.out.println(new StringPermutation().Check(new int[]{1, 2, 3, 2, 3, 2, 1, 2}));

    }

    public ArrayList<String> Permutation(String str) {
        if (str == null) return res;
        char[] pStr = str.toCharArray();
        permutation(pStr, 0);
        Collections.sort(res);
        System.out.println(count);
        return res;
    }
    int count = 0;
    void permutation(char[] pStr, int pBegin) {
        if (pStr == null || pBegin < 0 || pBegin > pStr.length)
            return;
        if (pBegin == pStr.length - 1) {
            if (!res.contains(String.valueOf(pStr))){
                res.add(String.valueOf(pStr));
                ++count;
            }
        } else {
            for (int pCh = pBegin; pCh < pStr.length; pCh++) {
                char temp = pStr[pCh];
                pStr[pCh] = pStr[pBegin];
                pStr[pBegin] = temp;

                permutation(pStr, pBegin + 1);

                temp = pStr[pCh];
                pStr[pCh] = pStr[pBegin];
                pStr[pBegin] = temp;
            }
        }
    }

    /*
    输入一个8个数字的数组,判断有没有可能把这八个数字分别放到正方体的8个顶点上,
    使得三组相对的面上的和都相等
    全排列,判断有没有 a1+a2+a3+a4 = a5+a6+a7+a8,a1+a3+a5+a7 = a2+a4+a6+a8,
    并且a1+a2+a5+a6 = a3+a4+a7+a8
     */
    void Permutation(int[] pInt, int pBegin) {
        if (pInt == null || pBegin < 0 || pBegin > pInt.length)
            return;
        if (pBegin == pInt.length - 1) {
            if (Check(pInt)) {
                if (!res0.contains(Arrays.toString(pInt)))
                    res0.add(Arrays.toString(pInt));
            }
        } else {
            for (int pCh = pBegin; pCh < pInt.length; pCh++) {
                int temp = pInt[pCh];
                pInt[pCh] = pInt[pBegin];
                pInt[pBegin] = temp;

                Permutation(pInt, pBegin + 1);

                temp = pInt[pCh];
                pInt[pCh] = pInt[pBegin];
                pInt[pBegin] = temp;
            }
        }

    }

    boolean Check(int[] arr) {
        if ((arr[0] + arr[1] + arr[2] + arr[3] == arr[4] + arr[5] + arr[6] + arr[7])
                && (arr[0] + arr[2] + arr[4] + arr[6] == arr[1] + arr[3] + arr[5] + arr[7])
                && (arr[0] + arr[1] + arr[4] + arr[5] == arr[2] + arr[3] + arr[6] + arr[7]))
            return true;
        else
            return false;
    }
}