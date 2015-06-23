import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by liferay on 2015-06-09.
 */
public class MergeSort {

    public static void main(String[] args) {
        ArrayList<Integer> a = new ArrayList<Integer>(Arrays.asList(5, 2, 3, 8, 7, 6, 4, 1));

        MergeSort ms = new MergeSort();
        ms.mergeSort(a);
    }

    List<Integer> merge(List<Integer> a, List<Integer> b) {

        List<Integer> c = new ArrayList<Integer>();

        while (a.size() > 0 && b.size() > 0) {
            if (a.get(0) < b.get(0)) {
                c.add(a.remove(0));
            } else {
                c.add(b.remove(0));
            }
        }

        if (a.size() > 0) {
            c.addAll(a);
        }

        if (b.size() > 0) {
            c.addAll(b);
        }
        return c;
    }

    List<Integer> mergeSort(List<Integer> a) {
        int size = a.size();
        if (size == 1) {
            return a;
        } else {
            int middle = size / 2;
            List<Integer> left = a.subList(0, middle);
            List<Integer> right = a.subList(middle, size);

            List<Integer> q = merge(mergeSort(left), mergeSort(right));
            return q;
        }
    }
}