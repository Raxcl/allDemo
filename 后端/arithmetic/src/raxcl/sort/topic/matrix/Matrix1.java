package raxcl.sort.topic.matrix;

import java.util.ArrayList;
import java.util.PriorityQueue;

/**
 * 找出矩阵中最弱的k行 优化1 二分查找 + 小顶堆
 * start 22：07
 * end
 * @author D30100_chenlong
 * @date 2022/3/30 14:23
 */
public class Matrix1 {
    public static void main(String[] args) {
    }

    public int[] kWeakestRows(int[][] mat, int k) {
        //优化1 二分查找 +
        //start 22：07
        //end
        //1. 使用二分统计每行军人数
        int m = mat.length,n=mat[0].length;
        ArrayList<int[]> power = new ArrayList<>();
        for(int i=0;i<m;i++){
            int l=0,r=n-1,pos=-1;
            while(l<=r){
                int mid = (l+r)/2;
                if(mat[i][mid] == 0){
                    r = mid-1;
                }else{
                    pos=mid;
                    l= mid+1;
                }
            }
            power.add(new int[]{pos+1,i});
        }

        //2. 将最小值放入小跟堆
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1[0] != o2[0]){
                return o1[0] - o2[0];
            }else {
                return o1[1] - o2[1];
            }
        });
        for (int[] pair : power){
            pq.offer(pair);
        }
        int[] ans = new int[k];
        for (int i=0; i<k; i++){
            ans[i] = pq.poll()[1];
        }
        return ans;
    }
}
