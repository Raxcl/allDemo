package raxcl.sort.topic.matrix;

import java.util.ArrayList;

/**
 * 找出矩阵中最弱的k行
 *
 * @author D30100_chenlong
 * @date 2022/3/30 14:23
 */
public class Matrix {
    //todo 二分法+小顶堆的时间复杂度待研究
    //小顶堆的比较方法待研究

    public int[] kWeakestRows(int[][] mat, int k) {
        //start 14:07
        //1. 统计每行军人数，用list<int[]>封装
        ArrayList<int[]> matList = new ArrayList<>();

        for(int i=0;i<mat.length;i++){
            int s = 0;
            for(int j=0;j<mat[i].length;j++){
                if(mat[i][j]==0){
                    break;
                }
                s++;
            }
            matList.add(new int[]{s,i});
        }
        int[] resultArr = new int[k];
        //2. 循环查找最小（循环k次），将下标复制给另一个list，并删除这个元素
        //3. 遍历找出最小值min
        for(int s=1; s<=k; s++){
            int min = matList.get(0)[0];
            int value = 0;
            for(int i=1;i<matList.size();i++){
                if(min > matList.get(i)[0]){
                    min = matList.get(i)[0];
                    value = i;
                }
            }
            resultArr[s-1] = matList.get(value)[1];
            matList.remove(value);
        }
        return resultArr;
    }
}
