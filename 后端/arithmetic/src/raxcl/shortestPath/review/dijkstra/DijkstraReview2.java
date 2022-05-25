package raxcl.shortestPath.review.dijkstra;


import java.util.LinkedList;

/**
 * 迪杰特斯拉算法复习2
 *
 * @author D30100_chenlong
 * @date 2022-05-09 15:23:40
 */
public class DijkstraReview2 {
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
        if (i>0){
            printPrevs(vertexes, prevs, prevs[i]);
        }
        System.out.print(vertexes[i].data+" ");
    }

    //Dijkstra最短路径算法（返回完整路径）
    private static int[][] dijkstra2(Graph graph, int startIndex) {
        //图的顶点数量
        int size = graph.vertexes.length;
        //初始化距离表
        int[] distances = new int[size];
        for (int i = 1; i < size; i++) {
            distances[i] = Integer.MAX_VALUE;
        }
        //初始化前置顶点表
        int[] prevs = new int[size];
        //初始化是否遍历过顶点表
        boolean[] access = new boolean[size];
        //遍历起点，各边的距离输入到距离表中，维护前置顶点表，找到最短距离节点
        access[0] = true;
        LinkedList<Edge> edges = graph.adj[startIndex];
        for (Edge edge: edges){
            distances[edge.index] = edge.weight;
        }
        // 主循环，遍历剩余节点，到各边的距离，与距离表比较，取最小值
        for (int i = 1; i < size; i++) {
            //寻找距离最短的点
            int minDistanceFromStart = Integer.MAX_VALUE;
            int minDistanceIndex = -1;
            for (int j = 1; j < size; j++) {
                if (!access[j] && distances[j]<minDistanceFromStart){
                    minDistanceFromStart = distances[j];
                    minDistanceIndex = j;
                }
            }
            if (minDistanceIndex==-1){
                break;
            }
            //遍历顶点，刷新距离表
            access[minDistanceIndex] = true;
            for (Edge edge: graph.adj[minDistanceIndex]){
                if (access[edge.index]){
                    continue;
                }
                if (distances[edge.index]>edge.weight + minDistanceFromStart){
                    distances[edge.index] = edge.weight + minDistanceFromStart;
                    prevs[edge.index] = minDistanceIndex;
                }
            }
        }
        return new int[][]{prevs,distances};
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
