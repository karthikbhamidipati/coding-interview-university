package sorting;

public class BottomUpMergeSort {

    public static void sort(int[] arr) {
        for (int i = 1; i < arr.length; i *= 2) {
            for (int j = 0; j < arr.length - i; j += i * 2) {
                int end = Math.min(arr.length - 1, j + (2 * i) - 1);
                int mid = j + i - 1;
                merge(arr, j, mid, end);
            }
        }
    }

    private static void merge(int[] arr, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= end) {
            temp[k++] = arr[j++];
        }

        k--;
        while (k >= 0) {
            arr[start + k] = temp[k];
            k--;
        }
    }
}
