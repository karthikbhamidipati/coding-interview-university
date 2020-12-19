package leetcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class RotateImage {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int numLines = Integer.parseInt(br.readLine());
        int[][] matrix = new int[numLines][];
        for (int i = 0; i < numLines; i++) {
            matrix[i] = Arrays.stream(br.readLine().split(" ")).mapToInt(Integer::parseInt).toArray();
        }
        rotate(matrix);
        System.out.println(Arrays.deepToString(matrix).replace("], ", "\n").replace("[", "").replace("]", "").replace(",", ""));
    }

    private static void rotate(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) {
            return;
        }

        int len = matrix.length;

        transpose(matrix, len);
        reverseColumns(matrix, len);
    }

    private static void transpose(int[][] matrix, int len) {
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                swap(matrix, i, j, j, i);
            }
        }
    }

    private static void reverseColumns(int[][] matrix, int len) {
        for (int col = 0; col < len / 2; col++) {
            for (int row = 0; row < len; row++) {
                swap(matrix, row, col, row, len - col - 1);
            }
        }
    }

    private static void swap(int[][] matrix, int i1, int j1, int i2, int j2) {
        matrix[i1][j1] = matrix[i1][j1] + matrix[i2][j2];
        matrix[i2][j2] = matrix[i1][j1] - matrix[i2][j2];
        matrix[i1][j1] = matrix[i1][j1] - matrix[i2][j2];
    }
}
