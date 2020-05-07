package searching;

public class BinarySearch {

    public int search(int[] sorted, int value) {
        int start = 0;
        int end = sorted.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (sorted[mid] == value) {
                return mid;
            } else if (sorted[mid] < value) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }


    public int searchWithRecursion(int[] sorted, int value, int start, int end) {
        int mid = (start + end) / 2;
        if (start > end) {
            return -1;
        } else if (sorted[mid] > value) {
            return searchWithRecursion(sorted, value, start, mid - 1);
        } else if (sorted[mid] < value) {
            return searchWithRecursion(sorted, value, mid + 1, end);
        }
        return mid;
    }
}
