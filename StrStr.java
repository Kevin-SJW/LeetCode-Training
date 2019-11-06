package leetcode;

/**
 * @Classname StrStr
 * @Description TODO
 * @Date 2019/11/6 14:22
 * @Created by 14241
 */
public class StrStr {
    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        System.out.println(strStr(haystack,needle));

    }
    public static int strStr(String haystack, String needle) {
        char[] a1=haystack.toCharArray();
        char[] a2=needle.toCharArray();
        if(needle.length()==0){
            return 0;
        }
        for(int i=0;i<a1.length;i++){
            boolean flag=true;
            for(int j=0;j<a2.length;j++){
                if(i+j>a1.length||a1[i+j]!=a2[j]){
                    flag=false;
                    break;
                }
                if(flag){
                    return i;
                }
            }
        }
        return -1;
    }
}
