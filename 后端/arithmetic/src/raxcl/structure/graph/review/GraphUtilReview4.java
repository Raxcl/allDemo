package raxcl.structure.graph.review;


import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 图的深度优先遍历和广度优先遍历复习4
 *
 * @author D30100_chenlong
 * @date 2022-05-19 10:27:05
 */
public class GraphUtilReview4 {
    public static void main(String[] args) {
        Graph graph = new Graph(6);
        graph.adj[0].add(1);
        graph.adj[0].add(2);
        graph.adj[0].add(3);
        graph.adj[1].add(0);
        graph.adj[1].add(3);
        graph.adj[1].add(4);
        graph.adj[2].add(0);
        graph.adj[3].add(0);
        graph.adj[3].add(1);
        graph.adj[3].add(4);
        graph.adj[3].add(5);
        graph.adj[4].add(1);
        graph.adj[4].add(3);
        graph.adj[4].add(5);
        graph.adj[5].add(3);
        graph.adj[5].add(4);
        System.out.println("图的深度优先遍历：");
        dfs(graph, 0, new boolean[graph.size]);
        System.out.println();
        System.out.println("图的广度优先遍历：");
        bfs(graph, 0, new boolean[graph.size], new LinkedList<Integer>());
    }

    private static void bfs(Graph graph, int start, boolean[] visited, LinkedList<Integer> queue) {
        queue.offer(start);
        while(!queue.isEmpty()){
            int front = queue.poll();
            if (visited[front]){
                continue;
            }
            visited[front] = true;
            System.out.print(front+" ");
            for (Integer edge: graph.adj[front]){
                if (!visited[edge]){
                    queue.offer(edge);
                }
            }
        }
    }

    private static void dfs(Graph graph, int start, boolean[] visited) {
        if (visited[start]){
            return;
        }
        System.out.print(start+" ");
        visited[start]=true;
        for (Integer edge: graph.adj[start]){
            dfs(graph, edge, visited);
        }
    }

    private static class Graph {
        int size;
        Vertex[] vertexes;
        LinkedList<Integer>[] adj;

        Graph(int size){
            this.size = size;
            //初始化顶点和邻接矩阵
            vertexes = new Vertex[size];
            adj = new LinkedList[size];
            for (int i = 0; i < size; i++) {
                vertexes[i] = new Vertex(i);
                adj[i] = new LinkedList<>();
            }
        }
    }

    private static class Vertex {
        int data;
        Vertex(int data){
            this.data = data;
        }
    }


}
