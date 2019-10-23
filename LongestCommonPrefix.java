package leetcode;

/**
 * @Classname LongestCommonPrefix
 * @Description TODO
 * @Date 2019/10/23 15:35
 * @Created by 14241
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs={"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
    }
    public static String longestCommonPrefix(String[] strs){
        if(strs.length==0){
            return "";
        }
        String prefix=strs[0];
        for(int i=1;i<=strs.length-1;i++){
            while(strs[i].indexOf(prefix)!=0){
                prefix=prefix.substring(0,strs.length-1);
                if(prefix.isEmpty()){
                    return "";
                }
            }
        }
        return prefix;

    }
}
