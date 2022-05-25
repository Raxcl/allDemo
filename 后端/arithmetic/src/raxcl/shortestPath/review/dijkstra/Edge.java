package raxcl.shortestPath.review.dijkstra;

/**
 * 图的边
 *
 * @author D30100_chenlong
 * @date 2022/5/6 10:22
 */
public class Edge {
    public int index;
    public int weight;
    public Edge(int index, int weight){
         //边（记录指向的终点下标）
        this.index = index;
        //权重
        this.weight = weight;
    }

}
