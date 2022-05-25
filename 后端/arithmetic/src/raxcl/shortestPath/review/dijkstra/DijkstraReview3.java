package raxcl.shortestPath.review.dijkstra;


import java.util.LinkedList;

/**
 * 迪杰特斯拉算法复习3
 *
 * @author D30100_chenlong
 * @date 2022-05-18 11:05:29
 */
public class DijkstraReview3 {
    public static void main(String[] args) {
        Graph graph = new Graph(7);
        initGraph(graph);
        int[][] result = dijkstra2(graph, 0);
        System.out.println(result[1][6]);
        System.out.println("输出完整路径：");
        printPrevs(graph.vertexes, result[0], graph.vertexes.length-1);
        System.out.println();
    }

    private static void printPrevs(Vertex[] vertexes, int[] prevs, int i) {
        if (i!=0){
            printPrevs(vertexes, prevs, prevs[i]);
        }
        System.out.print(vertexes[i].data+" ");
    }

    //Dijkstra最短路径算法（返回完整路径）
    private static int[][] dijkstra2(Graph graph, int startIndex) {
        int length = graph.vertexes.length;
        //距离表
        int[] distances = new int[length];
        //初始化距离表
        for (int i = 0; i < length; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        //前置顶点表
        int[] preGraphs = new int[length];
        //是否遍历过的表
        boolean[] isFlag = new boolean[length];
        //刷新起点的距离表
        LinkedList<Edge> edges = graph.adj[startIndex];
        for (Edge edge: edges){
            distances[edge.index] = edge.weight;
            preGraphs[edge.index] = startIndex;
        }
        isFlag[0] = true;
        //主逻辑
        for (int x = 1; x < length; x++) {
            //找到最短距离的点
            int minDistanceFromStart = Integer.MAX_VALUE;
            int minDistanceIndex = -1;
            for (int i = 0; i < length; i++) {
                if (!isFlag[i] && distances[i] < minDistanceFromStart){
                    minDistanceFromStart = distances[i];
                    minDistanceIndex =i;
                }
            }
            if (minDistanceIndex==-1){
                break;
            }
            //遍历顶点
            LinkedList<Edge> edges1 = graph.adj[minDistanceIndex];
            for (Edge edge: edges1){
                if (distances[edge.index] > edge.weight+minDistanceFromStart){
                    distances[edge.index] = edge.weight+minDistanceFromStart;
                    preGraphs[edge.index] = minDistanceIndex;
                }
            }
            isFlag[minDistanceIndex] = true;
        }
        return new int[][]{preGraphs, distances};
    }



    private static void initGraph(Graph graph){
        graph.vertexes[0] = new Vertex("A");
        graph.vertexes[1] = new Vertex("B");
        graph.vertexes[2] = new Vertex("C");
        graph.vertexes[3] = new Vertex("D");
        graph.vertexes[4] = new Vertex("E");
        graph.vertexes[5] = new Vertex("F");
        graph.vertexes[6] = new Vertex("G");
        graph.adj[0].add(new Edge(1,5));
        graph.adj[0].add(new Edge(2,2));
        graph.adj[1].add(new Edge(0,5));
        graph.adj[1].add(new Edge(3,1));
        graph.adj[1].add(new Edge(4,6));
        graph.adj[2].add(new Edge(0,2));
        graph.adj[2].add(new Edge(3,6));
        graph.adj[2].add(new Edge(5,8));
        graph.adj[3].add(new Edge(1,1));
        graph.adj[3].add(new Edge(2,6));
        graph.adj[3].add(new Edge(4,1));
        graph.adj[3].add(new Edge(5,2));
        graph.adj[4].add(new Edge(1,6));
        graph.adj[4].add(new Edge(3,1));
        graph.adj[4].add(new Edge(6,7));
        graph.adj[5].add(new Edge(2,8));
        graph.adj[5].add(new Edge(3,2));
        graph.adj[5].add(new Edge(6,3));
        graph.adj[6].add(new Edge(4,7));
        graph.adj[6].add(new Edge(5,3));
    }
}
