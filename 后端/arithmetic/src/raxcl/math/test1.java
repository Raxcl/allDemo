package raxcl.math;


/**
 * @author D30100_chenlong
 * @date 2022/6/25 10:51
 */
public class test1 {
    public static void main(String[] args) {
        digui(1,36,37);
    }

    private static void digui(int left, int right, int target) {
        int mid = left + (right-left)/2;
        if (target==mid){
            System.out.println("1 "+mid);
            return;
        }else if(target<mid && target>=left){
            digui(left,mid-1,target);
        }else if(target>mid && target<=right){
            digui(mid+1,right,target);
        }else{
            System.out.println("毁灭吧");
        }
    }
}
