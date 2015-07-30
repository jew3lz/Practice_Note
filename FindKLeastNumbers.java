import java.util.ArrayList;

/**
 * Created by JEWELZ on 28/7/15.
 */
public class FindKLeastNumbers {

    /**
     * 不修改数组,适合海量数据,时间效率O(nlogk),基于最大堆的实现
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (input == null || input.length < 1 || k < 1 || k > input.length)
            return res;
        int[] heap = input;//you can do this:int[] heap=new int[k].but that maybe space-cost

        //create MaxHeap of K elements.from the lastRootIndex to 0.
        int rootIndex = k / 2 - 1;
        while (rootIndex >= 0) {
            reheap(heap, rootIndex, k - 1);
            rootIndex--;
        }
        for (int i = k, len = heap.length; i < len; i++) {
            if (heap[i] < heap[0]) {
                heap[0] = heap[i];
                reheap(heap, 0, k - 1);
            }
        }
        System.out.print("the K min elements=");
        for (int i = 0; i < k; i++) {
            System.out.print(heap[i] + ",");
            res.add(heap[i]);
        }

        return res;

    }


    //reheap:from root to lastIndex.
    public void reheap(int[] heap, int rootIndex, int lastIndex) {
        int orphan = heap[rootIndex];
        boolean done = false;
        int leftIndex = rootIndex * 2 + 1;
        while (!done && leftIndex <= lastIndex) {
            int largerIndex = leftIndex;
            if (leftIndex + 1 <= lastIndex) {
                int rightIndex = leftIndex + 1;
                if (heap[rightIndex] > heap[leftIndex]) {
                    largerIndex = rightIndex;
                }
            }
            //Attention! should not use -->heap[root]<heap[largerIndex]<--.
            //I spend time to find the problem....
            if (orphan < heap[largerIndex]) {
                heap[rootIndex] = heap[largerIndex];
                rootIndex = largerIndex;
                leftIndex = rootIndex * 2 + 1;
            } else {
                done = true;
            }
        }
        heap[rootIndex] = orphan;

    }

    /**
     * 允许修改数组的解法,基于partition,时间效率O(n)
     *
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution2(int[] input, int k) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if (input == null || input.length < 1 || k < 1 || k > input.length)
            return res;
        int start = 0;
        int end = input.length - 1;
        int index = partition(input, start, end);
        while (index != k - 1) {
            if (index > k - 1)
                index = partition(input, start, index - 1);
            else
                index = partition(input, index + 1, end);
        }
        for (int i = 0; i < k; i++) {
            res.add(input[i]);
        }
        return res;
    }

    private int partition(int[] arr, int start, int end) {
        int pivotKey = arr[start];
        while (start < end) {
            while (start < end && arr[end] >= pivotKey)
                end--;
            arr[start] = arr[end];
            while (start < end && arr[start] <= pivotKey)
                start++;
            arr[end] = arr[start];
        }

        arr[start] = pivotKey;//一趟快排完成后start位为空,填补上
        return start;//返回中轴位置
    }
}
