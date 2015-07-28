import java.util.Arrays;

/**
 * Created by JEWELZ on 27/7/15.
 */
public class VarifyBackSequenceOfBTree {
    public boolean VerifySquenceOfBST(int[] sequence) {
        if (sequence == null || sequence.length < 1)
            return false;
        int length = sequence.length;
        int root = sequence[length - 1];
        int i = 0;
        for (; i < length - 1; i++) {
            if (sequence[i] > root)
                break;
        }
        int j = i;
        for (; j < length - 1; j++) {
            if (sequence[j] < root)
                return false;
        }
        boolean left = true;
        boolean right = true;
        if (i > 0)
            left = VerifySquenceOfBST(Arrays.copyOfRange(sequence, 0, i));
        if (i < length - 1)
            right = VerifySquenceOfBST(Arrays.copyOfRange(sequence, i, length - 1));
        return (left && right);
    }
}
