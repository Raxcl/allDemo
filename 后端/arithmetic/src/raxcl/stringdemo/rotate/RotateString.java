package raxcl.stringdemo.rotate;

/**
 * 旋转字符串
 *
 * @author D30100_chenlong
 * @date 2022/4/7 9:54
 */
public class RotateString {
    public static void main(String[] args) {
        RotateString r = new RotateString();
        System.out.println(r.rotateString("clrwmpkwru","wmpkwruclr"));
    }
    public boolean rotateString(String s, String goal) {
        //start 9:20
        //end 10:04
        //先判断两个长度是否相等
        if(s.length()!=goal.length()){
            return false;
        }
        //先翻转s，首先要确定和目标第一个字符相等的字符位置(有逻辑漏洞)
        //
        int start = 0;

        for(int i=0;i<s.length(); i++){
            //如果等于，判断剩下的是否相等
            if(goal.charAt(0)==s.charAt(i)){
                int goalStart = 0;
                boolean flag= true;
                for(int j=i;j<s.length(); j++){
                    if(goal.charAt(goalStart)!=s.charAt(j)){
                        flag=false;
                        break;
                    }
                    goalStart++;
                }
                //剩下的全部相等，返回
                if(flag==true){
                    start = i;
                    break;
                }
            }
        }
        //然后翻转
        String newS;
        if(start!=0){
            newS = s.substring(start,s.length())+s.substring(0,start);
        }else{
            newS = s;
        }
        // 一次遍历判断
        for(int i=0;i<newS.length(); i++){
            if(newS.charAt(i)!=goal.charAt(i)){
                return false;
            }
        }
        return true;
    }
}
