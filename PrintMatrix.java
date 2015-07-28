import java.util.ArrayList;

/**
 * Created by JEWELZ on 12/7/15.
 */
public class PrintMatrix {

    ArrayList<Integer> list = new ArrayList<>();

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1)
            return list;
        int start = 0;
        while (start * 2 < matrix.length && start * 2 < matrix[0].length) {
            printMatrixAction(matrix, matrix[0].length, matrix.length, start);
            start++;
        }
        return list;
    }

    public void printMatrixAction(int[][] nums, int cols, int rows, int start) {
        int endX = cols - 1 - start;
        int endY = rows - 1 - start;

        //从左到右
        for (int i = start; i <= endX; i++) {
            list.add(nums[start][i]);
        }

        //从上到下
        if (start < endY) {
            for (int i = start + 1; i <= endY; i++) {
                list.add(nums[i][endX]);
            }
        }

        //从右到左
        if (start < endX && start < endY) {
            for (int i = endX - 1; i >= start; --i) {
                list.add(nums[endY][i]);
            }
        }

        //从上到下
        if (start < endX && start < endY - 1) {
            for (int i = endY - 1; i >= start + 1; --i) {
                list.add(nums[i][start]);
            }
        }
    }
}
