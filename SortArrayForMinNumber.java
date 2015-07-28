/**
 * Created by JEWELZ on 5/5/15.
 */

public class SortArrayForMinNumber {
    public static void main(String[] args) {
        System.out.println(new SortArrayForMinNumber().PrintMinNumber(new int[]{3,5,1,4,2}));
    }
    public String PrintMinNumber(int [] numbers) {
        if(numbers == null || numbers.length <=0)
            return "";
        int [] strNumbers = numbers.clone();
        printMinNumber(strNumbers,0,strNumbers.length-1);
//        System.out.println(Arrays.toString(strNumbers));
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < strNumbers.length; i++) {
//            System.out.println(strNumbers[i]);
            sb.append(strNumbers[i]);
        }
//        System.out.println(sb);
        return String.valueOf(sb);
    }

    public void printMinNumber(int []arr, int start, int end)
    {
        if(start < end)
        {
            int main_number = arr[end];
            int small_cur = start;
            for(int j = start; j < end; j++)
            {
                if(compare(String.valueOf(arr[j]),String.valueOf(main_number)))
                {
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

    private boolean compare(String m, String n)
    {
        String left = m + n;
        String right = n + m;
        boolean res = false;
        for(int i = 0;i < left.length(); i++)
        {
            if(left.charAt(i) < right.charAt(i))
                return true;
            else
            if(left.charAt(i) > right.charAt(i))
                return false;
        }
        return res;
    }
}