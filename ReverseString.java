package leetcode;

/**
 * @Classname ReverseString
 * @Description TODO
 * @Date 2020/6/1 16:01
 * @Created by Administrator
 */
public class ReverseString {
    public static void main(String[] args) {
        String[] s={"h","e","l","l","o"};
        char[] sh=new char[5];
        for(int i=0;i<s.length;i++){
            sh[i]=s[i].charAt(0);
        }
        for(char sh_:sh){
            System.out.print(sh_+" ");
        }
        reverseString(sh);
        System.out.println();
        for(char sh_:sh){
            System.out.print(sh_+" ");
        }

    }
    public static void reverseString(char[] s){
        int start=0,end=s.length-1;
        char temp;
        while(start<end){
            temp=s[start];
            s[start]=s[end];
            s[end]=temp;
            start++;
            end--;

        }
    }
}
