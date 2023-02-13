package raxcl.structure.graph.review;

import raxcl.structure.graph.GraphUtil;

import java.util.LinkedList;

/**
 * @author Raxcl
 * @date 2023/2/12 21:06
 */
public class GraphUtilReviewAll {
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
        while (!queue.isEmpty()) {
            int front = queue.poll();
            if (visited[front]){
                continue;
            }
            System.out.print(graph.vertices[front].data + " ");
            visited[front] = true;
            for (int index: graph.adj[front]) {
                queue.offer(index);
            }
        }
    }

    private static void dfs(Graph graph, int start, boolean[] visited) {
        System.out.print(graph.vertices[start].data + " ");
        visited[start] = true;
        for (int index: graph.adj[start]) {
            if (!visited[index]) {
                dfs(graph, index, visited);
            }
        }
    }

    private static class Vertex{
        int data;
        Vertex(int data){
            this.data = data;
        }
    }

    private static class Graph{
        private int size;
        private Vertex[] vertices;
        private LinkedList<Integer>[] adj;

        Graph(int size) {
            this.size = size;
            vertices = new Vertex[size];
            adj = new LinkedList[size];
            for (int i = 0; i < size; i++) {
                vertices[i] = new Vertex(i);
                adj[i] = new LinkedList<>();
            }
        }
    }
}
