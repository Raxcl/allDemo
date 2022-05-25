package raxcl.kmp.review;

/**
 * kmp复习3
 *
 * @author D30100_chenlong
 * @date 2022-05-25 10:42:20
 */
public class KMPReview3 {
    public static void main(String[] args) {
        String str = "ATGTGAGCTGGTGTGTGCFAA";
        String pattern = "GTGTGCF";
        int index = kmp(str,pattern);
        System.out.println("首次出现的位置："+ index);
    }

    private static int kmp(String str, String pattern) {
        int[] next = getNexts(pattern);
        int j=0;
        for (int i = 0; i < str.length(); i++) {
            while(j>0 && str.charAt(i)!=pattern.charAt(j)){
                j = next[j];
            }
            if (str.charAt(i)==pattern.charAt(j)){
                j++;
            }
            if (j == pattern.length()){
                return i-j+1;
            }
        }
        return -1;
    }

    private static int[] getNexts(String pattern) {
        int[] next = new int[pattern.length()];
        int j=0;
        for (int i = 2; i < pattern.length(); i++) {
            while(j>0 && pattern.charAt(j)!=pattern.charAt(i-1)){
                j = next[j];
            }
            if (pattern.charAt(j)==pattern.charAt(i-1)){
                j++;
            }
            next[i] = j;
        }
        return next;
    }
}
