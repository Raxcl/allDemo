package cn.raxcl.basic;

public class 获取cpu数 {
    public static void main(String[] args) {
        int n_cpu = Runtime.getRuntime() .availableProcessors();
        System.out.println(n_cpu);
    }
}
