package raxcl.shortestPath.review.dijkstra;

import java.util.LinkedList;

/**
 * 图
 *
 * @author D30100_chenlong
 * @date 2022/5/6 10:24
 */
public class Graph {
    //顶点
    public Vertex[] vertexes;
    //边 每个顶点的所有边
    public LinkedList<Edge>[] adj;

    public Graph(int size){
        //初始化顶点
        vertexes = new Vertex[size];
        //初始化邻接表
        adj = new LinkedList[size];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new LinkedList<>();
        }
    }
}
