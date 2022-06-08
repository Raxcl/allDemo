package raxcl.shortestPath.review.floyd;

/**
 * 弗洛伊德算法复习4
 * @author D30100_chenlong
 * @date 2022-05-26 14:25:47
 */
public class FloydReview4 {
    final static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 5, 2, INF, INF, INF, INF },
                { 5, 0, INF, 1, 6, INF, INF },
                { 2, INF, 0, 6, INF, 8, INF },
                { INF, 1, 6, 0, 1, 2, INF },
                { INF, 6, INF, 1, 0, INF, 7 },
                { INF, INF, 8, 2, INF, 0, 3 },
                { INF, INF, INF, INF, 7, 3, 0 }
        };
        floyd(matrix);
    }

    private static void floyd(int[][] matrix) {
        int length = matrix.length;
        for (int k = 0; k < length; k++) {
            for (int i = 0; i < length; i++) {
                for (int j = 0; j < length; j++) {
                    if (matrix[i][k]!=INF && matrix[k][j]!=INF){
                        matrix[i][j] = Math.min(matrix[i][j],matrix[i][k]+matrix[k][j]);
                    }
                }
            }
        }

        //输出
        for (int[] ints : matrix) {
            for (int j = 0; j < length; j++) {
                System.out.printf("%5d", ints[j] == INF ? "INF" : ints[j]);
            }
            System.out.println();
        }
    }
}
