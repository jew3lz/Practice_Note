import java.util.Stack;

/**
 * Created by JEWELZ on 7/7/15.
 */
public class FindInPartiallySortedMatrix {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack();
        stack.push(1);

    }
    public boolean Find(int[][] array, int target) {
        if (array == null || array.length <= 0)
            return false;
        int row = 0;
        int col = array[0].length - 1;

        while (row < array.length && col >= 0) {
            if (array[row][col] == target)
                return true;
            else if (array[row][col] < target)
                row++;
            else
                col--;
        }
        return false;
    }
}
