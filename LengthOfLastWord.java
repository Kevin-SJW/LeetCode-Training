package leetcode;

/**
 * @Classname LengthOfLastWord
 * @Description TODO
 * @Date 2019/12/21 16:12
 * @Created by 14241
 */
public class LengthOfLastWord {
    public static void main(String[] args) {
        String s="Hello World";
        System.out.println(lengthOfLastWord(s));

    }
    public static int lengthOfLastWord(String s) {
        if(s==null||s.length()==0){
            return 0;
        }
        int length=0;
        int i=s.length()-1;
        while(i>=0&&s.charAt(i)==' '){
            i--;
        }
        while(i>=0&&s.charAt(i)!=' '){
            length++;
            i--;
        }
        return length;
    }
}
