package raxcl.shortestPath.review.dijkstra;


import java.util.LinkedList;

/**
 * 迪杰特斯拉算法复习1
 *
 * @author D30100_chenlong
 * @date 2022/5/6 10:16
 */
public class DijkstraReview1 {
    public static void main(String[] args) {
        Graph graph = new Graph(7);
        initGraph(graph);
        int[] distances = dijkstra(graph,0);
        System.out.println(distances[6]);
        System.out.println("输出完整路径：");
        int[] prevs = dijkstra2(graph, 0);
        printPrevs(graph.vertexes, prevs, graph.vertexes.length-1);

    }

    private static void printPrevs(Vertex[] vertexes, int[] prevs, int i) {
        if (i>0){
            printPrevs(vertexes, prevs, prevs[i]);
        }
        System.out.print(vertexes[i].data);
    }

    //Dijkstra最短路径算法（返回完整路径）
    private static int[] dijkstra2(Graph graph, int startIndex) {
        //图的顶点数量
        int size = graph.vertexes.length;
        //创建距离表，存储从起点到没有给顶点的临时距离
        int[] distances = new int[size];
        //创建前置顶点表，存储从起点到每一个顶点的已知最短路径的前置节点
        int[] prevs = new int[size];
        //记录顶点遍历状态
        boolean[] access = new boolean[size];
        //初始化最短路径表， 到达每个顶点的路径代价默认为无穷大
        for (int i = 0; i < size; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        //遍历起点，刷新距离表
        access[0] = true;
        LinkedList<Edge> edgesFromStart = graph.adj[startIndex];
        for (Edge edge : edgesFromStart){
            distances[edge.index] = edge.weight;
            prevs[edge.index] = 0;
        }
        //主循环， 重复 遍历最短距离顶点和刷新距离表的操作
        for (int i=1; i<size; i++){
            //寻找最短距离顶点
            int minDistanceFromStart = Integer.MAX_VALUE;
            int minDistanceIndex = -1;
            for (int j = 1; j < size; j++) {
                if (!access[j] && distances[j]<minDistanceFromStart){
                    minDistanceFromStart = distances[j];
                    minDistanceIndex = j;
                }
            }
            if (minDistanceIndex == -1){
                break;
            }
            //遍历顶点，刷新距离表
            access[minDistanceIndex] = true;
            for (Edge edge : graph.adj[minDistanceIndex]){
                if (access[edge.index]){
                    continue;
                }
                int weight = edge.weight;
                int preDistance = distances[edge.index];
                if (weight+ minDistanceFromStart<preDistance){
                    distances[edge.index] = weight+ minDistanceFromStart;
                    prevs[edge.index] = minDistanceIndex;
                }
            }
        }
        return prevs;
    }

    //Dijkstra最短路径算法
    private static int[] dijkstra(Graph graph, int startIndex) {
        //图的顶点数量
        int size = graph.vertexes.length;
        //创建距离表，存储从起点到每一个顶点的临时距离
        int[] distances = new int[size];
        //记录顶点遍历状态
        boolean[] access = new boolean[size];
        //初始化最短路径表，到达每个顶点的路径代价默认为无穷大
        for (int i = 1; i < distances.length; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        //遍历起点，刷新距离表
        access[0] = true;
        LinkedList<Edge> edgesFromStart = graph.adj[startIndex];
        for (Edge edge : edgesFromStart){
            distances[edge.index] = edge.weight;
        }
        //主循环，重复遍历最短距离顶点和刷新距离表的操作
        for (int i = 1; i < size; i++) {
            //寻找最短距离顶点
            //todo 从起点到点i，然后从点i开始，找下一个最短距离
            //距离
            int minDistanceFromStart = Integer.MAX_VALUE;
            //顶点
            int minDistanceIndex = -1;
            for (int j = 1; j < size; j++) {
                if (!access[j] && distances[j]<minDistanceFromStart){
                    minDistanceFromStart = distances[j];
                    minDistanceIndex = j;
                }
            }
            //遍历完了所有点，结束循环
            if (minDistanceIndex == -1){
                break;
            }
            //遍历顶点，刷新距离表
            access[minDistanceIndex] = true;
            for (Edge edge: graph.adj[minDistanceIndex]){
                if (access[edge.index]){
                    continue;
                }
                int weight = edge.weight;
                int preDistance = distances[edge.index];
                //preDistance等于无穷大
                if (minDistanceFromStart+weight < preDistance){
                    distances[edge.index] = minDistanceFromStart+weight;
                }
            }
        }
        return distances;
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
