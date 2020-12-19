package leetcode;

public class MaxPointsOnLine {

    public static void main(String[] args) {
        int[][] points = {{0, 0}, {0, 1}, {1, 1}, {2, 2}, {4, 5}, {3, 3}};

        MaxPointsOnLine obj = new MaxPointsOnLine();

        System.out.println("Expected : Tuple2{m=1, b=0} Actual : " + obj.findIntersectionLine(points));

        points = new int[][]{{0, 0}, {0, 1}, {1, 1}, {2, 2}, {4, 5}, {3, 4}, {5, 6}};

        System.out.println("Expected : Tuple2{m=1, b=1} Actual : " + obj.findIntersectionLine(points));

        points = new int[][]{{4, 0}, {4, -1}, {4, 5}};

        System.out.println("Expected : Tuple2{m=2147483647, b=2147483647} Actual : " + obj.findIntersectionLine(points));

        points = new int[][]{{1, 1}, {2, 1}, {3, 1}};

        System.out.println("Expected : Tuple2{m=0, b=1} Actual : " + obj.findIntersectionLine(points));
    }

    public Tuple2 findIntersectionLine(int[][] points) {
        if (points == null || points.length == 0) {
            return null;
        }

        Tuple2 result = new Tuple2();
        int maxNumPointsOnLine = Math.min(points.length, 2);

        for (int i = 0; i < points.length - 2; i++) {
            for (int j = i + 1; j < points.length - 1; j++) {
                int slope = getSlope(points[i], points[j]);
                int b = slope == Integer.MAX_VALUE ? Integer.MAX_VALUE : points[i][1] - (slope * points[i][0]);
                int numPointsOnLine = 2;
                for (int k = j + 1; k < points.length; k++) {
                    if (slope == Integer.MAX_VALUE && points[i][0] == points[k][0]) {
                        numPointsOnLine++;
                    } else if (checkOnLine(slope, b, points[k])) {
                        numPointsOnLine++;
                    }
                }
                if (numPointsOnLine > maxNumPointsOnLine) {
                    maxNumPointsOnLine = numPointsOnLine;
                    result.b = b;
                    result.m = slope;
                }
            }
        }
        return result;
    }

    private boolean checkOnLine(int m, int b, int[] point) {
        return m * point[0] + b == point[1];
    }

    private int getSlope(int[] pointA, int[] pointB) {
        int x_diff = pointA[0] - pointB[0];
        int y_diff = pointA[1] - pointB[1];
        return x_diff == 0 ? Integer.MAX_VALUE : y_diff / x_diff;
    }

    private static class Tuple2 {
        int m;
        int b;

        public Tuple2() {
        }

        @Override
        public String toString() {
            return "Tuple2{" +
                    "m=" + m +
                    ", b=" + b +
                    '}';
        }
    }

}
