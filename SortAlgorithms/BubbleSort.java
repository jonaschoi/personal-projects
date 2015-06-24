package SortAlgorithms; /**
 * Created by liferay on 2015-06-09.
 */

import java.util.Arrays;

public class BubbleSort {

    public static void main(String[] args) {
        int[] inputArr = {2, 7, 6, 4, 1, 8, 5, 3};

        BubbleSort bs = new BubbleSort();
        bs.bubbleSort(inputArr);
    }

    public static int[] bubbleSort(int[] arr) {
        boolean swap = true;

        while (swap) {
            swap = false;

            for (int i = 0; i < arr.length - 1; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp;
                    temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                    System.out.println(Arrays.toString(arr));
                    swap = true;
                }
            }
        }
        return arr;
    }
}