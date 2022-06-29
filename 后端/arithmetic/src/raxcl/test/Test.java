package raxcl.test;

import java.util.Arrays;

/**
 * @author D30100_chenlong
 * @date 2022/6/1 11:13
 */
public class Test {
    //输出今天日期并格式化”yyyy-MM-dd”

    public static void main(String[] args) {
        Test test = new Test();
        test.duplicateZeros(new int[]{1,0,2,3,0,4,5,0});
    }

    public void duplicateZeros(int[] arr) {
        int n = arr.length;
        int top = 0;
        int i =-1;
        while(top<n){
            i++;
            if (arr[i]!=0){
                top++;
            }else{
                top +=2;
            }
        }
        int j=n-1;
        if (top==n+1){
            arr[j]=0;
            j--;
            i--;
        }
        while (j>=0){
            arr[j] = arr[i];
            j--;
            if (arr[i]==0){
                arr[j]=arr[i];
                j--;
            }
            i--;
        }
    }

    //堆排序
}
