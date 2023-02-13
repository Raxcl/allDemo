package raxcl.shortestPath.review.dijkstra;


import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Raxcl
 * @date 2023/2/12 21:40
 */
public class DijkstraReviewAll {
    public static void main(String[] args) {
        Graph graph = new Graph(7);
        initGraph(graph);
        int[] distances = dijkstra(graph,0);
        System.out.println(Arrays.toString(distances));
        System.out.println(distances[6]);
        System.out.println("输出完整路径：");
        int[] prevs = dijkstraV2(graph,0);
        printPrevs(graph.vertexes, prevs, graph.vertexes.length-1);
    }

    private static void printPrevs(Vertex[] vertexes, int[] prev, int i) {
        if (i > 0) {
            printPrevs(vertexes, prev, prev[i]);
        }
        System.out.print(vertexes[i].data);
    }

    private static int[] dijkstraV2(Graph graph, int startIndex) {
        int size = graph.vertexes.length;
        int[] distances = new int[size];
        int[] prevs = new int[size];
        boolean[] access = new boolean[size];
        for (int i = 1; i < size; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        access[0] = true;
        List<Edge> edgesFromStart = graph.adj[startIndex];
        for (Edge edge : edgesFromStart) {
            distances[edge.index] = edge.weight;
            prevs[edge.index] = 0;
        }
        for (int i = 1; i < size; i++) {
            int minDistanceFromStart = Integer.MAX_VALUE;
            int minDistanceIndex = -1;
            for (int j = 1; j < size; j++) {
                if (!access[j] && (distances[j] < minDistanceFromStart)) {
                    minDistanceFromStart = distances[j];
                    minDistanceIndex = j;
                }
            }
            if (minDistanceIndex == -1){
                break;
            }
            // 遍历顶点，刷新距离表
            access[minDistanceIndex] = true;
            for (Edge edge : graph.adj[minDistanceIndex]){
                if (access[edge.index]){
                    continue;
                }
                int weight = edge.weight;
                int preDistance = distances[edge.index];
                if ((weight != Integer.MAX_VALUE) && ((minDistanceFromStart + weight) < preDistance)){
                    distances[edge.index] = minDistanceFromStart + weight;
                    prevs[edge.index] = minDistanceIndex;
                }
            }
        }
        return prevs;

    }

    private static int[] dijkstra(Graph graph, int startIndex) {
        int size = graph.vertexes.length;
        int[] distances = new int[size];
        boolean[] access = new boolean[size];
        for (int i = 1; i < size; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        access[0] = true;
        List<Edge> edgesFromStart = graph.adj[startIndex];
        for (Edge edge : edgesFromStart) {
            distances[edge.index] = edge.weight;
        }
        for (int i = 1; i < size; i++) {
            int minDistanceFromStart = Integer.MAX_VALUE;
            int minDistanceIndex = -1;
            for (int j = 1; j < size; j++) {
                if (!access[j] && (distances[j] < minDistanceFromStart)) {
                    minDistanceFromStart = distances[j];
                    minDistanceIndex = j;
                }
            }
            if (minDistanceIndex == -1){
                break;
            }
            // 遍历顶点，刷新距离表
            access[minDistanceIndex] = true;
            for (Edge edge : graph.adj[minDistanceIndex]){
                if (access[edge.index]){
                    continue;
                }
                int weight = edge.weight;
                int preDistance = distances[edge.index];
                if ((weight != Integer.MAX_VALUE) && ((minDistanceFromStart + weight) < preDistance)){
                    distances[edge.index] = minDistanceFromStart + weight;
                }
            }
        }
        return distances;
    }

    private static void initGraph(Graph graph) {
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

    private static class Graph{
        private Vertex[] vertexes;
        private LinkedList<Edge>[] adj;

        Graph(int size){
            //初始化顶点
            vertexes = new Vertex[size];
            //初始化邻接矩阵
            adj = new LinkedList[size];
            for (int i=0; i<adj.length; i++){
                adj[i] = new LinkedList<Edge>();
            }
        }
    }

    //图的顶点
    private static class Vertex{
        String data;

        Vertex(String data){
            this.data = data;
        }
    }

    private static class Edge{
        int index;
        int weight;
        Edge(int index, int weight){
            this.index = index;
            this.weight = weight;
        }
    }
}
